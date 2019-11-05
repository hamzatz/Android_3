package com.example.android3.ui.onboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.example.android3.R;
import com.example.android3.data.entity.OnBoardEntity;
import com.example.android3.ui.main.MainActivity;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class OnBoardActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private OnBoardAdapter boardAdapter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard);



        initViews();
        setupViewPager();
        onNextClick();

    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, OnBoardActivity.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void initViews() {

        circleIndicator = findViewById(R.id.circle);
        button = findViewById(R.id.btn_next);
        viewPager = findViewById(R.id.view_pager);
        toolbar = findViewById(R.id.tooolbarTransparent);
        setSupportActionBar(toolbar);

    }

    public void onNextClick() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (viewPager.getCurrentItem() == 3) {
                    button.setText("Finish");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            MainActivity.start(OnBoardActivity.this);
                        }
                    });
                } else {
                    button.setText("Next");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.skip:
                MainActivity.start(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



         private  void setupViewPager() {


        boardAdapter= new OnBoardAdapter(getResourse());


        viewPager.setAdapter(boardAdapter);

        circleIndicator.setViewPager(viewPager);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });

    }
    private ArrayList<OnBoardEntity> getResourse(){
        ArrayList<OnBoardEntity> list = new ArrayList<>();
        list.add(new OnBoardEntity("Here you are my learn!",R.drawable.step));
        list.add(new OnBoardEntity("Here you are my update!",R.drawable.update));
        list.add(new OnBoardEntity("Here you are my delete!",R.drawable.delete));
        list.add(new OnBoardEntity("Thanks that you are with us!",R.drawable.thanks));
        return list;
    }
}