package edu.orangecoastcollege.cs273.dnovasky.alohamusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private Animation mSplashAnimator;
    private TextView mSplashScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        mSplashScreen = (TextView) findViewById(R.id.splashScreenTextView);

//        TimerTask mediaTask = new TimerTask() {
//            @Override
//            public void run() {
//                finish();
//                startActivity(new Intent(SplashActivity.this, MediaActivity.class));
//            }
//        };
//
//        Timer timer = new Timer();
//        timer.schedule(mediaTask, 3000);
        mSplashAnimator = AnimationUtils.loadAnimation(this, R.anim.splashscreen_animator);
        mSplashScreen.startAnimation(mSplashAnimator);

        mSplashAnimator.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mSplashScreen.setVisibility(View.INVISIBLE);
                finish();
                startActivity(new Intent(SplashActivity.this, MediaActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
