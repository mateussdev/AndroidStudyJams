package com.mateuss.firstaid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


    public void goIntent(View v) {

        Intent intent = new Intent(this, AccidentActivity.class);


        switch (v.getId()) {
            case (R.id.btn_pcr):
                intent.putExtra("target", "pcr.html");
                intent.putExtra("title", "Parada Cárdio Respiratória");
                startActivity(intent);
                break;
            case (R.id.btn_rcp):
                intent.putExtra("target", "rcp.html");
                intent.putExtra("title", "Reanimação Cárdio Pulmonar");
                startActivity(intent);
                break;

        }

    }


}