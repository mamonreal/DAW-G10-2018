import { Routes, RouterModule } from '@angular/router';
import { userProfileComponent } from './User/userProfile.component';
import { ProductComponent } from './Product/products.component';
import { IndexComponent } from './Index/index.component';

const appRoutes = [
    { path: '', component: IndexComponent, pathMatch: 'full' },
    { path: 'User', component: userProfileComponent },
    { path: 'Product', component: ProductComponent }
];

export const routing = RouterModule.forRoot(appRoutes);