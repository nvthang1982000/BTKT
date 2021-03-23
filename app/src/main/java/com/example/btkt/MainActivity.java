package com.example.btkt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btndangnhap,btndangnhap1,btndangnhap2,btndangnhap3,btndangnhap4;
    int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inits();
        events();
    }

    private void events() {
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,thi.class);
                a=0;
                it.putExtra("key",a);
                startActivity(it);
            }
        });
        btndangnhap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,thi.class);
                a=1;
                it.putExtra("key",a);
                startActivity(it);
            }
        });
        btndangnhap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,thi.class);
                a=2;
                it.putExtra("key",a);
                startActivity(it);
            }
        });
        btndangnhap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,thi.class);
                a=3;
                it.putExtra("key",a);
                startActivity(it);
            }
        });
        btndangnhap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,thi.class);
                a=4;
                it.putExtra("key",a);
                startActivity(it);
            }
        });
    }

    private void inits() {
        btndangnhap=(Button) findViewById(R.id.btndn);
        btndangnhap1=(Button) findViewById(R.id.btndn1);
        btndangnhap2=(Button) findViewById(R.id.btndn2);
        btndangnhap3=(Button) findViewById(R.id.btndn3);
        btndangnhap4=(Button) findViewById(R.id.btndn4);
    }



}