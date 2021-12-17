package com.grupo2.agrosoft.data.service;

import java.util.List;

import com.grupo2.agrosoft.data.entity.*;

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

    List<ControlSiembra> consultarControlSiembras();
    String agregarControlSiembra(ControlSiembra controlSiembra);
    String eliminarControlSiembra(Integer id);

    List<Parcelas> consultarParcelas();
    String agregarParcelas(Parcelas parcelas);
    String eliminarParcelas(Integer id);

    List<RegistroSiembras> consultarRegistroSiembras();
    String agregarRegistroSiembras(RegistroSiembras registroSiembras);
    String eliminarRegistroSiembras(Integer id);
}
