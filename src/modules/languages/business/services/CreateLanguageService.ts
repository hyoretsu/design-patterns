import Language, { ICreateLanguageDTO } from "../../infra/entities/Language";
import LanguageCreator from "../../infra/entities/creators/LanguageCreator";
import ILanguagesRepository from "../../infra/repositories/ILanguagesRepository";

export default class CreateLanguageService {
    constructor(private languagesRepository: ILanguagesRepository) {}

    async execute({ description, icon, name }: ICreateLanguageDTO): Promise<Language> {
        const language = new LanguageCreator().createEntity({ description, icon, name });

        await this.languagesRepository.save(language);

        return language;
    }
}
