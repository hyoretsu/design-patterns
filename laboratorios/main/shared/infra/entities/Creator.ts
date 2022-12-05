import Entity from "./Entity";

export default abstract class Creator {
    public abstract createEntity(info: Record<string, any>): Entity;
}
