package org.creational;

class DBConnectionTwo {
    private static DBConnectionTwo instance;

    private DBConnectionTwo() {
    }

    public static synchronized DBConnectionTwo getInstance() {
        if (instance == null) {
            instance = new DBConnectionTwo();
        }
        return instance;
    }
}

public class SynchronizedInitialization {
    public static void main(String[] args) {
        DBConnectionTwo dbConnectionTwo = DBConnectionTwo.getInstance();
    }
}



