package com.example.btkt;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class thi extends AppCompatActivity {
    private int mType;
    int diem, sai;
    TextView socauhoi;
    int cau = 1;
    String mausac = "";
    Button trangchu, ketqua;
    TextView txcauhoi,scd;
    Button btntl1;
    Button btntl2;
    Button btntl3;
    Button btntl4;
    ImageButton bNext;
    ArrayList<cauhoi> arr = new ArrayList<>();
    public static String DATABASE_NAME = "CauHoi.db";
    SQLiteDatabase database1;
    MediaPlayer mediaPlayer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cauhoi);
        overridePendingTransition(R.anim.slide_right, R.anim.slide_left);


        Int();
        readdata();
        diem = 0;
        sai = 0;
//        Collections.reverse(arr);
        // Collections.shuffle(arr);
        cauhoi cauhoi = arr.get(0);
        String ch = cauhoi.getCauhoii();
        String lc1 = cauhoi.getDapan1();
        String lc2 = cauhoi.getDapan2();
        String lc3 = cauhoi.getDapan3();
        String lc4 = cauhoi.getDapan4();
        Put(ch, lc1, lc2, lc3, lc4);
        final int[] d = {1};
        final int s = arr.size() - 1;
        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(thi.this,MainActivity.class);
                startActivity(it);
            }
        });
        ketqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sai = 10 - diem;
                mediaPlayer = MediaPlayer.create(thi.this, R.raw.tieng_vo_tay);
                mediaPlayer.start();
                Intent it=new Intent(thi.this,ketqua.class);
                it.putExtra("keydiem",diem);
                it.putExtra("keysai",sai);
                startActivity(it);
            }
        });
            bNext.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    final Animation myAnim = AnimationUtils.loadAnimation(thi.this, R.anim.slide_right);
                    if(btntl1.isEnabled() ==  true){
                        sai++;
                    }
                    scd.setText(diem*10+"");
                    bNext.startAnimation(myAnim);
                    btntl1.setEnabled(true);
                    btntl2.setEnabled(true);
                    btntl3.setEnabled(true);
                    btntl4.setEnabled(true);
                    if (d[0] <= s) {
                        if (cau <= arr.size()) {
                            cauhoi cauhoi = arr.get(d[0]);
                            String ch = cauhoi.getCauhoii();
                            String lc1 = cauhoi.getDapan1();
                            String lc2 = cauhoi.getDapan2();
                            String lc3 = cauhoi.getDapan3();
                            String lc4 = cauhoi.getDapan4();
                            Put(ch, lc1, lc2, lc3, lc4);
                        }
                        d[0]++;
                        overridePendingTransition(R.anim.item_animation_from_cauhoi, R.anim.layoutanimation_from_cauhoi);
                        cau = cau + 1;
                        socauhoi.setText("Câu hỏi " + cau + ":");
                    } else {
                        mediaPlayer = MediaPlayer.create(thi.this, R.raw.tieng_vo_tay);
                        mediaPlayer.start();
                        Intent it=new Intent(thi.this,ketqua.class);
                        it.putExtra("keydiem",diem);
                        it.putExtra("keysai",sai);
                        startActivity(it);
                    }
                    btntl1.setBackground(getDrawable(R.drawable.botronbuttondn));
                    btntl2.setBackground(getDrawable(R.drawable.botronbuttondn));
                    btntl3.setBackground(getDrawable(R.drawable.botronbuttondn));
                    btntl4.setBackground(getDrawable(R.drawable.botronbuttondn));
                }
            });


    }

    //    public void chuyenmau(String cautl){
