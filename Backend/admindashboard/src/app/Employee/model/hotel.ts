import { Booking } from 'src/app/Booking/model/booking';
export class Hotel {
    bookId!: number;
    bookName?: string;
    author?: string;
    bookings?: Booking[];
    
}
