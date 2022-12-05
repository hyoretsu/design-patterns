import Entity from "../../../../shared/infra/entities/Entity";

export interface ICreateUserDTO {
    login: string;
    nickname: string;
    password: string;
}

export default class User extends Entity {
    private _nickname: string;
    private _login: string;
    private _password: string;
    private _avatar?: string;
    private _experience: number;

    constructor({ login, nickname, password }: ICreateUserDTO) {
        super();
        this._experience = 0;
        this._login = login;
        this._nickname = nickname;
        this._password = password;
    }

    public get nickname() {
        return this._nickname;
    }

    public set nickname(value) {
        this._nickname = value;

        this.updatedAt = new Date();
    }

    public get login() {
        return this._login;
    }

    public set login(value) {
        this._login = value;

        this.updatedAt = new Date();
    }

    public get password() {
        return this._password;
    }

    public set password(value) {
        this._password = value;

        this.updatedAt = new Date();
    }

    public get avatar() {
        return this._avatar || "";
    }

    public set avatar(value) {
        this._avatar = value;

        this.updatedAt = new Date();
    }

    public get experience() {
        return this._experience;
    }

    public set experience(value) {
        this._experience = value;

        this.updatedAt = new Date();
    }
}
