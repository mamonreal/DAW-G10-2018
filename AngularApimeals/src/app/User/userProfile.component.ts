import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { LoginService } from '../login/login.service';
import { UserService } from '../User/user.service';
import { user } from '../Interfaces/User/user.model';

@Component({
    selector: 'userProfileComponent',
    templateUrl: './user.component.html'
})

export class userProfileComponent{
    loggedUser: user;
    


constructor(private loginService: LoginService, private userService: UserService) {
    this.loggedUser = this.loginService.getLoggedUser();
}


}