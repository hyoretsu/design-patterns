import { randomUUID } from "crypto";

export default class Entity {
    protected _id: string;
    protected _createdAt: Date;
    protected accessor updatedAt: Date;

    constructor() {
        this._id = randomUUID();
        this._createdAt = new Date();
        this.updatedAt = new Date();
    }

    get id() {
        return this._id;
    }

    get createdAt() {
        return this._createdAt;
    }
}
