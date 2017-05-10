package com.lokeshkvn.org.statlog;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by DELL PC on 10-05-2017.
 */

public class Splashscreen extends Activity {
    /**
     * Called when the activity is first created.
     */

    Thread splashTread;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        StartAnimations();
    }

    private void StartAnimations() {
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim1.reset();
        anim2.reset();
        RelativeLayout l = (RelativeLayout) findViewById(R.id.relative_lay);
        l.clearAnimation();
        l.startAnimation(anim1);

        anim1 = AnimationUtils.loadAnimation(this, R.anim.translate_down);
        anim1.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        iv.clearAnimation();
        iv.startAnimation(anim1);

        anim2 = AnimationUtils.loadAnimation(this, R.anim.translate_up);
        anim2.reset();
        ImageView imv = (ImageView) findViewById(R.id.splash2);
        imv.clearAnimation();
        imv.startAnimation(anim2);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Splashscreen.this,
                            MainActivity.class);
                    ActivityOptions options =
                            ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                    startActivity(intent, options.toBundle());
                    Splashscreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Splashscreen.this.finish();
                }

            }
        };
        splashTread.start();

    }

}
