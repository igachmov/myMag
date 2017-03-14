package com.mymag.mymag.model.activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by UserX on 14.3.2017 г..
 */

public class DBWorker  extends DBHelper {
    public DBWorker(Context context) {
        super(context);
    }


    public  void addRecord(String name, String password,String email, String phone,String address){
        open();
        ContentValues cv = new ContentValues();

        cv.put("name",name);
        cv.put("password",password);
        cv.put("email",email);
        cv.put("phone",phone);
        cv.put("address",address);
        this.db.insert("users",null,cv);
    }

    public Cursor getValues(){
        open();
        return  this.db.query("users", new String[]{"_id","name", "password","email",
                "phone", "address"},null,null,null,null,null);
    }

    public void deleteALL() {
        open();
        db.delete("users",null,null);
    }
}
