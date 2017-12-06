package com.room.proharvesting.phvroomdb.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by proharvesting on 12/4/2017.
 */
@Entity(tableName = "Company")
public class Company {

    @PrimaryKey(autoGenerate = true)
    private int CompanyID;
    @ColumnInfo(name = "Name")
    private String Name;
    @ColumnInfo(name = "Description")
    private String Description;

    private boolean Available;
    private int DataBaseTypeID;

    public Company(){

    }

    public Company(int companyID, String name, String description, boolean available, int dataBaseTypeID) {
        CompanyID = companyID;
        Name = name;
        Description = description;
        Available = available;
        DataBaseTypeID = dataBaseTypeID;
    }

    public void setCompanyID(int CompanyID){
        this.CompanyID = CompanyID;
    }
    public int getCompanyID(){
        return this.CompanyID;
    }

    public void setName(String Name){
        this.Name = Name;
    }
    public String getName(){
        return this.Name;
    }
    public void setDescription(String Description){
        if(Description==null){
            Description="";
        }
        this.Description = Description;
    }
    public String getDescription(){
        return this.Description;
    }

    public void setAvailable(boolean Available){
        this.Available = Available;
    }
//    public boolean getAvailable(){
//        return this.Available;
//    }

    public boolean isAvailable() {
        return Available;
    }

    public int getDataBaseTypeID() {
        return DataBaseTypeID;
    }

    public void setDataBaseTypeID(int dataBaseTypeID) {
        DataBaseTypeID = dataBaseTypeID;
    }

}
