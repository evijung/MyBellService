package com.th.samsen.tunyaporn.mybellservice.utility;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by TunyapornSamsen on 11/19/2017 AD.
 */

public class GetJSON extends AsyncTask<String ,Void,String >{

    private Context context;

    public GetJSON(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[0]).build();
            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
