package edu.cascadia.mobas.pollinatorpathway;


import androidx.lifecycle.LiveData;

import edu.cascadia.mobas.pollinatorpathway.Database.PnwppDb;
import edu.cascadia.mobas.pollinatorpathway.Database.Profile.Profile;

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

    public LiveData<Profile> getProfiles() {
        return mDatabase.profileDao().getProfiles();
    }
}