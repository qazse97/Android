package com.example.laba.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.laba.R;
import com.example.laba.base.BaseBindingFragment;
import com.example.laba.databinding.FragmentMainBinding;

public class MainFragment extends BaseBindingFragment<FragmentMainBinding> {

    private static Bundle result = new Bundle();

    @Override
    protected int layoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initListeners();
    }

    private void initListeners() {

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(requireContext(), R.array.dishes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinnerList.setAdapter(adapter);

        binding.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result.putString("priceKey", String.valueOf(binding.rsPrice.getValues()));
                if (binding.radioButton1.isChecked())
                    result.putString("producerKey", binding.radioButton1.getText().toString());

                if (binding.radioButton2.isChecked())
                    result.putString("producerKey", binding.radioButton2.getText().toString());

                if (binding.radioButton3.isChecked())
                    result.putString("producerKey", binding.radioButton3.getText().toString());

                result.putString("dishesKey", binding.spinnerList.getSelectedItem().toString());

                getParentFragmentManager().setFragmentResult("requestKey", result);

                navigate(R.id.action_mainFragment_to_resultFragment, binding.getRoot());
            }
        });
    }
}