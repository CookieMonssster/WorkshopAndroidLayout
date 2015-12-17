package com.tomtom.workshop.workshopapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String MAIL_TO = "mailto:";

    EditText etPerson;
    EditText etSubject;
    EditText etMessage;
    Button sendMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Intent intent = getIntent();
        String pattern = intent.getStringExtra(MainActivity.PATTERN);

        initializeComponents(pattern);
    }

    private void initializeComponents(String pattern) {
        etPerson = (EditText) findViewById(R.id.et_person);
        etSubject = (EditText) findViewById(R.id.et_subject);
        etMessage = (EditText) findViewById(R.id.et_message);
        sendMessageButton = (Button) findViewById(R.id.send_button);
        sendMessageButton.setOnClickListener(this);

        etMessage.setText(pattern);
    }

    @Override
    public void onClick(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse(MAIL_TO + etPerson.getText().toString()));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, etMessage.getText().toString());

        startActivity(Intent.createChooser(emailIntent, getString(R.string.send_mail_with)));
    }
}
