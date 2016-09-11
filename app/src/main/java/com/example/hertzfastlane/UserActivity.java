package com.example.hertzfastlane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcome);

    }
}
