import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LayoutComponent } from './layout/layout.component';
import { SentmailsComponent } from './sentmails/sentmails.component';
import { RecievedmailsComponent } from './recievedmails/recievedmails.component';
import { NewmailComponent } from './newmail/newmail.component';
import { UtilisateursComponent } from './utilisateurs/utilisateurs.component';
import {HttpClientModule, provideHttpClient, withFetch} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {AuthGuard} from './auth.guard';
import {GestionService} from './gestion.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LayoutComponent,
    SentmailsComponent,
    RecievedmailsComponent,
    NewmailComponent,
    UtilisateursComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [
    provideHttpClient(withFetch()),
    provideClientHydration(),
    AuthGuard,
    GestionService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
