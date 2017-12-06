package com.room.proharvesting.phvroomdb.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;


import com.room.proharvesting.phvroomdb.Entities.Company;

import java.util.List;



@Dao
public abstract class CompanyDao {

    @Query("SELECT * FROM company")
    public abstract List<Company> getAll();

    @Query("SELECT * FROM company where name LIKE  :name")
    public abstract Company findByName(String name);

    @Query("SELECT * FROM company where CompanyID LIKE  :ID")
    public abstract Company findByID(int ID);


    @Query("SELECT COUNT(*) from company")
    public abstract int countCompanies();

    @Insert
    public abstract void insertAll(Company... companies);

    @Delete
    public abstract void delete(Company company);

    @Transaction
    public void deleteTwoFirstCompanies(List<Company> companies){

        for (Company company: companies) {
            delete(company);
        }


    }
}
