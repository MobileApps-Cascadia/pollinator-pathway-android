package edu.cascadia.mobas.pollinatorpathway.ui.login;

import static java.time.chrono.MinguoChronology.INSTANCE;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                WordDao dao = INSTANCE.wordDao();
                dao.deleteAll();

                Word word = new Word("Hello");
                dao.insert(word);
                word = new Word("World");
                dao.insert(word);
            });
        }
    };

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
