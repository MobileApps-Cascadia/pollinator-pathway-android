package edu.cascadia.mobas.pollinatorpathway.Database.Planting;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import edu.cascadia.mobas.pollinatorpathway.Database.Profile.Profile;


@Entity(foreignKeys = @ForeignKey(entity = Profile.class, parentColumns = "userId",
        childColumns = "userId", onDelete = CASCADE))
public class Planting {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "plantingId")
    private long plantingId;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "description")
    String description;


    @ColumnInfo(name = "gpsLocation")
    String gpsLocation;


    @ColumnInfo(name = "userId")
    private long userId;


    public long getPlantingId() {
        return plantingId;
    }

    public void setPlantingId(long plantingId) {
        this.plantingId = plantingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGpsLocation() { return gpsLocation; }

    public void setGpsLocation(String gpsLocation) { this.gpsLocation = gpsLocation; }

   public long getUserId() {
       return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
   }
}