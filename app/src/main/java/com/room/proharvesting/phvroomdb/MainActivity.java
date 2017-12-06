package com.room.proharvesting.phvroomdb;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.room.proharvesting.phvroomdb.Database.AppDatabase;
import com.room.proharvesting.phvroomdb.Utils.DatabaseInitializer;
import com.room.proharvesting.phvroomdb.fragments.MainFragment;
import com.room.proharvesting.phvroomdb.fragments.NestedFragment;

public class MainActivity extends FragmentActivity {

    public static AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(R.layout.activity_main);

    }


    private void init(){

        db = AppDatabase.getAppDatabase(this);
        DatabaseInitializer.populateAsync(db);

    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();

    }
}
