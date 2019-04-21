package com.example.lenovo.geeknews.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.geeknews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

                ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(img, "alpha", 0, 0.2f, 0.5f, 1);
                ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(img, "rotation", 0, 360, 540, 720);
                 ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(img, "translationX", 0, 2.5f * 0.35f);
                 ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat(img, "translationY", 0, 2.5f * 0.425f);
                 ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(img, "scaleX", 0, 1, 2, 3); ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(img, "scaleY", 0, 1, 2, 3);
                 AnimatorSet animatorSet = new AnimatorSet(); animatorSet.setDuration(3000); animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
                 animatorSet.playTogether(alphaAnimator, rotationAnimator, translationXAnimator, translationYAnimator, scaleXAnimator, scaleYAnimator);
                 animatorSet.start();

        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {
                tv.setText(l/1000+"");
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(MainActivity.this,ZhuActivity.class));
            }
        }.start();

    }
}