package edu.cascadia.mobas.pollinatorpathway.ui.Database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;


@Entity(foreignKeys = @ForeignKey(entity = Planting.class, parentColumns = "plantingId",
        childColumns = "plantingId", onDelete = CASCADE))
public class Box {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "boxId")
    private long boxId;

    @ColumnInfo(name = "gps")
    String gps;

    @ColumnInfo(name = "qrCode")
    String qrCode;

    @ColumnInfo(name = "plantingId")
    long plantingId;

    public long getBoxId() {
        return boxId;
    }

    public void setBoxId(long boxId) {
        boxId = boxId;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

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