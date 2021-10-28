package com.example.laba;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.laba.databinding.DialogMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainDialog extends DialogFragment {

    private DialogMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogMainBinding.inflate(inflater, container, false);

        return binding.getRoot();
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
                Bundle result = new Bundle();

                result.putString("priceKey", String.valueOf(binding.rsPrice.getValues()));
                if (binding.radioButton1.isChecked())
                    result.putString("producerKey", binding.radioButton1.getText().toString());

                if (binding.radioButton2.isChecked())
                    result.putString("producerKey", binding.radioButton2.getText().toString());

                if (binding.radioButton3.isChecked())
                    result.putString("producerKey", binding.radioButton3.getText().toString());


                result.putString("dishesKey", binding.spinnerList.getSelectedItem().toString());

                getParentFragmentManager().setFragmentResult("requestKey", result);
                dismiss();
            }
        });

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
