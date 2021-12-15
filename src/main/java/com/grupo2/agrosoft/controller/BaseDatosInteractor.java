package com.grupo2.agrosoft.controller;

import java.util.List;

import com.grupo2.agrosoft.data.entity.Proveedor;
import com.grupo2.agrosoft.data.entity.Semilla;
import com.grupo2.agrosoft.data.entity.Siembra;

public interface BaseDatosInteractor {
    List<Proveedor> consultarProveedores();

    String agregarProveedor(Proveedor proveedor);

    String eliminarProveedor(Integer id);

    // Semilla
    List<Semilla> consultarSemillas();

    String agregarSemilla(Semilla semilla);

    String eliminarSemilla(Integer id);

    // Siembra
    List<Siembra> consultarSiembras();

    String agregarSiembra(Siembra siembra);

    String eliminarSiembra(Integer id);

}
