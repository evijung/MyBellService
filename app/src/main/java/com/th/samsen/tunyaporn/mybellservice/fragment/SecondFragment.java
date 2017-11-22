package com.th.samsen.tunyaporn.mybellservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.th.samsen.tunyaporn.mybellservice.R;
import com.th.samsen.tunyaporn.mybellservice.utility.GetJSON;
import com.th.samsen.tunyaporn.mybellservice.utility.MyConstant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by TunyapornSamsen on 11/18/2017 AD.
 */

public class SecondFragment extends Fragment {

    private String jsonString, dateString, usdString,jsonRateString;
    private double rateADouble,answerADouble;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        readJSON();
        showDate();
        showRate();
        calculate();

    }

    private void showAnswer() {
        TextView textView = getView().findViewById(R.id.txtAnswer);
        textView.setText(String.valueOf(answerADouble));

    }

    private void calculate() {
        Button button = getView().findViewById(R.id.btnExchanged);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = getView().findViewById(R.id.edtUSD);
                usdString = editText.getText().toString();
                if (usdString.isEmpty()) {
                    Toast.makeText(getActivity(), "Please Fill USD", Toast.LENGTH_SHORT).show();

                } else {
                    Double aDouble = Double.valueOf(editText.getText().toString());
                    answerADouble = aDouble * rateADouble;

                    showAnswer();
                }
            }
        });

    }

    private void showRate() {
        TextView rateTextView = getView().findViewById(R.id.txtRate);
        try {
            JSONObject jsonObject = new JSONObject(jsonRateString);
            rateADouble = jsonObject.getDouble("THB");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rateTextView.setText(getResources().getText(R.string.rate) + " " + rateADouble);
    }


    private void showDate() {
        TextView textView = getView().findViewById(R.id.txtDate);

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            dateString = jsonObject.getString("date");
            jsonRateString = jsonObject.getString("rates");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        textView.setText(getResources().getText(R.string.date)+" "+dateString);

    }

    private void readJSON() {

        String tag = "SecondFragment";
        MyConstant myConstant = new MyConstant();

        try {

            GetJSON getJSON = new GetJSON(getActivity());
            getJSON.execute(myConstant.getUrlJson());

            jsonString = getJSON.get();

            Log.d(tag, "JSON ==> " + jsonString);

        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.d(tag, "e ==> " + e.toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
            Log.d(tag, "e ==> " + e.toString());
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        return view;

    }
}
