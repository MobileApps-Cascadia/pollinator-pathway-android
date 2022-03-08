package edu.cascadia.mobas.pollinatorpathway.UI.Profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import edu.cascadia.mobas.pollinatorpathway.DataRepository;
import edu.cascadia.mobas.pollinatorpathway.Database.Box.Box;
import edu.cascadia.mobas.pollinatorpathway.Database.Planting.Planting;
import edu.cascadia.mobas.pollinatorpathway.Database.Profile.Profile;
import edu.cascadia.mobas.pollinatorpathway.PnwppApp;

public class ProfileViewModel extends AndroidViewModel {

    private final DataRepository mRepository;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((PnwppApp) application).getRepository();
    }

    public LiveData<Profile> getProfile(long mID) { return mRepository.getProfile(mID); }
    public LiveData<List<Profile>> getProfiles() {
        return mRepository.getProfiles();
    }
    public LiveData<List<Planting>> getAllPlantings() {return mRepository.getAllPlantings();}
    public LiveData<List<Box>> getBoxes() {return mRepository.getBoxes();}
}