package com.mymag.mymag.model.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mymag.mymag.R;
import com.mymag.mymag.model.users.User;

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

                if (!email.getText().toString().trim().isEmpty()&& !password.getText().toString().trim().isEmpty()&&
                        email.getText().toString().trim().matches(getString(R.string.Regex))&& password.getText().toString().trim().length()>=4){
                    DBWorker dbWorker = new DBWorker(getApplicationContext());
                    Cursor c = dbWorker.getValues();
                    if (c.moveToFirst()){
                        boolean isRegistry=false;
                        do {
                            if (c.getString(c.getColumnIndex("email")).equals(email.getText().toString().trim()) &&
                                    c.getString(c.getColumnIndex("password")).equals(password.getText().toString().trim())) {
                                id = c.getInt(c.getColumnIndex("_id"));
                                Toast.makeText(LoginActivity.this, "LOG IN SUCCESS", Toast.LENGTH_SHORT).show();
                                startActivity(homeActivity);
                                isRegistry=true;
                                dbWorker.close();

                                /* Create a new user from Class User and took the  fields and id from the data base*/

                                User user = new User(c.getString(c.getColumnIndex("name")),c.getString(c.getColumnIndex("password")),
                                        c.getString(c.getColumnIndex("email")),c.getString(c.getColumnIndex("phone")),
                                                c.getString(c.getColumnIndex("address")),User.Type.CLIENT);
                                user.setId(c.getInt(c.getColumnIndex("_id")));
                                User.setUser(user);




                                c.close();
                                break;
                            }
                        }while (c.moveToNext());

                        if (!isRegistry){
                            Toast.makeText(LoginActivity.this, "LOG IN IS NOT SUCCESS\n PLEASE  REGISTERY"
                                    , Toast.LENGTH_SHORT).show();
                        }

                    }

                }
                else{
                    if (email.getText().toString().trim().isEmpty()){
                        email.setError("Please enter your email!");
                    }
                    if (!email.getText().toString().trim().matches(getString(R.string.Regex))) {
                        email.setError("Please check your email!");
                    }
                    if (password.getText().toString().trim().isEmpty()){
                        password.setError("Please enter your password!");
                    }
                    if (password.getText().toString().length()<4 ){
                        password.setError("Minimum 4 characters!");
                    }

                }
            }
        });

    }
}
