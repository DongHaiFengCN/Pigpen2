package com.doaing.pigpen.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doaing.pigpen.R;
import com.doaing.pigpen.other.Main2Activity;

import java.util.List;

public class AFragment extends Fragment {

    private BlankViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Log.e("DOAING", "onCreateView");
        View view = inflater.inflate(R.layout.a_fragment, container, false);
        view.findViewById(R.id.s).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), Main2Activity.class));
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.e("DOAING", "onActivityCreated");
        mViewModel = ViewModelProviders.of(getActivity()).get(BlankViewModel.class);
        // TODO: Use the ViewModel

        mViewModel.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                // 更新 UI
                Log.e("DOAING", users.size() + "");

            }
        });


    }

}
