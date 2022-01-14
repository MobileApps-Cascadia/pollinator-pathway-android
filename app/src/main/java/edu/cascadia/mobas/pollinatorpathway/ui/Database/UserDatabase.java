package edu.cascadia.mobas.pollinatorpathway.ui.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Profile.class, Planting.class, Box.class}, version = 1)
abstract class PnwppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "user.db";

    private static PnwppDatabase mPnwppDatabase;

    //Singleton
    public static PnwppDatabase getInstance(Context context){
        if (mPnwppDatabase == null){
            mPnwppDatabase = Room.databaseBuilder(context, PnwppDatabase.class, DATABASE_NAME)
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

    }
}
