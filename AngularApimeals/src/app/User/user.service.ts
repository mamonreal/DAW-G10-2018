import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../environments/environment';
import { user } from '../Interfaces/User/user.model';

const BASE_URL = environment.apiBase + '/User';


@Injectable()
export class UserService {

    public user: user;

    constructor(private http: Http) {

    }

    getUser(id: number){
        const headers = new Headers({
            'X-Requested-With': 'XMLHttpRequest'    
        });
        
    }
}