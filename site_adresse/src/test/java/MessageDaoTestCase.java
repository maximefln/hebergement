import dao.DataSourceProvider;
import dao.MessageDao;
import dao.MessageDaoImpl;
import entities.Message;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.tuple;

public class MessageDaoTestCase {

    private MessageDao messageDao = new MessageDaoImpl();

    @Before
    public void initDb() throws Exception {
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate("DELETE FROM message");
            statement.executeUpdate("ALTER TABLE message AUTO_INCREMENT=0");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-08', 'La Luck', 'Bar', 'test', 'Maxime Fillion', 50.6462, 3.05978, 'img/articles/la_luck.jpg', 'test', 4, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-07', 'Bibovino', 'Bar', 'test', 'Maxime Fillion', 50.641169, 3.06147, 'img/articles/bibovino.jpg', 'test', 3, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-06', 'La Capsule', 'Bar', 'test', 'Maxime Fillion', 50.640498, 3.060141, 'img/articles/la_capsule.jpg', 'test', 4, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-05', 'Le Point de Départ', 'Bar', 'test', 'Maxime Fillion', 50.634885, 3.047588, 'img/articles/le_point_de_depart.jpg', 'test', 3, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-04', 'La part des anges', 'Bar', 'test', 'Maxime Fillion', 50.64148, 3.062211, 'img/articles/la_part_des_anges.jpg', 'test', 4, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-03', 'L_Adresse', 'Restaurant', 'Description à venir', 'Maxime Fillion', 50.637879, 3.058189, 'img/articles/l_adresse.jpg', 'test', 4, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-02', 'T_Rijsel', 'Restaurant', 'Description à venir', 'Maxime Fillion', 50.642121, 3.065889, 'img/articles/t_rijsel.jpg', 'test', 4, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-01', 'le_pot_beaujolais', 'Restaurant', 'Description à venir', 'Maxime Fillion', 50.63656, 3.065094, 'img/articles/le_pot_beaujolais.jpg', 'test', 4, 0, 0);");
            statement.executeUpdate("INSERT INTO message(`date`, `nom`, `prenom`, `adresse_mail`, `message`) VALUES ('2018-03-14', 'premier', 'message', 'premier@message.fr', 'hello world')");
            statement.executeUpdate("INSERT INTO message(`date`, `nom`, `prenom`, `adresse_mail`, `message`) VALUES ('2018-03-15', 'second', 'message', 'second@message.fr', 'hello again')");
        }
    }

    @Test
    public void ShouldListMessage () {
        //WHEN
        List<Message> messageList = messageDao.listMessage();
        //THEN
        assertThat(messageList).hasSize(2);
        assertThat(messageList).extracting( "nom", "prenom", "adresse_mail", "message").containsOnly(
                tuple( "second", "message", "second@message.fr", "hello again"),
                tuple( "premier", "message", "premier@message.fr", "hello world")
        );
    }

    @Test
    public void shouldAddMessage() throws SQLException {
        //GIVEN
        Message message = new Message(null, LocalDate.of(2018, 02, 17), "test", "test", "test@test.fr", "ceci est un test");
        //WHEN
        messageDao.addMessage(message);
        //THEN
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM message WHERE nom = 'test';")) {
            Assertions.assertThat(resultSet.next()).isTrue();
            Assertions.assertThat(resultSet.getInt("id")).isNotNull();
            Assertions.assertThat(resultSet.getString("nom")).isEqualToIgnoringCase("test");
            Assertions.assertThat(resultSet.getString("prenom")).isEqualToIgnoringCase("test");
            Assertions.assertThat(resultSet.getString("adresse_mail")).isEqualToIgnoringCase("test@test.fr");
            Assertions.assertThat(resultSet.getDate("date").toLocalDate()).isEqualTo(LocalDate.of(2018, 02, 17));
            Assertions.assertThat(resultSet.getString("message")).isEqualToIgnoringCase("ceci est un test");
            Assertions.assertThat(resultSet.next()).isFalse();

        }
    }

    @Test
    public void shouldDeleteMessage() {
        //WHEN
        messageDao.deleteMessage(3);
        List<Message> message = messageDao.listMessage();
        //THEN
        assertThat(message).hasSize(2);
        assertThat(message).extracting("nom", "prenom", "adresse_mail", "message").containsOnly(
                tuple("premier", "message", "premier@message.fr", "hello world"),
                tuple("second", "message", "second@message.fr", "hello again")
        );
    }
}
