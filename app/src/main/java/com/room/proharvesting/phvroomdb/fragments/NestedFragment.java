package com.room.proharvesting.phvroomdb.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.room.proharvesting.phvroomdb.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NestedFragment extends Fragment {

    OnHeadlineSelectedListener mCallback;
    TextView textViewMessage;

    public NestedFragment() {

        try {
            mCallback = (OnHeadlineSelectedListener) this.getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(this.getActivity().toString()
                    + " must implement OnHeadlineSelectedListener");
        }

    }

    public void sendMessage(String message){
        textViewMessage.setText(message);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nested, container, false);

        textViewMessage = view.findViewById(R.id.textViewMessage);

        return  view;
    }

    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {
        public void sendMessage(String message);
    }

}
