package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    TextView tv;
    EditText username;
    EditText password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("login", MODE_PRIVATE);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equalsIgnoreCase("user")
                    && password.getText().toString().equalsIgnoreCase("user")) {

                    editor = pref.edit();
                    editor.putString("username", username.getText().toString());
                    editor.putString("status", "login");
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(),MainMenu.class));
                    finish();


                }
            }
        });

    }
}