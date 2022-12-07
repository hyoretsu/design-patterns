import Entity from "../../../../shared/infra/entities/Entity";

export interface ICreateFriendshipDTO {
    friendId: string;
    userId: string;
}

export default class Friendship extends Entity {
    private _userId: string;
    private _friendId: string;

    constructor({ friendId, userId }) {
        super();
        this._friendId = friendId;
        this._userId = userId;
    }

    public get friendId() {
        return this._friendId;
    }

    public get userId() {
        return this._userId;
    }
}
