import dao.ArticleDao;
import dao.ArticleDaoImpl;
import dao.DataSourceProvider;
import entities.Article;
import managers.ArticleLibrary;
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
import static org.assertj.core.api.Assertions.tuple;

public class ArticleDaoTestCase {

    private ArticleDao articleDao = new ArticleDaoImpl();

    @Before
    public void initDb() throws Exception {
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate("DELETE FROM adresse");
            statement.executeUpdate("ALTER TABLE adresse AUTO_INCREMENT=0");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-08', 'La Luck', 'Bar', 'test', 'Maxime Fillion', 50.6462, 3.05978, 'img/articles/la_luck.jpg', 'test', 4, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-07', 'Bibovino', 'Bar', 'test', 'Maxime Fillion', 50.641169, 3.06147, 'img/articles/bibovino.jpg', 'test', 3, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-06', 'La Capsule', 'Bar', 'test', 'Maxime Fillion', 50.640498, 3.060141, 'img/articles/la_capsule.jpg', 'test', 4, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-05', 'Le Point de Départ', 'Bar', 'test', 'Maxime Fillion', 50.634885, 3.047588, 'img/articles/le_point_de_depart.jpg', 'test', 3, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-04', 'La part des anges', 'Bar', 'test', 'Maxime Fillion', 50.64148, 3.062211, 'img/articles/la_part_des_anges.jpg', 'test', 4, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-03', 'L_Adresse', 'Restaurant', 'Description à venir', 'Maxime Fillion', 50.637879, 3.058189, 'img/articles/l_adresse.jpg', 'test', 4, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-02', 'T_Rijsel', 'Restaurant', 'Description à venir', 'Maxime Fillion', 50.642121, 3.065889, 'img/articles/t_rijsel.jpg', 'test', 4, 0, 0);");
            statement.executeUpdate("INSERT INTO adresse(`date_ajout`, `Nom`, `Type`, `presentation`, `Visiteur`, `coordonnee_x`, `coordonnee_y`, `lien_image`, `lien_image_accueil`, `note`, `nb_like`, `nbdislike` ) VALUES ('2018-02-01', 'le_pot_beaujolais', 'Restaurant', 'Description à venir', 'Maxime Fillion', 50.63656, 3.065094, 'img/articles/le_pot_beaujolais.jpg', 'test', 4, 0, 0);");
        }
    }

    @Test
    public void shouldListArticle(){
        //WHEN
        List<Article> article = articleDao.listArticle();
        //THEN
        assertThat(article).hasSize(8);
        assertThat(article).extracting( "Nom", "Type", "presentation", "Visiteur", "coordonnee_x", "coordonnee_y", "lien_image", "note", "nb_like", "nbdislike").containsOnly(
                tuple("La part des anges", "Bar", "test", "Maxime Fillion", 50.64148, 3.062211, "img/articles/la_part_des_anges.jpg", 4, 0, 0),
                tuple("Le Point de Départ","Bar", "test", "Maxime Fillion", 50.634885, 3.047588, "img/articles/le_point_de_depart.jpg", 3, 0, 0),
                tuple("La Capsule", "Bar", "test", "Maxime Fillion", 50.640498, 3.060141, "img/articles/la_capsule.jpg", 4, 0, 0),
                tuple("Bibovino", "Bar", "test", "Maxime Fillion", 50.641169, 3.06147, "img/articles/bibovino.jpg", 3, 0, 0),
                tuple("La Luck", "Bar", "test", "Maxime Fillion", 50.6462, 3.05978, "img/articles/la_luck.jpg", 4, 0, 0),
                tuple("L_Adresse", "Restaurant", "Description à venir", "Maxime Fillion", 50.637879, 3.058189, "img/articles/l_adresse.jpg", 4, 0, 0),
                tuple("T_Rijsel", "Restaurant", "Description à venir", "Maxime Fillion", 50.642121, 3.065889, "img/articles/t_rijsel.jpg", 4, 0, 0),
                tuple("le_pot_beaujolais", "Restaurant", "Description à venir", "Maxime Fillion", 50.63656, 3.065094, "img/articles/le_pot_beaujolais.jpg", 4, 0, 0)
        );
    }

    @Test
    public void shouldLikeArticle() throws SQLException{
        //WHEN
        articleDao.likeArticle(5);
        //THEN
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM adresse WHERE id=5")) {
                assertThat(resultSet.next()).isTrue();
                assertThat(resultSet.getInt("id")).isEqualTo(5);
                assertThat(resultSet.getString("Nom")).isEqualToIgnoringCase("La part des anges");
                assertThat(resultSet.getString("Type")).isEqualToIgnoringCase("Bar");
                assertThat(resultSet.getString("presentation")).isEqualToIgnoringCase("test");
                assertThat(resultSet.getString("Visiteur")).isEqualToIgnoringCase("Maxime Fillion");
                assertThat(resultSet.getInt("nb_like")).isEqualTo(1);
                assertThat(resultSet.getInt("nbdislike")).isEqualTo(0);
                assertThat(resultSet.next()).isFalse();
            }

        }
    }

        @Test
        public void shouldDislikeArticle() throws SQLException{
        //WHEN
        articleDao.dislikeArticle(5);
        //THEN
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM adresse WHERE id=5")) {
                assertThat(resultSet.next()).isTrue();
                assertThat(resultSet.getInt("id")).isEqualTo(5);
                assertThat(resultSet.getString("Nom")).isEqualToIgnoringCase("La part des anges");
                assertThat(resultSet.getString("Type")).isEqualToIgnoringCase("Bar");
                assertThat(resultSet.getString("presentation")).isEqualToIgnoringCase("test");
                assertThat(resultSet.getString("Visiteur")).isEqualToIgnoringCase("Maxime Fillion");
                assertThat(resultSet.getInt("nb_like")).isEqualTo(0);
                assertThat(resultSet.getInt("nbdislike")).isEqualTo(1);
                assertThat(resultSet.next()).isFalse();
            }

        }
    }

    @Test
    public void shouldGetArticle() throws SQLException{
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM adresse WHERE id=5")) {
                assertThat(resultSet.next()).isTrue();
                assertThat(resultSet.getInt("id")).isEqualTo(5);
                assertThat(resultSet.getString("Nom")).isEqualToIgnoringCase("La part des anges");
                assertThat(resultSet.getString("Type")).isEqualToIgnoringCase("Bar");
                assertThat(resultSet.getString("presentation")).isEqualToIgnoringCase("test");
                assertThat(resultSet.getString("Visiteur")).isEqualToIgnoringCase("Maxime Fillion");
                assertThat(resultSet.getInt("nb_like")).isEqualTo(0);
                assertThat(resultSet.getInt("nbdislike")).isEqualTo(0);
                assertThat(resultSet.next()).isFalse();
            }

        }
    }

    @Test
    public void shouldAddArticle() throws SQLException {
        //GIVEN
        Article article = new Article(LocalDate.of(2018, 02, 17), null, "test", "bar", "test", "test", 50.566, 6.1234, "test", "test", 4, 0, 0);
        //WHEN
        articleDao.addArticle(article);
        //THEN
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM adresse WHERE id=9")) {
            Assertions.assertThat(resultSet.next()).isTrue();
            Assertions.assertThat(resultSet.getInt("id")).isNotNull();
            Assertions.assertThat(resultSet.getString("Nom")).isEqualToIgnoringCase("test");
            Assertions.assertThat(resultSet.getString("type")).isEqualToIgnoringCase("bar");
            Assertions.assertThat(resultSet.getString("presentation")).isEqualToIgnoringCase("test");
            Assertions.assertThat(resultSet.getDate("date_ajout").toLocalDate()).isEqualTo(LocalDate.of(2018, 02, 17));
            Assertions.assertThat(resultSet.getDouble("coordonnee_x")).isEqualTo(50.566);
            Assertions.assertThat(resultSet.getDouble("coordonnee_y")).isEqualTo(6.1234);
            Assertions.assertThat(resultSet.getString("lien_image")).isEqualToIgnoringCase("test");
            Assertions.assertThat(resultSet.getString("lien_image_accueil")).isEqualToIgnoringCase("test");
            Assertions.assertThat(resultSet.getInt("note")).isEqualTo(4);
            Assertions.assertThat(resultSet.getInt("nb_like")).isEqualTo(0);
            Assertions.assertThat(resultSet.getInt("nbdislike")).isEqualTo(0);
            Assertions.assertThat(resultSet.next()).isFalse();

        }
    }

}
