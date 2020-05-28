package com.ccamacho.canilroomviewmodel.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ccamacho.canilroomviewmodel.model.DogDetail;

public class CanilDetailViewModel extends ViewModel {

    private MutableLiveData<DogDetail> dogDetail;
    private MutableLiveData<Boolean> loading;

    public MutableLiveData<DogDetail> getDogDetail() {
        if (dogDetail == null) {
            dogDetail = new MutableLiveData<>();
        }
        return dogDetail;
    }

    public void updateDogDetail(DogDetail dogDetail) {
        this.dogDetail.setValue(dogDetail);
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
