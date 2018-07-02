import { Routes, RouterModule } from '@angular/router';
import { userProfileComponent } from './User/userProfile.component';
import { ProductsComponent } from './Product/products.component';
import { LoginComponent } from './login/login.component';
import { IndexComponent } from './Index/index.component';
import { SignUpComponent } from './SignUp/signup.component';

const appRoutes = [
    // {path: 'user', component: userProfileComponent},
    // {path: 'product', component: ProductsComponent },
    // {path: 'login', component: LoginComponent},
    // {path: 'signUp', component: SignUpComponent},
    {path: '', component: IndexComponent, pathMatch: 'full' },
        
];

export const routing = RouterModule.forRoot(appRoutes);