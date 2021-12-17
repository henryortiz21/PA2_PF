package com.grupo2.agrosoft.views.listaparcelas;

import java.util.ArrayList;
import java.util.List;

import com.grupo2.agrosoft.controller.BaseDatosInteractor;
import com.grupo2.agrosoft.controller.BaseDatosInteractorImpl;
import com.grupo2.agrosoft.data.entity.Parcelas;
import com.grupo2.agrosoft.views.MainLayout;
import com.grupo2.agrosoft.views.notificaciones.Notificaciones;
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

@PageTitle("Parcelas")
@Route(value = "parcelas", layout = MainLayout.class)
public class ListaParcelasView extends Div {
	private Integer ID = 0;
	private Grid<Parcelas> grid = new Grid<>(Parcelas.class, false);
	private List<Parcelas> lista_parcelas = new ArrayList<>();
	private BaseDatosInteractor interactor;

	private Button bNuevo = new Button("Nueva parcela", new Icon(VaadinIcon.PLUS_CIRCLE));
	private Button bEliminar = new Button("Eliminar parcela", new Icon(VaadinIcon.CLOSE_SMALL));

	public ListaParcelasView() {
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
		grid.addColumn("nombre").setAutoWidth(true);
		grid.addColumn("descripcion").setAutoWidth(true);
		grid.addColumn("ubicacion").setAutoWidth(true);
		grid.addColumn("ancho").setAutoWidth(true);
		grid.addColumn("largo").setAutoWidth(true);
		grid.addColumn("dimension_met2").setAutoWidth(true).setHeader("Dimensiones m²");
		grid.addColumn("estatus").setAutoWidth(true).setHeader("Estado");
		grid.setDataProvider(new ListDataProvider<>(lista_parcelas));
	}

	private Component buttonActions() {
		HorizontalLayout hl = new HorizontalLayout();
		hl.setJustifyContentMode(JustifyContentMode.CENTER);
		hl.setAlignItems(Alignment.CENTER);
		bNuevo.addThemeVariants(ButtonVariant.LUMO_LARGE);
		bNuevo.addClassName("buttonadd");
		bEliminar.addThemeVariants(ButtonVariant.LUMO_LARGE);
		//bBorrar.setEnabled(false);
		hl.add(bNuevo, bEliminar);
		hl.getStyle().set("padding-left", "10px");
		return hl;
	}

	private void cargar_datos() {
		lista_parcelas = interactor.consultarParcelas();
		if (lista_parcelas == null)
			lista_parcelas = new ArrayList<>();
		grid.select(null);
		grid.getDataProvider().refreshAll();
	}

	private void eventos() {
		grid.asSingleSelect().addValueChangeListener(e -> {
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
			UI.getCurrent().navigate(ListaParcelasView.class);
		});

		bEliminar.addClickListener(e -> {
			String r = interactor.eliminarParcelas(ID);
			if (r != null)
				new Notificaciones("Parcela eliminada satisfactoriamente", 2, 7);
			else
				new Notificaciones("No se pudo eliminar la parcela seleccionada", 1, 7);
		});
	}
}
