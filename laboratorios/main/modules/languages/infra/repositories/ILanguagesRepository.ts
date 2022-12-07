import Language from "../entities/Language";

export default interface ILanguagesRepository {
    findById(languageId: string): Promise<Language | undefined>;
    save(language: Language): Promise<void>;
}
