package com.taweesak.passdatafragment.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.taweesak.passdatafragment.DataModel.DataModel;
import com.taweesak.passdatafragment.R;
import com.taweesak.passdatafragment.viewModel.MyViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ButtomFragment extends Fragment {

    Context context;
    TextView textViewGetValue,textViewShowCal;
    EditText editTextInput;
    Button btnCalValue;
    MyViewModel myViewModel;
    String key;
    double keyToDouble;


    public ButtomFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

        key = getArguments().getString("Text");
        keyToDouble = Double.parseDouble(key);
        //Toast.makeText(getActivity(),"Get bundle is "+key,Toast.LENGTH_SHORT).show();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_buttom, container, false);

        findView(view);
        textViewGetValue.setText(""+keyToDouble);


        btnCalValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myViewModel.getmRates().observe(getActivity(), new Observer<DataModel>() {
                    @Override
                    public void onChanged(DataModel dataModel) {
                        double x = keyToDouble;
                        double y = Double.parseDouble(editTextInput.getText().toString());
                        //textViewShowCal.setText(""+dataModel.getRates());
                        textViewShowCal.setText(""+(x*y));

                    }
                });

                //Toast.makeText(getActivity(),"data get from bundle is ",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    private void findView(View view) {
        textViewGetValue = view.findViewById(R.id.textViewGetValue);
        textViewShowCal = view.findViewById(R.id.textViewShowCal);
        editTextInput = view.findViewById(R.id.editTextInput);
        btnCalValue = view.findViewById(R.id.btnCalValue);
    }

}
