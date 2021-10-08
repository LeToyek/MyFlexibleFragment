package com.example.myflexiblefragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        HomeFragement mHomeFragment = new HomeFragement();
        Fragment fragment = mFragmentManager.findFragmentByTag(HomeFragement.class.getSimpleName());

        if(!(fragment instanceof  HomeFragement)){
            Log.d("MyFlexibleFragment","FragmentName : " +HomeFragement.class.getSimpleName());
            mFragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container,mHomeFragment,HomeFragement.class.getSimpleName())
                    .commit();
        }
    }
}