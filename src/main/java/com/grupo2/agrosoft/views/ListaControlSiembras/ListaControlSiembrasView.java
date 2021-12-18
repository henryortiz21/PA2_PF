package com.grupo2.agrosoft.views.ListaControlSiembras;

import java.util.ArrayList;
import java.util.List;

import com.grupo2.agrosoft.controller.BaseDatosInteractor;
import com.grupo2.agrosoft.controller.BaseDatosInteractorImpl;
import com.grupo2.agrosoft.data.entity.ControlSiembra;
import com.grupo2.agrosoft.views.MainLayout;
import com.grupo2.agrosoft.views.Notificaciones.Notificaciones;
import com.grupo2.agrosoft.views.ViewControlSiembras.ControlSiembrasAddView;
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

@PageTitle("Lista Control Siembras")
@Route(value = "listacontrolsiembras", layout = MainLayout.class)
public class ListaControlSiembrasView extends Div {
	private Integer ID = 0;
	private Grid<ControlSiembra> grid = new Grid<>(ControlSiembra.class, false);
	private List<ControlSiembra> controlSiembras = new ArrayList<>();
	private ControlSiembra item;
	private BaseDatosInteractor interactor;

	private Button bNuevo = new Button("Nuevo Control Siembra", new Icon(VaadinIcon.PLUS_CIRCLE));
	private Button bEliminar = new Button("Eliminar Control Siembra", new Icon(VaadinIcon.TRASH));

	public ListaControlSiembrasView() {
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
		grid.addColumn("codigo").setAutoWidth(true).setHeader("Código");
		grid.addColumn("tipo_siembra").setAutoWidth(true).setHeader("Tipo Siembra");
		grid.addColumn("riego").setAutoWidth(true).setHeader("Riego");
		grid.addColumn("fertilizacion").setAutoWidth(true).setHeader("Fertilización");
		grid.addColumn("aplicacioninsecticida").setAutoWidth(true).setHeader("Aplicación Insecticida");
		grid.addColumn("limpieza").setAutoWidth(true).setHeader("Limpieza");

		grid.setDataProvider(new ListDataProvider<>(controlSiembras));
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
		controlSiembras = interactor.consultarControlSiembras();
		if (controlSiembras == null)
			controlSiembras = new ArrayList<>();
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
			UI.getCurrent().navigate(ControlSiembrasAddView.class);
		});

		bEliminar.addClickListener(e -> {
			String r = interactor.eliminarControlSiembras(ID);
			if (r != null){
				new Notificaciones("Control Siembra eliminado satisfactoriamente", 2, 7);
				controlSiembras.remove(item);
				refreshGrid();
			}else
				new Notificaciones("No se pudo eliminar el Control Siembra seleccionada", 1, 7);
		});
	}
}
