package tn.essat.boitemessagerie.model;

import javax.persistence.*;

@Entity
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sujet;
    private String contenu;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usersender_id",
            foreignKey = @ForeignKey(
                    name = "fk_usersender",
                    foreignKeyDefinition = "FOREIGN KEY (usersender_id) REFERENCES User(id) ON DELETE CASCADE ON CASCADE UPDATE")
    )
    private User usersend;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userreciever_id",
            foreignKey = @ForeignKey(
                    name = "fk_userreciever",
                    foreignKeyDefinition = "FOREIGN KEY (userreciever_id) REFERENCES User(id) ON DELETE CASCADE")
    )
    private User userreceive;

    public Message() {
        super();
    }

    public Message(Integer id, String sujet, String contenu, User usersend, User datereceive) {
        this.id = id;
        this.sujet = sujet;
        this.contenu = contenu;
        this.usersend = usersend;
        this.userreceive = datereceive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public User getUsersend() {
        return usersend;
    }

    public void setUsersend(User usersend) {
        this.usersend = usersend;
    }

    public User getUserreceive() {
        return userreceive;
    }

    public void setDatereceive(User datereceive) {
        this.userreceive = datereceive;
    }
}
