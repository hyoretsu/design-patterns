import Entity from "../Entity";

export default abstract class Creator {
    abstract createEntity(info: Record<string, any>): Entity;
}
