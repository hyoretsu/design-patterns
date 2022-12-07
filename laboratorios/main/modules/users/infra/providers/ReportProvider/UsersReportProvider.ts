import ReportProvider from "../../../../../shared/providers/reports/ReportProvider";
import User from "../../entities/User";
import IUsersRepository from "../../repositories/IUsersRepository";

export default abstract class UsersReportProvider extends ReportProvider {
    constructor(private usersRepository: IUsersRepository) {
        super();
    }

    protected async findEntity(userId: string): Promise<User | undefined> {
        return this.usersRepository.findById(userId);
    }

    protected async extractInfo(user: User): Promise<Record<string, any>> {
        return user;
    }
}
