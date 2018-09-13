package com.example.bottomsecnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener {
    MenuItem item1, item2, item3, item4;
    private TextView mTextMessage;


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.navigation_home) {
            Intent intent = new Intent(this, actionbar_n_tabbar01.class);
            startActivity(intent);
            return true;
        }
        if (menuItem.getItemId() == R.id.navigation_search) {
            Intent intent = new Intent(this, signin.class);
            startActivity(intent);
            return true;
        }
        return false;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            onMenuItemClick(item);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("메인");
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText("맞춤복지");
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText("카테고리");
                    return true;
                case R.id.navigation_search:
                    mTextMessage.setText("로그인");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);

    }

}