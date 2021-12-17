package com.grupo2.agrosoft.views.ControlSiembras;

import com.grupo2.agrosoft.controller.BaseDatosInteractor;
import com.grupo2.agrosoft.controller.BaseDatosInteractorImpl;
import com.grupo2.agrosoft.data.entity.ControlSiembra;
import com.grupo2.agrosoft.data.entity.RegistroSiembras;
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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Nuevo Control Siembras")
@Route(value = "nuevocontrolsiembras", layout = MainLayout.class)
public class ControlSiembrasAddView extends Div {
    private BaseDatosInteractor interactor;

    private ComboBox<RegistroSiembras> cmbCodigo = new ComboBox<>("Código Siembra");
    private TextField tipo_siembra = new TextField("Tipo Siembra");
    private ComboBox<String> cmbRiego = new ComboBox<>("Riego");
    private ComboBox<String> cmbFertilizacion = new ComboBox<>("Fertilizacion");
    private ComboBox<String> cmbAplicaIsecticida = new ComboBox<>("Aplicación Isecticida");
    private ComboBox<String> cmbLimpieza = new ComboBox<>("Limpieza");

    private Button bGuardar = new Button("Guardar");
    private Button bCancelar = new Button("Cancelar");

    public ControlSiembrasAddView() {
        addClassName("nuevocontrolsiembras-view");
        interactor = new BaseDatosInteractorImpl("https://apex.oracle.com", 30000L);
        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        DatosComboBox();

        cmbCodigo.addValueChangeListener(e->{
            tipo_siembra.setValue(cmbCodigo.getValue().getTiposiembra());
        });

        bGuardar.addClickListener(e -> {
            ControlSiembra controlSiembras = new ControlSiembra(
                    cmbCodigo.getValue().getCodigo(),
                    tipo_siembra.getValue().toString(),
                    cmbRiego.getValue().toString(),
                    cmbFertilizacion.getValue().toString(),
                    cmbAplicaIsecticida.getValue().toString(),
                    cmbLimpieza.getValue().toString());

            String respuesta = interactor.agregarControlSiembras(controlSiembras);
            if (respuesta != null) {
                new Notificaciones("Datos almacenados correctamente", 2, 7);
                clearForm();
            }
            else
                new Notificaciones("No se pudo almacenar la información", 1, 7);
        });

        bCancelar.addClickListener(buttonClickEvent -> {
            clearForm();});

    }

    private Component createTitle() {
        return new H3("Nuevo Control Siembra");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();

        tipo_siembra.setReadOnly(true);

        formLayout.add(cmbCodigo, tipo_siembra, cmbRiego, cmbFertilizacion, cmbAplicaIsecticida, cmbLimpieza);
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

    private void DatosComboBox() {
        cmbCodigo.setItems(interactor.consultarRegistroSiembras());
        cmbCodigo.setItemLabelGenerator(RegistroSiembras::getCodigo);

        cmbRiego.setItems("Diario", "Semanal", "Quincenal", "Mensual");
        cmbFertilizacion.setItems("Diario", "Semanal", "Quincenal", "Mensual");
        cmbAplicaIsecticida.setItems("Diario", "Semanal", "Quincenal", "Mensual");
        cmbLimpieza.setItems("Diario", "Semanal", "Quincenal", "Mensual");
    }

    private void clearForm()
    {
        cmbCodigo.setItems(interactor.consultarRegistroSiembras());
        cmbCodigo.setItemLabelGenerator(RegistroSiembras::getCodigo);
        tipo_siembra.clear();
        cmbRiego.setValue("");
        cmbFertilizacion.setValue("");
        cmbAplicaIsecticida.setValue("");
        cmbLimpieza.setValue("");
    }

}
