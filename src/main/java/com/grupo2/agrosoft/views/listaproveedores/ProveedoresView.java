package com.grupo2.agrosoft.views.listaproveedores;

import java.util.ArrayList;
import java.util.List;

import com.grupo2.agrosoft.controller.BaseDatosInteractor;
import com.grupo2.agrosoft.controller.BaseDatosInteractorImpl;
import com.grupo2.agrosoft.data.entity.Proveedor;
import com.grupo2.agrosoft.views.MainLayout;
import com.grupo2.agrosoft.views.notificaciones.Notificaciones;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Proveedores")
@Route(value = "proveedores", layout = MainLayout.class)
public class ProveedoresView extends Div {

	private Integer ID_proveedor = 0;

	private Grid<Proveedor> grid = new Grid<>(Proveedor.class, false);
	private List<Proveedor> lista_proveedores = new ArrayList<>();
	private BaseDatosInteractor interactor;

	private Image logo;
	private TextArea txtLogo;
	private TextField nombre;
	private TextField telefono;
	private TextArea direccion;
	private TextArea web;

	private Icon iok = new Icon(VaadinIcon.CHECK);
	private Icon icancel = new Icon(VaadinIcon.CLOSE_SMALL);
	private Button bGuardar = new Button("Guardar", iok);
	private Button bCancelar = new Button("Cancelar", icancel);

	public ProveedoresView() {
		addClassNames("proveedores-view", "flex", "flex-col", "h-full");

		interactor = new BaseDatosInteractorImpl("https://apex.oracle.com", 30000L);
		lista_proveedores = interactor.consultarProveedores();
		if (lista_proveedores == null)
			lista_proveedores = new ArrayList<>();

		SplitLayout splitLayout = new SplitLayout();
		splitLayout.setSizeFull();

		createGridLayout(splitLayout);
		createEditorLayout(splitLayout);
		splitLayout.getStyle().set("margin-top", "0px");
		add(splitLayout);

		eventos();
	}

	private void createEditorLayout(SplitLayout splitLayout) {
		Div editorLayoutDiv = new Div();
		editorLayoutDiv.setClassName("flex flex-col");
		editorLayoutDiv.setWidth("350px");
		editorLayoutDiv.setMaxWidth("500px");
		editorLayoutDiv.setMinWidth("350px");

		Div editorDiv = new Div();
		editorDiv.setClassName("p-l flex-grow");
		editorDiv.getStyle().set("padding-top", "0px");
		editorLayoutDiv.add(editorDiv);

		FormLayout formLayout = new FormLayout();
		Div vl = new Div();
		vl.getStyle().set("padding-top", "10px");
		vl.setWidthFull();

		vl.addClassName("vl");

		HorizontalLayout hl = new HorizontalLayout();
		hl.setWidthFull();
		hl.setPadding(false);
		hl.getStyle().set("margin-top", "0px");
		logo = new Image("images/proveedor.png", "");

		txtLogo = new TextArea();
		txtLogo.setLabel("url logo de la empresa");
		txtLogo.getStyle().set("padding", "0px");
		txtLogo.setWidthFull();
		nombre = new TextField("Nombre");
		telefono = new TextField("Telefono");
		direccion = new TextArea("Direccion");
		web = new TextArea("Sitio web");

		hl.add(txtLogo);
		vl.add(logo, hl);

		Component[] fields = new Component[] { nombre, telefono, direccion, web };
		formLayout.add(fields);
		editorDiv.add(vl);
		editorDiv.add(formLayout);
		createButtonLayout(editorLayoutDiv);

		splitLayout.addToSecondary(editorLayoutDiv);
	}

	private void createButtonLayout(Div editorLayoutDiv) {
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setClassName("w-full flex-wrap bg-contrast-5 py-s px-l");
		buttonLayout.setSpacing(true);
		bGuardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		buttonLayout.add(bGuardar, bCancelar);
		editorLayoutDiv.add(buttonLayout);
	}

