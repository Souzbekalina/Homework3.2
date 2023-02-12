package com.alina.homework32;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment {
      private  TextView S_result;
       private Integer anotherResult;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
       getData();
    }
    private void initView() {
        S_result=requireActivity().findViewById(R.id.tv_second);
    }
    private void getData() {
        if (getArguments()!=null) {
            anotherResult = getArguments().getInt(First_Fragment.KEY_FOR_ANOTHER);
            S_result.setText(anotherResult.toString());
        }

    }

}