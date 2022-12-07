import Creator from "@shared/infra/entities/creators/Creator";

import Language, { ICreateLanguageDTO } from "../Language";

export default class LanguageCreator extends Creator {
    createEntity(info: ICreateLanguageDTO): Language {
        return new Language(info);
    }
}
