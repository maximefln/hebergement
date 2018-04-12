import dao.CommentaireDao;
import dao.CommentaireDaoImpl;
import dao.DataSourceProvider;
import entities.Commentaire;
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

public class CommentaireDaoTestCase {

    private CommentaireDao commentaireDao = new CommentaireDaoImpl();

    @Before
    public void initDb() throws Exception {
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate("DELETE FROM commentaire");
            statement.executeUpdate("ALTER TABLE commentaire AUTO_INCREMENT=0");
            statement.executeUpdate("INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-01', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 1);");
            statement.executeUpdate("INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-02', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 1);");
            statement.executeUpdate("INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-03', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 1);");
            statement.executeUpdate("INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-04', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 2);");
            statement.executeUpdate("INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-05', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 2);");
            statement.executeUpdate("INSERT INTO commentaire(`date`, `nom`, `prenom`, `commentaire`, `id_article`)  VALUES ('2018-02-06', 'Dupuis', 'Paul', 'Vraiment très intéréssant cet article', 2);");

        }
    }

    @Test
    public void ShouldListCommentaire () {
        //WHEN
        List<Commentaire> commentaire = commentaireDao.listCommentaire();
        //THEN
        assertThat(commentaire).hasSize(6);
        assertThat(commentaire).extracting("nom", "prenom", "commentaire", "id_article").containsOnly(
                tuple("Dupuis", "Paul", "Vraiment très intéréssant cet article", 1),
                tuple("Dupuis", "Paul", "Vraiment très intéréssant cet article", 1),
                tuple("Dupuis", "Paul", "Vraiment très intéréssant cet article", 1),
                tuple("Dupuis", "Paul", "Vraiment très intéréssant cet article", 2),
                tuple("Dupuis", "Paul", "Vraiment très intéréssant cet article", 2),
                tuple("Dupuis", "Paul", "Vraiment très intéréssant cet article", 2)
        );
    }

    @Test
    public void shouldAddCommentaire() throws SQLException {
        //GIVEN
        Commentaire newcommentaire = new Commentaire(null, "jean", "thomas", "très sympa cet article", LocalDate.of(2018, 02, 17), null);
        //WHEN
        commentaireDao.addCommentaire(newcommentaire, 1);
        //THEN
        try(Connection connection = DataSourceProvider.getDataSource().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM commentaire WHERE Nom='jean'")){
            Assertions.assertThat(resultSet.next()).isTrue();
            Assertions.assertThat(resultSet.getInt("id")).isNotNull();
            Assertions.assertThat(resultSet.getString("nom")).isEqualToIgnoringCase("jean");
            Assertions.assertThat(resultSet.getString("prenom")).isEqualToIgnoringCase("thomas");
            Assertions.assertThat(resultSet.getString("commentaire")).isEqualToIgnoringCase("très sympa cet article");
            Assertions.assertThat(resultSet.getDate("date").toLocalDate()).isEqualTo(LocalDate.of(2018, 02, 17));
            Assertions.assertThat(resultSet.getInt("id_article")).isEqualTo(1);
            Assertions.assertThat(resultSet.next()).isFalse();

        }

    }

    @Test
    public void shouldDeleteCommentaire() {
        //WHEN
        commentaireDao.deleteCommentaire(6);
        List<Commentaire> commentaire = commentaireDao.listCommentaire();
        //THEN
        assertThat(commentaire).hasSize(5);
        assertThat(commentaire).extracting("nom", "prenom", "commentaire", "id_article").containsOnly(
                tuple("Dupuis", "Paul", "Vraiment très intéréssant cet article", 1),
                tuple("Dupuis", "Paul", "Vraiment très intéréssant cet article", 1),
                tuple("Dupuis", "Paul", "Vraiment très intéréssant cet article", 1),
                tuple("Dupuis", "Paul", "Vraiment très intéréssant cet article", 2),
                tuple("Dupuis", "Paul", "Vraiment très intéréssant cet article", 2));
    }

}
