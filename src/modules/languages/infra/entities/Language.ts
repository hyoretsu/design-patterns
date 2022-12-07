import Entity from "@shared/infra/entities/Entity";

export interface ICreateLanguageDTO {
    description: string;
    name: string;
    icon: string;
}

export default class Language extends Entity {
    accessor name: string;
    accessor description: string;
    accessor icon: string;

    constructor({ description, name, icon }: ICreateLanguageDTO) {
        super();
        this.description = description;
        this.name = name;
        this.icon = icon;
    }
}
