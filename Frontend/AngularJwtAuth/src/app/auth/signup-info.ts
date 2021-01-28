export class SignUpInfo {
    id:number;
    name: string;
    username: string;
    email: string;
    address: string;
    phone: number;
    role: string[];
    password: string;

    constructor( id:number,name: string, username: string, email: string, address: string,phone: number,password: string) {
        this.id=id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.role = ['user'];
    }
}
