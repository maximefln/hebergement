package dao;

import Exceptions.CommentaireRunTimeException;
import entities.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    @Override
    public List<Message> listMessage() {
        String query = "SELECT * FROM message ORDER BY message.date DESC;";
        List<Message> listMessage = new ArrayList();

        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ){
            while (resultSet.next()) {
                listMessage.add(new Message(
                        resultSet.getInt("id"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("adresse_mail"),
                        resultSet.getString("message"))

                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listMessage;
    }

    @Override
    public void addMessage(Message message) {
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(("INSERT INTO message(date, nom, prenom, adresse_mail, message) VALUES (?,?,?,?,?)"))){
            statement.setDate(1, Date.valueOf(message.getDate()));
            statement.setString(2, message.getNom());
            statement.setString(3, message.getPrenom());
            statement.setString(4, message.getAdresse_mail());
            statement.setString(5, message.getMessage());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new CommentaireRunTimeException("Error when getting message");
        }
    }

    @Override
    public void deleteMessage(int id) {
        String query = "DELETE FROM message WHERE id=?;";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
