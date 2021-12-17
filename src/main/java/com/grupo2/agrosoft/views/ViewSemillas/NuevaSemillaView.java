package com.grupo2.agrosoft.views.ViewSemillas;

import com.grupo2.agrosoft.controller.BaseDatosInteractor;
import com.grupo2.agrosoft.controller.BaseDatosInteractorImpl;
import com.grupo2.agrosoft.data.entity.Semilla;
import com.grupo2.agrosoft.views.MainLayout;
import com.grupo2.agrosoft.views.Notificaciones.Notificaciones;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Nueva Semilla")
@Route(value = "nuevasemilla", layout = MainLayout.class)
public class NuevaSemillaView extends Div {

    private BaseDatosInteractor interactor;

    private TextField nombre= new TextField("Nombre");
    private TextField tiempo_cosecha= new TextField("Tiempo Cosecha (dias)");
    private TextField producto_pormetro= new TextField("Producción Por Metro Cuadrado");
    private TextField unidad_peso= new TextField("Unidad de Peso");

    private Button bGuardar = new Button("Guardar");
    private Button bCancelar = new Button("Cancelar");

    public NuevaSemillaView() {
        addClassName("nuevasiembra-view");
        interactor = new BaseDatosInteractorImpl("https://apex.oracle.com", 30000L);
        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        bGuardar.addClickListener(e -> {
            Semilla semilla= new Semilla(
                nombre.getValue(),
                Integer.valueOf(tiempo_cosecha.getValue()),
                Integer.valueOf(producto_pormetro.getValue()),
                unidad_peso.getValue()
            );

            String respuesta = interactor.agregarSemilla(semilla);
            if (respuesta != null) {
                new Notificaciones("Datos almacenados correctamente", 2, 7);
                clearForm();
            }
            else
                new Notificaciones("No se pudo almacenar la informacion", 1, 7);
        });

        bCancelar.addClickListener(buttonClickEvent -> {
            clearForm();
        });

    }
    private Component createTitle() {
        return new H3("Registro De Nueva Semilla");
    }
    
    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(nombre,tiempo_cosecha,producto_pormetro,unidad_peso);
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

    private void clearForm(){
        nombre.clear();
        tiempo_cosecha.clear();
        producto_pormetro.clear();
        unidad_peso.clear();
    }

}
