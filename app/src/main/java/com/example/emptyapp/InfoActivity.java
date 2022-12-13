package com.example.emptyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class InfoActivity extends AppCompatActivity {

    WebView webView;
    String tmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        webView = findViewById(R.id.webView);

        Intent intent = getIntent();
        String nameEx = intent.getStringExtra("nameEx");
        String latitudeEx = intent.getStringExtra("latitudeEx");
        String longitudeEx = intent.getStringExtra("longitudeEx");
        String addressEx = intent.getStringExtra("addressEx");

        tmp = "Широта: " + latitudeEx + "<br><br>" + "Долгота: " + longitudeEx + "<br><br>" + "Название: " + nameEx + "<br><br>" +
"Адрес: " + addressEx;

        webView.loadData(tmp,"text/html; charset=utf-8", null);

    }
}