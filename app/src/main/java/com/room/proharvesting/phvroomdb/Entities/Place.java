package com.room.proharvesting.phvroomdb.Entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.room.proharvesting.phvroomdb.Utils.TypeTransform;

import java.util.Date;

@Entity(tableName = "Place")
public class Place {
	@PrimaryKey(autoGenerate = true)
	public int PlaceID;
	@ColumnInfo(name="Name")
	public String Name;
	@ColumnInfo(name="PlaceCode")
	public String PlaceCode;
	@ColumnInfo(name="Description")
	public String Description;
	@ColumnInfo(name="CompanyID")
	public int CompanyID;

//	@TypeConverters({TypeTransform.class})
//	public String RegisterDate;
//	@TypeConverters({TypeTransform.class})
//	public String FinishDate;
	@ColumnInfo(name="PlaceManagerID")
	public int PlaceManagerID;

//	@TypeConverters({TypeTransform.class})
//	@ColumnInfo(name="Date")
//	public String date;

	@ColumnInfo(name="LocationID")
	public int LocationID;
	@ColumnInfo(name="Acres")
	public double Acres;
	//@ColumnInfo(name="Available")
	public boolean Available;
	@ColumnInfo(name="DataBaseTypeID")
	public int DataBaseTypeID;
	@ColumnInfo(name="CostCenterTypeID")
	public int CostCenterTypeID;

	public int getPlaceID() {
		return PlaceID;
	}
	public void setPlaceID(int placeID) {
		PlaceID = placeID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPlaceCode() {
		return PlaceCode;
	}
	public void setPlaceCode(String placeCode) {
		PlaceCode = placeCode;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getCompanyID() {
		return CompanyID;
	}
	public void setCompanyID(int companyID) {
		CompanyID = companyID;
	}

	public int getPlaceManagerID() {
		return PlaceManagerID;
	}
	public void setPlaceManagerID(int placeManagerID) {
		PlaceManagerID = placeManagerID;
	}

	public int getLocationID() {
		return LocationID;
	}
	public void setLocationID(int locationID) {
		LocationID = locationID;
	}
	public double getAcres() {
		return Acres;
	}
	public void setAcres(double acres) {
		Acres = acres;
	}
	public boolean isAvailable() {
		return Available;
	}
	public void setAvailable(boolean available) {
		Available = available;
	}

	public int getDataBaseTypeID() {
		return DataBaseTypeID;
	}

	public void setDataBaseTypeID(int dataBaseTypeID) {
		DataBaseTypeID = dataBaseTypeID;
	}

	public int getCostCenterTypeID() {
		return CostCenterTypeID;
	}

	public void setCostCenterTypeID(int costCenterTypeID) {
		CostCenterTypeID = costCenterTypeID;
	}
}
