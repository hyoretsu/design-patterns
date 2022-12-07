import User from "../../infra/entities/User";
import IUsersRepository from "../../infra/repositories/IUsersRepository";

type IRequest = Partial<User> & {
    id: string;
};

export default class UpdateUserService {
    constructor(private usersRepository: IUsersRepository) {}

    public async execute(info: IRequest): Promise<void> {
        const user = await this.usersRepository.findById(info.id);
        if (!user) {
            throw new Error("User not found.");
        }

        Object.assign(user, info);
        await this.usersRepository.save(user);
    }
}
