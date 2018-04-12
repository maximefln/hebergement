package managers;

/*Cette classe permet de regrouper toutes les méthodes utilisées dans les fonctionnalités du site web, en lien avec les membres sans que les servlets associées ne puisse avoir un accès direct à la base de données.
        *
        * @author MFillion
        * @version 1.0
        */

import dao.MembreDao;
import dao.MembreDaoImpl;
import entities.Membre;

import java.util.List;
import java.util.TreeMap;

public class MembreLibrary {


    private static class MembreLibraryHolder{
        private static final MembreLibrary instance = new MembreLibrary();
    }

    /*methode qui permet de récupérer l'instance MembreLibrary
     *
     * Elle retourne l'instance de MembreLibrary
     * @return l'instance de MembreLibrary
     *
     * @author MFillion
     * @version 1.0
     */

    public static MembreLibrary getInstance(){
        return MembreLibrary.MembreLibraryHolder.instance;
    }

    private MembreDao membreDao = new MembreDaoImpl();

    /*Contructeur par défaut
     * @author MFillion
     * @version 1.0
     */

    private MembreLibrary(){
    }

    private TreeMap<Integer, Membre> membreList;

    /*methode qui permet de lister les membres enregistrés dans la base de données
     *
     * Elle retourne une liste de membres
     * @return une liste de membres (List<Membre>)
     *
     * @author MFillion
     * @version 1.0
     */

    public List<Membre> listMembre(){
        return membreDao.ListMembre();
    }

    /*methode qui permet d'ajouter un membre
     *
     * @param newMembre : le nouveau membre à ajouter (Membre)
     *
     * @author MFillion
     * @version 1.0
     */

    public void addMembre(Membre newMembre) {
        membreDao.addMembre(newMembre);
    }

    /*methode qui permet de supprimer un membre de la base de données
     *
     * @param id : l'identifiant du membre à supprimer en base de données (int)
     *
     * @author MFillion
     * @version 1.0
     */

    public void deleteMembre( int id){
        membreDao.deleteMembre(id);
    }
}


