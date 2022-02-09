package edu.cascadia.mobas.pollinatorpathway;

import android.app.Application;

import edu.cascadia.mobas.pollinatorpathway.ui.login.PnwppDb;

public class PnwppApp extends Application {
    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppExecutors = new AppExecutors();
    }

    public PnwppDb getDatabase() {
        return PnwppDb.getInstance(this, mAppExecutors);
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }
}
