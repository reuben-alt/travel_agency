package fr.lernejo.travelsite;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PredictionEngineClient {
    @GET("api/ping")
    Call<String> ping();
    @GET("api/temperature")
    Call<Temperature> temperature();
}

