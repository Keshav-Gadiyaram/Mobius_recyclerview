package com.keshav.mobius.rest;

import com.keshav.mobius.model.Voucher;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    String BASE_URL = "https://run.mocky.io/v3/4c663239-03af-49b5-bcb3-0b0c41565bd2/";

    /**
     * The return type is important here
     * The class structure that you've defined in Call<T>
     * should exactly match with your json response
     * If you are not using another api, and using the same as mine
     * then no need to worry, but if you have your own API, make sure
     * you change the return type appropriately
     **/
    @GET("voucher")
    Call<List<Voucher>> getVouchers() ;
}
