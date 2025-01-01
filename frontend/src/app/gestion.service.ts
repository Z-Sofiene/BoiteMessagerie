import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GestionService {

  constructor(private http: HttpClient) {}
  getAllUtilisateurs(){
    return this.http.get('http://localhost:11000/api/utilisateurs');
  }
  getUtilisateur(id:number){
    return this.http.get('http://localhost:11000/api/utilisateur/'+id)
  }
  getAllMessages(){
    return this.http.get('http://localhost:11000/api/messages');
  }
  getMessageById(id:number){
    return this.http.get('http://localhost:11000/api/message/'+id)
  }
  addMessage(msg:any) {
    return this.http.post("http://localhost:11000/api/addMessage",msg );
  }
  getAllSentMessagesByUserId(usid:number){
    return this.http.get('http://localhost:11000/api/messagesrecus/'+usid);
  }
  getAllRecievedMessagesByUserId(urid:number){
    return this.http.get('http://localhost:11000/api/messagesenvoyes/'+urid);
  }
  deleteMessage(id_msg:number){
    return this.http.delete("http://localhost:11000/api/delMessage/"+id_msg);
  }
}
