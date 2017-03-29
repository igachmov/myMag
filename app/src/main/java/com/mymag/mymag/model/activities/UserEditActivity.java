package com.mymag.mymag.model.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mymag.mymag.R;
import com.mymag.mymag.model.users.User;

import java.io.File;

public class UserEditActivity extends AppCompatActivity {
    public static final int RESULT_EDIT = 1;
    public static final int REQUEST_CODE = 1;
    EditText name;
    EditText phone;
    EditText email;
    EditText address;
    Button confirm;
    Button cancel;
    Button makePicture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);
        Toolbar tb = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(tb);

        name= (EditText) findViewById(R.id.edit_name);
        phone= (EditText) findViewById(R.id.edit_phone);
        email= (EditText) findViewById(R.id.edit_email);
        address= (EditText) findViewById(R.id.edit_address);
        confirm= (Button) findViewById(R.id.edit_confirm);
        cancel= (Button) findViewById(R.id.edit_cancel);
        makePicture=(Button) findViewById(R.id.edit_picture);

        name.setText(User.user.getName());
        phone.setText(User.user.getTelNumber());
        email.setText(User.user.getEmail());
        address.setText(User.user.getAddress());

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        makePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file= getFile();
                camera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera, REQUEST_CODE);

            }
        });



        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean hasError= false;
                if (name.getText().toString().trim().isEmpty()){
                    name.setError("Please enter your name!");
                    hasError=true;
                }

                if (email.getText().toString().trim().isEmpty()){
                    email.setError("Please enter your email!");
                    hasError=true;
                }
                if (!email.getText().toString().trim().matches(getString(R.string.Regex))) {
                    email.setError("Please check your email!");
                    hasError=true;
                }

                if (phone.getText().toString().trim().isEmpty()||!phone.getText().toString().matches("08[0-9]{8}")){
                    phone.setError("Please enter your phone!");
                    hasError=true;
                }
                if (address.getText().toString().trim().isEmpty()){
                    address.setError("Please enter your address!");
                    hasError=true;
                }

                if(!hasError){
                    Log.e("anatoli","dadasdasda");
                    DBWorker dbWorker= new DBWorker(getApplicationContext());
                    ContentValues values= new ContentValues();
                    values.put("name",name.getText().toString().trim());
                    values.put("phone",phone.getText().toString().trim());
                    values.put("email",email.getText().toString().trim());
                    values.put("address",address.getText().toString().trim());
                    dbWorker.edit(values,User.user.getUserID());
                    dbWorker.close();
                    User.user.setName(name.getText().toString().trim());
                    User.user.setTelNumber(phone.getText().toString().trim());
                    User.user.setEmail(email.getText().toString().trim());
                    User.user.setAddress(address.getText().toString().trim());
                    setResult(RESULT_EDIT);
                    finish();

                }

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionbutton_to_cart:
                startActivity(new Intent(this, CartActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
    private File getFile(){
        File folder= new File("sdcard/camera_app");
        if(!folder.exists()){
            folder.mkdir();
        }
        File image_fale =new File(folder,"cam_image.jpg");
        return  image_fale;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "sdcard/camera_app/cam_image.jpg";
        User.user.setImagePath(path);
        cancel.setVisibility(View.INVISIBLE);
        makePicture.setVisibility(View.INVISIBLE);

    }
}

