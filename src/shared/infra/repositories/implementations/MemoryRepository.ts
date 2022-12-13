export default class MemoryRepository {
    private static instance: MemoryRepository;
    private entities: Record<string, Record<string, any>> = {};

    static getInstance() {
        if (!this.instance) {
            this.instance = new MemoryRepository();
        }

        return this.instance;
    }

    getRepository(entityName: string) {
        return this.entities[entityName] || {};
    }
}
