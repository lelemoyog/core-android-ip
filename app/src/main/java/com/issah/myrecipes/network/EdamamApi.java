package com.issah.myrecipes.network;

import com.issah.myrecipes.models.MyrecipesSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EdamamApi {
    @GET("api/recipes/v2")
    Call<MyrecipesSearchResponse> getRecipes(
            @Query("app_id") String app_id,
            @Query("app_key") String app_key,
            @Query("type") String type,
            @Query("q") String q
    );
}
