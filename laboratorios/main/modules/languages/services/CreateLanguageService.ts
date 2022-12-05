import Language from "../entities/Language";
import ILanguagesRepository from "../repositories/ILanguagesRepository";

export default class CreateLanguageService {
    constructor(private languagesRepository: ILanguagesRepository) {}

    public async execute({ description, icon, name }): Promise<Language> {
        const language = new Language({ description, icon, name });

        await this.languagesRepository.save(language);

        return language;
    }
}
