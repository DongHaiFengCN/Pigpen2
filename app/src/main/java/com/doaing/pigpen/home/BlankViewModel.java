package com.doaing.pigpen.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class BlankViewModel extends ViewModel {
    private MutableLiveData<List<User>> users;

    public LiveData<List<User>> getUsers() {
        if (users == null) {

            users = new MutableLiveData<>();
            users.setValue(new ArrayList<User>());
        }
        return users;
    }

    public void add(User user) {
        List<User> list = users.getValue();
        assert list != null;
        list.add(user);
        users.postValue(list);

    }

}
