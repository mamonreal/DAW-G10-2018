import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

import { LoginService } from './login.service';
import { user } from '../Interfaces/User/user.model';


@Component({
    selector:'app-login',
    templateUrl: './login.component.html'
})

export class LoginComponent{

    constructor(private router:Router, private loginService:LoginService){}
    private result: string;

    @Input()
    private form: string;

    logIn(event: any, userName:string, pass: string){
        event.preventDefault();
        this.loginService.logIn(userName, pass).subscribe(
            user=>{
                console.log(user);
                if(this.form=="1"){
                    this.router.navigate(['/login']);
                }
                else{
                    this.router.navigate(['/']).then(
                        response=>{
                            this.router.navigate(['/login'])
                        }
                    );
                }
            },
            error=>alert('Wrong user or password')
        );
    }

    logOut() {
        this.loginService.logOut().subscribe(
            response => {
                console.log('Logged out');
                this.router.navigate(['/']);
            },
            error => console.log('Error in the log out: ' + error)
        );
        
    }
}