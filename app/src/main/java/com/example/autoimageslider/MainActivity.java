package com.example.autoimageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        CustomSwipeAdapter adapter = new CustomSwipeAdapter(this);

        viewPager.setAdapter(adapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 5000);

    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    }else if (viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }

}
