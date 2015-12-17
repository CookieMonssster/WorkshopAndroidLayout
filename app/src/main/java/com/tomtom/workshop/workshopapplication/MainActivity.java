package com.tomtom.workshop.workshopapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PATTERN = "pattern";
    private static final int START_POSITION = 3;

    private Button intentsButton;
    private Button fragmentsButton;
    private Button recyclerViewButton;

    private int position = START_POSITION;
    private CharSequence[] patterns =
            {"I will be late", "I'm on my way", "I had to stay at work", "no pattern"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    private void initializeComponents() {
        intentsButton = (Button) findViewById(R.id.intents_button);
        fragmentsButton = (Button) findViewById(R.id.fragments_buttons);
        recyclerViewButton = (Button) findViewById(R.id.recycler_view_buttons);

        intentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Intents", Toast.LENGTH_SHORT).show();
                showAlertDialog();
            }
        });

        fragmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        recyclerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(getString(R.string.usage_message_pattern))
                .setSingleChoiceItems(patterns, START_POSITION, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        position = which;
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), IntentActivity.class);
                        if(!(position == START_POSITION)) {
                            intent.putExtra(PATTERN, patterns[position]);
                        }
                        startActivity(intent);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
