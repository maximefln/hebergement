package dao;


import entities.Membre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDaoImpl implements MembreDao{


    @Override
    public List<Membre> ListMembre() {

        String query = "SELECT * FROM membre ORDER BY membre.id ASC;";
        List<Membre> listMembre = new ArrayList();
        try (
                Connection connection = DataSourceProvider.getDataSource().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)
        ){
            while (resultSet.next()) {
                listMembre.add(new Membre(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("fonction"),
                        resultSet.getString("lien_image")
                ));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listMembre;
    }

    @Override
    public void addMembre(Membre membre) {
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(("INSERT INTO membre(nom, prenom, fonction, lien_image) VALUES (?,?,?,?)"))){
            statement.setString(1, membre.getNom());
            statement.setString(2, membre.getPrenom());
            statement.setString(3, membre.getFonction());
            statement.setString(4, membre.getLien_image());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMembre(int id) {
        String query = "DELETE FROM membre WHERE id=?;";
        try (Connection connection = DataSourceProvider.getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
