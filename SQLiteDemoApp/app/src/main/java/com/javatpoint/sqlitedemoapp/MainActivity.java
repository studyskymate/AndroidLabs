package com.javatpoint.sqlitedemoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db=new DatabaseHandler(this);
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Dinesh", "9100000000"));
        db.addContact(new Contact("Tony", "9199999999"));
        db.addContact(new Contact("Kumar", "9522222222"));
        db.addContact(new Contact("Rohit", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNo();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

    }
}
