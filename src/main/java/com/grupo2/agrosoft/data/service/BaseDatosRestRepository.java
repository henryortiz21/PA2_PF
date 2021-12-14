package com.grupo2.agrosoft.data.service;

import java.sql.Date;
import java.time.LocalDate;

import com.grupo2.agrosoft.data.entity.Proveedor;
import com.grupo2.agrosoft.data.entity.Siembra;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface BaseDatosRestRepository {

        @Headers({
                        "Content-Type: application/json",
                        "Accept-Charset: utf-8"
        })
        @GET("/pls/apex/hortiz_bd/pa23p/t_proveedores")
        Call<RespuestaProveedores> consultarProveedores();

        @Headers({
                        "Content-Type: application/json",
                        "Accept-Charset: utf-8"
        })
        @POST("/pls/apex/hortiz_bd/pa23p/t_proveedores")
        Call<ResponseBody> agregarProveedor(@Body Proveedor proveedor);

        @Headers({
                        "Content-Type: text/csv",
                        "Accept-Charset: utf-8"
        })
        @DELETE("/pls/apex/hortiz_bd/pa23p/t_proveedores")
        Call<ResponseBody> eliminarProveedor(@Query("id") Integer id);

        @Headers({
                        "Content-Type: application/json",
                        "Accept-Charset: utf-8"
        })
        @POST("/pls/apex/hortiz_bd/pa23p/t_siembra")
        Call<ResponseBody> agregarSiembra(@Body Siembra siembra);
}
