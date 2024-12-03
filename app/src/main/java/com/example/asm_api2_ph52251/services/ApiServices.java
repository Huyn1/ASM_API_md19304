package com.example.asm_api2_ph52251.services;

import com.example.asm_api2_ph52251.model.Distributor;
import com.example.asm_api2_ph52251.model.Fruit;
import com.example.asm_api2_ph52251.model.Order;
import com.example.asm_api2_ph52251.model.Page;
import com.example.asm_api2_ph52251.model.Response;
import com.example.asm_api2_ph52251.model.User;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiServices {
//    public static String BASE_URL = "http://192.168.1.74:3000/api/";
    public static String BASE_URL = "http://192.168.1.2:3000/api/"; // api truong
    @POST("add-order")
    Call<Response <Order>>order (@Body Order order);
    @GET("get-list-distributor")
    Call<Response<ArrayList<Distributor>>> getListDistributor();

    @GET("search-distributor")
    Call<Response<ArrayList<Distributor>>> searchDistributor(@Query("key") String key);

    @POST("add-distributor")
    Call<Response<Distributor>> addDistributor(@Body Distributor distributor);

    @PUT("update-distributor-by-id/{id}")
    Call<Response<Distributor>> updateDistributor(@Path("id") String id,@Body Distributor distributor);

    @DELETE("destroy-distributor-by-id/{id}")
    Call<Response<Distributor>> deleteDistributor(@Path("id") String id);

    //lab 6
    @Multipart
    @POST("register-send-email")
    Call<Response<User>> register(
            @Part("username") RequestBody username,
            @Part("password") RequestBody password,
            @Part("email") RequestBody email,
            @Part("name") RequestBody name,
            @Part MultipartBody.Part avartar

    );

    @POST("login")
    Call<Response<User>> login (@Body User user);

    @GET("get-list-fruit")
    Call<Response<ArrayList<Fruit>>> getListFruit(@Header("Authorization")String token);

    @Multipart
    @POST("add-fruit-with-file-image")
    Call<Response<Fruit>> addFruitWithFileImage(@PartMap Map<String, RequestBody> requestBodyMap,
                                                @Part ArrayList<MultipartBody.Part> ds_hinh
    );


    @GET("get-page-fruit")
    Call<Response<Page<ArrayList<Fruit>>>> getPageFruit( @QueryMap Map<String, String> stringMap);


    @Multipart
    @PUT("update-fruit-by-id/{id}")
    Call<Response<Fruit>> updateFruitWithFileImage(@PartMap Map<String, RequestBody> requestBodyMap,
                                                   @Path("id") String id,
                                                   @Part ArrayList<MultipartBody.Part> ds_hinh
    );

    @DELETE("destroy-fruit-by-id/{id}")
    Call<Response<Fruit>> deleteFruits(@Path("id") String id);

    @GET("get-fruit-by-id/{id}")
    Call<Response<Fruit>> getFruitById (@Path("id") String id);




}
