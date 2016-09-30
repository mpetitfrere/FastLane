package com.example.hertzfastlane;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends AppCompatActivity {

    String TAG = "LoginActivity";
    String username;
    String password;
    boolean exist;
    private DatabaseReference mDatabase;
    private DynamoDBMapper mapperMembers;
    private Member member;
    private String resultString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);




        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();


                //Amazon Web Services Connection
                //Credentials for identity pools for Table Cars and members - AWS
                // Initialize the Amazon Cognito credentials provider for members Table
                CognitoCachingCredentialsProvider credentialsProviderMembers = new CognitoCachingCredentialsProvider(
                        getApplicationContext(),
                        "us-east-1:d203cc02-4b6f-475d-84b1-93687e673058", // Identity Pool ID
                        Regions.US_EAST_1 // Region
                );
                AmazonDynamoDBClient ddbClientMembers = new AmazonDynamoDBClient(credentialsProviderMembers);
                mapperMembers = new DynamoDBMapper(ddbClientMembers);
                

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        member = mapperMembers.load(Member.class, username);
                        if(member == null){
                            System.out.println("User does not exist");
                        }else{
                            if(password.equals(member.getPassword())){
                                System.out.println("SUCCESS!");
                            }else{
                                System.out.println("Failure");
                            }
                        }

                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();

                try{
                    thread.join();
                }catch(Exception e){
                    return;
                }
//firebase();
//if(username.toString() == "john")
//{
                Intent userActivityIntent = new Intent(LoginActivity.this, UserActivity.class);
                LoginActivity.this.startActivity(userActivityIntent);
//}
            }
        });


    }

}