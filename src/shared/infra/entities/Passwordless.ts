import Entity from "./Entity";

export default class Passwordless {
    constructor(entity: Entity & { password: string }) {
        Object.entries(entity).forEach(([property, value]) => {
            if (property !== "password") {
                // This is hacky, but it works.
                // @ts-ignore
                this[property] = value;
            }
        });
    }
}
