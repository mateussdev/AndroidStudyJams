package com.mateuss.firstaid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class AccidentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident_view);
        onLoadWebView();
    }


    public void onLoadWebView() {
        Intent intent = getIntent();
        String page = intent.getStringExtra("target");
        String title = intent.getStringExtra("title");
        WebView myWebView = (WebView) findViewById(R.id.webview);


        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle(title);
        }

        myWebView.loadUrl("file:///android_asset/" + page);
    }
}
