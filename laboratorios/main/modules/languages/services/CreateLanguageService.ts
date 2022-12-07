import XMLToJSON from "../../../shared/utils/XMLToJSON";
import Language, { ICreateLanguageDTO } from "../infra/entities/Language";
import LanguageCreator from "../infra/entities/LanguageCreator";
import ILanguagesRepository from "../repositories/ILanguagesRepository";

interface IRequest {
    // Proveniente de biblioteca externa
    file?: Record<string, any>;
    info: ICreateLanguageDTO;
}

export default class CreateLanguageService {
    constructor(private languagesRepository: ILanguagesRepository) {}

    public async execute({ file, info }: IRequest): Promise<Language> {
        if (file && file.mimetype === "application/xml") {
            info = (await XMLToJSON.execute(file.path)) as ICreateLanguageDTO;
        }

        const language = new LanguageCreator().createEntity(info);

        await this.languagesRepository.save(language);

        return language;
    }
}
