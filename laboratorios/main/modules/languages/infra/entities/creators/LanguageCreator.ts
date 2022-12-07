import Creator from "../../../../../shared/infra/entities/creators/Creator";
import Language, { ICreateLanguageDTO } from "../Language";

export default class LanguageCreator extends Creator {
    public createEntity(info: ICreateLanguageDTO): Language {
        return new Language(info);
    }
}