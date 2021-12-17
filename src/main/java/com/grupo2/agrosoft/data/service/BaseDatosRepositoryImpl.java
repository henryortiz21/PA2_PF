package com.grupo2.agrosoft.data.service;

import java.util.List;

import com.grupo2.agrosoft.data.entity.Semilla;

import com.grupo2.agrosoft.data.entity.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class BaseDatosRepositoryImpl implements BaseDatosRepository {

    private BaseDatosRestServiceClient client;

    public BaseDatosRepositoryImpl(String url, Long timeout){
        this.client = new BaseDatosRestServiceClient(url, timeout);
    }

    // Semillas
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


    //Control Siembras
    @Override
    public List<ControlSiembra> consultarControlSiembras() {
        try{
            Call<RespuestaControlSiembras> call = client.getBaseDatosRestService().consultarControlSiembras();
            Response<RespuestaControlSiembras> respuesta = call.execute();
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
    public String agregarControlSiembra(ControlSiembra controlSiembra) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().agregarControlSiembras(controlSiembra);
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
    public String eliminarControlSiembra(Integer id) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().eliminarControlSiembras(id);
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


    //Parcelas
    @Override
    public List<Parcelas> consultarParcelas() {
        try{
            Call<RespuestaParcelas> call = client.getBaseDatosRestService().consultarParcelas();
            Response<RespuestaParcelas> respuesta = call.execute();
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
    public String agregarParcelas(Parcelas parcelas) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().agregarParcelas(parcelas);
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
    public String eliminarParcelas(Integer id) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().eliminarParcelas(id);
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



    //Registro Siembras
    @Override
    public String agregarRegistroSiembras(RegistroSiembras registroSiembras) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().agregarRegistroSiembras(registroSiembras);
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
    public List<RegistroSiembras> consultarRegistroSiembras() {
        try{
            Call<RespuestaRegistroSiembras> call = client.getBaseDatosRestService().consultarRegistroSiembras();
            Response<RespuestaRegistroSiembras> respuesta = call.execute();
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
    public String eliminarRegistroSiembras(Integer id) {
        try{
            Call<ResponseBody> call = client.getBaseDatosRestService().eliminarRegistroSiembras(id);
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
