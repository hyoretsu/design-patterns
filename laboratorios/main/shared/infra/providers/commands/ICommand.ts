export default interface ICommand {
    execute(info: Record<string, any>): Promise<void>;
}
