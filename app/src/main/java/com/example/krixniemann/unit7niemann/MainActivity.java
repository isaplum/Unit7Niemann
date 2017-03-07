package com.example.krixniemann.unit7niemann;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText rmwenter;
    EditText rmhenter;
    TextView resulty;
    private static final int CIS3334_REQUEST_CODE = 1001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       resulty = (TextView) findViewById(R.id.txtResult);
        rmwenter = (EditText) findViewById(R.id.rmwedit);
        rmhenter = (EditText) findViewById(R.id.rmhedit);
    }

    public void onBtnClick(View view){
        double width = Double.parseDouble(String.valueOf(rmwenter.getText()));
        double height = Double.parseDouble(String.valueOf(rmhenter.getText()));
        Intent intent = new Intent(MainActivity.this, OtherActivity.class);
        intent.putExtra("Width", width);
        intent.putExtra("Height", height);
        startActivityForResult(intent, CIS3334_REQUEST_CODE);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == CIS3334_REQUEST_CODE) {
            if (data.hasExtra("Flooring")) {
                String result = data.getExtras().getString("Flooring");
                if (result != null && result.length() > 0) {
                    resulty.setText(result);
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
