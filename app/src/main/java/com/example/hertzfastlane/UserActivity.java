package com.example.hertzfastlane;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final Button bMyReservation = (Button) findViewById(R.id.bMyReservation);
        final Button bScanner = (Button) findViewById(R.id.bScanner);
        final Button bMap = (Button) findViewById(R.id.bMap);
        final Button bHelp = (Button) findViewById(R.id.bHelp);

        //Intent intent = getIntent();
        //String name = intent.getStringExtra("name");

        //etName.setText(name);

        bScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(UserActivity.this, QrScanner.class);
                UserActivity.this.startActivity(registerIntent);
            }
        });

        bHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent helpIntent = new Intent(UserActivity.this, HelpActivity.class);
                UserActivity.this.startActivity(helpIntent);
            }
        });


    }
}
