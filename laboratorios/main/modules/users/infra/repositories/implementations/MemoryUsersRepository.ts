import MemoryRepository from "../../../../../shared/infra/repositories/implementations/MemoryRepository";
import User from "../../entities/User";
import IUsersRepository from "../IUsersRepository";

export default class MemoryUsersRepository implements IUsersRepository {
    private users: Record<string, User>;

    constructor() {
        const memoryRepository = MemoryRepository.getInstance();
        this.users = memoryRepository.get("users");
    }

    public async findById(userId: string): Promise<User | undefined> {
        const [_, foundUser] = Object.entries(this.users).find(([id, user]) => id === userId) || [];

        return foundUser;
    }

    public async save(user: User): Promise<void> {
        this.users[user.id] = user;
    }
}
