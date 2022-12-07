export default class MemoryRepository {
    private static instance: MemoryRepository;
    private entities: Record<string, Record<string, any>> = {};

    public static getInstance() {
        if (!this.instance) {
            this.instance = new MemoryRepository();
        }

        return this.instance;
    }

    public get(entityName: string) {
        return this.entities[entityName];
    }
}
