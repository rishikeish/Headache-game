package com.example.student.headache2;

import android.content.Intent;
import
        android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.util.List;


import Database.DBHandler;
import Classes.User;


public class Main2Activity extends AppCompatActivity {

    private Button sign;
    private Button register;

    DBHandler dbHandler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dbHandler = new DBHandler(this);

        sign = findViewById(R.id.signin);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit1 = findViewById(R.id.addUsername);
                String username = edit1.getText().toString();

                EditText edit2 = findViewById(R.id.addPassword);
                String password = edit2.getText().toString();

                if (isEmpty(username)) {
                    Toast t = Toast.makeText(getApplicationContext(), "You must enter username to sign in!", Toast.LENGTH_SHORT);
                    t.show();
                }else if (isEmpty(password)) {
                    Toast t = Toast.makeText(getApplicationContext(), "You must enter password to sign in!", Toast.LENGTH_SHORT);
                    t.show();
                }else if(activeUser(username ,password) == true ){
                    Intent i = new Intent(getApplicationContext(),level01.class);
                    i.putExtra("UserName", username);
                    Toast t = Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_SHORT);
                    t.show();

                    startActivity(i);
                }else{
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);

                    Toast t = Toast.makeText(getApplicationContext(), "enter valid username and password!", Toast.LENGTH_SHORT);
                    t.show();

                    startActivity(i);

                }

            }
        });

        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edit1 = findViewById(R.id.addUsername);
                String username = edit1.getText().toString();

                EditText edit2 = findViewById(R.id.addPassword);
                String password = edit2.getText().toString();

                if (isEmpty(username)) {
                    Toast t = Toast.makeText(getApplicationContext(), "You must enter username to register!", Toast.LENGTH_SHORT);
                    t.show();
                }else if(isEmpty(password)) {
                    Toast t = Toast.makeText(getApplicationContext(), "You must enter password to register!", Toast.LENGTH_SHORT);
                    t.show();
                }else if(!checkUser(username)) {
                    dbHandler.addUser(username, password);
                    Intent i = new Intent(getApplicationContext(), Level2_Activity.class);
                    i.putExtra("UserName", username);

                    Toast t = Toast.makeText(getApplicationContext(), "Registered successfully!", Toast.LENGTH_SHORT);
                    t.show();

                    startActivity(i);

                }else{
                    Intent i = new Intent(getApplicationContext(),Main2Activity.class );

                    Toast t = Toast.makeText(getApplicationContext(), "Registration unsuccessful!", Toast.LENGTH_SHORT);
                    t.show();

                    startActivity(i);
                }
            }
        });
    }





    boolean isEmpty(String text) {

        return TextUtils.isEmpty(text);
    }



    public boolean activeUser(String username , String password){

        List<User> users = dbHandler.readAllUsers();

        for(User list : users){

            if((list.getUsername().equals(username) )&& (list.getPassword().equals(password))){
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
