package com.example.laboratornaya3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.laboratornaya3.base.BaseBindingActivity;
import com.example.laboratornaya3.databinding.ActivityMainBinding;

public class MainActivity extends BaseBindingActivity<ActivityMainBinding> {

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initListeners();
    }

    private void initListeners() {

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);

        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.dishes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        binding.spinnerList.setAdapter(adapter);

        binding.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent.putExtra("priceKey", String.valueOf(binding.rsPrice.getValues()));
                if (binding.radioButton1.isChecked())
                    intent.putExtra("producerKey", binding.radioButton1.getText().toString());

                if (binding.radioButton2.isChecked())
                    intent.putExtra("producerKey", binding.radioButton2.getText().toString());

                if (binding.radioButton3.isChecked())
                    intent.putExtra("producerKey", binding.radioButton3.getText().toString());


                intent.putExtra("dishesKey", binding.spinnerList.getSelectedItem().toString());
                startActivity(intent);
            }
        });

        binding.btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("check_result", true);
                startActivity(intent);
            }
        });
    }
}