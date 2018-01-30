package com.example.williamanderssonber.androidvning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView firstText = (TextView) findViewById(R.id.firstText);
    }
    public void buttonClicked(View view) {
        TextView firstText = (TextView) findViewById(R.id.firstText);
        firstText.setText(R.string.newText);
    }
    public void nextWindow(View view) {
        Intent intent = new Intent(this, newScreen.class);
        startActivity(intent);
    }
}
