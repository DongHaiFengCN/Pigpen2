package com.doaing.pigpen.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.doaing.pigpen.R;

import java.util.List;

public class DFragment extends Fragment {

    private BlankViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.d_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
