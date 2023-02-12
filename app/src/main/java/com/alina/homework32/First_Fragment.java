package com.alina.homework32;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class First_Fragment extends Fragment {
    Runnable runnable;

    private Button btnPlus;
    private Button btnMinus;
    private TextView tvResuit;
    private int mCounter = 1;
    private Button btnAnother;
    static final String KEY_FOR_ANOTHER= "Key";


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        initListener();

    }

    private void initView() {
        btnPlus=requireActivity().findViewById(R.id.btn_pius);
        btnMinus=requireActivity().findViewById(R.id.btn_Minus);
        tvResuit=requireActivity().findViewById(R.id.tv_result);
        btnAnother= requireActivity().findViewById(R.id.btn_another);
    }

    private void initListener() {


        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCounter++;
                String result = Integer.toString(mCounter);

                tvResuit.setText(result);

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCounter--;
                String result = Integer.toString(mCounter);

                tvResuit.setText(result);
            }
        });
        btnAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                bundle.putInt( KEY_FOR_ANOTHER, Integer.parseInt(tvResuit.getText().toString()));
                SecondFragment secondFragment=new SecondFragment();
                secondFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.conteiner,
                        secondFragment).addToBackStack(null).commit();

            }
        });
    }

}

