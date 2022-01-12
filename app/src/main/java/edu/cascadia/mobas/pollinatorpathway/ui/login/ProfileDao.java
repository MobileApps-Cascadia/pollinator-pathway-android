package edu.cascadia.mobas.pollinatorpathway.ui.login;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;


@Dao
public interface ProfileDao {

    @Query("SELECT * FROM Profile WHERE userId = :userId")
    public Profile getProfile(long userId);

    @Query("SELECT * FROM Profile WHERE firstname = :firstname")
    public Profile getProfileByText(String firstname);

    @Query("SELECT * FROM Profile ORDER BY lastname COLLATE NOCASE")
    public List<Profile> getProfile();

    @Query("SELECT * FROM Profile ORDER BY username DESC")
    public List<Profile> getProfileNewerFirst();

    @Query("SELECT * FROM Profile ORDER BY firstname ASC")
    public List<Profile> getProfileOlderFirst();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertProfile(Profile profile);

    @Update
    public void updateProfile(Profile profile);

    @Delete
    public void deleteProfile(Profile profile);
}