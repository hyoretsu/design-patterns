import Entity from "../../../../shared/infra/entities/Entity";

export interface ICreateUserDTO {
    login: string;
    nickname: string;
    password: string;
}

export default class User extends Entity {
    accessor nickname: string;
    accessor login: string;
    accessor password: string;
    accessor avatar: string;
    accessor experience: number;

    constructor({ login, nickname, password }: ICreateUserDTO) {
        super();
        this.avatar = "";
        this.experience = 0;
        this.login = login;
        this.nickname = nickname;
        this.password = password;
    }
}
