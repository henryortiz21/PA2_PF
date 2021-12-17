package com.grupo2.agrosoft.views.parcelas;

import com.grupo2.agrosoft.controller.BaseDatosInteractor;
import com.grupo2.agrosoft.controller.BaseDatosInteractorImpl;
import com.grupo2.agrosoft.data.entity.Parcelas;
import com.grupo2.agrosoft.views.MainLayout;
import com.grupo2.agrosoft.views.notificaciones.Notificaciones;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("Nueva Parcela")
@Route(value = "nuevaparcela", layout = MainLayout.class)
public class ParcelasAddView extends Div {

    private BaseDatosInteractor interactor;

    private TextField nombre = new TextField("Nombre");
    private TextArea descripcion = new TextArea("Descripción");
    private TextArea ubicacion = new TextArea("Ubicacion");
    private TextField ancho = new TextField("Ancho");
    private TextField largo = new TextField("Largo");
    private TextField dimensiones = new TextField("Dimensiones Metros Cuadrados");
    private ComboBox cmbEstatus = new ComboBox("Estatus");

    private Button bGuardar = new Button("Guardar");
    private Button bCancelar = new Button("Cancelar");

    public ParcelasAddView() {
        addClassName("nuevaparcela-view");
        interactor = new BaseDatosInteractorImpl("https://apex.oracle.com", 30000L);
        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());


        ancho.addValueChangeListener(e-> {
            Integer Calc = 0;
            Integer dimensionM2 = Integer.parseInt(e.getValue());
            if (dimensionM2 > 0 && Integer.parseInt(largo.getValue()) > 0)
                 Calc = Integer.parseInt(e.getValue()) * Integer.parseInt(largo.getValue());
                 dimensiones.setValue(Calc.toString());
                }
        );

        largo.addValueChangeListener(e-> {
                    Integer Calc = 0;
                    Integer dimensionM2 = Integer.parseInt(e.getValue());
                    if (dimensionM2 > 0 && Integer.parseInt(ancho.getValue()) > 0)
                        Calc = Integer.parseInt(e.getValue()) * Integer.parseInt(ancho.getValue());
                    dimensiones.setValue(Calc.toString());
                }
        );

        bGuardar.addClickListener(e -> {
            Parcelas parcelas = new Parcelas(
                    nombre.getValue()
                    ,descripcion.getValue()
                    ,ubicacion.getValue()
                    ,Integer.parseInt(ancho.getValue())
                    ,Integer.parseInt(largo.getValue())
                    ,Integer.parseInt(dimensiones.getValue())
                    ,cmbEstatus.getValue().toString());

            String respuesta = interactor.agregarParcelas(parcelas);
            if (respuesta != null) {
                new Notificaciones("Datos almacenados correctamente", 2, 7);
                clearForm();
            }
            else
                new Notificaciones("No se pudo almacenar la información", 1, 7);
        });

        bCancelar.addClickListener(e -> {
            clearForm();
        });


    }
    private Component createTitle() {
        return new H3("Nueva Parcela");
    }
    
    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        dimensiones.setReadOnly(true);
        formLayout.add(nombre, descripcion, ubicacion, ancho, largo, dimensiones, cmbEstatus);
        cmbEstatus.setItems("Disponible", "No Disponible");
        cmbEstatus.isReadOnly();
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        buttonLayout.setSpacing(true);
        bGuardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(bGuardar, bCancelar);
        return buttonLayout;
    }

    private void clearForm()
    {
        nombre.setValue("");
        descripcion.setValue("");
        ubicacion.setValue("");
        ancho.setValue("0");
        largo.setValue("0");
        dimensiones.setValue("0");
        cmbEstatus.setValue("Disponible");
    }

}
