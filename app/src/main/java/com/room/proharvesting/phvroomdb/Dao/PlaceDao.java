package com.room.proharvesting.phvroomdb.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.room.proharvesting.phvroomdb.Entities.Place;

import java.util.List;

/**
 * Created by proharvesting on 12/4/2017.
 */
@Dao
public interface PlaceDao {

    @Query("SELECT * FROM place")
    List<Place> getAll();

    @Query("SELECT * FROM place where Available LIKE :boolValue")
    List<Place> getActives(boolean boolValue);

    @Query("SELECT * FROM place where CompanyID LIKE :ID")
    List<Place> getActivesByCompany(int ID);

    @Query("SELECT * FROM place where Name LIKE :name")
    Place findByName(String name);

    @Query("SELECT * FROM place where PlaceID LIKE  :ID")
    Place findByID(int ID);

    @Query("SELECT COUNT(*) from place")
    int countPlaces();

    @Update
    void update(Place place);

    @Insert
    void insertAll(Place... places);


}


