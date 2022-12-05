import Creator from "../../../../shared/infra/entities/Creator";
import Friendship, { ICreateFriendshipDTO } from "./Friendship";

export default class FriendshipCreator extends Creator {
    public createEntity(info: ICreateFriendshipDTO): Friendship {
        return new Friendship(info);
    }
}
