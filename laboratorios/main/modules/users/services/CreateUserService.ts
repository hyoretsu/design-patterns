import { randomId } from "@hyoretsu/shared.utils";

import User, { ICreateUserDTO } from "../entities/User";
import IUsersRepository from "../repositories/IUsersRepository";

export default class CreateUserService {
    constructor(private usersRepository: IUsersRepository) {}

    public async execute({ login, nickname, password }: ICreateUserDTO): Promise<User> {
        if (login === "") {
            throw new Error("O login não pode ser vazio.");
        } else if (login.length > 12) {
            throw new Error("O máximo de caracteres permitido é 12.");
        } else if (login.match(/\d/)) {
            throw new Error("O login não pode conter números.");
        }

        if (password.length < 8) {
            throw new Error("O mínimo de caracteres permitido é 8.");
        } else if (password.length > 20) {
            throw new Error("O máximo de caracteres permitido é 20.");
        } else if (!password.match(/[A-z]/)) {
            throw new Error("A senha deve conter letras.");
        } else if (!password.match(/\d/)) {
            throw new Error("A senha deve conter números.");
        } else if ((password.match(/\d/g) || []).length < 2) {
            throw new Error("A senha deve conter pelo menos 2 números.");
        }

        const user = new User({ login, nickname, password });

        await this.usersRepository.save(user);

        return user;
    }
}
