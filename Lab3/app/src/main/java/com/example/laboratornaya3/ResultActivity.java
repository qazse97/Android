package com.example.laboratornaya3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.laboratornaya3.base.BaseBindingActivity;
import com.example.laboratornaya3.databinding.ActivityResultBinding;
import com.example.laboratornaya3.fragments.ResultFragment;

/**
 * Created by Android Studio on 12/28/2021 1:42 PM
 * Developer: Sergey Leskov
 */

public class ResultActivity extends BaseBindingActivity<ActivityResultBinding> {

    @Override
    protected int layoutId() {
        return R.layout.activity_result;
    }

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor ed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getPreferences(MODE_PRIVATE);

        getPreference();
        putReference();
    }

    private void getPreference(){

        Bundle bundle = new Bundle();

        if ((getIntent() != null && getIntent().getBooleanExtra("check_result", false))){
            String dishName = sharedPreferences.getString("dish_name", "");
            String dishPrice = sharedPreferences.getString("dish_price", "");
            String dishProducer = sharedPreferences.getString("dish_producer", "");
            // Устанавливаем в TextView значение полученное из SharedPreferences
            if (dishName.isEmpty() && dishPrice.isEmpty() && dishProducer.isEmpty()) {
                showMessage(this, "No data in preference");
                return;
            } else {
                bundle.putString("dish_name", dishName);
                bundle.putString("dish_price", dishPrice);
                bundle.putString("dish_producer", dishProducer);
                binding.tvDishName.setText(dishName);
                binding.tvDishPrice.setText(dishPrice);
                binding.tvDishProducer.setText(dishProducer);
                Fragment navhost = getSupportFragmentManager().findFragmentById(R.id.nav_host);
                NavController navController = NavHostFragment.findNavController(navhost);
                binding.navHost.setVisibility(View.VISIBLE);
                getSupportFragmentManager().setFragmentResult("requestKey", bundle);
                navController.navigate(R.id.resultFragment, bundle);
                showMessage(this, "Text loaded");
                return;
            }
        }
    }

    private void putReference(){
        ed = sharedPreferences.edit();
        if (getIntent().getStringExtra("priceKey").isEmpty() || getIntent().getStringExtra("producerKey").isEmpty() || getIntent().getStringExtra("dishesKey").isEmpty()) {
            showMessage(this, getString(R.string.error_message));
        } else {
            binding.tvDishPrice.setText(getIntent().getStringExtra("priceKey"));
            binding.tvDishProducer.setText(getIntent().getStringExtra("producerKey"));
            binding.tvDishName.setText(getIntent().getStringExtra("dishesKey"));
//
            // Запись данных
            ed.putString("dish_name", getIntent().getStringExtra("dishesKey"));
            ed.putString("dish_price", getIntent().getStringExtra("priceKey"));
            ed.putString("dish_producer", getIntent().getStringExtra("producerKey"));
            // Подтверждаем сохранение
            ed.commit();
            showMessage(this, "Text saved");
        }
    }
}
