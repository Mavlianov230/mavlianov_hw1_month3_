package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewBinding;

    private EditText editText;
    private Button buttonGmail;
    private Button buttonScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonGmail = findViewById(R.id.gmailButton);
        buttonScreen = findViewById(R.id.screenButton);

        buttonGmail.setOnClickListener(v -> sendEmail());

        buttonScreen.setOnClickListener(v -> goToScreen2());
    }

    private void sendEmail() {
        String emailBody = editText.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "тема");
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);

        startActivity(Intent.createChooser(emailIntent, "письмо"));
    }

    private void goToScreen2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
