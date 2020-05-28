package com.ccamacho.canilroomviewmodel.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ccamacho.canilroomviewmodel.model.Dog;

import java.util.List;

public class CanilListViewModel extends ViewModel {

    private MutableLiveData<List<Dog>> dogList;
    private MutableLiveData<Boolean> loading;

    public MutableLiveData<List<Dog>> getDogList() {
        if (dogList == null) {
            dogList = new MutableLiveData<>();
        }
        return dogList;
    }

    public void updateDogList(List<Dog> dogList) {
        this.dogList.setValue(dogList);
    }

    public MutableLiveData<Boolean> isLoading() {
        if (loading == null) {
            loading = new MutableLiveData<>();
            updateLoading(true);
        }
        return loading;
    }

    public void updateLoading(boolean loading) {
        this.loading.setValue(loading);
    }
}
