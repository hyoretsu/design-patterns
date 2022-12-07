import Entity from "../../../../shared/infra/entities/Entity";

export interface ICreateLanguageDTO {
    description: string;
    name: string;
    icon: string;
}

export default class Language extends Entity {
    private _name: string;
    private _description: string;
    private _icon: string;

    constructor({ description, name, icon }: ICreateLanguageDTO) {
        super();
        this._description = description;
        this._name = name;
        this._icon = icon;
    }

    public get name() {
        return this._name;
    }

    public set name(value) {
        this._name = value;

        this.updatedAt = new Date();
    }

    public get description() {
        return this._description;
    }

    public set description(value) {
        this._description = value;

        this.updatedAt = new Date();
    }

    public get icon() {
        return this._icon;
    }

    public set icon(value) {
        this._icon = value;

        this.updatedAt = new Date();
    }
}
