package com.room.proharvesting.phvroomdb.Utils;


import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.room.proharvesting.phvroomdb.Entities.Company;
import com.room.proharvesting.phvroomdb.Dao.CompanyDao;
import com.room.proharvesting.phvroomdb.Database.AppDatabase;
import com.room.proharvesting.phvroomdb.Entities.Place;

import java.util.List;

public class DatabaseInitializer {

    private static final String TAG = DatabaseInitializer.class.getName();

    public static void populateAsync(@NonNull final AppDatabase db) {
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    public static Company addCompany(final AppDatabase db, Company company) {
        db.companyDao().insertAll(company);
        return company;
    }

    private static void populateWithTestData(AppDatabase db) {

        List<Company> companyList = db.companyDao().getAll();
        List<Place> placeList = db.placeDao().getAll();

    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
