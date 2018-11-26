package com.bwie.my.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bwie.my.fragment.DingDan_Fragment;
import com.bwie.my.fragment.Home_Fragment;
import com.bwie.my.fragment.My_Fragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottomTabBar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(10)
                .setTabPadding(4,6,10)
                .setChangeColor(R.drawable.index_active,Color.DKGRAY)
                .addTabItem("首页",R.drawable.index,Home_Fragment.class)
                .addTabItem("订单",R.drawable.order,DingDan_Fragment.class)
                .addTabItem("我的",R.drawable.home,My_Fragment.class)
                .setTabBarBackgroundColor(Color.WHITE)
                .isShowDivider(false);

    }
}
