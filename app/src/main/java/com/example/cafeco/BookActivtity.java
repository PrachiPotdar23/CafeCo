package com.example.cafeco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BookActivtity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_activtity);
        button=(Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book();
            }
        });
    }
    public void Book(){

        EditText editText=findViewById(R.id.editTextTextPersonName2);
        EditText editText1=findViewById(R.id.editTextTextPersonName3);
        if(editText.getText().toString().equals("")){
            Toast.makeText(this, "You have not selected occasion!", Toast.LENGTH_SHORT).show();
        }
        if (editText1.getText().toString().equals("")){
            Toast.makeText(this, "you have not selected Table no.!", Toast.LENGTH_SHORT).show();
        }
        if (editText.getText().toString().equals("") && editText1.getText().toString().equals("")){
            Toast.makeText(this, "you have not selected occasion and table no.!!", Toast.LENGTH_SHORT).show();
        }
        else{
            String message1="Table no->"+editText1.getText().toString()+" for "+editText.getText().toString()+" has been booked!";
            Toast.makeText(this, message1, Toast.LENGTH_SHORT).show();
        }
    }
}