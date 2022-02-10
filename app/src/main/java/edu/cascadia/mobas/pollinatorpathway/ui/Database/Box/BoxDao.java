package edu.cascadia.mobas.pollinatorpathway.ui.Database.Box;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import edu.cascadia.mobas.pollinatorpathway.ui.Database.Box.Box;


@Dao
public interface BoxDao {

    @Query("SELECT * FROM Box WHERE boxId = :boxId")
    public Box getBox(long boxId);

    @Query("SELECT * FROM Box WHERE qrCode = :qrCode")
    public Box getBoxByText(String qrCode);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertBox(Box box);

    @Update
    public void updateBox(Box box);

    @Delete
    public void deleteBox(Box box);
}