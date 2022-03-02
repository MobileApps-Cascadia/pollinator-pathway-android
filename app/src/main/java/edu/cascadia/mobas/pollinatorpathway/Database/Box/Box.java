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

    @ColumnInfo(name = "gps")
    private long gps;

    @ColumnInfo(name = "qrCode")
    private String qrCode;

    @ColumnInfo(name = "plantingId")
    private long plantingId;

    public long getBoxId() {
        return boxId;
    }

    public void setBoxId(long boxId) {
        this.boxId = boxId;
    }

    public long getGps() {
        return gps;
    }

    public void setGps(long gps) { this.gps = gps; }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public long getPlantingId() {
        return plantingId;
    }

    public void setPlantingId(long plantingId) {
        this.plantingId = plantingId;
    }
}