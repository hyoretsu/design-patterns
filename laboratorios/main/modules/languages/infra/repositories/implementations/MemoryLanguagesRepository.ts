import MemoryRepository from "../../../../../shared/infra/repositories/implementations/MemoryRepository";
import Language from "../../entities/Language";
import ILanguagesRepository from "../ILanguagesRepository";

export default class MemoryLanguagesRepository implements ILanguagesRepository {
    private languages: Record<string, Language>;

    constructor() {
        const memoryRepository = MemoryRepository.getInstance();
        this.languages = memoryRepository.get("languages");
    }

    public async findById(languageId: string): Promise<Language | undefined> {
        const [_, foundLanguage] = Object.entries(this.languages).find(([id, language]) => id === languageId) || [];

        return foundLanguage;
    }

    public async save(language: Language): Promise<void> {
        this.languages[language.id] = language;
    }
}
