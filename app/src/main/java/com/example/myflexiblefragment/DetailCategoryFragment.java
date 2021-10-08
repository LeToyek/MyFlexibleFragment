package com.example.myflexiblefragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class DetailCategoryFragment extends Fragment{


    public DetailCategoryFragment(){

    }
    TextView tvCategoryName,tvCategoryDescription;
    Button btnProfile,btnShowDialog;

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCategoryName = view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = view.findViewById(R.id.tv_category_description);

        btnProfile = view.findViewById(R.id.btn_profile);
        btnShowDialog = view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(v -> {
            OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();

            FragmentManager mFragmentManager = getChildFragmentManager();
            mOptionDialogFragment.show(mFragmentManager,OptionDialogFragment.class.getSimpleName());
        });

        if(savedInstanceState != null){
            String descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION);
            setDescription(descFromBundle);
        }

        if(getArguments() != null){
            String categoryName = getArguments().getString(EXTRA_NAME);
            tvCategoryName.setText(categoryName);
            tvCategoryDescription.setText(getDescription());
        }
        btnProfile.setOnClickListener(v->{
            Intent mIntent = new Intent(getActivity(),ProfileActivity.class);
            startActivity(mIntent);
        });

    }
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(EXTRA_DESCRIPTION, getDescription());
    }
    OptionDialogFragment.OnOptionDialogListener optionDialogListener = new OptionDialogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    };
}