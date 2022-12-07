import UsersReportProvider from "../UsersReportProvider";

export default class UsersPDFReportProvider extends UsersReportProvider {
    protected async outputReport(info: Record<string, any>): Promise<string | Buffer> {
        return "PDFzão";
    }
}
