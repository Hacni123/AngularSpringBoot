
export class Order {
    id!: number;
   status : String
    order_date? : Date;
    total_price:number;
   cakeid: number;
   
   constructor( id:number, status: string, order_date: Date, total_price: number,cakeid:number) {
       this.id=id;
       this.status = status;
       this.order_date = order_date;
       this.total_price = total_price;
       this.cakeid = cakeid;
   }
}
