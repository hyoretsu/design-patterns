import User from '../../entities/User';
import IUsersRepository from '../IUsersRepository';

export default class MemoryUsersRepository implements IUsersRepository {
    private users: User[] = [];

    public async save(user: User): Promise<void> {
        this.users.push(user);
    }
}
