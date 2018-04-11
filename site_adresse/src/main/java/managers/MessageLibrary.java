package managers;

/*Cette classe permet de regrouper toutes les méthodes utilisées dans les fonctionnalités du site web, en lien avec les messsages sans que les servlets associées ne puisse avoir un accès direct à la base de données.
 * @see projet_100h.servlets.ContactServlet
 * @see projet_100h.dao.MessageDaoImpl
 *
 * @author MFillion
 * @version 1.0
 */

import dao.MessageDao;
import dao.MessageDaoImpl;
import entities.Message;

import java.util.List;
import java.util.TreeMap;

public class MessageLibrary {


    /* Cette classe permet de créer une seule et unique instance de MessageLibrary en empechant l'instanciation extérieure
     *
     * @author MFillion
     * @version 1.0
     */

    private static class MessageLibraryHolder{
        private static final MessageLibrary instance = new MessageLibrary();
    }

    /*methode qui permet de récupérer l'instance MessageLibrary
     *
     * Elle retourne l'instance de MessageLibrary
     * @return l'instance de MessageLibrary
     *
     * @author MFillion
     * @version 1.0
     */

    public static MessageLibrary getInstance(){
        return MessageLibrary.MessageLibraryHolder.instance;
    }

    private MessageDao messageDao = new MessageDaoImpl();

    /*Contructeur par défaut
     * @author MFillion
     * @version 1.0
     */

    private MessageLibrary(){
    }

    private TreeMap<Integer, Message> messageList;

    /*methode qui permet de lister tous les messages stockés en base de données.
     *
     * Elle retourne une liste de message
     * @return une liste de message (List<Message>)
     *
     * @author MFillion
     * @version 1.0
     */

    public List<Message> listMessage(){
        return messageDao.listMessage();
    }

    /*methode qui permet d'ajouter un message.
     *
     * @param newMessage : le nouveau message à ajouter (Message)
     *
     * @author MFillion
     * @version 1.0
     */

    public void addMessage(Message message) {
        messageDao.addMessage(message);
    }

    /*methode qui permet de supprimer un message de la base de données
     *
     * @param id : l'identifiant du message à supprimer en base de données (int)
     *
     * @author MFillion
     * @version 1.0
     */

    public void deleteMessage( int id){
        messageDao.deleteMessage(id);
    }
}

