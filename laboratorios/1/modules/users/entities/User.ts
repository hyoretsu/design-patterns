export default class User {
    private _login: string;
    private _password: string;

    constructor({ login, password }) {
        this._login = login;
        this._password = password;
    }

    public get login(): string {
        return this._login;
    }

    public get password(): string {
        return this._password;
    }
}
