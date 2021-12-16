package com.grupo2.agrosoft.views.nuevasiembra;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.grupo2.agrosoft.controller.BaseDatosInteractor;
import com.grupo2.agrosoft.controller.BaseDatosInteractorImpl;
import com.grupo2.agrosoft.data.entity.Semilla;
import com.grupo2.agrosoft.data.entity.Siembra;
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

@PageTitle("Nueva siembra")
@Route(value = "nuevasiembra", layout = MainLayout.class)
public class NuevaSiembraView extends Div {
    private Integer produccion_mts = 0, dias_cosecha = 0;
    private BaseDatosInteractor interactor;

    private TextField descripcion = new TextField("Descripción");
    private TextArea ubicacion = new TextArea("Ubicacion");
    private TextField dimensiones = new TextField("Dimensiones");
    private ComboBox<String> tipo_siembra = new ComboBox<>("Tipo siembra");
    private DatePicker f_siembra = new DatePicker("Fecha de siembra", LocalDate.now());
    private TextField f_cosecha = new TextField("Fecha proxima de cosecha");
    private TextField cosecha_aproximada = new TextField("Cosecha aproximada");
    private DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private List<Semilla> list_Semilla = new ArrayList<>();
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
            String t_s = tipo_siembra.getValue().substring(tipo_siembra.getValue().indexOf("  "));
            Integer t_d=Integer.valueOf(cosecha_aproximada.getValue());
            Siembra siembra = new Siembra(
                    descripcion.getValue(),
                    ubicacion.getValue(),
                    Integer.valueOf(dimensiones.getValue()),
                    t_s,//Tipo siembra
                    fecha_siembra,
                    f_cosecha.getValue(),
                    t_d);
            String respuesta = interactor.agregarSiembra(siembra);
            if (respuesta != null)
                new Notificaciones("Datos almacenados correctamente", 2, 7);
            else
                new Notificaciones("No se pudo almacenar la informacion", 1, 7);
        });

        f_siembra.addValueChangeListener(e -> {
            calcular();
        });
        tipo_siembra.addValueChangeListener(e -> {
            String va = tipo_siembra.getValue().toString().substring(0,
                    tipo_siembra.getValue().toString().indexOf("  "));
            produccion_mts = list_Semilla.get((Integer.valueOf(va) - 1)).getProduccio_por_metro2();
            dias_cosecha = list_Semilla.get((Integer.valueOf(va) - 1)).getTiempo_cosecha();
            calcular();
        });
        obtenerSemillas();
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

    private void obtenerSemillas() {
        list_Semilla = interactor.consultarSemillas();
        if (list_Semilla != null)
            new Notificaciones("Datos alquiridos", 2, 7);
        else {
            list_Semilla = new ArrayList<>();
            new Notificaciones("No se encontraron datos", 1, 7);
        }
        List<String> lista = new ArrayList<>();
        int a = 1;
        for (Semilla nombre : list_Semilla) {
            lista.add(a + "  " + nombre.getNombre());
            a++;
        }
        tipo_siembra.setItems(lista);
    }

    private void calcular() {
        LocalDate f = f_siembra.getValue();
        f = f.plusDays(dias_cosecha);
        String f_proxima = f.format(dtformat);
        f_cosecha.setValue(f_proxima);
        Integer dim = dimensiones.getValue().isBlank() ? 0 : Integer.parseInt(dimensiones.getValue());
        cosecha_aproximada.setValue("" + (dim * produccion_mts));
    }
}
