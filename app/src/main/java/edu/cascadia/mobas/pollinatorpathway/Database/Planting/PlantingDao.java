package edu.cascadia.mobas.pollinatorpathway.Database.Planting;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;


@Dao
public interface PlantingDao {

    @Query("SELECT * FROM Planting WHERE plantingId = :plantingId")
    LiveData<Planting> getPlanting (long plantingId);

    @Query("SELECT * FROM Planting WHERE name = :name")
    LiveData<Planting> getPlantingByText(String name);

    @Query("SELECT * FROM Planting ORDER BY name ASC")
    LiveData<List<Planting>> getAllPlantings();

    @Query("SELECT * FROM Planting WHERE userId = :userId ORDER BY name ASC")
    LiveData<List<Planting>> getProfilePlantings(long userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertPlanting(Planting planting);

    @Update
    public void updatePlanting(Planting planting);

    @Delete
    public void deletePlanting(Planting planting);


}