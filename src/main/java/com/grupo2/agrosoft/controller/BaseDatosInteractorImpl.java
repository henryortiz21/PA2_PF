package com.grupo2.agrosoft.controller;

import java.util.List;

import com.grupo2.agrosoft.data.entity.*;
import com.grupo2.agrosoft.data.service.BaseDatosRepository;
import com.grupo2.agrosoft.data.service.BaseDatosRepositoryImpl;

public class BaseDatosInteractorImpl implements BaseDatosInteractor {

    private BaseDatosRepository repository;

    public BaseDatosInteractorImpl(String url, Long timeout){
        this.repository = new BaseDatosRepositoryImpl(url, timeout);
    }
    //Proveedor
    @Override
    public List<Proveedor> consultarProveedores() {
        return repository.consultarProveedores();
    }
    @Override
    public String agregarProveedor(Proveedor proveedor) {
        return repository.agregarProveedor(proveedor);
    }

    @Override
    public String eliminarProveedor(Integer id) {
        return repository.eliminarProveedor(id);
    }

    //Semilla
    @Override
    public List<Semilla> consultarSemillas() {
        return repository.consultarSemillas();
    }
    @Override
    public String agregarSemilla(Semilla semilla) {
        return repository.agregarSemilla(semilla);
    }
    @Override
    public String eliminarSemilla(Integer id) {
        return repository.eliminarSemilla(id);
    }

    //Siembra
    @Override
    public String agregarSiembra(Siembra siembra) {
        return repository.agregarSiembra(siembra);
    }
    @Override
    public String eliminarSiembra(Integer id) {
        return repository.eliminarSiembra(id);
    }
    @Override
    public List<Siembra> consultarSiembras() {
        return repository.consultarSiembras();
    }

    //Control Siembra
    @Override
    public List<ControlSiembra> consultarControlSiembras() { return repository.consultarControlSiembras();}
    @Override
    public String agregarControlSiembras(ControlSiembra controlSiembra) {return repository.agregarControlSiembra(controlSiembra);}
    @Override
    public String eliminarControlSiembras(Integer id) {return repository.eliminarControlSiembra(id);}

    //Parcelas
    @Override
    public List<Parcelas> consultarParcelas() { return repository.consultarParcelas();}
    @Override
    public String agregarParcelas(Parcelas parcelas) {return repository.agregarParcelas(parcelas);}
    @Override
    public String eliminarParcelas(Integer id) {return repository.eliminarParcelas(id);}

    //Registro Siembra
    @Override
    public String agregarRegistroSiembras(RegistroSiembras registroSiembras) {
        return repository.agregarRegistroSiembras(registroSiembras);
    }
    @Override
    public String eliminarRegistroSiembras(Integer id) {
        return repository.eliminarRegistroSiembras(id);
    }
    @Override
    public List<RegistroSiembras> consultarRegistroSiembras() {
        return repository.consultarRegistroSiembras();
    }
}
