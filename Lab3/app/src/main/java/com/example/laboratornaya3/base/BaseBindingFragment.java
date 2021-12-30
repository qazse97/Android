package com.example.laboratornaya3.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public abstract class BaseBindingFragment<Binding extends ViewDataBinding> extends Fragment {

    protected Binding binding;

    @LayoutRes
    protected abstract int layoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false);
        return binding.getRoot();
    }

    protected static void popBackStack(View view){
        Navigation.findNavController(view).popBackStack();
    }

    protected static void navigate(@IdRes int id, View view){
        Navigation.findNavController(view).navigate(id);
    }

    protected static void navigate(@IdRes int id, View view, Bundle bundle){
        Navigation.findNavController(view).navigate(id, bundle);
    }

    @SuppressLint("ResourceType")
    protected static void showMessage(Context context, @IdRes int message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    protected static void showMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
