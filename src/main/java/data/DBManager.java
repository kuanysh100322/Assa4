package data;

import data.interfaces.ForMna;

import javax.ws.rs.ServerErrorException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager implements ForMna {

    @Override
    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assa3.java", "postgres", "123");

            return connection;
        } catch (Exception e) {
            throw new ServerErrorException("Cannot connect to DB", 500);
        }
    }
}
