package com.taweesak.passdatafragment.viewModel;

import com.taweesak.passdatafragment.DataModel.DataModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<DataModel> mNumber = new MutableLiveData<>();

    public void setmRates(DataModel myModelData){
        mNumber.setValue(myModelData);
    }

    public LiveData<DataModel> getmRates(){
        return mNumber;
    }
}
