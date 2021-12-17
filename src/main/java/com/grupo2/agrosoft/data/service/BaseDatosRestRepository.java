package com.grupo2.agrosoft.data.service;

import com.grupo2.agrosoft.data.entity.*;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

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


        //SIEMBRA
        @Headers({
                        "Content-Type: application/json",
                        "Accept-Charset: utf-8"
        })
        @GET("/pls/apex/progavanzada2/uthg2/siembra")
        Call<RespuestaSiembras> consultarSiembras();

        @Headers({
                        "Content-Type: application/json",
                        "Accept-Charset: utf-8"
        })
        @POST("/pls/apex/progavanzada2/uthg2/siembra")
        Call<ResponseBody> agregarSiembra(@Body Siembra siembra);


        @Headers({
                        "Content-Type: text/csv",
                        "Accept-Charset: utf-8"
        })
        @DELETE("/pls/apex/progavanzada2/uthg2/siembra")
        Call<ResponseBody> eliminarSiembra(@Query("id") Integer id);


        //SEMILLAS//
        @Headers({
                        "Content-Type: application/json",
                        "Accept-Charset: utf-8"
        })
        @GET("/pls/apex/progavanzada2/uthg2/semillas")
        Call<RespuestaSemillas> consultarSemillas();

        @Headers({
                        "Content-Type: application/json",
                        "Accept-Charset: utf-8"
        })
        @POST("/pls/apex/progavanzada2/uthg2/semillas")
        Call<ResponseBody> agregarSemilla(@Body Semilla semilla);

        @Headers({
                        "Content-Type: text/csv",
                        "Accept-Charset: utf-8"
        })
        @DELETE("/pls/apex/progavanzada2/uthg2/semillas")
        Call<ResponseBody> eliminarSemilla(@Query("id") Integer id);



        // Control Siembras
        @Headers({
                "Content-Type: application/json",
                "Accept-Charset: utf-8"
        })
        @GET("/pls/apex/progavanzada2/uthg2/controlsiembra")
        Call<RespuestaControlSiembras> consultarControlSiembras();

        @Headers({
                "Content-Type: application/json",
                "Accept-Charset: utf-8"
        })
        @POST("/pls/apex/progavanzada2/uthg2/controlsiembra")
        Call<ResponseBody> agregarControlSiembras(@Body ControlSiembra controlSiembras);

        @Headers({
                "Content-Type: text/csv",
                "Accept-Charset: utf-8"
        })
        @DELETE("/pls/apex/progavanzada2/uthg2/controlsiembra")
        Call<ResponseBody> eliminarControlSiembras(@Query("id") Integer id);


        // Parcelas
        @Headers({
                "Content-Type: application/json",
                "Accept-Charset: utf-8"
        })
        @GET("/pls/apex/progavanzada2/uthg2/parcelas")
        Call<RespuestaParcelas> consultarParcelas();

        @Headers({
                "Content-Type: application/json",
                "Accept-Charset: utf-8"
        })
        @POST("/pls/apex/progavanzada2/uthg2/parcelas")
        Call<ResponseBody> agregarParcelas(@Body Parcelas parcelas);

        @Headers({
                "Content-Type: text/csv",
                "Accept-Charset: utf-8"
        })
        @DELETE("/pls/apex/progavanzada2/uthg2/parcelas")
        Call<ResponseBody> eliminarParcelas(@Query("id") Integer id);


        //REGISTRO SIEMBRAS
        @Headers({
                "Content-Type: application/json",
                "Accept-Charset: utf-8"
        })
        @GET("/pls/apex/progavanzada2/uthg2/registrosiembras")
        Call<RespuestaRegistroSiembras> consultarRegistroSiembras();

        @Headers({
                "Content-Type: application/json",
                "Accept-Charset: utf-8"
        })
        @POST("/pls/apex/progavanzada2/uthg2/registrosiembras")
        Call<ResponseBody> agregarRegistroSiembras(@Body RegistroSiembras registroSiembras);


        @Headers({
                "Content-Type: text/csv",
                "Accept-Charset: utf-8"
        })
        @DELETE("/pls/apex/progavanzada2/uthg2/registrosiembras")
        Call<ResponseBody> eliminarRegistroSiembras(@Query("id") Integer id);
}
