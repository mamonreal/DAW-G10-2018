import { Injectable, OnInit } from '@angular/core';
import { user } from '../Interfaces/User/user.model';
import { Http, RequestOptions, Headers } from '@angular/http';
import { environment } from '../../environments/environment';
import 'rxjs/Rx';

const BASE_URL = environment.apiBase;

@Injectable()
    export class LoginService{
        isLogged = false;
        isAdmin = false;
        user: user;

        constructor(private http: Http){
            this.reqisLogged();
        }

 

        getLoggedUser(){
            return this.user;
        }

        setLoggedUser(user:user){
            this.user=user;
        }

        isLoggedUser(){
            return this.isLogged;
        }
        //admin isAdmin

        reqisLogged(){
            const headers = new Headers({
                'X-Requested-With': 'XMLHttpRequest'
            });

        const options = new RequestOptions({withCredentials:true, headers});
        this.http.get(BASE_URL + '/logIn', options).subscribe(
            response => this.processLogInResponse(response),
            error => {
                if (error.status !== 401){
                    console.error('Error with the logged: ' + JSON.stringify(error));
                }
            }
        );
    }

    private processLogInResponse(response){
        this.isLogged= true;
        this.user = response.json();
        this.isAdmin = this.user.roles.indexOf('ROLE_ADMIN') !== -1;
    }

    logIn(user: string, pass:string){
        const userPass = user + ':' + pass;

        const headers = new Headers({
            'Authorization': 'Basic ' + utf8_to_b64(userPass),
            'X-Requested-With': 'XMLHttpRequest'
        });

        const options = new RequestOptions({withCredentials: true});
        return this.http.get(URL +'/user',options).map(
            response => {
                this.processLogInResponse(response);
                return this.user;
            }
        );
    }

    logOut(){
        return this.http.get(URL + '/logout', {withCredentials: true}).map(
            response => {
                this.isLogged = false;
                this.isAdmin = false;
                return response;
            }
        );
    }
}
    function utf8_to_b64(str) {
        return btoa(encodeURIComponent(str).replace(/%([0-9A-F]{2})/g, function (match, p1) {
            return String.fromCharCode(<any>'0x' + p1);
        }));

        
    }
