import Language from "../infra/entities/Language";
import LanguageCreator from "../infra/entities/LanguageCreator";
import ILanguagesRepository from "../repositories/ILanguagesRepository";

export default class CreateLanguageService {
    constructor(private languagesRepository: ILanguagesRepository) {}

    public async execute({ description, icon, name }): Promise<Language> {
        const language = new LanguageCreator().createEntity({ description, icon, name });

        await this.languagesRepository.save(language);

        return language;
    }
}