//        cauhoi cauhoi=arr.get(0);
//        for(int i=1;i<arr.size();i++){
//            if(cautl.equals(cauhoi.dapan)) {
//               Toast.makeText(thi.this,"Bạn trả lời đúng",Toast.LENGTH_SHORT).show();
//            }
//            else
//                Toast.makeText(thi.this,"Bạn đã trả lời sai",Toast.LENGTH_SHORT).show();
//        }
//    }
    private void readdata() {
        database1 = DataBase.initDatabase(thi.this, DATABASE_NAME);
        Intent it = getIntent();
        int a = it.getIntExtra("key",0);
        String tenbang;
        switch (a){
            case 0: tenbang = "CongNam"; break;
            case 1: tenbang = "CongMuoi"; break;
            case 2: tenbang = "TruNam"; break;
            case 3: tenbang = "TruMuoi"; break;
            case 4: tenbang = "SoSanh"; break;
            default: tenbang = "CongNam"; break;
        }
        Cursor cursor = database1.rawQuery("select * from "+tenbang, null);
        arr.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String cauhoi = cursor.getString(1);
            String dapan1 = cursor.getString(2);
            String dapan2 = cursor.getString(3);
            String dapan3 = cursor.getString(4);
            String dapan4 = cursor.getString(5);
            String dapan = cursor.getString(6);

            arr.add(new cauhoi(cauhoi, dapan1, dapan2, dapan3, dapan4, dapan));
            Collections.shuffle(arr);
        }
//
    }

    private void Int() {
//
        ketqua = findViewById(R.id.KetQua);
        trangchu = findViewById(R.id.TrangChu);
        txcauhoi = (TextView) findViewById(R.id.cauhoi);
        btntl1 = (Button) findViewById(R.id.dapan1);
        btntl2 = (Button) findViewById(R.id.dapan2);
        btntl3 = (Button) findViewById(R.id.dapan3);
        btntl4 = (Button) findViewById(R.id.dapan4);
        bNext = (ImageButton) findViewById(R.id.bNext);
        socauhoi = (TextView) findViewById(R.id.socau);
        trangchu = findViewById(R.id.TrangChu);
        scd = findViewById(R.id.scd);
    }

    private void Put(String ch, String lc1, String lc2, String lc3, String lc4) {
        txcauhoi.setText(ch + "");
        btntl1.setText(lc1 + "");
        btntl2.setText(lc2 + "");
        btntl3.setText(lc3 + "");
        btntl4.setText(lc4 + "");
    }

