package com.example.formvalidationapp;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity
{
    private EditText nameInputForm;
    private EditText mailInputForm;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameInputForm = findViewById(R.id.nameForm);
        mailInputForm = findViewById(R.id.mailForm);
        submitButton = findViewById(R.id.submit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInputForm.getText().toString().trim();
                String mail = mailInputForm.getText().toString().trim();

                if(name.isEmpty()) { Toast.makeText(MainActivity.this,  "Wprowadź imię", Toast.LENGTH_SHORT).show();  return; }
                if(mail.isEmpty()) { Toast.makeText(MainActivity.this,  "Wprowadź e-mail", Toast.LENGTH_SHORT).show(); return; }
                if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) { Toast.makeText(MainActivity.this,  "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show(); return; }

                Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show();
            }
        });


    }
}