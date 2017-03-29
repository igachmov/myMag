package com.mymag.mymag.model.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mymag.mymag.R;
import com.mymag.mymag.model.users.User;

public class UserActivity extends AppCompatActivity {
    TextView textName;
    TextView textPhone;
    TextView textEmail;
    TextView textAddress;
    ImageView imageUser;
    ImageView imagePhone;
    ImageView imageEmail;
    ImageView imageAddress;
    Button edit;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Toolbar tb = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(tb);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.mipmap.ic_launcher_round);
        ab.setDisplayShowTitleEnabled(false);



        textName= (TextView) findViewById(R.id.text_name);
        textPhone= (TextView) findViewById(R.id.text_phone);
        textEmail= (TextView) findViewById(R.id.text_email);
        textAddress= (TextView) findViewById(R.id.text_address);
        imageUser= (ImageView) findViewById(R.id.image_user);
        imagePhone= (ImageView) findViewById(R.id.image_phone);
        imageEmail= (ImageView) findViewById(R.id.image_email);
        imageAddress= (ImageView) findViewById(R.id.image_address);
        delete= (Button) findViewById(R.id.user_button_delete);
        edit= (Button) findViewById(R.id.user_button_edit);
        User user = User.user;

        //imageUser.setImageResource(R.drawable.user);
     //   imagePhone.setImageResource(R.drawable.phone);
      //  imageEmail.setImageResource(R.drawable.email);
      //  imageAddress.setImageResource(R.drawable.address);
        textName.setText(user.getName());
        textPhone.setText(user.getTelNumber());
        textAddress.setText(user.getAddress());
        textEmail.setText(user.getEmail());

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(UserActivity.this);
                builder1.setMessage("Are you sure ? This will remove user: "+ User.user.getName());
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });



    }
}
