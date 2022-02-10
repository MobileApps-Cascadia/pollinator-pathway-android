package edu.cascadia.mobas.pollinatorpathway.ui.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.cascadia.mobas.pollinatorpathway.ui.Database.Box.Box;
import edu.cascadia.mobas.pollinatorpathway.ui.Database.Box.BoxDao;
import edu.cascadia.mobas.pollinatorpathway.ui.Database.Planting.Planting;
import edu.cascadia.mobas.pollinatorpathway.ui.Database.Planting.PlantingDao;
import edu.cascadia.mobas.pollinatorpathway.ui.Database.Profile.Profile;
import edu.cascadia.mobas.pollinatorpathway.ui.Database.Profile.ProfileDao;

@Database(entities = {Profile.class, Planting.class, Box.class}, version = 1)
public abstract class PnwppDb extends RoomDatabase {

    private static final String DATABASE_NAME = "user.db";

    private static PnwppDb mPnwppDatabase;


    //Singleton
    public static PnwppDb getInstance(Context context){
        if (mPnwppDatabase == null){
            mPnwppDatabase = Room.databaseBuilder(context, PnwppDb.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
            mPnwppDatabase.addStarterData();
        }
        return mPnwppDatabase;
    }



    public abstract ProfileDao profileDao();
    public abstract PlantingDao plantingDao();
    public abstract BoxDao boxDao();

    private void addStarterData() {
        // Add a few users
        Profile p = new Profile();
        p.setFirstname("Fabrice");
        p.setLastname("Kalvin");
        p.setUsername("fk");
        p.setPassword("king");
        profileDao().insertProfile(p);
    }
}
