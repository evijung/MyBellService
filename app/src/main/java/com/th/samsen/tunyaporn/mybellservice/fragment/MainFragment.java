package com.th.samsen.tunyaporn.mybellservice.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.th.samsen.tunyaporn.mybellservice.R;

/**
 * Created by TunyapornSamsen on 11/18/2017 AD.
 */

public class MainFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Button Controller

        buttonController();


    }

    private void buttonController() {
        Button button = getView().findViewById(R.id.btnGoToSecond);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Replace Fragment

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.contentFragmentMain, new SecondFragment()).addToBackStack(null).commit();

            }
        });


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);


        return view;
    }

}//Main Fragment Class
