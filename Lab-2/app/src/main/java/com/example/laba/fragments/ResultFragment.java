package com.example.laba.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laba.R;
import com.example.laba.base.BaseBindingFragment;
import com.example.laba.databinding.FragmentResultBinding;
import com.google.android.material.snackbar.Snackbar;


public class ResultFragment extends BaseBindingFragment<FragmentResultBinding> {

    @Override
    protected int layoutId() {
        return R.layout.fragment_result;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("requestKey", getViewLifecycleOwner(), new FragmentResultListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                if (bundle.getString("priceKey").isEmpty() || bundle.getString("producerKey").isEmpty() || bundle.getString("dishesKey").isEmpty()) {
                    showMessage(requireContext(), getString(R.string.error_message));
                } else {
                    binding.tvDishPrice.setText("Price range: " + bundle.getString("priceKey"));
                    binding.tvDishProducer.setText("Producer: " + bundle.getString("producerKey"));
                    binding.tvDishName.setText("Dish name: " + bundle.getString("dishesKey"));
                }
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popBackStack(binding.getRoot());
            }
        });
    }
}