import UsersReportProvider from "../UsersReportProvider";

export default class UsersHTMLReportProvider extends UsersReportProvider {
    protected async outputReport(info: Record<string, any>): Promise<string | Buffer> {
        return "HTML brabo";
    }
}
