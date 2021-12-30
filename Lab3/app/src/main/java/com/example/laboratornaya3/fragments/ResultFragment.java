package com.example.laboratornaya3.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentResultListener;

import android.view.MenuItem;
import android.view.View;

import com.example.laboratornaya3.R;
import com.example.laboratornaya3.ResultActivity;
import com.example.laboratornaya3.base.BaseBindingFragment;
import com.example.laboratornaya3.databinding.FragmentResultBinding;


public class ResultFragment extends BaseBindingFragment<FragmentResultBinding> {

    @Override
    protected int layoutId() {
        return R.layout.fragment_result;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundleResult = ((ResultActivity) getActivity()).getIntent().getExtras();
        binding.tvDishPrice.setText(bundleResult.getString("dish_price"));
        binding.tvDishProducer.setText(bundleResult.getString("dish_producer"));
        binding.tvDishName.setText(bundleResult.getString("dish_name"));

    }
}