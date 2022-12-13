import Command from "../infra/providers/commands/ICommand";

interface ICreateButtonDTO {
    command: Command;
    text: string;
}

export default class Button {
    private command: Command;
    private text: string;

    constructor({ command, text }: ICreateButtonDTO) {
        this.command = command;
        this.text = text;
    }

    render() {
        return (
            <button type="button" onClick={this.command.execute}>
                {this.text}
            </button>
        );
    }
}
