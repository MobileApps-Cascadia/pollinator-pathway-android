package edu.cascadia.mobas.pollinatorpathway.Database.Planting;

import static androidx.room.ForeignKey.CASCADE;

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

    @ColumnInfo(name = "address")
    String address;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "description")
    String description;

    @ColumnInfo(name = "type")
    String type;

    @ColumnInfo(name = "website")
    String website;

    @ColumnInfo(name = "dateJoined")
    String dateJoined;

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

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getDateJoined() { return dateJoined; }

    public void setDateJoined(String dateJoined) { this.dateJoined = dateJoined; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() { return website; }

    public void setWebsite(String website) { this.website = website; }

    public String getGpsLocation() { return gpsLocation; }

    public void setGpsLocation(String gpsLocation) { this.gpsLocation = gpsLocation; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}