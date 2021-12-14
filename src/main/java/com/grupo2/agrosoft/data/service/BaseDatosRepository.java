package com.grupo2.agrosoft.data.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.grupo2.agrosoft.data.entity.Proveedor;
import com.grupo2.agrosoft.data.entity.Siembra;

public interface BaseDatosRepository {
    List<Proveedor> consultarProveedores();
    String agregarProveedor(Proveedor proveedor);
    String eliminarProveedor(Integer id);

    String agregarSiembra(Siembra siembra);
}
