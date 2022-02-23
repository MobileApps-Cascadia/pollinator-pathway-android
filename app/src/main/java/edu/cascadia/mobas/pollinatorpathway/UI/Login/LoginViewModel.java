package edu.cascadia.mobas.pollinatorpathway.UI.Login;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.cascadia.mobas.pollinatorpathway.DataRepository;
import edu.cascadia.mobas.pollinatorpathway.Database.Profile.Profile;
import edu.cascadia.mobas.pollinatorpathway.PnwppApp;

public class LoginViewModel extends AndroidViewModel {

    private DataRepository mRepository;

    public LoginViewModel(Application application) {
        super(application);
        mRepository = ((PnwppApp) application).getRepository();
    }

    LiveData<List<Profile>> getProfiles() {
        return mRepository.getProfiles();
    }
    LiveData<Profile> getProfile(long mID) { return mRepository.getProfile(mID);}
}