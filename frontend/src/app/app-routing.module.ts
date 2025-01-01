import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {LayoutComponent} from './layout/layout.component';
import {AuthGuard} from './auth.guard';
import {UtilisateursComponent} from './utilisateurs/utilisateurs.component';
import {RecievedmailsComponent} from './recievedmails/recievedmails.component';
import {SentmailsComponent} from './sentmails/sentmails.component';
import {NewmailComponent} from './newmail/newmail.component';



const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: '', component: LayoutComponent,
    canActivate: [AuthGuard],
    children: [
      {path: 'utilisateurs', component: UtilisateursComponent},
      {path: 'newmails', component: NewmailComponent},
      {path: 'messagesRecus', component: RecievedmailsComponent},
      {path: 'messagesEnvoyes', component: SentmailsComponent},
    ]
  },
  {path:'', redirectTo: '/login', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
