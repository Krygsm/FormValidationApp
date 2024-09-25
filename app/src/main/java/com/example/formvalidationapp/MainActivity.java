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
    private EditText numberInputForm;
    private EditText passwordInputForm;
    private EditText confirmationInputForm;

    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameInputForm = findViewById(R.id.nameForm);
        mailInputForm = findViewById(R.id.mailForm);
        numberInputForm = findViewById(R.id.numberForm);
        passwordInputForm = findViewById(R.id.passwordForm);
        confirmationInputForm = findViewById(R.id.confirmationForm);

        submitButton = findViewById(R.id.submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInputForm.getText().toString().trim();
                String mail = mailInputForm.getText().toString().trim();
                String number = numberInputForm.getText().toString().trim();
                String password = passwordInputForm.getText().toString().trim();
                String confirmation = confirmationInputForm.getText().toString().trim();

                if(!password.isEmpty() && !confirmation.isEmpty() && !password.equals(confirmation)) { Toast.makeText(MainActivity.this,  "Hasła się nie zgadzają", Toast.LENGTH_SHORT).show(); return; }
                if(!mail.isEmpty() && (!Patterns.EMAIL_ADDRESS.matcher(mail).matches())) { Toast.makeText(MainActivity.this,  "Niepoprawny adres e-mail", Toast.LENGTH_SHORT).show(); return; }

                if(name.isEmpty()) { Toast.makeText(MainActivity.this,  "Wprowadź imię", Toast.LENGTH_SHORT).show();  return; }
                if(mail.isEmpty()) { Toast.makeText(MainActivity.this,  "Wprowadź e-mail", Toast.LENGTH_SHORT).show(); return; }
                if(number.isEmpty()) { Toast.makeText(MainActivity.this,  "Wprowadź numer", Toast.LENGTH_SHORT).show(); return; }
                if(password.isEmpty()) { Toast.makeText(MainActivity.this,  "Wprowadź hasło", Toast.LENGTH_SHORT).show(); return; }
                if(confirmation.isEmpty()) { Toast.makeText(MainActivity.this,  "Potwierdź hasło", Toast.LENGTH_SHORT).show(); return; }

                if(number.length() < 9) { Toast.makeText(MainActivity.this,  "Nuemr telefonu powinien mieć min. 9 znaków", Toast.LENGTH_SHORT).show(); return; }
                if(password.length() < 6) { Toast.makeText(MainActivity.this,  "Hasło powinno mieć min. 6 znaków", Toast.LENGTH_SHORT).show(); return; }

                Toast.makeText(MainActivity.this, "Rejestracja udana", Toast.LENGTH_SHORT).show();
            }
        });


    }
}