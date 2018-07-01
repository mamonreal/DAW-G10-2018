import { Routes, RouterModule } from '@angular/router';
import { userProfileComponent } from './User/userProfile.component';
import { ProductComponent } from './Product/product.component';
import { LoginComponent } from './login/login.component';










const appRoutes = [
    {path: 'User', component: userProfileComponent},
    {path: 'Product', component: ProductComponent },
    {path: 'Login', component:LoginComponent}
];





export const routing = RouterModule.forRoot(appRoutes);