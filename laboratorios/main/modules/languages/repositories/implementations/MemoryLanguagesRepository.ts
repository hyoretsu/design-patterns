import MemoryRepository from "../../../../shared/repositories/implementations/MemoryRepository";
import Language from "../../infra/entities/Language";
import ILanguagesRepository from "../ILanguagesRepository";

export default class MemoryLanguagesRepository implements ILanguagesRepository {
    private languages: Language[];

    constructor() {
        const memoryRepository = MemoryRepository.getInstance();
        this.languages = memoryRepository.get("languages");
    }

    public async findById(languageId: string): Promise<Language | undefined> {
        const foundLanguage = this.languages.find(language => language.id === languageId);

        return foundLanguage;
    }

    public async save(language: Language): Promise<void> {
        this.languages.push(language);
    }
}
