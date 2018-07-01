import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService} from '../login/login.service';



@Component({
    selector: 'HeaderComponent',
    templateUrl: 'header.component.html'

})


export class HeaderComponent {
    isAdmin: boolean;
    

    @Output() openLogin: EventEmitter<any> = new EventEmitter<any>();



    constructor(private router: Router, public service: LoginService){
        this.isAdmin = false;
    }


    logOut(){
        this.service.logOut().subscribe(
            response => { this.router.navigate['/login'], console.log ('Te has desconectado')},
            error => console.log('Error in log out proccess: ' + error )
        );
    }
}