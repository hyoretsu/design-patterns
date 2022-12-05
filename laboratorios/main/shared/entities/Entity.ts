import { randomUUID } from "crypto";

export default class Entity {
    protected _id: string;
    protected _createdAt: Date;
    protected _updatedAt: Date;

    constructor() {
        this._id = randomUUID();
        this._createdAt = new Date();
        this._updatedAt = new Date();
    }

    public get id() {
        return this._id;
    }

    public get createdAt() {
        return this._createdAt;
    }

    public get updatedAt() {
        return this._updatedAt;
    }

    public set updatedAt(value) {
        this._updatedAt = value;
    }
}
