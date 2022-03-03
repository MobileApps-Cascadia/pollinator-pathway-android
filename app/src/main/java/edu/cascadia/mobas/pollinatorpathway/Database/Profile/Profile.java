package edu.cascadia.mobas.pollinatorpathway.Database.Profile;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
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
    @ColumnInfo(name = "organizationName")
    String orgName;

    @NonNull
    @ColumnInfo(name = "email")
    String email;

    @ColumnInfo(name = "website")
    String website;

    @ColumnInfo(name = "dateJoined")
    String dateJoined;

    @ColumnInfo(name = "address")
    String address;

    @ColumnInfo(name = "type")
    String type;

    @ColumnInfo(name = "ProfDescription")
    String ProfDescription;


    @NonNull
    @ColumnInfo(name = "phone")
    String phone;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() { return phone; }

    public void setPhone( String phone) { this.phone = phone; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrgName() {return orgName;}

    public void setOrgName(String orgName){this.orgName = orgName;}

    public String getProfDescription() {
        return ProfDescription; }

    public void setProfDescription(String Profdescription) {
        this.ProfDescription = ProfDescription; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getDateJoined() { return dateJoined; }

    public void setDateJoined(String dateJoined) { this.dateJoined = dateJoined; }

    public String getWebsite() { return website; }

    public void setWebsite(String website) { this.website = website; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}


