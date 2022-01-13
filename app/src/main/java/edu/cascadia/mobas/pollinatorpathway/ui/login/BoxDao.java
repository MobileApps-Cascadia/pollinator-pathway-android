package edu.cascadia.mobas.pollinatorpathway.ui.login;

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
    public Planting getBox(long boxId);

    @Query("SELECT * FROM Box WHERE name = :qrCode")
    public Box getBoxByText(String qrCode);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertBox(Box box);

    @Update
    public void updateBox(Box box);

    @Delete
    public void deleteBox(Box box);
}