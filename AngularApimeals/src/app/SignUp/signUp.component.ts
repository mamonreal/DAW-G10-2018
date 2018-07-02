import { Component} from '@angular/core';
import { user } from '../Interfaces/User/user.model';
import { SignUpService } from 'app/SignUp/signUp.service';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../login/login.service';
import { UserService} from '../User/user.service'


@Component({
    
    selector:'SignUpComponent',
    templateUrl: './signUp.component.html',

})

export class SignUpComponent {
    private registered: boolean = false;
    private userData: any = {
        user: "",
        pass: ""
    }

    constructor(private router: Router, private loginService: LoginService, private signUpService: SignUpService, activatedRoute: ActivatedRoute){
        const id = activatedRoute.snapshot.params['id'];


    if(id){
        signUpService.signup(this.userData).subscribe(
            user => this.userData = user,
            error => console.error(error)         
        );
        this.registered = false;
    } else {
        this.userData = { name: ' ', passwordHash: '', roles: ['ROLE_USER'] };
        this.registered = true;
    }
      }

    signup(){
        this.signUpService.signup(this.userData).subscribe(
            product => { },
            error => console.error('Error al crear el usuario: ' + error)
        );
        window.confirm('Ha introducido los datos correctamente?')
        this.router.navigate(['/login']);
    }
}