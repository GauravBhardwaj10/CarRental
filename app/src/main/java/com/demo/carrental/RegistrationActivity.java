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

public class RegistrationActivity extends AppCompatActivity {

    TextView loginTextVIEW;
    private EditText fNameEd,lNameEd,emailAddEd,passEd;
    SqliteDatabase myDb;
    private Button joinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fNameEd=(EditText) findViewById(R.id.firsteditText);
        lNameEd=(EditText) findViewById(R.id.lasteditText);
        emailAddEd=(EditText) findViewById(R.id.EmaileditText);
        passEd=(EditText) findViewById(R.id.passwordeditText);
        joinBtn=(Button) findViewById(R.id.joinbtn);

        loginTextVIEW=findViewById(R.id.loginTextView);

        myDb=new SqliteDatabase(this);

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstname=fNameEd.getText().toString();
                String lastname=lNameEd.getText().toString();
                String emailid=emailAddEd.getText().toString();
                String pass=passEd.getText().toString();
                if(!(firstname.equals("") && lastname.equals("") && emailid.equals("") && pass.equals(""))) {
                    boolean isInserted = myDb.insertData(firstname, lastname, emailid, pass);

                    Cursor res = myDb.getAllData();



                    if(isInserted == true) {
                        Toast.makeText(RegistrationActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();

                        Intent in = new Intent(RegistrationActivity.this, MainActivity.class);
                        startActivity(in);
                    }
                    else
                        Toast.makeText(RegistrationActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(RegistrationActivity.this,"Insert in Empty Fields",Toast.LENGTH_LONG).show();

                }

            }
        });

        loginTextVIEW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
