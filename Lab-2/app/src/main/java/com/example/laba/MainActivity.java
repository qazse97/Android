package com.example.laba;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laba.base.BaseBindingActivity;
import com.example.laba.databinding.ActivityMainBinding;

public class MainActivity extends BaseBindingActivity<ActivityMainBinding> {

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }
}