package com.example.intentschallege;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvMain;
    Button btnCreateNew;
    ImageView ivMood;
    ImageView ivPhone;
    ImageView ivWeb;
    ImageView ivAddress;

    String name="",number="",web="",address="",mood="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tvMain);
        btnCreateNew = findViewById(R.id.btnCreateNew);
        ivMood = findViewById(R.id.ivMood);
        ivPhone = findViewById(R.id.ivPhone);
        ivWeb = findViewById(R.id.ivWeb);
        ivAddress = findViewById(R.id.ivAddress);


        ivMood.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivAddress.setVisibility(View.GONE);



        btnCreateNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this,com.example.intentschallege.DataReqd.class);
        startActivityForResult(intent,1);



            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number)); //number are taken from dataReqd activity
                startActivity(intent);

            }
        });


        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+web));
                startActivity(intent);

            }
        });


        ivAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?=" + address));
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                ivMood.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivAddress.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name"); // we are passing these on implicit intents
                number = data.getStringExtra("number");
                web = data.getStringExtra("web");
                address = data.getStringExtra("address");
                mood = data.getStringExtra("mood");

                if(mood.equals("happy1")){
                    ivMood.setImageResource(R.drawable.happy1);
                }
                else if(mood.equals("sad1")){
                    ivMood.setImageResource(R.drawable.sad1);
                }
                else{
                    ivMood.setImageResource(R.drawable.neutral1);
                }

            }
        }

    }
}

