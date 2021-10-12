package com.app.spacex.Api;

import com.app.model.DataClass;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SpaceXApi {
    @GET("v4/launches")
    Call<List<DataClass>> getMessage();
}