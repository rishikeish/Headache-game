package com.example.student.headache2;

import android.content.Intent;
import
        android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import Database.DBHandler;
import Database.User;


public class Main2Activity extends AppCompatActivity {


    DBHandler dbHandler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dbHandler = new DBHandler(this);
    }

    protected void register(View view){

        EditText edit1 = (EditText)findViewById(R.id.addUsername);
        String username = edit1.getText().toString();


        if (isEmpty(username)) {
            Toast t = Toast.makeText(this, "You must enter username to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        EditText edit2 = (EditText)findViewById(R.id.addPassword);
        String password = edit2.getText().toString();

        if (isEmpty(password)) {
            Toast t = Toast.makeText(this, "You must enter password to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if(!checkUser(username)) {
            dbHandler.addUser(username, password);
            Intent i = new Intent(getApplicationContext(), lvl3_Activity.class);
            i.putExtra("UserName", username);

            startActivity(i);

        }else{
            Intent i = new Intent(getApplicationContext(), this.getClass());

            startActivity(i);
        }
    }

    protected void signIn(View view){
        EditText edit1 = (EditText)findViewById(R.id.addUsername);
        String username = edit1.getText().toString();

        if (isEmpty(username)) {
            Toast t = Toast.makeText(this, "You must enter username to sign in!", Toast.LENGTH_SHORT);
            t.show();
        }

        EditText edit2 = (EditText)findViewById(R.id.addPassword);
        String password = edit2.getText().toString();

        if (isEmpty(password)) {
            Toast t = Toast.makeText(this, "You must enter password to sign in!", Toast.LENGTH_SHORT);
            t.show();
        }

        if(activeUser(username ,password) == true ){
            Intent i = new Intent(getApplicationContext(), lvl3_Activity.class);
            i.putExtra("UserName", username);

            startActivity(i);
        }else{
            Intent i = new Intent(getApplicationContext(), this.getClass());

            startActivity(i);

        }
    }


    boolean isEmpty(String text) {

        return TextUtils.isEmpty(text);
    }

    public boolean activeUser(String username , String password){

        List<User> users = dbHandler.readAllUsers();

        for(User list : users){

            if(list.getUsername().equals(username) && list.getPassword().equals(password)){
                return true;
            }
        }

        return false;
    }


    public boolean checkUser(String username ){

        List<User> users = dbHandler.readAllUsers();

        for(User list : users){

            if(list.getUsername().equals(username)){
                return true;
            }
        }

        return false;
    }
}
