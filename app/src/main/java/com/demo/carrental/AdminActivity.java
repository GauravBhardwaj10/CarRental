package com.demo.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminActivity extends AppCompatActivity {

    Button AdminSignUp;
    TextView loginTextviewAdminPage,RegistrationTextViewAdminPage;
    EditText AdminpasswordediText,AdminEmailIdediText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        loginTextviewAdminPage=findViewById(R.id.loginTextViewAdminpage);
        RegistrationTextViewAdminPage=findViewById(R.id.registrationTextViewAdminpage);

        AdminpasswordediText=findViewById(R.id.PasswordEditTextAdminPage);
        AdminEmailIdediText=findViewById(R.id.EmailEditTextADMINPAge);


        AdminSignUp=findViewById(R.id.AdmiPagesignup);


        AdminSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });


        loginTextviewAdminPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        RegistrationTextViewAdminPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(AdminActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });


        AdminSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (AdminEmailIdediText.getText().toString().equals("admin")&&AdminpasswordediText.getText().toString().equals("admin"))

                {
                    Intent intent=new Intent(AdminActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {

                    {
                        Toast.makeText(getApplicationContext(),"invalid username and password",Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });

    }
}
