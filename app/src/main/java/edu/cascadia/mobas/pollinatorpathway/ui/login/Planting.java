package edu.cascadia.mobas.pollinatorpathway.ui.login;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Planting {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "PlantingId")
    private long plantingId;

    @ColumnInfo(name = "address")
    String address;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "description")
    String description;


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
}