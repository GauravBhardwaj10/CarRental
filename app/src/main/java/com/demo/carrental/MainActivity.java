package com.demo.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText emailAddEd,passEd;
    SqliteDatabase myDb;
    private Button joinBtn;
    TextView registrationTextVIEW,AdminTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailAddEd=(EditText) findViewById(R.id.LogEmaileditText);
        passEd=(EditText) findViewById(R.id.LogpasswordeditText);
        joinBtn=(Button) findViewById(R.id.Logjoinbtn);
        myDb=new SqliteDatabase(this);
        Cursor res = myDb.getAllData();

        registrationTextVIEW=findViewById(R.id.registrationTextView);
        AdminTextview=findViewById(R.id.ADMINTextView);




        registrationTextVIEW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });


        AdminTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AdminActivity.class);
                startActivity(intent);
            }
        });



        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailAddEd.getText().toString();
                String password=passEd.getText().toString();
                try {
                    if(email.length() > 0 && password.length() >0)

                    {
                        if(myDb.Login(email, password))

                        {

                            Toast.makeText(MainActivity.this,"Successfully Logged In", Toast.LENGTH_LONG).show();


                            Intent in=new Intent(MainActivity.this,WelcomeActivity.class);
                            startActivity(in);

                        }else{
                            Toast.makeText(MainActivity.this," not Successfully Logged In", Toast.LENGTH_LONG).show();

                        }
                    }
                }catch (Exception ee){
                    ee.toString();
                }
            }
        });

    }
}
