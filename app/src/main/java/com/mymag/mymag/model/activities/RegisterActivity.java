package com.mymag.mymag.model.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mymag.mymag.R;

public class RegisterActivity extends AppCompatActivity {


    EditText name;
    EditText password;
    EditText repPassword;
    EditText email;
    EditText phone;
    EditText address;
    Button save;
    Button cancel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        save=(Button)findViewById(R.id.save);
        name = (EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        repPassword=(EditText)findViewById(R.id.repPassword);
        phone=(EditText)findViewById(R.id.phone);
        email=(EditText)findViewById(R.id.email);
        address=(EditText)findViewById(R.id.address);
        cancel = (Button) findViewById(R.id.cancel_Register);

        final Intent cancelIntent= new Intent(RegisterActivity.this,LoginActivity.class);
        final Intent goToLogIn= new Intent(RegisterActivity.this,LoginActivity.class);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBWorker dbWorker= new DBWorker(getApplicationContext());
                if (name.getText().toString().isEmpty()||(email.getText().toString().isEmpty()||email.getText().toString()
                .matches(getString(R.string.Regex)))||
                        password.getText().toString().isEmpty()||repPassword.getText().toString().isEmpty()||
                        phone.getText().toString().isEmpty()||address.getText().toString().isEmpty()||
                        !password.getText().toString().equals(repPassword.getText().toString())){

                    Toast.makeText(RegisterActivity.this, "Please check all data again!!", Toast.LENGTH_SHORT).show();
                }
                else {

                    dbWorker.addRecord(name.getText().toString(),name.getText().toString(),
                            password.getText().toString(),phone.getText().toString(),
                            address.getText().toString());
                    Log.e("anatoli", "SAVE");
                    dbWorker.close();
                    Toast.makeText(RegisterActivity.this, "registration is successful! \n Please Log In", Toast.LENGTH_SHORT).show();
                    startActivity(goToLogIn);
                }



            }
        });

       cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(cancelIntent);
           }
       });

    }
}
