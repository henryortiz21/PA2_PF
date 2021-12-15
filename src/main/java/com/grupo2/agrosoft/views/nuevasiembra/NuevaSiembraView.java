package com.grupo2.agrosoft.views.nuevasiembra;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.grupo2.agrosoft.controller.BaseDatosInteractor;
import com.grupo2.agrosoft.controller.BaseDatosInteractorImpl;
import com.grupo2.agrosoft.data.entity.Siembra;
import com.grupo2.agrosoft.views.MainLayout;
import com.grupo2.agrosoft.views.notificaciones.Notificaciones;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Nueva siembra")
@Route(value = "nuevasiembra", layout = MainLayout.class)
public class NuevaSiembraView extends Div {

    private BaseDatosInteractor interactor;

    private TextField descripcion= new TextField("Descripción");
    private TextArea ubicacion= new TextArea("Ubicacion");
    private TextField dimensiones= new TextField("Dimensiones");
    private TextField tipo_siembra= new TextField("Tipo siembra");
    private DatePicker f_siembra=new DatePicker("Fecha de siembra",LocalDate.now());
    private TextField f_cosecha= new TextField("Fecha proxima de cosecha");
    private TextField cosecha_aproximada= new TextField("Cosecha aproximada");
    private DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Button bGuardar = new Button("Guardar");
    private Button bCancelar = new Button("Cancelar");

    public NuevaSiembraView() {
        addClassName("nuevasiembra-view");
        interactor = new BaseDatosInteractorImpl("https://apex.oracle.com", 30000L);
        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        bGuardar.addClickListener(e -> {
            String fecha_siembra = f_siembra.getValue().format(dtformat);
            Siembra siembra = new Siembra(
                    descripcion.getValue(),
                    ubicacion.getValue(),
                    Integer.getInteger(dimensiones.getValue()),
                    tipo_siembra.getValue(),//Combobox
                    fecha_siembra,
                    f_cosecha.getValue(),
                    "200");
            String respuesta = interactor.agregarSiembra(siembra);
            if (respuesta != null)
                new Notificaciones("Datos almacenados correctamente", 2, 7);
            else
                new Notificaciones("No se pudo almacenar la informacion", 1, 7);
        });

        f_siembra.addValueChangeListener(e->{
            LocalDate f= e.getValue();
            f=f.plusDays(10);
            String f_proxima = f.format(dtformat);
            f_cosecha.setValue(f_proxima);
        });
    }
    private Component createTitle() {
        return new H3("Nueva siembra");
    }
    
    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        f_cosecha.setReadOnly(true);
        cosecha_aproximada.setReadOnly(true);
        formLayout.add(descripcion, ubicacion, dimensiones, tipo_siembra, f_siembra, f_cosecha, cosecha_aproximada);
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

}
