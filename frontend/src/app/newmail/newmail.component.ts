import { Component } from '@angular/core';
import {GestionService} from '../gestion.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-newmail',
  templateUrl: './newmail.component.html',
  styleUrl: './newmail.component.css'
})
export class NewmailComponent {
  msg: any = { sujet: '',  contenu: '' , usersender: { id: 1 }, userreciever: { id:1} }; // Object to hold new category input
  users : any =[]
  constructor(private gest: GestionService, private router: Router) {
    this.getUsers();
  }
  getUsers(): void {
    this.gest.getAllUtilisateurs().subscribe (
      {
        next: data => { this.users = data; },
        error : err => { console.log(err) },
        complete : () => { }

      }
    )
  }
  sentMessage(): void {
    console.log('Sent avec success'); // To check if the method is called
    this.gest.addMessage(this.msg).subscribe(
      {
        next: data => {
          this.router.navigateByUrl('/messagesEnvoyes');
        },
        error: err => {},
        complete: () => { }
      }
    )
  }

}
