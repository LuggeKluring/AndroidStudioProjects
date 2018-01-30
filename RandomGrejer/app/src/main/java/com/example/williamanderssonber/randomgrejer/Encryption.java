package com.example.williamanderssonber.randomgrejer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Encryption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);
    }
    public void encrypt(View view){
        EditText in = (EditText)findViewById(R.id.inText);
        String encrypt_in = in.getText().toString();
        String ny = "";
        char[]tecken = encrypt_in.toCharArray();
        for(int i=0;i < tecken.length;i++){
            int tal = (int)tecken[i];
            tal+=10;
            char n = (char)tal;
            ny+=n;
        }
        EditText ut = (EditText)findViewById(R.id.outText);
        ut.setText(ny);
        in.setText("");
    }
    public void decrypt(View view){
        EditText in = (EditText)findViewById(R.id.outText);
        String decrypt_in = in.getText().toString();
        String ny = "";
        char[]tecken = decrypt_in.toCharArray();
        for(int i=0;i < tecken.length;i++){
            int tal = (int)tecken[i];
            tal-=10;
            char n = (char)tal;
            ny+=n;
        }
        EditText ut = (EditText)findViewById(R.id.inText);
        ut.setText(ny);
        in.setText("");
    }
}
