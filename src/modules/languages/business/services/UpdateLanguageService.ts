import Language from "../../infra/entities/Language";
import ILanguagesRepository from "../../infra/repositories/ILanguagesRepository";

type IRequest = Partial<Language> & {
    id: string;
};

export default class UpdateLanguageService {
    constructor(private languagesRepository: ILanguagesRepository) {}

    async execute(info: IRequest): Promise<void> {
        const language = await this.languagesRepository.findById(info.id);
        if (!language) {
            throw new Error("Language not found.");
        }

        Object.assign(language, info);
        await this.languagesRepository.save(language);
    }
}
