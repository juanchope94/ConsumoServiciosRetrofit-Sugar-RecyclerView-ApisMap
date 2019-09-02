package com.juan.enciclav20;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Peticiones {

    @GET("estado/")
    Call<Example> getEncicla();

}
