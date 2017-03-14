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

public class LoginActivity extends AppCompatActivity {

    Button logIn;
    Button goToRegister;
    EditText email;
    EditText password;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email=(EditText)findViewById(R.id.email_in);
        password=(EditText)findViewById(R.id.password_in);
        goToRegister= (Button)findViewById(R.id.Button_Register);
        logIn= (Button)findViewById(R.id.Button_logIn_in);
        final Intent register = new Intent(LoginActivity.this,RegisterActivity.class);
        final Intent homeActivity = new Intent(LoginActivity.this,HomeActivity.class);



        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(register);
            }
        });

        {
            DBWorker worker = new DBWorker(getApplicationContext());
            worker.addRecord("admin","123456","admin@ittalents.bg","0888888888","Mall Bulgaria");
            worker.close();
        }

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().isEmpty()&& !password.getText().toString().isEmpty()){
                    DBWorker dbWorker = new DBWorker(getApplicationContext());
                    Cursor c = dbWorker.getValues();
                    if (c.moveToFirst()){
                        boolean isRegistry=false;
                        do {
                            if (c.getString(c.getColumnIndex("email")).equals(email.getText().toString()) &&
                                    c.getString(c.getColumnIndex("password")).equals(password.getText().toString())) {
                                id = c.getInt(c.getColumnIndex("_id"));
                                Toast.makeText(LoginActivity.this, "LOG IN SUCCESS", Toast.LENGTH_SHORT).show();
                                startActivity(homeActivity);
                                isRegistry=true;
                                dbWorker.close();
                                c.close();
                                break;
                            }
                        }while (c.moveToNext());

                        if (!isRegistry){
                            Toast.makeText(LoginActivity.this, "LOG IN IS NOT SUCCESS\n PLEASE REGISTERY" +
                                    " FIRST", Toast.LENGTH_SHORT).show();
                        }

                    }

                }
                else{
                    Toast.makeText(LoginActivity.this, "PLEASE CHECK YOUR DATA AGAIN!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
