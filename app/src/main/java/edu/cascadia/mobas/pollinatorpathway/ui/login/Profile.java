package edu.cascadia.mobas.pollinatorpathway.ui.login;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;



@Entity
public class Profile {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    private long userId;

    @ColumnInfo(name = "firstname")
    String firstname;

    @NonNull
    @ColumnInfo(name = "lastname")
    String lastname;

    @NonNull
    @ColumnInfo(name = "username")
    String username;

    @NonNull
    @ColumnInfo(name = "password")
    String password;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
