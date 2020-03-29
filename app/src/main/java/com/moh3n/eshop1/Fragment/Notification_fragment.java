package com.moh3n.eshop1.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moh3n.eshop1.MainActivity;
import com.moh3n.eshop1.R;

public class Notification_fragment extends Fragment {


    public Notification_fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        ((MainActivity) getActivity()).setTitle("Notification");



        return view;
    }




}

