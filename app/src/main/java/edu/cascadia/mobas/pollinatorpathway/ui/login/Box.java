package edu.cascadia.mobas.pollinatorpathway.ui.login;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;


@Entity(foreignKeys = @ForeignKey(entity = Planting.class, parentColumns = "PlantingId",
        childColumns = "PlantingId", onDelete = CASCADE))
public class Box {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "BoxId")
    private long BoxId;

    @ColumnInfo(name = "gps")
    private String gps;

    @ColumnInfo(name = "qrCode")
    private String qrCode;

    @ColumnInfo(name = "PlantingId")
    private long PlantingId;

    public long getBoxId() {
        return BoxId;
    }

    public void setBoxId(long boxId) {
        BoxId = boxId;
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
}