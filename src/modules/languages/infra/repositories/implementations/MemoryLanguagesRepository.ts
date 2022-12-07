import MemoryRepository from "@shared/infra/repositories/implementations/MemoryRepository";

import Language from "../../entities/Language";
import ILanguagesRepository from "../ILanguagesRepository";

export default class MemoryLanguagesRepository implements ILanguagesRepository {
    private languages: Record<string, Language>;

    constructor() {
        const memoryRepository = MemoryRepository.getInstance();
        this.languages = memoryRepository.getRepository("languages");
    }

    async findById(languageId: string): Promise<Language | undefined> {
        const [_, foundLanguage] = Object.entries(this.languages).find(([id, language]) => id === languageId) || [];

        return foundLanguage;
    }

    async save(language: Language): Promise<void> {
        this.languages[language.id] = Object.assign(language, { updatedAt: new Date() });
    }
}
