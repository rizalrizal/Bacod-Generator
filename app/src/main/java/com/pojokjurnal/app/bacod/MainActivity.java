package com.pojokjurnal.app.bacod;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button hilih,byksw,alay,autis,copy;
    EditText edtSumber,edtHasil;
    String sumber,hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide(); //hide the title bar
        hilih = (Button) findViewById(R.id.hilih);
        byksw = (Button) findViewById(R.id.byksw);
        alay = (Button) findViewById(R.id.alay);
        autis = (Button) findViewById(R.id.autis);
        edtSumber = (EditText) findViewById(R.id.edtSumber);
        edtHasil = (EditText) findViewById(R.id.edtHasil);
        copy = (Button) findViewById(R.id.copyhasil);
        edtHasil.setEnabled(false);
        hilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumber = edtSumber.getText().toString();
                hasil = sumber.replaceAll("[a,i,u,e,o]", "i");
                edtHasil.setText(hasil);
            }
        });

        byksw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumber = edtSumber.getText().toString();
                hasil = sumber.replaceAll("[a,u,e,o]", "w");
                hasil = hasil.replaceAll("[i]", "y");
                edtHasil.setText(hasil);
            }
        });

        alay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumber = edtSumber.getText().toString();
                hasil = sumber.replaceAll("[a]", "4");
                hasil = hasil.replaceAll("[b]", "13");
                hasil = hasil.replaceAll("[e]", "3");
                hasil = hasil.replaceAll("[g]", "6");
                hasil = hasil.replaceAll("[i]", "1");
                hasil = hasil.replaceAll("[o]", "0");
                hasil = hasil.replaceAll("[s]", "5");
                edtHasil.setText(hasil);
            }
        });

        autis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = edtSumber.getText().length();
                sumber = edtSumber.getText().toString();
                sumber = sumber.toLowerCase();
                hasil ="";
                for (int i = 0; i < length; i++) {
                    if(i % 2 == 0){
                        char c = Character.toUpperCase(sumber.charAt(i));
                        hasil = hasil + Character.toString(c);
                    }else{
                        char c = sumber.charAt(i);
                        hasil = hasil.concat(Character.toString(c));
                    }

                }

                edtHasil.setText(hasil);
            }
        });

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil = edtHasil.getText().toString();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("copy", hasil);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(MainActivity.this, "Copy Berhasil", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
