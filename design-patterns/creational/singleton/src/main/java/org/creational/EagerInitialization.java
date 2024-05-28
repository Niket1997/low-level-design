package org.creational;

class DBConnection {
    private static DBConnection instance;

    private DBConnection() {}

    public static DBConnection getInstance() {
        return instance;
    }

}

public class EagerInitialization {
    public static void main(String[] args) {
        DBConnection dbConnection = DBConnection.getInstance();
    }
}
