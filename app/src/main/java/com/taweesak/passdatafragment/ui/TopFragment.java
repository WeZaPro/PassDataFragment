package com.taweesak.passdatafragment.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.taweesak.passdatafragment.DataModel.DataModel;
import com.taweesak.passdatafragment.R;
import com.taweesak.passdatafragment.adapter.MyAdapter;
import com.taweesak.passdatafragment.callBack.itemClickCallBack;
import com.taweesak.passdatafragment.viewModel.MyViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment implements itemClickCallBack {

    private Context context;
    private ArrayList<DataModel> mDataList = new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    MyViewModel myViewModel;
    TopFragment topFragment;
    ButtomFragment buttomFragment;
    int fragmentManager;
    FragmentTransaction fragmentTransaction;
    Button buttonCalValue;

    public TopFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_top, container, false);

        findView(view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapter = new MyAdapter(getActivity(),mDataList,this);
        recyclerView.setAdapter(myAdapter);

        data();

        buttonCalValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.getmRates().observe(getActivity(), new Observer<DataModel>() {
                    @Override
                    public void onChanged(DataModel dataModel) {

                        buttomFragment = new ButtomFragment();
                        /*Bundle bundle = new Bundle();
                        bundle.putString("Text", String.valueOf(dataModel.getRates()));
                        buttomFragment.setArguments(bundle);*/

                        fragmentManager = getActivity().getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.contentContainer_top,buttomFragment)
                                .commit();
                    }
                });
            }
        });

        return view;
    }

    private void data() {
        String country[] = {"USA","JAPAN","EUROPE"};
        double rates[] = {10,100,1000};
        int imageFlags[] = {R.drawable.usa,R.drawable.japan,R.drawable.europe};

        int dataSize = country.length;

        for (int i = 0; i < dataSize; i++) {
            DataModel myModelData = new DataModel(country[i],rates[i],imageFlags[i]);
            mDataList.add(myModelData);
        }
    }

    private void findView(View view) {
        recyclerView = view.findViewById(R.id.myRecyclerView);
        buttonCalValue = view.findViewById(R.id.buttonCalValue);

    }

    @Override
    public void itemCallback(final int position) {

        DataModel myModelData = mDataList.get(position);
        myModelData.setChecked(true);
        for (int i = 0; i < mDataList.size(); i++) {
            DataModel ship = mDataList.get(i);

            // radio button is check
            if(i != position){
                ship.setChecked(false);
            }
        }


        myAdapter.notifyDataSetChanged();
        recyclerView.refreshDrawableState();

    }
}
