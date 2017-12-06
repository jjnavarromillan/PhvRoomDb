package com.room.proharvesting.phvroomdb.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.room.proharvesting.phvroomdb.Dao.CompanyDao;
import com.room.proharvesting.phvroomdb.Dao.PlaceDao;
import com.room.proharvesting.phvroomdb.Entities.Company;
import com.room.proharvesting.phvroomdb.Entities.Place;

@Database(entities = {Company.class, Place.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract CompanyDao companyDao();
    public abstract PlaceDao placeDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "phv.sqlite")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
