package edu.cascadia.mobas.pollinatorpathway.ui.Database;

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
    public Planting getPlanting(long plantingId);

    @Query("SELECT * FROM Planting WHERE name = :name")
    public Planting getPlantingByText(String name);

    @Query("SELECT * FROM Planting ORDER BY name ASC")
    List<Planting> getAllPlantings();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertPlanting(Planting planting);

    @Update
    public void updatePlanting(Planting planting);

    @Delete
    public void deletePlanting(Planting planting);
}