import { Routes, RouterModule } from '@angular/router';

import { IndexComponent } from './index/index.component';

const appRoutes = [
    {path: '', component: IndexComponent, pathMatch: 'full' }
];

export const routing = RouterModule.forRoot(appRoutes);