package com.grupo2.agrosoft.views.RegistroSiembras;

import com.grupo2.agrosoft.controller.BaseDatosInteractor;
import com.grupo2.agrosoft.controller.BaseDatosInteractorImpl;
import com.grupo2.agrosoft.data.entity.Parcelas;
import com.grupo2.agrosoft.data.entity.RegistroSiembras;
import com.grupo2.agrosoft.data.entity.Semilla;
import com.grupo2.agrosoft.views.MainLayout;
import com.grupo2.agrosoft.views.notificaciones.Notificaciones;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@PageTitle("Nuevo Registro Siembras")
@Route(value = "nuevoregistrosiembras", layout = MainLayout.class)
public class RegistroSiembrasAddView extends Div {
    private Integer produccion_mts = 0, dias_cosecha = 0;
    private BaseDatosInteractor interactor;

    private TextField codigo = new TextField("Código");
    private ComboBox<Parcelas> cmbParcelas = new ComboBox<>("Parcelas");
    private TextField descripcion = new TextField("Descripción");
    private TextArea ubicacion = new TextArea("Ubicacion");
    private TextField dimensiones = new TextField("Dimensiones Metro Cuadrado");
    private TextField producto = new TextField("Producto Por Metro Cuadrado");
    private ComboBox<Semilla> cmbTipo_siembra = new ComboBox<>("Tipo Siembra");
    private DatePicker f_siembra = new DatePicker("Fecha Siembra", LocalDate.now());
    private TextField f_cosecha = new TextField("Fecha Cosecha");
    private TextField cosecha_aproximada = new TextField("Cantidad de Cosecha Aproximada");
    private ComboBox<String> cmbEstatus = new ComboBox<>("Estatus");

    private DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Button bGuardar = new Button("Guardar");
    private Button bCancelar = new Button("Cancelar");

    public RegistroSiembrasAddView() {
        addClassName("nuevoregistrosiembras-view");
        interactor = new BaseDatosInteractorImpl("https://apex.oracle.com", 30000L);
        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        DatosComboBox();

        cmbParcelas.addValueChangeListener(e->{
            descripcion.setValue(cmbParcelas.getValue().getDescripcion());
            ubicacion.setValue(cmbParcelas.getValue().getUbicacion());
            dimensiones.setValue(cmbParcelas.getValue().getDimension_met2().toString());
            Calcular();
        });

        cmbTipo_siembra.addValueChangeListener(e->{
            producto.setValue(cmbTipo_siembra.getValue().getProduccio_por_metro2().toString());
            Calcular();
        });

        f_siembra.addValueChangeListener(e -> {
            Calcular();
        });

        bGuardar.addClickListener(e -> {
            String fecha_siembra = f_siembra.getValue().format(dtformat);
            RegistroSiembras registroSiembras = new RegistroSiembras(
                    codigo.getValue(),
                    cmbTipo_siembra.getValue().getNombre(),
                    cmbParcelas.getValue().getNombre(),
                    descripcion.getValue(),
                    ubicacion.getValue(),
                    Integer.parseInt(dimensiones.getValue()),
                    Integer.parseInt(producto.getValue()),
                    fecha_siembra,
                    f_cosecha.getValue(),
                    Integer.parseInt(cosecha_aproximada.getValue()),
                    cmbEstatus.getValue().toString());

            String respuesta = interactor.agregarRegistroSiembras(registroSiembras);
            if (respuesta != null) {
                new Notificaciones("Datos almacenados correctamente", 2, 7);
                clearForm();
            }
            else
                new Notificaciones("No se pudo almacenar la información", 1, 7);
        });

        bCancelar.addClickListener(buttonClickEvent -> {
            clearForm();
        });

    }

    private Component createTitle() {
        return new H3("Nuevo Registro Siembra");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();

        codigo.setReadOnly(true);
        descripcion.setReadOnly(true);
        ubicacion.setReadOnly(true);
        f_cosecha.setReadOnly(true);
        dimensiones.setReadOnly(true);
        producto.setReadOnly(true);
        cosecha_aproximada.setReadOnly(true);

        formLayout.add(codigo, cmbTipo_siembra, cmbParcelas, descripcion, ubicacion, dimensiones, producto
                ,f_siembra, f_cosecha, cosecha_aproximada, cmbEstatus);
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
        cmbParcelas.setItems(interactor.consultarParcelas());
        cmbParcelas.setItemLabelGenerator(Parcelas::getNombre);

        cmbTipo_siembra.setItems(interactor.consultarSemillas());
        cmbTipo_siembra.setItemLabelGenerator(Semilla::getNombre);

        cmbEstatus.setItems("En Proceso", "Finalizado");
        cmbEstatus.setValue("En Proceso");
    }

    private void Calcular() {
        LocalDate f = f_siembra.getValue();
        f = f.plusDays(cmbTipo_siembra.getValue().getTiempo_cosecha());
        String f_proxima = f.format(dtformat);
        f_cosecha.setValue(f_proxima);

        Integer ProduccionTotal = cmbParcelas.getValue().getDimension_met2() * cmbTipo_siembra.getValue().getProduccio_por_metro2();
        cosecha_aproximada.setValue(ProduccionTotal.toString());
        codigo.setValue(cmbParcelas.getValue().getNombre() + "-" + f_siembra.getValue().format(dtformat));
    }

    private void clearForm(){
        codigo.clear();
        descripcion.clear();
        ubicacion.clear();
        dimensiones.clear();
        producto.clear();
        f_siembra.clear();
        f_cosecha.clear();
        cosecha_aproximada.clear();

        DatosComboBox();
    }
}
