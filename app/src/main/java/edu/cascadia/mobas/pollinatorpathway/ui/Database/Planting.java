package edu.cascadia.mobas.pollinatorpathway.ui.Database;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(foreignKeys = @ForeignKey(entity = Profile.class, parentColumns = "userId",
        childColumns = "userId", onDelete = CASCADE))
public class Planting {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "plantingId")
    private long plantingId;

    @ColumnInfo(name = "address")
    String address;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "description")
    String description;

    @ColumnInfo(name = "userId")
    private long userId;


    public long getPlantingId() {
        return plantingId;
    }

    public void setPlantingId(long plantingId) {
        this.plantingId = plantingId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}