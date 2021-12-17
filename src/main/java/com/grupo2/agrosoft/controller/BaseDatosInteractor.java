package com.grupo2.agrosoft.controller;

import java.util.List;

import com.grupo2.agrosoft.data.entity.*;

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


    // Control Siembra
    List<ControlSiembra> consultarControlSiembras();
    String agregarControlSiembras(ControlSiembra controlSiembra);
    String eliminarControlSiembras(Integer id);

    // parcelas
    List<Parcelas> consultarParcelas();
    String agregarParcelas(Parcelas parcelas);
    String eliminarParcelas(Integer id);

    // Registro Siembra
    List<RegistroSiembras> consultarRegistroSiembras();
    String agregarRegistroSiembras(RegistroSiembras registroSiembras);
    String eliminarRegistroSiembras(Integer id);

}
