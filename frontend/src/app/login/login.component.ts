import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  loginError: boolean = false;

  constructor(private auth: AuthService, private router: Router) {}

  Login() {
    this.auth.verifUser(this.username, this.password).subscribe({
      "next": data => {

        if (data) {
          localStorage.setItem("currentUser", JSON.stringify(data));
          this.router.navigateByUrl('/messagesRecus');
        }
      },
      "error": err => {
      },
      "complete": () => {
      }
    })
  }

}
