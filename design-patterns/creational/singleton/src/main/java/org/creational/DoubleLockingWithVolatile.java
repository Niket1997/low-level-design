package org.creational;

class DBConnectionThree {
    private static volatile DBConnectionThree instance;

    private DBConnectionThree() {
    }

    public static DBConnectionThree getInstance() {
        if (instance == null) {
            synchronized (DBConnectionThree.class) {
                if (instance == null) {
                    instance = new DBConnectionThree();
                }
            }
        }
        return instance;
    }
}

public class DoubleLockingWithVolatile {
    public static void main(String[] args) {
        DBConnectionThree dbConnectionThree = DBConnectionThree.getInstance();
    }
}
