package com.example.bottomsecnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;

public class actionbar_n_tabbar01 extends AppCompatActivity {

    private ViewPager mViewPager;
    android.support.v7.app.ActionBar bar;
    private FragmentManager fm;
    private ArrayList<Fragment> fList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionbar_n_tabbar01);

        // 스와이프할 뷰페이저를 정의
        mViewPager = (ViewPager) findViewById(R.id.pager);

        // 프라그먼트 매니져 객체 정의
        fm = getSupportFragmentManager();

        // 액션바 객체 정의
        bar = getSupportActionBar();

        // 액션바 속성 정의
        bar.setDisplayShowTitleEnabled(true);   // 액션바 노출 유무
        bar.setTitle("Actionbar Tab Sample");   // 액션바 타이틀 라벨

        // 액션바에 모드 설정 = ActionBar.NAVIGATION_MODE_TABS 로 TAB 모드로 설정
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // 액션바에 추가될 탭 생성
        ActionBar.Tab tab1 = bar.newTab().setText("최신순").setTabListener(tabListener);
        ActionBar.Tab tab2 = bar.newTab().setText("인기순").setTabListener(tabListener);


        // 액션바에 탭 추가
        bar.addTab(tab1);
        bar.addTab(tab2);


        // 각 탭에 들어갈 프라그먼트 생성 및 추가
        fList = new ArrayList<Fragment>();
        fList.add(fragment1.newInstance());
        fList.add(fragment2.newInstance());

        // 스와이프로 탭간 이동할 뷰페이저의 리스너 설정
        mViewPager.setOnPageChangeListener(viewPagerListener);

        // 뷰페이져의 아답터 생성 및 연결
        CustomFragmentPagerAdapter adapter = new CustomFragmentPagerAdapter(fm, fList);
        mViewPager.setAdapter(adapter);

        bottomtle navigat=new bottomtle();
        BottomNavigationView bnavi=(BottomNavigationView)findViewById(R.id.navigation);
        bnavi.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(bnavi);

    }

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            onMenuItemClick(item);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    // mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    // mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_search:
                    // mTextMessage.setText("Login");
                    return true;
            }
            return false;
        }
    };

    //@Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.navigation_home) {
            Intent intent = new Intent(this, actionbar_n_tabbar01.class);
            startActivity(intent);
            //  finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.navigation_search) {
            Intent intent = new Intent(this, signin.class);
            startActivity(intent);
            //    finish();
            return true;
        }
        return false;
    }

    ViewPager.SimpleOnPageChangeListener viewPagerListener = new ViewPager.SimpleOnPageChangeListener(){
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);

            // 뷰페이저 이동시 해당 탭으로 이동
            bar.setSelectedNavigationItem(position);
        }
    };


    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            // 해당 탭에서 벚어났을때 처리
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            // 해당 탭을 선택시 처리
            // 해당 탭으로 뷰페이저도 이동
            mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            // 해당 탭이 다시 선택됐을때 처리
        }
    };
}
