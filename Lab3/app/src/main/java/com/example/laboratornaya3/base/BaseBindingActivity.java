package com.example.laboratornaya3.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;


public abstract class BaseBindingActivity<Binding extends ViewDataBinding> extends AppCompatActivity {

    protected Binding binding;

    @LayoutRes
    protected abstract int layoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, layoutId());
        setContentView(binding.getRoot());
    }

    @SuppressLint("ResourceType")
    protected static void showMessage(Context context, @IdRes int message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    protected static void showMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