//    public void btndapan(View view) {
//        cauhoi cauhoi=arr.get(0);
//        String cautl=cauhoi.dapan;
//        chuyenmau(cautl);
//    }

    public void btndapan1(View view) {
        cauhoi cauhoi = arr.get(cau - 1);
        String cautl = btntl1.getText().toString();
        if (cautl.equals(cauhoi.dapan)) {
//                Toast.makeText(thi.this,"Bạn trả lời đúng",Toast.LENGTH_SHORT).show();
            btntl1.setBackground(getDrawable(R.drawable.mauxanh));
            mediaPlayer = MediaPlayer.create(thi.this, R.raw.nhac_tre_con);
            mediaPlayer.start();
            diem++;
        } else{
            //Toast.makeText(thi.this,"Bạn đã trả lời sai",Toast.LENGTH_SHORT).show();
            btntl1.setBackground(getDrawable(R.drawable.maudo));
            mediaPlayer = MediaPlayer.create(thi.this, R.raw.nhac_that_bai);
            mediaPlayer.start();
            sai++;
        }
        if (btntl2.getText().toString().equals(cauhoi.dapan)) {
            btntl2.setBackground(getDrawable(R.drawable.mauxanh));
        }
        if (btntl3.getText().toString().equals(cauhoi.dapan)) {
            btntl3.setBackground(getDrawable(R.drawable.mauxanh));
        }
        if (btntl4.getText().toString().equals(cauhoi.dapan)) {
            btntl4.setBackground(getDrawable(R.drawable.mauxanh));
        }
        btntl1.setEnabled(false);
        btntl2.setEnabled(false);
        btntl3.setEnabled(false);
        btntl4.setEnabled(false);
    }


    public void btndapan2(View view) {
        String cautl2 = btntl2.getText().toString();
        cauhoi cauhoi = arr.get(cau - 1);
        btntl1.setEnabled(false);
        btntl2.setEnabled(false);
        btntl3.setEnabled(false);
        btntl4.setEnabled(false);
        if (cautl2.equals(cauhoi.dapan)) {
            btntl2.setBackground(getDrawable(R.drawable.mauxanh));
            mediaPlayer = MediaPlayer.create(thi.this, R.raw.nhac_tre_con);
            mediaPlayer.start();
            diem++;
        } else{
            //Toast.makeText(thi.this,"Bạn đã trả lời sai",Toast.LENGTH_SHORT).show();
            btntl2.setBackground(getDrawable(R.drawable.maudo));
            mediaPlayer = MediaPlayer.create(thi.this, R.raw.nhac_that_bai);
            mediaPlayer.start();
            sai++;
        }
        if (btntl1.getText().toString().equals(cauhoi.dapan)) {
            btntl1.setBackground(getDrawable(R.drawable.mauxanh));
        }
        if (btntl3.getText().toString().equals(cauhoi.dapan)) {
            btntl3.setBackground(getDrawable(R.drawable.mauxanh));
        }
        if (btntl4.getText().toString().equals(cauhoi.dapan)) {
            btntl4.setBackground(getDrawable(R.drawable.mauxanh));
        }
        btntl1.setEnabled(false);
        btntl2.setEnabled(false);
        btntl3.setEnabled(false);
        btntl4.setEnabled(false);
    }


    public void btndapan3(View view) {
        cauhoi cauhoi = arr.get(cau - 1);
        String cautl3 = btntl3.getText().toString();

        if (cautl3.equals(cauhoi.dapan)) {
            btntl3.setBackground(getDrawable(R.drawable.mauxanh));
            mediaPlayer = MediaPlayer.create(thi.this, R.raw.nhac_tre_con);
            mediaPlayer.start();
            diem++;
        } else{
            btntl3.setBackground(getDrawable(R.drawable.maudo));
            mediaPlayer = MediaPlayer.create(thi.this, R.raw.nhac_that_bai);
            mediaPlayer.start();
            sai++;
        }
        if (btntl2.getText().toString().equals(cauhoi.dapan)) {
            btntl2.setBackground(getDrawable(R.drawable.mauxanh));
        }
        if (btntl1.getText().toString().equals(cauhoi.dapan)) {
            btntl1.setBackground(getDrawable(R.drawable.mauxanh));
        }
        if (btntl4.getText().toString().equals(cauhoi.dapan)) {
            btntl4.setBackground(getDrawable(R.drawable.mauxanh));
        }
        btntl1.setEnabled(false);
        btntl2.setEnabled(false);
        btntl3.setEnabled(false);
        btntl4.setEnabled(false);
    }

    public void btndapan4(View view) {
        cauhoi cauhoi = arr.get(cau - 1);
        String cautl4 = btntl4.getText().toString();

        if (cautl4.equals(cauhoi.dapan)) {
            btntl4.setBackground(getDrawable(R.drawable.mauxanh));
            mediaPlayer = MediaPlayer.create(thi.this, R.raw.nhac_tre_con);
            mediaPlayer.start();
            diem++;
        } else{
            btntl4.setBackground(getDrawable(R.drawable.maudo));
            mediaPlayer = MediaPlayer.create(thi.this, R.raw.nhac_that_bai);
            mediaPlayer.start();
            sai++;
        }
        if (btntl2.getText().toString().equals(cauhoi.dapan)) {
            btntl2.setBackground(getDrawable(R.drawable.mauxanh));
        }
        if (btntl3.getText().toString().equals(cauhoi.dapan)) {
            btntl3.setBackground(getDrawable(R.drawable.mauxanh));
        }
        if (btntl1.getText().toString().equals(cauhoi.dapan)) {
            btntl1.setBackground(getDrawable(R.drawable.mauxanh));
        }
        btntl1.setEnabled(false);
        btntl2.setEnabled(false);
        btntl3.setEnabled(false);
        btntl4.setEnabled(false);
    }


}
