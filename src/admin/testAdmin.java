package admin;

import singleton.databaseConnection;

import java.sql.Connection;

public class testAdmin {


    public static void main(String[] args) {
        Connection connection = databaseConnection.getInstance().getConnected();


    }

}
