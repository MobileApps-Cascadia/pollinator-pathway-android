package edu.cascadia.mobas.pollinatorpathway.ui.profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import edu.cascadia.mobas.pollinatorpathway.DataRepository;
import edu.cascadia.mobas.pollinatorpathway.Database.Profile.Profile;
import edu.cascadia.mobas.pollinatorpathway.PnwppApp;

public class ProfileViewModel extends ViewModel {

    private final DataRepository mRepository;

    public ProfileViewModel(@NonNull Application application) {
        mRepository = ((PnwppApp) application).getRepository();
    }

    public LiveData<Profile> getProfiles() {
        return mRepository.getProfiles();
    }
}