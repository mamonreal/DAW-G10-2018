import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Observable';
import { user } from '../Interfaces/User/user.model';


const BASE_URL = environment.apiBase + '/signup';

@Injectable()
export class SignUpService {

    constructor(private http: Http){ }



    signup(userData: any) {
        const headers = new Headers({
            'Content-Type': 'application/json'
    });

    const options = new RequestOptions({ headers});
    return this.http.post(BASE_URL, userData, options)
        .map(response =>response.json())
        .catch(error => this.handleError(error));
}

private handleError(error: any) {
    console.error(error);
    return Observable.throw("Server error (" + error.status + "): " + error.text())
  }


}