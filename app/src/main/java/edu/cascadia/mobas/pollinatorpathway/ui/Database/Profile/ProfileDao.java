package edu.cascadia.mobas.pollinatorpathway.ui.Database.Profile;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.cascadia.mobas.pollinatorpathway.ui.Database.Profile.Profile;


@Dao
public interface ProfileDao {

    @Query("SELECT * FROM Profile WHERE userId = :userId")
    public Profile getProfiles(long userId);

    @Query("SELECT * FROM Profile WHERE firstname = :firstname")
    public Profile getProfiles(String firstname);

    @Query("SELECT * FROM Profile ORDER BY username DESC")
    public LiveData<List<Profile>> getProfiles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertProfile(Profile profile);

    @Update
    public void updateProfile(Profile profile);

    @Delete
    public void deleteProfile(Profile profile);
}