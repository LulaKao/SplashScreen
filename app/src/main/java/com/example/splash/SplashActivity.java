package com.example.splash;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashActivity extends AppCompatActivity {
    ImageView pic;
    LinearLayout logo; // 開頭動畫的 logo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 設定淡入動畫
        Animation fadeIn = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade_in);

        pic = findViewById(R.id.pic);
        logo = findViewById(R.id.logo);
        logo.setAnimation(fadeIn);

        Thread timer = new Thread(){
          @Override
          public void run(){
              super.run();
              try{
                  sleep(3000); // 3秒
              } catch (InterruptedException e) {
                  e.printStackTrace();
              } finally {
                  startActivity(new Intent(SplashActivity.this, MainActivity.class));
                  finish();
                  // 使用系统自帶的淡入淡出效果
                  overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_in);
              }
          }
        };
        timer.start();
    }
}
