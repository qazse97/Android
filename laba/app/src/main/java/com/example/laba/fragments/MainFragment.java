package com.example.laba.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.laba.MainDialog;
import com.example.laba.R;
import com.example.laba.databinding.FragmentMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;

    private MainDialog dialog = new MainDialog();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initListeners();
    }

    private void initListeners(){
        getParentFragmentManager().setFragmentResultListener("requestKey", getViewLifecycleOwner(), new FragmentResultListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                // We use a String here, but any type that can be put in a Bundle is supported
                if (bundle.getString("priceKey").isEmpty() || bundle.getString("producerKey").isEmpty() || bundle.getString("dishesKey").isEmpty()){
                    Snackbar.make(requireView(), getString(R.string.error_message), Snackbar.LENGTH_SHORT).show();
                }else {
                    binding.tvDishPrice.setText("Price range: " + bundle.getString("priceKey"));
                    binding.tvDishProducer.setText("Producer: " + bundle.getString("producerKey"));
                    binding.tvDishName.setText("Dish name: " + bundle.getString("dishesKey"));
                }
            }
        });
        binding.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show(getParentFragmentManager(), "dialog_main");
            }
        });
    }
}