package edu.cascadia.mobas.pollinatorpathway.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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

                Profile one = new Profile();
                one.setFirstname("Robin");
                one.setLastname("Crowder");
                one.setEmail("rbcrowder@21acres.org");
                one.setPhone("326-224-7220");
                one.setPassword("1234");
                profileDao.insertProfile(one);

                Profile two = new Profile();
                two.setFirstname("Patricia");
                two.setLastname("Newkirk");
                two.setEmail("patricia.newkirk@gmail.com");
                two.setPhone("206-902-8107");
                two.setPassword("abcd");
                profileDao.insertProfile(two);

                Profile three = new Profile();
                three.setFirstname("Kristi");
                three.setLastname("Bolles");
                three.setEmail("kbolles@coastalbank.com");
                three.setPhone("425-482-3103");
                three.setPassword("3333");
                profileDao.insertProfile(three);

                Profile four = new Profile();
                four.setFirstname("Alexia");
                four.setLastname("Allen");
                four.setEmail("alexiaallen@hotmail.com");
                four.setPhone("425-286-5640");
                four.setPassword("4444");
                profileDao.insertProfile(four);

                Profile five = new Profile();
                five.setFirstname("Cameron");
                five.setLastname("Graves");
                five.setPhone("206-949-3333");
                five.setPassword("5555");
                profileDao.insertProfile(five);
            });

            dbExecutor.execute(() -> {
                PlantingDao plantingDao = mPnwppDatabase.plantingDao();

                Planting planting = new Planting();
                planting.setName("21 Acres");
                planting.setUserId(1);
                planting.setDescription("Organization");
                plantingDao.insertPlanting(planting);

                Planting planting2 = new Planting();
                planting.setName("Songaia Co-House");
                planting.setUserId(2);
                planting.setDescription("Co-Housing");
                plantingDao.insertPlanting(planting2);

            });
        }
    };
}
