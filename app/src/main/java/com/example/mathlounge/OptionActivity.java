package com.example.mathlounge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OptionActivity extends AppCompatActivity {
    private ImageView imgRate,imgExit;
    private TextView tvQuestion,tvSayac,tvDogru,tvYanlıs;
    private Button btn1,btn2,btn3,btn4;
    private List<Integer>opList=new ArrayList<>();
    private List<Button> buttonList= new ArrayList<>();
    Random random;
    String question="";
    int answer;
    int correct;
    int wrong;
    int op;
    int index;
    private MediaPlayer mediaPlayer;
    private MediaPlayer falseMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_acvivity);
        bindViews();
        setQuestion();
        setMediaPlayer();
    }
    private void bindViews() {
        imgRate=findViewById(R.id.imgRate);
        imgExit=findViewById(R.id.imgExit);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        tvQuestion=findViewById(R.id.tvQuestion);
        tvSayac=findViewById(R.id.tvSayac);
        random=new Random();
        buttonList.add(btn1);
        buttonList.add(btn2);
        buttonList.add(btn3);
        buttonList.add(btn4);
    }
    
    private void setMediaPlayer() {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dogru);
        falseMedia = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
    }
    

    public void onButtonClick(View view){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn1.getText().toString().equals(String.valueOf(answer))){
                    setAnswerTrue();
                }
                else{
                    setAnswerFalse();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn2.getText().toString().equals(String.valueOf(answer))){
                    setAnswerTrue();
                }
                else{
                    setAnswerFalse();
                }
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn3.getText().toString().equals(String.valueOf(answer))){
                    setAnswerTrue();
                }
                else{
                    setAnswerFalse();
                }
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn4.getText().toString().equals(String.valueOf(answer))){
                    setAnswerTrue();
                }
                else{
                    setAnswerFalse();
                }
            }
        });
    }

    private void setAnswerTrue(){
        mediaPlayer.start();
        index++;
        correct++;
        tvQuestion.setBackgroundResource(R.drawable.bg_trueanswer_yesil);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setQuestion();
            }
        },1500);
    }

    private void setAnswerFalse(){
        falseMedia.start();
        index++;
        wrong++;
        tvQuestion.setBackgroundResource(R.drawable.bg_false_answer_yesil);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setQuestion();
            }
        },1500);
    }

    private void setQuestion() {
        tvQuestion.setBackgroundResource(R.drawable.bg_text_background);
        int number1=random.nextInt(10)+1;
        int number2=random.nextInt(10)+1;
        question=number1+""+"x"+""+number2+""+"="+"?";
        answer=number1*number2;
        tvQuestion.setText(question);
        setOpList();
        setTvSayac();

    }
    private void setTvSayac(){
        tvSayac.setText(index+"/15");
        if (index>15){
         showBottomSheetDialog();
        }
    }
    private void showBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.bottomSheetDialog);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                R.layout.layout_bottom_sheet, (LinearLayout) findViewById(R.id.lnrButtomSheet));
        tvDogru = bottomSheetView.findViewById(R.id.tvDogru);
        tvYanlıs = bottomSheetView.findViewById(R.id.tvYanlıs);
        tvDogru.setText("" + correct);
        tvYanlıs.setText("" + wrong);
        bottomSheetView.findViewById(R.id.lnrHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bottomSheetView.findViewById(R.id.lnrRefresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionActivity.this, TestActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setCanceledOnTouchOutside(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setOpList() {
        opList.clear();
        opList.add(0);
        opList.add(1);
        opList.add(2);
        opList.add(3);
        op=random.nextInt(4);
        opList.remove(op);
        buttonList.get(op).setText(""+answer);
        buttonList.get(opList.get(0)).setText(""+(answer-1));
        buttonList.get(opList.get(1)).setText(""+(answer+1));
        buttonList.get(opList.get(2)).setText(""+(answer+2));
    }


   
}