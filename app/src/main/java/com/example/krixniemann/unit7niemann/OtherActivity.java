package com.example.krixniemann.unit7niemann;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by krixniemann on 3/6/2017.
 */

public class OtherActivity extends AppCompatActivity {

    TextView textViewData;
    double width;
    double height;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout2);

        textViewData = (TextView) findViewById(R.id.txtDisplay);

        Bundle extras = getIntent().getExtras();
        width = extras.getDouble("Width");
        height = extras.getDouble("Height");
        textViewData.setText("Width is " + width + " the length is " + height + " and flooring needed is " +(width * height));

    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("Flooring", (width*height));
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
