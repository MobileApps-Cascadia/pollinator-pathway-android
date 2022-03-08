package edu.cascadia.mobas.pollinatorpathway.Database.Box;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import edu.cascadia.mobas.pollinatorpathway.Database.Planting.Planting;


@Entity(foreignKeys = @ForeignKey(entity = Planting.class, parentColumns = "plantingId",
        childColumns = "plantingId", onDelete = CASCADE))
public class Box {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "boxId")
    private long boxId;

    @ColumnInfo(name = "name")
    private String boxName;

    @ColumnInfo(name = "lat")
    private double lat;

    @ColumnInfo(name = "lon")
    private double lon;

    @ColumnInfo(name = "gps")
    private String gps;

    @ColumnInfo(name = "qrCode")
    private String qrCode;

    @ColumnInfo(name = "plantingId")
    private long plantingId;

    public long getBoxId() {
        return boxId;
    }

    public String getName() { return boxName; }

    public void setName(String boxName) { this.boxName = boxName; }

    public void setBoxId(long boxId) { this.boxId = boxId; }

    public String getGPS() { return gps; }

    public void setGps(double lat, double lon) {
        String gps;
        this.lat = lat;
        this.lon = lon;
        gps = lat + ", " + lon;
    }

    public String getQrCode() { return qrCode; }

    public void setQrCode(String qrCode) { this.qrCode = qrCode; }

    public long getPlantingId() { return plantingId; }

    public void setPlantingId(long plantingId) { this.plantingId = plantingId; }
}