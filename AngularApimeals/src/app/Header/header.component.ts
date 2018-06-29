import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService} from '../login/login.service';



@Component({
    selector: 'app-header',
    templateUrl: 'header.component.html'

})


export class HeaderComponent {
    isAdmin: boolean;
    

    @Output() openLogin: EventEmitter<any> = new EventEmitter<any>();



    constructor(private router: Router, public service: LoginService){
        this.isAdmin = false;
    }

    logIn(){
        this.openLogin.emit();
    }

    logOut(){
        this.service.logOut().subscribe(
            response => { },
            error => console.log('Error in log out proccess: ' + error )
        );
    }
}