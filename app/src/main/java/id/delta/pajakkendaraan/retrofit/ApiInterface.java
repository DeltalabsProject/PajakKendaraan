package id.delta.pajakkendaraan.retrofit;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import id.delta.pajakkendaraan.retrofit.models.ResponsePajak;
import id.delta.pajakkendaraan.retrofit.models.aceh.ResponseAceh;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 8/7/16.
 */
public interface ApiInterface {
//GET http://ibacor.com/api/pajak-kendaraan?kode=B&nomor=1234&seri=AB

    String BASE_URL = "http://ibacor.com/api/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(new OkHttpClient.Builder().readTimeout(20, TimeUnit.SECONDS).writeTimeout(20, TimeUnit.SECONDS).build())
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
            .build();


    @GET("pajak-kendaraan")
    Call<ResponsePajak> getResponse(@Query("kode") String kode, @Query("nomor") String nomor, @Query("seri") String seri
    );

    @GET("pajak-kendaraan")
    Call<ResponseAceh> getAcehResponse(@Query("kode") String kode, @Query("nomor") String nomor, @Query("seri") String seri
    );

}
