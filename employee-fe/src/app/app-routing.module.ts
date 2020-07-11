import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './list/list.component';
import {CreateComponent} from './create/create.component';
import {UpdateComponent} from './update/update.component';
import {DetailComponent} from './detail/detail.component';

const routes: Routes = [
  { path: '', redirectTo: 'list', pathMatch: 'full' },
  { path: 'list', component: ListComponent },
  { path: 'create', component: CreateComponent },
  { path: 'update/:no', component: UpdateComponent },
  { path: 'detail/:no', component: DetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
