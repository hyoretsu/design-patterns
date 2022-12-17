export default class EnsureAuthenticated {
    static execute(req: Record<string, any>) {
        if (!req.session.user) {
            throw new Error("This action needs authentication.");
        }
    }
}
