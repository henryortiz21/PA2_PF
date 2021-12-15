package com.grupo2.agrosoft.data.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.grupo2.agrosoft.data.entity.Proveedor;
import com.grupo2.agrosoft.data.entity.Semilla;
import com.grupo2.agrosoft.data.entity.Siembra;

public class BaseDatosRepositoryImpl implements BaseDatosRepository {

    private BaseDatosRestServiceClient client;

    public BaseDatosRepositoryImpl(String url, Long timeout){
        this.client = new BaseDatosRestServiceClient(url, timeout);
    }

    @Override
    public List<Proveedor> consultarProveedores() {
        try{
            Call<RespuestaProveedores> call = client.getBaseDatosRestService().consultarProveedores();
            Response<RespuestaProveedores> respuesta = call.execute();
            if(respuesta.isSuccessful()){
                return respuesta.body().getItems();
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String agregarProveedor(Proveedor proveedor) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().agregarProveedor(proveedor);
            Response<ResponseBody> respuesta = call.execute();
            if(respuesta.isSuccessful()){
                return respuesta.message();
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String eliminarProveedor(Integer id) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().eliminarProveedor(id);
            Response<ResponseBody> respuesta = call.execute();
            if(respuesta.isSuccessful()){
                return respuesta.message();
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String agregarSemilla(Semilla semilla) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().agregarSemilla(semilla);
            Response<ResponseBody> respuesta = call.execute();
            if(respuesta.isSuccessful()){
                return respuesta.message();
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Semilla> consultarSemillas() {
        try{
            Call<RespuestaSemillas> call = client.getBaseDatosRestService().consultarSemillas();
            Response<RespuestaSemillas> respuesta = call.execute();
            if(respuesta.isSuccessful()){
                return respuesta.body().getItems();
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String eliminarSemilla(Integer id) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().eliminarSemilla(id);
            Response<ResponseBody> respuesta = call.execute();
            if(respuesta.isSuccessful()){
                return respuesta.message();
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String agregarSiembra(Siembra siembra) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().agregarSiembra(siembra);
            Response<ResponseBody> respuesta = call.execute();
            if(respuesta.isSuccessful()){
                return respuesta.message();
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Siembra> consultarSiembras() {
        try{
            Call<RespuestaSiembras> call = client.getBaseDatosRestService().consultarSiembras();
            Response<RespuestaSiembras> respuesta = call.execute();
            if(respuesta.isSuccessful()){
                return respuesta.body().getItems();
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String eliminarSiembra(Integer id) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().eliminarSiembra(id);
            Response<ResponseBody> respuesta = call.execute();
            if(respuesta.isSuccessful()){
                return respuesta.message();
            }else{
                return null;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }



}
