package edu.cascadia.mobas.pollinatorpathway.ui.Login;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends AndroidViewModel {

    private final LiveData<Profile> mProfile;

    public LoginViewModel(Application application) {
        super(application);
        PnwppDb db = PnwppDb.getInstance(application);

        mProfile = db.profileDao().getProfile(1);
    }

    LiveData<Profile> getProfile() {
        return mProfile;
    }
}