	private void createGridLayout(SplitLayout splitLayout) {
		Div wrapper = new Div();
		wrapper.setId("grid-wrapper");
		wrapper.setWidthFull();
		splitLayout.addToPrimary(wrapper);
		wrapper.add(grid);

		grid.addColumn("id").setAutoWidth(true);
		grid.addColumn("nombre").setAutoWidth(true);
		grid.addColumn("telefono").setAutoWidth(true);
		grid.addColumn("direccion").setAutoWidth(true);
		grid.addColumn("web").setAutoWidth(true);
		grid.setDataProvider(new ListDataProvider<>(lista_proveedores));
		grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
				GridVariant.LUMO_ROW_STRIPES);
		grid.setHeightFull();
	}

	private void refreshGrid() {
		grid.select(null);
		grid.getDataProvider().refreshAll();
	}

	private void clearForm() {
		populateForm(null);
		ID_proveedor = 0;
	}

	private void populateForm(Proveedor v) {
		logo.setSrc(v == null ? "images/proveedor.png" : v.getLogo());
		txtLogo.setValue(v == null ? "" : v.getLogo());
		txtLogo.setReadOnly(v == null ? false : true);
		nombre.setValue(v == null ? "" : v.getNombre());
		nombre.setReadOnly(v == null ? false : true);
		telefono.setValue(v == null ? "" : v.getTelefono());
		telefono.setReadOnly(v == null ? false : true);
		direccion.setValue(v == null ? "" : v.getDireccion());
		direccion.setReadOnly(v == null ? false : true);
		web.setValue(v == null ? "" : v.getWeb());
		web.setReadOnly(v == null ? false : true);
		bGuardar.setText(v == null ? "Guardar" : "Nuevo proveedor");
		bCancelar.setText(v == null ? "Cancelar" : "Eliminar");
		bGuardar.setIcon(v == null ? new Icon(VaadinIcon.CHECK) : new Icon(VaadinIcon.ARROW_CIRCLE_LEFT_O));
		if (v == null) {
			bCancelar.removeClassName("buttondel");
		} else {
			bCancelar.addClassName("buttondel");
		}
		ID_proveedor = v == null ? 0 : ID_proveedor;
	}

	private void guardar_datos() {
		Proveedor proveedor = new Proveedor(
				nombre.getValue(),
				telefono.getValue(),
				direccion.getValue(),
				web.getValue(),
				txtLogo.getValue());

		String respuesta = interactor.agregarProveedor(proveedor);
		if (respuesta != null)
			Notification.show("Se Guardo");
		else
			Notification.show("No se guardo");
	}

	private void eventos() {
		txtLogo.addBlurListener(e -> {
			if (!e.getSource().getValue().trim().isBlank()) {
				logo.setSrc(e.getSource().getValue().trim());
			} else {
				logo.setSrc("images/proveedor.png");
			}
		});
		grid.asSingleSelect().addValueChangeListener(e -> {
			if (e.getValue() != null) {
				ID_proveedor = e.getValue().getId();
				populateForm(e.getValue());
				// lista_proveedores.remove(e.getValue());
			} else {
				clearForm();
			}
		});

		bCancelar.addClickListener(e -> {
			if (ID_proveedor == 0) {
				clearForm();
				refreshGrid();
				txtLogo.focus();
			} else {
				Notification.show(""+lista_proveedores.listIterator().nextIndex());
				/*
				 * String resp = interactor.eliminarProveedor(ID_proveedor);
				 * if (resp != null){
				 * new Notificaciones("El proveedor fue eliminado exitosamente",2,7);
				 * grid.getSelectedItems();
				 * clearForm();
				 * }else{
				 * new Notificaciones("El proveedor fue eliminado exitosamente",1,7);
				 * }
				 */
			}
		});

		bGuardar.addClickListener(e -> {
			if (ID_proveedor == 0) {
				guardar_datos();
			} else {
				clearForm();
				refreshGrid();
				txtLogo.focus();
			}
		});

	}

}
