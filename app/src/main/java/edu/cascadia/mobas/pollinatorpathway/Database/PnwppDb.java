package edu.cascadia.mobas.pollinatorpathway.Database;

import android.content.Context;
import android.media.Image;

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
import edu.cascadia.mobas.pollinatorpathway.Database.Box.BoxDao;
import edu.cascadia.mobas.pollinatorpathway.Database.Planting.Planting;
import edu.cascadia.mobas.pollinatorpathway.Database.Planting.PlantingDao;
import edu.cascadia.mobas.pollinatorpathway.Database.Profile.Profile;
import edu.cascadia.mobas.pollinatorpathway.Database.Profile.ProfileDao;
import edu.cascadia.mobas.pollinatorpathway.R;

@Database(entities = {Profile.class, Planting.class, Box.class}, version = 1)
public abstract class PnwppDb extends RoomDatabase {

    private static final String DATABASE_NAME = "user.db";
    private static volatile PnwppDb mPnwppDatabase;

    private static final ExecutorService dbExecutor = Executors.newSingleThreadExecutor();


    //Singleton
    public static PnwppDb getInstance(Context context, AppExecutors mAppExecutor) {
        if (mPnwppDatabase == null) {
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
    public abstract BoxDao boxDao();


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
                p.setType("Organization");
                p.setProfDescription("The 21 Acres Center for Local Food & Sustainable living is a global leader in sustainable & regenerative practices, serving as a living laboratory & learning center for conscious consumers who want to learn new, more sustainable ways of living.");
                p.setDateJoined("11/2021");
                p.setWebsite("https://21acres.org/?s=beevesting");
                profileDao.insertProfile(p);

                Profile p2 = new Profile();
                p2.setFirstname("Patricia");
                p2.setLastname("Newkirk");
                p2.setOrgName("Songaia Co-Housing Community");
                p2.setType("Co-Housing");
                p2.setEmail("patricia.newkirk@gmail.com");
                p2.setPhone("206.902.8107");
                p2.setPassword("1234");
                p2.setDateJoined("11.2021");
                p2.setWebsite("http://www.songaia.com/the-garden1.html");
                profileDao.insertProfile(p2);

                Profile p3 = new Profile();
                p3.setFirstname("Kristi");
                p3.setLastname("Bolles");
                p3.setOrgName("Coastal Bank");
                p3.setEmail("kbolles@coastalbank.com");
                p3.setPhone("425.482.3103");
                p3.setPassword("1234");
                p3.setType("Company");
                p3.setProfDescription("Coastal Community Bank");
                p3.setDateJoined("11/2021");
                p3.setWebsite("kbolles@coastalbank.com");
                profileDao.insertProfile(p3);

                Profile p4 = new Profile();
                p4.setFirstname("Alexia");
                p4.setLastname("Allen");
                p4.setOrgName("Hawthorn Farm");
                p4.setEmail("alexiaallen@hotmail.com");
                p4.setPhone("425.286.5640");
                p4.setPassword("1234");
                p4.setType("Farm");
                p4.setProfDescription("A suburban homestead where happy humans are integrated into the ecological system. We love to teach.");
                p4.setDateJoined("11/2021");
                p4.setWebsite("https://www.facebook.com/hawthornfarmheals");
                profileDao.insertProfile(p4);

                Profile p5 = new Profile();
                p5.setFirstname("Cameron");
                p5.setLastname("Graves");
                p5.setOrgName("Red Barn Farm");
                p5.setPhone("206.949.3333");
                p5.setPassword("1234");
                p5.setType("Farm");
                p5.setEmail("dummy@gmail.com");
                p5.setProfDescription("Almost 100 years old and recently restored for the 21st century, The Red Barn Farm is currently raising hens, ducks, goats, honey bees, and harvesting seasonal produce and flowers (green house coming for year-round harvesting!). We’re also a full service venue ready to be host to your next special event, and our small craft whiskey distillery and tasting room is coming soon!");
                p5.setDateJoined("11/2021");
                p5.setWebsite("https://redbarnfarm.com/");
                profileDao.insertProfile(p5);




            });

            dbExecutor.execute(() -> {
                PlantingDao plantingDao = mPnwppDatabase.plantingDao();
                List<Planting> plantings = new ArrayList<Planting>();

                Planting planting = new Planting();
                planting.setName("Permaculture Vegetable Garden");
                planting.setUserId(1);
                planting.setPlantingId(1);
                //planting.setDescription("First planted in 1978, the vegetable garden provides veggies to the 40+ members of Songaia CoHousing Community.  ");
                planting.setImage(R.drawable.hummingbird1_2);
                plantings.add(planting);

                Planting planting2 = new Planting();
                planting2.setName("Herbal Gerbil Garden");
                planting2.setUserId(1);
                planting2.setPlantingId(2);
               // planting2.setDescription("Vegetable and medicinal herb garden");
                planting2.setImage(R.drawable.bee2_2);
                plantings.add(planting2);

                Planting planting3 = new Planting();
                planting3.setName("Native Garden");
                planting3.setUserId(1);
                planting3.setPlantingId(3);
                //planting3.setDescription("Features a large variety of plants that are significant to the Coast Salish tribes.   ");
                planting3.setImage(R.drawable.bee4_2png);
                plantings.add(planting3);

                plantingDao.insertPlantingALL(plantings);

            });

            /*dbExecutor.execute(() -> {
                BoxDao boxDao = mPnwppDatabase.boxDao();
                List<Box> boxes = new ArrayList<Box>();


        });*/


        }
    };
}
