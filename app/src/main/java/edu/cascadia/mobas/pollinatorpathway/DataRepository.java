package edu.cascadia.mobas.pollinatorpathway;


import androidx.lifecycle.LiveData;

import java.util.List;

import edu.cascadia.mobas.pollinatorpathway.Database.Box.Box;
import edu.cascadia.mobas.pollinatorpathway.Database.Planting.Planting;
import edu.cascadia.mobas.pollinatorpathway.Database.PnwppDb;
import edu.cascadia.mobas.pollinatorpathway.Database.Profile.Profile;


public class DataRepository {

    private static DataRepository sInstance;
    private final PnwppDb mDatabase;



    public static DataRepository getInstance(PnwppDb db) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                sInstance = new DataRepository(db);
            }
        }
        return sInstance;
    }
    private DataRepository(PnwppDb db) {
        mDatabase = db;
    }

    public LiveData<List<Profile>> getProfiles() {
        return mDatabase.profileDao().getProfiles();
    }

    public LiveData<Profile> getProfile(long mID) {
        return mDatabase.profileDao().getProfile(mID);
    }

    public LiveData<List<Planting>> getAllPlantings() { return mDatabase.plantingDao().getAllPlantings(); }

    public LiveData<Box> getBox(String qrCode) { return mDatabase.boxDao().getBoxByText(qrCode); }

    public LiveData<List<Box>> getBoxes() { return mDatabase.boxDao().getBoxes(); }
}
