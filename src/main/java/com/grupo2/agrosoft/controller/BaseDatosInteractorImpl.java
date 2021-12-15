package com.grupo2.agrosoft.controller;

import java.util.List;

import com.grupo2.agrosoft.data.entity.Proveedor;
import com.grupo2.agrosoft.data.entity.Semilla;
import com.grupo2.agrosoft.data.entity.Siembra;
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
}
