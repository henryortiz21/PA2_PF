package com.grupo2.agrosoft.views.ListaSiembras;

import java.util.ArrayList;
import java.util.List;

import com.grupo2.agrosoft.controller.BaseDatosInteractor;
import com.grupo2.agrosoft.controller.BaseDatosInteractorImpl;
import com.grupo2.agrosoft.data.entity.RegistroSiembras;
import com.grupo2.agrosoft.views.MainLayout;
import com.grupo2.agrosoft.views.Notificaciones.Notificaciones;
import com.grupo2.agrosoft.views.ViewRegistroSiembras.RegistroSiembrasAddView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Lista Registro Siembras")
@Route(value = "listaregistrosiembras", layout = MainLayout.class)
public class ListaRegistroSiembrasView extends Div {
	private Integer ID = 0;
	private Grid<RegistroSiembras> grid = new Grid<>(RegistroSiembras.class, false);
	private List<RegistroSiembras> lista_Siembras = new ArrayList<>();
	private RegistroSiembras item;
	private BaseDatosInteractor interactor;

	private Button bNuevo = new Button("Nuevo Registro Siembra", new Icon(VaadinIcon.PLUS_CIRCLE));
	private Button bEliminar = new Button("Eliminar Registro Siembra", new Icon(VaadinIcon.TRASH));

	public ListaRegistroSiembrasView() {
		addClassNames("parcelas-view", "flex", "flex-col", "h-full");
		setSizeFull();
		interactor = new BaseDatosInteractorImpl("https://apex.oracle.com", 30000L);
		cargar_datos();

		VerticalLayout prinLayout = new VerticalLayout();
		prinLayout.setSizeFull();
		prinLayout.setPadding(false);
		prinLayout.setSpacing(false);

		VerticalLayout layout = new VerticalLayout();
		layout.setPadding(false);
		layout.setMargin(false);
		layout.setSpacing(true);
		layout.setSizeFull();

		add(prinLayout);
		createGridLayout(layout);
		prinLayout.add(buttonActions(), layout);
		eventos();
		refreshGrid();
	}

	private void createGridLayout(VerticalLayout layout) {
		Div wrapper = new Div();
		wrapper.setId("grid-wrapper");
		wrapper.setSizeFull();
		wrapper.getStyle().set("margin", "0px");
		wrapper.add(grid);
		layout.addComponentAsFirst(buttonActions());
		layout.add(wrapper);
		layout.getStyle().set("overflow", "auto");
		grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS,
				GridVariant.LUMO_ROW_STRIPES);
		grid.setHeightFull();

		grid.addColumn("id").setAutoWidth(true);
		grid.addColumn("codigo").setAutoWidth(true).setHeader("Codigo");
		grid.addColumn("tiposiembra").setAutoWidth(true).setHeader("Tipo Siembra");
		grid.addColumn("parcela").setAutoWidth(true).setHeader("Parcela");
		grid.addColumn("descripcion").setAutoWidth(true).setHeader("Descripción");
		grid.addColumn("ubicacion").setAutoWidth(true).setHeader("Ubicacion");
		grid.addColumn("dimension_met2").setAutoWidth(true).setHeader("Dimensiones M2");
		grid.addColumn("producto_x_met2").setAutoWidth(true).setHeader("Producto x M2");
		grid.addColumn("fechasiembra").setAutoWidth(true).setHeader("Fecha Siembra");
		grid.addColumn("fecha_cosecha").setAutoWidth(true).setHeader("Fecha Cosecha");
		grid.addColumn("cantidadaproximacosechar").setAutoWidth(true).setHeader("Cant.Cosecha Aproximada");
		grid.addColumn("estatus").setAutoWidth(true).setHeader("Estatus");

		grid.setDataProvider(new ListDataProvider<>(lista_Siembras));
	}

	private Component buttonActions() {
		HorizontalLayout hl = new HorizontalLayout();
		hl.setJustifyContentMode(JustifyContentMode.CENTER);
		hl.setAlignItems(Alignment.CENTER);
		bNuevo.addThemeVariants(ButtonVariant.LUMO_LARGE);
		bNuevo.addClassName("buttonadd");
		bEliminar.addThemeVariants(ButtonVariant.LUMO_LARGE);
		bEliminar.setEnabled(false);
		hl.add(bNuevo, bEliminar);
		hl.getStyle().set("padding-left", "10px");
		return hl;
	}

	private void cargar_datos() {
		lista_Siembras = interactor.consultarRegistroSiembras();
		if (lista_Siembras == null)
			lista_Siembras = new ArrayList<>();
	}

	private void refreshGrid() {
		grid.select(null);
		grid.getDataProvider().refreshAll();
	}

	private void eventos() {
		grid.asSingleSelect().addValueChangeListener(e -> {
			item=e.getValue();
			if (e.getValue() != null) {
				ID = e.getValue().getId();
				bEliminar.setEnabled(true);
				bEliminar.addClassName("buttondel");
			} else {
				ID = 0;
				bEliminar.removeClassName("buttondel");
				bEliminar.setEnabled(false);
			}
		});

		bNuevo.addClickListener(e -> {
			UI.getCurrent().navigate(RegistroSiembrasAddView.class);
		});

		bEliminar.addClickListener(e -> {
			String r = interactor.eliminarRegistroSiembras(ID);
			if (r != null){
				new Notificaciones("Registro Siembra eliminado satisfactoriamente", 2, 7);
				lista_Siembras.remove(item);
				refreshGrid();
			}else
				new Notificaciones("No se pudo eliminar la semilla seleccionada", 1, 7);
		});
	}
}
