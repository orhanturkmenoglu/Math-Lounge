package com.example.mathlounge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.mathlounge.R.id.imgRate;

public class MainActivity extends AppCompatActivity {
    private ImageView imgRate,imgPlayStore;
    private LinearLayout lnrLearn,lnrPratice,lnrTest,lnrExit;
    private TextView tvAnimation;
    private Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        setTvAnimation();
    }
    private void findView() {
        imgRate=findViewById(R.id.imgRate);
        imgPlayStore=findViewById(R.id.imgPlayStore);
        lnrLearn=findViewById(R.id.lnrLearn);
        lnrPratice=findViewById(R.id.lnrPratice);
        lnrTest=findViewById(R.id.lnrTest);
        lnrExit=findViewById(R.id.lnrExit);
        tvAnimation=findViewById(R.id.tvAnimation);
    }

    private void setTvAnimation(){
        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_animation);
        tvAnimation.startAnimation(animation);
    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.lnrLearn:
                Utility.nextActivity(getApplicationContext(), LearnActivity.class);
                break;
            case R.id.lnrPratice:
                Utility.nextActivity(getApplicationContext(), OptionActivity.class);
                break;
            case R.id.lnrTest:
                Utility.nextActivity(getApplicationContext(), TestActivity.class);
                break;
            case R.id.imgPlayStore:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.setsoft.semihtr13.englishforkids"));
                startActivity(intent);
                break;
            case R.id.imgRate:
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.setsoft.semihtr13.englishforkids"));
                startActivity(intent2);
                break;
            case R.id.lnrExit:
                finish();
                break;
        }
    }


}