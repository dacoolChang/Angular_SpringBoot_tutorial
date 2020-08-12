import { Component, OnInit } from '@angular/core';
import { HelloService } from '../hello.service'

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit{
  data: String = "";
  constructor(private helloService:HelloService) { 
    helloService.getUser().subscribe(
      users => { // success
        users.forEach(element => {
          this.data += element.name+","+element.description;
        });
        console.log("success")
      }, error => { // failed
        console.log("error")
      }, () => {
        console.log("finally")
      } // complete
    );
  }
  ngOnInit() {
  }
}