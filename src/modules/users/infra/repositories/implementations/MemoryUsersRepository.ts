import MemoryRepository from "@shared/infra/repositories/implementations/MemoryRepository";

import User from "../../entities/User";
import IUsersRepository from "../IUsersRepository";

export default class MemoryUsersRepository implements IUsersRepository {
    private users: Record<string, User>;

    constructor() {
        const memoryRepository = MemoryRepository.getInstance();
        this.users = memoryRepository.getRepository("users");
    }

    async findById(userId: string): Promise<User | undefined> {
        const [_, foundUser] = Object.entries(this.users).find(([id, user]) => id === userId) || [];

        return foundUser;
    }

    async save(user: User): Promise<void> {
        this.users[user.id] = user;
    }
}
