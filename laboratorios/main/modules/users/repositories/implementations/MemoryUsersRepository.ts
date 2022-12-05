import MemoryRepository from "../../../../shared/repositories/implementations/MemoryRepository";
import User from "../../infra/entities/User";
import IUsersRepository from "../IUsersRepository";

export default class MemoryUsersRepository implements IUsersRepository {
    private users: User[];

    constructor() {
        const memoryRepository = MemoryRepository.getInstance();
        this.users = memoryRepository.get("users");
    }

    public async findById(userId: string): Promise<User | undefined> {
        const foundUser = this.users.find(user => user.id === userId);

        return foundUser;
    }

    public async save(user: User): Promise<void> {
        this.users.push(user);
    }
}
