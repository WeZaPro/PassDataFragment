package com.taweesak.passdatafragment.ui;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.taweesak.passdatafragment.DataModel.DataModel;
import com.taweesak.passdatafragment.R;
import com.taweesak.passdatafragment.viewModel.MyViewModel;

import java.io.File;
import java.util.ArrayList;

public class ButtomFragment extends Fragment {

    Context context;
    TextView textViewShowCal;
    EditText editTextInput;
    Button btnCalValue;
    MyViewModel myViewModel;
    //String key;
    //double keyToDouble;
    ImageView imageViewFlag;

    public ButtomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        /*key = getArguments().getString("Text");
        keyToDouble = Double.parseDouble(key);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_buttom, container, false);

        findView(view);

        btnCalValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myViewModel.getmRates().observe(getActivity(), new Observer<DataModel>() {
                    @Override
                    public void onChanged(DataModel dataModel) {
                        /*double x = keyToDouble;*/
                        double y = Double.parseDouble(editTextInput.getText().toString());
                        double z = dataModel.getRates();
                        Toast.makeText(getActivity(),"data change z = "+z,Toast.LENGTH_SHORT).show();
                        //textViewShowCal.setText(""+(x*y));
                        textViewShowCal.setText(""+(z*y));
                    }
                });
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myViewModel.getmRates().observe(getActivity(), new Observer<DataModel>() {
            @Override
            public void onChanged(DataModel dataModel) {
                imageViewFlag.setImageResource(dataModel.getImageFlag());
            }
        });
    }

    private void findView(View view) {
        textViewShowCal = view.findViewById(R.id.textViewShowCal);
        editTextInput = view.findViewById(R.id.editTextInput);
        btnCalValue = view.findViewById(R.id.btnCalValue);
        imageViewFlag = view.findViewById(R.id.imageViewFlag);
    }
}
