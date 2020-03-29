package com.moh3n.eshop1.Fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.moh3n.eshop1.Model.View_All_Deal_Of_Day_model;
import com.moh3n.eshop1.MainActivity;
import com.moh3n.eshop1.R;
import com.moh3n.eshop1.util.ConnectivityReceiver;

public class View_All_deals_fragments extends Fragment {

    //  private static String TAG = com.tcc.gogrocer.Fragment.My_Past_Order.class.getSimpleName();

    private RecyclerView rv_view_all;

    private List<View_All_Deal_Of_Day_model> view_all_deal_of_day_models = new ArrayList<>();

    public View_All_deals_fragments() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_all_deal, container, false);



        // handle the touch event if true
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // check user can press back button or not
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {

//                    com.tcc.gogrocer.Fragment fm = new Home_fragment();
//                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
//                    fragmentManager.beginTransaction().replace(R.id.contentPanel, fm)
//                            .addToBackStack(null).commit();
                    return true;
                }
                return false;
            }
        });

        rv_view_all = (RecyclerView) view.findViewById(R.id.rv_all_deals);
        rv_view_all.setLayoutManager(new LinearLayoutManager(getActivity()));

        // check internet connection
        if (ConnectivityReceiver.isConnected())

        {
        } else

        {
            ((MainActivity) getActivity()).onNetworkConnectionChanged(false);
        }


        return view;
    }




}