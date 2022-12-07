import { capitalize } from "@hyoretsu/shared.utils";

import Entity from "../../../entities/Entity";
import ICommand from "../ICommand";

export default class CreateCommand implements ICommand {
    private snapshots: Record<string, Entity>;

    constructor(private module: string) {}

    public async execute(info: Record<string, any>): Promise<void> {
        const CreateService = await import(
            `../../../../modules/${this.module}/business/services/Create${capitalize(this.module.slice(0, -1))}Service`
        );

        const createService = new CreateService();

        const entity = await createService.execute(info);

        Object.assign(this.snapshots, { [entity.updatedAt]: { ...entity } });
    }

    public async undo(): Promise<void> {
        const UpdateService = await import(
            `../../../../modules/${this.module}/business/services/Update${capitalize(this.module.slice(0, -1))}Service`
        );

        const updateService = new UpdateService();

        const [timestamp, snapshot] = Object.entries(this.snapshots).find(([time, id], i) => {
            return i === Object.keys(this.snapshots).length - 1;
        }) as [string, Entity];

        delete this.snapshots[timestamp];

        await updateService.execute(snapshot);
    }
}
