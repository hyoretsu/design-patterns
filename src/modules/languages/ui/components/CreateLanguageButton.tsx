import Button from "@shared/components/Button";
import CreateCommand from "@shared/infra/providers/commands/implementations/CreateCommand";

export default class CreateLanguageButton extends Button {
    constructor(text: string) {
        super({ command: new CreateCommand("languages"), text });
    }
}
