package edu.cascadia.mobas.pollinatorpathway;


import edu.cascadia.mobas.pollinatorpathway.ui.login.PnwppDb;

public class DataRepository {

    private static DataRepository sInstance;
    private final PnwppDb mDatabase;


    public static DataRepository getInstance(final PnwppDb db) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                sInstance = new DataRepository(db);
            }
        }
        return sInstance;
    };
    private DataRepository(PnwppDb db) {
        mDatabase = db;
    }
}
