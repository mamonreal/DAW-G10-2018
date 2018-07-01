import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import {environment} from '../../environments/environment';
import {user} from '../Interfaces/User/user.model';
import 'rxjs/Rx';


//const URL = environment.apiBase + '/admin';


@Injectable()
export class AdminService {

    constructor(private http: Http){ }


}