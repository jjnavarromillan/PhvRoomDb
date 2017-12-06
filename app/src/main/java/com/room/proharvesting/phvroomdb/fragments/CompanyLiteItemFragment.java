package com.room.proharvesting.phvroomdb.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.room.proharvesting.phvroomdb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyLiteItemFragment extends Fragment {


    public CompanyLiteItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company_lite_item, container, false);
    }

}
