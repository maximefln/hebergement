package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

public class DataSourceProvider {

    /*Cette classe permet de mémoriser les informations de connexion et de se connecter à la base de données.
     * @author MFillion
     * @version 1.0
     */

    private static MysqlDataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("projet_100h");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        }
        return dataSource;
    }
}
