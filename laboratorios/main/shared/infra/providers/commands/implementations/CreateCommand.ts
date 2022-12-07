import { capitalize } from "@hyoretsu/shared.utils";

import ICommand from "../ICommand";

export default class CreateCommand implements ICommand {
    constructor(private module: string) {}

    public async execute(info: Record<string, any>): Promise<void> {
        const CreateService = await import(
            `../../../../modules/${this.module}/business/services/Create${capitalize(this.module.slice(0, -1))}Service`
        );

        const createService = new CreateService();

        await createService.execute(info);
    }
}
