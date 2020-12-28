import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hotel } from '../../model/hotel';
import { HotelService } from '../../services/hotel.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.sass']
})
export class UpdateEmployeeComponent implements OnInit {
  user_id!: number;
  employee : Hotel= new Hotel();
  constructor(private hotelService : HotelService,
    private route : ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
   this.user_id=this.route.snapshot.params['id'];
    this.hotelService.getEmployeeById(this.user_id).subscribe(data =>{
      console.log(data);
       this.employee=data;
    }, error => console.log(error));
  }
  
  saveEmploee(){
    this.hotelService.updateEmployee(this.user_id,this.employee).subscribe(data =>{
      console.log(data);
      this.gotoEmployeeList();
    },
    error => console.log(error));
  }
  onSubmit(){
    this.saveEmploee();
    this.gotoEmployeeList();
  }
  gotoEmployeeList(){
     this.router.navigate(['/employee-list']);
   }

}
