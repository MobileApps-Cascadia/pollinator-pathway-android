package edu.cascadia.mobas.pollinatorpathway.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import edu.cascadia.mobas.pollinatorpathway.AppExecutors;
import edu.cascadia.mobas.pollinatorpathway.Database.Box.Box;
import edu.cascadia.mobas.pollinatorpathway.Database.Planting.Planting;
import edu.cascadia.mobas.pollinatorpathway.Database.Planting.PlantingDao;
import edu.cascadia.mobas.pollinatorpathway.Database.Profile.Profile;
import edu.cascadia.mobas.pollinatorpathway.Database.Profile.ProfileDao;

@Database(entities = {Profile.class, Planting.class, Box.class}, version = 1)
public abstract class PnwppDb extends RoomDatabase {

    private static final String DATABASE_NAME = "user.db";
    private static volatile PnwppDb mPnwppDatabase;

    private static final ExecutorService dbExecutor = Executors.newSingleThreadExecutor();


    //Singleton
    public static PnwppDb getInstance(Context context, AppExecutors mAppExecutor){
        if (mPnwppDatabase == null){
            synchronized (PnwppDb.class) {

                mPnwppDatabase = Room.databaseBuilder(context, PnwppDb.class, DATABASE_NAME)
                        .addCallback(sRoomDatabaseCallback)
                        .build();
            }
        }
        return mPnwppDatabase;
    }


    public abstract ProfileDao profileDao();
    public abstract PlantingDao plantingDao();
    //public abstract BoxDao boxDao();

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            dbExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                ProfileDao profileDao = mPnwppDatabase.profileDao();
                profileDao.deleteAll();

                Profile p = new Profile();
                p.setFirstname("Robin");
                p.setLastname("Crowder");
                p.setOrgName("21 Acres");
                p.setEmail("rbcrowder@21acres.org");
                p.setPhone("326-224-7220");
                p.setPassword("1234");
                p.setProfDescription("Organization");
                p.setDateJoined("11/2021");
                p.setWebsite("https://21acres.org/?s=beevesting");
                profileDao.insertProfile(p);
            });

            dbExecutor.execute(() -> {
                PlantingDao plantingDao = mPnwppDatabase.plantingDao();
                List<Planting> plantings = new ArrayList<Planting>();

                Planting planting = new Planting();
                planting.setName("Permaculture Vegetable Garden");
                planting.setUserId(1);
                planting.setPlantingId(1);
                planting.setDescription("First planted in 1978, the vegegable garden has evolved into a .6 acre permaculture garden providing veggies to the 40+ members of Songaia CoHousing Community.  ");
                plantings.add(planting);

                Planting planting2 = new Planting();
                planting2.setName("Herbal Gerbil Garden");
                planting2.setUserId(1);
                planting2.setPlantingId(2);
                planting2.setDescription("Vegetable and medicinal herb garden");
                plantings.add(planting2);

                Planting planting3 = new Planting();
                planting3.setName("Native Garden");
                planting3.setUserId(1);
                planting3.setPlantingId(3);
                planting3.setDescription("Features a large variety of plants that are significant to the Coast Salish tribes.   ");
                plantings.add(planting3);

            });
        }
    };

}
