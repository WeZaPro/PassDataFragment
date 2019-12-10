package com.taweesak.passdatafragment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.taweesak.passdatafragment.R;

public class MainActivity extends AppCompatActivity {

    TopFragment topFragment;
    ButtomFragment buttomFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callFragment();
    }

    private void callFragment() {

        topFragment = new TopFragment();
        buttomFragment = new ButtomFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.contentContainer_top,topFragment)
                //.add(R.id.contentContainer_buttom,buttomFragment)
                .commit();
    }
}
