package com.room.proharvesting.phvroomdb.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.room.proharvesting.phvroomdb.Adapters.CompanyAdapter;
import com.room.proharvesting.phvroomdb.Database.AppDatabase;
import com.room.proharvesting.phvroomdb.Entities.Company;
import com.room.proharvesting.phvroomdb.R;
import com.room.proharvesting.phvroomdb.Utils.DatabaseInitializer;

import java.util.List;

public class MainFragment extends Fragment {

    public static AppDatabase db;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    List<Company> companyList;


    Button button;
    Button buttonAdd;
    Button buttonTransaction;
    TextView textViewCount;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_main, container, false);

        initComponents(viewRoot);
        initDB();

        return viewRoot;
    }
    public void initComponents(View viewRoot ){
        button = viewRoot.findViewById(R.id.button);
        textViewCount = viewRoot.findViewById(R.id.textViewCount);
        buttonAdd = viewRoot.findViewById(R.id.buttonAdd);
        buttonTransaction = viewRoot.findViewById(R.id.buttonTransaction);

        mRecyclerView = viewRoot.findViewById(R.id.my_recycler_view);

        button.setOnClickListener(view -> read());
        buttonAdd.setOnClickListener(view-> add());
        buttonTransaction.setOnClickListener((view->deletingWithTransactions()));


    }

    public void initDB(){

        db = AppDatabase.getAppDatabase(getContext());
        companyList = db.companyDao().getAll();

        mAdapter = new CompanyAdapter(this, companyList);
        mRecyclerView.setAdapter(mAdapter);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        textViewCount.setText(""+companyList.size());


    }

    public void deletingWithTransactions(){

        db.beginTransaction();
        try{

            for (Company company:companyList ) {
                db.companyDao().delete(company);
            }
            db.setTransactionSuccessful();
            Toast.makeText(getContext(),"Transaction Finished ",Toast.LENGTH_LONG);

        }
        catch (Exception ex){
            //Error
        }
        finally {
            db.endTransaction();
            read();
        }

    }

    public void read(){

        companyList = db.companyDao().getAll();
        mAdapter = new CompanyAdapter(this, companyList);
        mRecyclerView.setAdapter(mAdapter);
        textViewCount.setText(""+companyList.size());
    }

    public void add(){

        Company company = new Company(0,"C 1","",true,1) ;
        DatabaseInitializer.addCompany(db,company);
        companyList = db.companyDao().getAll();
        textViewCount.setText(""+companyList.size());
        mAdapter = new CompanyAdapter(this, companyList);
        mRecyclerView.setAdapter(mAdapter);

    }





}
