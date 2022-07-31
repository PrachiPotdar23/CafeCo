package com.example.cafeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText editText_name,editTextTextEmailAddress,editTextPhone;
    Button register;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    public static final String KEY_MOB="mob";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.editText_name);
        editTextTextEmailAddress=findViewById(R.id.editText_Email);
        editTextPhone = findViewById(R.id.editText_Phone);
        register = findViewById(R.id.register);

        sharedPreferences = getSharedPreferences("", MODE_PRIVATE);
        //when open activity first check shared preferences data available or not

        String name = sharedPreferences.getString(KEY_NAME, null);
        if (name != null) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "You have not entered name!", Toast.LENGTH_SHORT).show();
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when click a button put data on shared preferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, editText_name.getText().toString());
                editor.putString(KEY_EMAIL, editTextTextEmailAddress.getText().toString());
                editor.putString(KEY_EMAIL, editTextPhone.getText().toString());

                editor.apply();

                Toast.makeText(MainActivity.this, "Successfully registered!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MakeYourOrder.class);
                startActivity(intent);
            }
        });
    }
}
