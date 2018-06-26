import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModule, ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { LoginService } from './login.service';
import { User } from '../Interfaces/User/user.model';


@Component({
    selector:'app-login',
    templateUrl: './login.component.html'
})

export class LoginComponent{

    constructor(private router:Router, private loginService:LoginService, private modalService:NgbModal){}
    private result: string;

    @Input()
    private form: string;

    login(event: any, userName:string, pass: string){
        event.preventDefault();
        this.loginService.login(userName, pass).subscribe(
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
            };
            error=>alert('Wrong user or password')
        );
    }
}