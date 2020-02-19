package com.example.intentschallege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class DataReqd extends AppCompatActivity {

    EditText etName;
    EditText etNumber;
    EditText etWeb;
    EditText etAddress;
    ImageView ivHappy;
    ImageView ivNeutral;
    ImageView ivSad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_reqd);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etWeb = findViewById(R.id.etWeb);
        etAddress = findViewById(R.id.etAddress);
        ivHappy = findViewById(R.id.ivHappy);
        ivNeutral = findViewById(R.id.ivNeutral);
        ivSad = findViewById(R.id.ivSad);

        ivHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString().trim();
                String number = etNumber.getText().toString().trim();
                String web = etWeb.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                Intent intent = new Intent();

                intent.putExtra("name",name);
                intent.putExtra("number",number);
                intent.putExtra("web",web);
                intent.putExtra("address",address);

                intent.putExtra("mood","happy1");
                setResult(RESULT_OK,intent);
                DataReqd.this.finish(); //If you do not write it then it will not go back to mainAvtivity
            }
        });


        ivNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString().trim();
                String number = etNumber.getText().toString().trim();
                String web = etWeb.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                Intent intent = new Intent();

                intent.putExtra("name",name);
                intent.putExtra("number",number);
                intent.putExtra("web",web);
                intent.putExtra("address",address);

                intent.putExtra("mood","neutral1");
                setResult(RESULT_OK,intent);
                DataReqd.this.finish();
            }
        });


        ivSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString().trim();
                String number = etNumber.getText().toString().trim();
                String web = etWeb.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                Intent intent = new Intent();

                intent.putExtra("name",name);
                intent.putExtra("number",number);
                intent.putExtra("web",web);
                intent.putExtra("address",address);

                intent.putExtra("mood","sad1");

                setResult(RESULT_OK,intent);
                DataReqd.this.finish();
            }
        });

    }
}
