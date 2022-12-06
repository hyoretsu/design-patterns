import Entity from "../../infra/entities/Entity";

export default abstract class ReportProvider {
    public async generateReport(id: string): Promise<string | Buffer> {
        const entity = await this.findEntity(id);
        if (!entity) {
            throw new Error("No entity with the given ID was found.");
        }

        const info = this.extractInfo(entity);

        return this.outputReport(info);
    }

    protected abstract findEntity(entityId: string): Promise<Entity | undefined>;
    protected abstract extractInfo(entity: Entity): Promise<Record<string, any>>;
    protected abstract outputReport(info: Record<string, any>): Promise<string | Buffer>;
}
