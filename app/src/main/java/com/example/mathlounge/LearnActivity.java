package com.example.mathlounge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LearnActivity extends AppCompatActivity {
    private ImageView imgExit;
    private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;
    private List<TextView> textViewList=new ArrayList<>();
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
    int tablo =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        findView();
    }

    public void onButtonExit(View view){
        onBackPressed();
    }
    public void onButtonClick(View view){
        switch (view.getId()){
            case R.id.btn1:
                tablo=1;
                break;
            case R.id.btn2:
                tablo=2;
                break;
            case R.id.btn3:
                tablo=3;
                break;
            case R.id.btn4:
                tablo=4;
                break;
            case R.id.btn5:
                tablo=5;
                break;
            case R.id.btn6:
                tablo=6;
                break;
            case R.id.btn7:
                tablo=7;
                break;
            case R.id.btn8:
                tablo=8;
                break;
            case R.id.btn9:
                tablo=9;
                break;
            case R.id.btn10:
                tablo=10;
                break;
            default:
                tablo=1;
                break;
        }
        setTablo();
    }

    private void setTablo() {
        for (int i=0; i<10; i++){
            textViewList.get(i).setText(tablo+""+"x"+""+(i+1)+""+"="+(tablo*(i+1)));
        }
    }

    private void findView() {
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        tv6=findViewById(R.id.tv6);
        tv7=findViewById(R.id.tv7);
        tv8=findViewById(R.id.tv8);
        tv9=findViewById(R.id.tv9);
        tv10=findViewById(R.id.tv10);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn10=findViewById(R.id.btn10);
        imgExit=findViewById(R.id.imgExit);
        textViewList.add(tv1);
        textViewList.add(tv2);
        textViewList.add(tv3);
        textViewList.add(tv4);
        textViewList.add(tv5);
        textViewList.add(tv6);
        textViewList.add(tv7);
        textViewList.add(tv8);
        textViewList.add(tv9);
        textViewList.add(tv10);
    }
}