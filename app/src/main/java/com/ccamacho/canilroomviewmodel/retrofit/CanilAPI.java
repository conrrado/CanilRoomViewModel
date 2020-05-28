package com.ccamacho.canilroomviewmodel.retrofit;

import com.ccamacho.canilroomviewmodel.model.Dog;
import com.ccamacho.canilroomviewmodel.model.DogDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CanilAPI {

    @GET("breeds")
    Call<List<Dog>> getAll();

    @GET("images/search")
    Call<List<DogDetail>> getDogByBreedId(@Query("breed_ids") int breedId);
}
