package com.example.btkt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ketqua extends AppCompatActivity {

    TextView diem,sai, ketqua,diemm;
    ImageView anh;
    Button trangchu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ketqua);
        inits();
        Intent it = getIntent();
        int diem1 = it.getIntExtra("keydiem",0);
        int sai1 = it.getIntExtra("keysai",0);
        diem.setText(diem1+"");
        sai.setText(sai1+"");
        diemm.setText(sai1*10+"");
        if(diem1 >= 9){
            Glide.with(this).load(R.drawable.minionyeah).into(anh);
            ketqua.setText("Bạn thật sự xuất sắc!");
        }else{
            if (diem1>5){
                Glide.with(this).load(R.drawable.minionf).into(anh);
                ketqua.setText("Bạn đã làm khá tốt!");
            }
            else{
                Glide.with(this).load(R.drawable.minionsad).into(anh);
                ketqua.setText("Bạn cần cố gắng hơn!");
            }
        }
        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(ketqua.this,MainActivity.class);
                startActivity(it);
            }
        });

        
    }

    private void inits() {
        diemm = findViewById(R.id.diem);
        diem = findViewById(R.id.dung);
        sai = findViewById(R.id.sai);
        ketqua = findViewById(R.id.ketqua);
        anh = findViewById(R.id.anh);
        trangchu = findViewById(R.id.TrangChu);
    }
}