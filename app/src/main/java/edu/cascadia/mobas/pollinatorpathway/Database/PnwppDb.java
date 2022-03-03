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
                one.setOrgName("21 Acres");
                one.setEmail("rbcrowder@21acres.org");
                one.setPhone("326-224-7220");
                one.setPassword("1234");
                one.setUserId(1);
                profileDao.insertProfile(one);

                Profile two = new Profile();
                two.setFirstname("Patricia");
                two.setLastname("Newkirk");
                two.setOrgName("Songaia Co-Housing Community");
                two.setEmail("patricia.newkirk@gmail.com");
                two.setPhone("206-902-8107");
                two.setPassword("abcd");
                profileDao.insertProfile(two);

                Profile three = new Profile();
                three.setFirstname("Kristi");
                three.setLastname("Bolles");
                three.setOrgName("Coastal Bank");
                three.setEmail("kbolles@coastalbank.com");
                three.setPhone("425-482-3103");
                three.setPassword("3333");
                profileDao.insertProfile(three);

                Profile four = new Profile();
                four.setFirstname("Alexia");
                four.setLastname("Allen");
                four.setOrgName("Hawthorn Farm");
                four.setEmail("alexiaallen@hotmail.com");
                four.setPhone("425-286-5640");
                four.setPassword("4444");
                profileDao.insertProfile(four);

                Profile five = new Profile();
                five.setFirstname("Cameron");
                five.setLastname("Graves");
                five.setOrgName("Red Barn Farm");
                five.setPhone("206-949-3333");
                five.setPassword("5555");
                profileDao.insertProfile(five);
            });

            dbExecutor.execute(() -> {
                PlantingDao plantingDao = mPnwppDatabase.plantingDao();

                Planting one = new Planting();
                one.setName("21 Acres");
                one.setUserId(1);
                one.setType("Organization");
                one.setDateJoined("11/2021");
                one.setWebsite("https://21acres.org/?s=beevesting");
                one.setDescription("The 21 Acres Center for Local Food & Sustainable " +
                        "living is a global leader in sustainable & regenerative practices, " +
                        "serving as a living laboratory & learning center for conscious consumers " +
                        "who want to learn new, more sustainable ways of living.");
                plantingDao.insertPlanting(one);


                Planting two = new Planting();
                two.setName("Permaculture Vegetable Garden");
                two.setUserId(2);
                two.setType("Co-housing");
                two.setDateJoined("11/2021");
                two.setWebsite("http://www.songaia.com/the-garden1.html");
                plantingDao.insertPlanting(two);


                Planting three = new Planting();
                three.setName("Coastal Bank");
                three.setUserId(2);
                three.setType("Company");
                three.setDateJoined("11/2021");
                three.setWebsite("https://www.coastalbank.com/about/join-us.html?gclid=CjwKCAiAnO2MBhApEiwA8q0HYTDhC4cKlHjx6VVf52wPoXj9IhTt5ejBtoCshnDEf2jtPYJVjLc0SxoCTOMQAvD_BwE");
                three.setDescription("Coastal Community Bank");
                plantingDao.insertPlanting(three);


                Planting four = new Planting();
                four.setName("Hawthorn Farm");
                four.setUserId(2);
                four.setType("Farm");
                four.setDateJoined("11/2021");
                four.setWebsite("https://www.coastalbank.com/about/join-us.html?gclid=CjwKCAiAnO2MBhApEiwA8q0HYTDhC4cKlHjx6VVf52wPoXj9IhTt5ejBtoCshnDEf2jtPYJVjLc0SxoCTOMQAvD_BwE");
                four.setDescription("A suburban homestead where happy humans are integrated " +
                        "into the ecological system. We love to teach.");
                plantingDao.insertPlanting(four);


                Planting five = new Planting();
                five.setName("Red Barn Farm");
                five.setUserId(2);
                five.setType("Farm");
                five.setDateJoined("11/2021");
                five.setWebsite("https://redbarnfarm.com/");
                plantingDao.insertPlanting(five);
            });
        }
    };
}
