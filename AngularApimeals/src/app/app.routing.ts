import { Routes, RouterModule } from '@angular/router';
import { userProfileComponent } from './User/userProfile.component';
import { ProductComponent } from './Product/product.component';
import { LoginComponent } from './login/login.component';
import { IndexComponent } from './Index/index.component';










const appRoutes = [
    {path: 'User', component: userProfileComponent},
    {path: 'Product', component: ProductComponent },
    {path: 'Login', component:LoginComponent},
    {path: '', component: IndexComponent, pathMatch: 'full' },
        
];

export const routing = RouterModule.forRoot(appRoutes);