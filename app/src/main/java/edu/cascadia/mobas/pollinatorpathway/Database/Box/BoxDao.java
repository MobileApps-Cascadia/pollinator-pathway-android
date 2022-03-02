package edu.cascadia.mobas.pollinatorpathway.Database.Box;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface BoxDao {

    @Query("SELECT * FROM Box WHERE boxId = :boxId")
    LiveData<Box> getBox(long boxId);

    @Query("SELECT * FROM Box WHERE qrCode = :qrCode")
    LiveData<Box> getBoxByText(String qrCode);

    @Query("SELECT * FROM Box ORDER BY PlantingId ASC")
    LiveData<List<Box>> getBoxes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertBox(Box box);

    @Update
    public void updateBox(Box box);

    @Delete
    public void deleteBox(Box box);
}