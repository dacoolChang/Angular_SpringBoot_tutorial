import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { TimeInterval } from 'rxjs';


@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit{

  data: number;
  interval;
  constructor(private router: Router) { 
    this.data = 100;
    this.interval = setInterval(() => {
        this.data+=1;
      }
    ,1000);
  }


  ngOnInit() {
  }
}