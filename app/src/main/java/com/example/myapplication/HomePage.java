package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.viewpager.StatusFrag;
import com.example.myapplication.viewpager.TabsPagerAdapter;
import com.example.myapplication.viewpager.ViewPagerMain;

public class HomePage extends AppCompatActivity {
    TextView users,status;
    private TabsPagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        init();
    }

public void init(){

    users = (TextView)findViewById(R.id.users);
    status = (TextView)findViewById(R.id.status);

    //startActivity(new Intent(HomePage.this, ViewPagerMain.class));

    fragmentcalling(new ViewPagerMain());

    status.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            fragmentcalling(new StatusFrag());
        }
    });
    users.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            fragmentcalling(new VisitorsData());
        }
    });

}

    public void fragmentcalling(Fragment fragment) {
        //fragment = new FeedBack();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).addToBackStack("").commit();
    }

}
