package com.th.samsen.tunyaporn.mybellservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.th.samsen.tunyaporn.mybellservice.fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Add Fragment to Activity
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().add(R.id.contentFragmentMain, new MainFragment()).commit();

        }

//        Drawer Controller

        drawerController();

    }   //Main Method

    private void drawerController() {
        TextView mainTextView = findViewById(R.id.txtMain);
        TextView secondTextView = findViewById(R.id.txtSecond);
        TextView exitTextView = findViewById(R.id.txtExit);

        mainTextView.setOnClickListener(this);
        secondTextView.setOnClickListener(this);
        exitTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtMain:

                break;
            case R.id.txtSecond:

                break;
            case R.id.txtExit:

                break;
        }
    }
}   //Main Class
