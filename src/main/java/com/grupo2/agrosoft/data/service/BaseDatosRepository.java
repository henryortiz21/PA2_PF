package com.grupo2.agrosoft.data.service;

import java.util.List;

import com.grupo2.agrosoft.data.entity.Proveedor;
import com.grupo2.agrosoft.data.entity.Semilla;
import com.grupo2.agrosoft.data.entity.Siembra;

public interface BaseDatosRepository {
    List<Proveedor> consultarProveedores();
    String agregarProveedor(Proveedor proveedor);
    String eliminarProveedor(Integer id);

    List<Semilla> consultarSemillas();
    String agregarSemilla(Semilla semilla);
    String eliminarSemilla(Integer id);

    List<Siembra> consultarSiembras();
    String agregarSiembra(Siembra siembra);
    String eliminarSiembra(Integer id);
}
