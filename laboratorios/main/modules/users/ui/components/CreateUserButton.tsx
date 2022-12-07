import Button from "../../../../shared/components/Button";
import CreateCommand from "../../../../shared/providers/commands/implementations/CreateCommand";

export default class CreateUserButton extends Button {
    constructor(text: string) {
        super({ command: new CreateCommand("users"), text });
    }
}
