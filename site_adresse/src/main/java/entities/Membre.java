package entities;

/*Cette classe permet de définir l'objet Membre, de l'instancier, d'accéder et de modifier ces variables de classe
 * @see projet_100h.dao.MembreDaoImpl
 * @see projet_100h.servlets.MembreServlet
 * @author MFillion
 * @version 1.0
 */

public class Membre {

    private Integer id;
    private String nom;
    private String prenom;
    private String fonction;
    private String lien_image;


    /*constructeur qui permet d'instancier un membre
     *
     * @param id : l'identifiant du membre (Integer)
     * @param nom : le nom de du membre (String)
     * @param prenom : le prenom du membre (String)
     * @param fonction : la fonction du membre au sein de l'association (String)
     * @param lien_image : le lien de la photo de profil
     *
     * Le contructeur retourne une instance de Membre
     * @return : une instance de Membre
     *
     * @author MFillion
     * @version 1.0
     */

    public Membre (Integer id, String nom, String prenom, String fonction, String lien_image){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.fonction = fonction;
        this.lien_image = lien_image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getLien_image() {
        return lien_image;
    }

    public void setLien_image(String lien_image) {
        this.lien_image = lien_image;
    }
}
