package entities;

/*Cette classe permet de définir l'objet Message, de l'instancier, d'accéder et de modifier ces variables de classe
 * @see projet_100h.dao.MessageDaoImpl
 * @see projet_100h.servlets.ContactServlet
 *
 * @author MFillion
 * @version 1.0
 */

import java.time.LocalDate;

public class Message {

    private Integer id;
    private LocalDate date;
    private String nom;
    private String prenom;
    private String adresse_mail;
    private String message;

    /*constructeur qui permet d'instancier un message
     *
     * @param id : l'identifiant du message (Integer)
     * @param nom : le nom de la personne ayant envoyé le message (String)
     * @param prenom : le prenom de la personne ayant envoyé le message (String)
     * @param adresse_mail : l'adresse mail pour répondre à la personne(String)
     * @param message : le contenu du message (String)
     *
     * Le contructeur retourne une instance de Message
     * @return : une instance de Message
     *
     * @author MFillion
     * @version 1.0
     * @see projet_100h.servlets.ContactServlet
     */

    public Message (Integer id, LocalDate date, String nom, String prenom, String adresse_mail, String message){
        this.id = id;
        this.date = date;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse_mail = adresse_mail;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
