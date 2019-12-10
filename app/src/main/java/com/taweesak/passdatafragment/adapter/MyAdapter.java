package com.taweesak.passdatafragment.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.taweesak.passdatafragment.DataModel.DataModel;
import com.taweesak.passdatafragment.R;
import com.taweesak.passdatafragment.callBack.itemClickCallBack;
import com.taweesak.passdatafragment.viewModel.MyViewModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH>{

    private Activity context;
    ArrayList<DataModel> listData = new ArrayList<>();
    private itemClickCallBack itemCallBack;
    private MyViewModel myViewModel;

    public MyAdapter(Activity context, ArrayList<DataModel> listData, itemClickCallBack itemCallBack) {
        this.context = context;
        this.listData = listData;
        this.itemCallBack = itemCallBack;

        myViewModel = ViewModelProviders.of((FragmentActivity) context).get(MyViewModel.class);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

        DataModel dataModel = listData.get(position);
        holder.textView.setText(""+dataModel.getCountry());

        holder.radioButton.setChecked(dataModel.isChecked());
        holder.itemView.setTag(position);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class VH extends RecyclerView.ViewHolder{

        RadioButton radioButton;
        TextView textView;
        ImageView imageView;

        public VH(@NonNull final View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_name);
            imageView = itemView.findViewById(R.id.imageFlag);
            radioButton = itemView.findViewById(R.id.radio_button);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Todo....
                    int clickItem = (int) view.getTag();
                    itemCallBack.itemCallback(clickItem);
                    notifyDataSetChanged();

                    updateCart(listData.get(clickItem));
                }
            });
        }
    }

    private void updateCart(DataModel dataModel) {
        myViewModel.setmRates(dataModel);
        /*Toast.makeText(context,"data from click : "+dataModel,Toast.LENGTH_SHORT).show();*/
        Toast.makeText(context,"data count from click : "+dataModel.getRates(),Toast.LENGTH_SHORT).show();
    }

}
