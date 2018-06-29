import { Routes, RouterModule } from '@angular/router';
import { userProfileComponent } from './User/userProfile.component';
import { ProductComponent } from './Product/product.component';










const appRoutes = [
    {path: 'User', component: userProfileComponent},
    {path: 'Product', component: ProductComponent }
];





export const routing = RouterModule.forRoot(appRoutes);