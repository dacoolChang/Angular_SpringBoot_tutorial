import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { DataModule } from '../models/DataModule'

@Injectable()
export class HelloService {
    apiUrl: String = 'http://localhost:8080/rest'
    constructor(private http: HttpClient) {

    }
  
    getUser() {
        return this.http.get<DataModule.User[]>(this.apiUrl + '/user');
    }
  }