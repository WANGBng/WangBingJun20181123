package com.bwie.application;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.my.activity.R;

import butterknife.OnClick;

/**
 * Created by wangbingjun on 2018/11/23.
 */

public class JiaJian extends LinearLayout implements View.OnClickListener {
    private ImageView jia;
    private ImageView jian;
    private TextView num;
    private int nu=0;

    public JiaJian(Context context) {
        super(context);
    }

    public JiaJian(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.jiajian, this);
        jia = findViewById(R.id.jia);
        jian = findViewById(R.id.jian);
        num = findViewById(R.id.num);
        jia.setOnClickListener(this);
        jian.setOnClickListener(this);
    }

    public JiaJian(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //定义的接口回调
    private AddAndMinus addAndMinusu;

    @OnClick({R.id.jian, R.id.jia})
    public void onClick(View v) {
        String s = num.getText().toString();
        int i = Integer.parseInt(s);
        switch (v.getId()){
            case R.id.jia:
                if (addAndMinusu!=null){
                    addAndMinusu.add();
                   // nu++;
                }
                //num.setText(nu);
                jian.setVisibility(VISIBLE);
                break;
            case R.id.jian:
                if (i>1){
                    if (addAndMinusu!=null){
                        addAndMinusu.minus();
                        nu--;
                    }

                } else if (i<=1) {
                    Toast.makeText(v.getContext(), "商品必须大于1", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public interface AddAndMinus {
        void add();
        void minus();
    }

    public void setAddAndMinusu(AddAndMinus addAndMinusu) {
        this.addAndMinusu = addAndMinusu;
    }
}