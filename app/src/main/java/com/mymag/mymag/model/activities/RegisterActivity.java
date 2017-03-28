package com.mymag.mymag.model.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mymag.mymag.R;

import java.io.Serializable;

public class RegisterActivity extends AppCompatActivity {


    public static final int RESULT_CODE = 2;
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




        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBWorker dbWorker= new DBWorker(getApplicationContext());



                 if (name.getText().toString().isEmpty()||(email.getText().toString().isEmpty()||! email.getText().toString()
                .matches(getString(R.string.Regex)))||
                        password.getText().toString().isEmpty()||repPassword.getText().toString().isEmpty()||
                         !phone.getText().toString().matches("08[0-9]{8}")||address.getText().toString().isEmpty()||
                        !password.getText().toString().equals(repPassword.getText().toString())||
                         password.getText().length()<4||repPassword.getText().toString().length()<4)
                {

                    if (name.getText().toString().trim().isEmpty()){
                        name.setError("Please enter your name!");
                    }
                    if (password.getText().toString().trim().isEmpty()){
                        password.setError("Please enter your password!");
                    }
                    if (repPassword.getText().toString().trim().isEmpty()){
                        repPassword.setError("Please repeat your password!");
                    }
                    if (email.getText().toString().trim().isEmpty()){
                        email.setError("Please enter your email!");
                    }
                    if (!email.getText().toString().trim().matches(getString(R.string.Regex))) {
                        email.setError("Please check your email!");
                    }

                    if (phone.getText().toString().trim().isEmpty()||!phone.getText().toString().matches("08[0-9]{8}")){
                        phone.setError("Please enter your phone!");
                    }
                    if (address.getText().toString().trim().isEmpty()){
                        address.setError("Please enter your address!");
                    }
                    if (!password.getText().toString().trim().isEmpty()&&!repPassword.getText().toString().trim().isEmpty()){
                        if (!password.getText().toString().equals(repPassword.getText().toString())){
                            repPassword.setError("Passwords are not the same!");
                        }

                    }

                    if (repPassword.getText().toString().length()<4 ){
                        repPassword.setError("Minimum 4 characters!");
                    }
                }
                else {
                    boolean isExist=false;
                    Cursor c = dbWorker.getValues();
                    if (c.moveToFirst()) {
                        do {
                            if (c.getString(c.getColumnIndex("email")).equals(email.getText().toString())) {

                                isExist=true;
                                Toast.makeText(RegisterActivity.this, "This email already exist!", Toast.LENGTH_LONG).show();
                                break;
                            }
                        } while (c.moveToNext());
                    }
                    if (!isExist){
                        dbWorker.addRecord(name.getText().toString().trim(),password.getText().toString().trim(),
                                email.getText().toString().trim(),phone.getText().toString().trim(),
                                address.getText().toString().trim());
                        dbWorker.close();
                        Toast.makeText(RegisterActivity.this, "registration is successful! \n Please Log In", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent();
                       UserIntent intentForResult = new UserIntent(email.getText().toString(),password.getText().toString());
                        intent.putExtra("intentForResult",intentForResult);
                        setResult(RESULT_OK,intent);
                        finish();

                    }

                }

            }
        });

       cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              finish();
           }
       });

    }
}
class UserIntent implements Serializable{
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserIntent(String email, String password) {
        this.email = email;
        this.password = password;
    }
}