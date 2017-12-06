package com.room.proharvesting.phvroomdb.Adapters;

import android.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.room.proharvesting.phvroomdb.Entities.Company;
import com.room.proharvesting.phvroomdb.R;
import com.room.proharvesting.phvroomdb.fragments.MainFragment;


import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by proharvesting on 12/5/2017.
 */

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.MyViewHolder> {
    private List<Company> CompanyList;
    private MainFragment fragment;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewID;
        public TextView textViewName;


        public MyViewHolder(View view) {
            super(view);

            textViewID =  view.findViewById(R.id.textViewID);
            textViewName = view.findViewById(R.id.textViewName);

        }
    }


    public CompanyAdapter(MainFragment fragment, List<Company> companyList) {
        CompanyList = companyList;
        this.fragment = fragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.
                from(parent.getContext())
                .inflate(R.layout.fragment_company_lite_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Company company = CompanyList.get(position);

        holder.textViewID.setText(""+company.getCompanyID());
        holder.textViewName.setText(company.getName());

    }

    @Override
    public int getItemCount() {
        return CompanyList.size();
    }


}
