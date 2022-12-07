import Creator from "@shared/infra/entities/creators/Creator";

import User, { ICreateUserDTO } from "../User";

export default class UserCreator extends Creator {
    createEntity(info: ICreateUserDTO): User {
        return new User(info);
    }
}
