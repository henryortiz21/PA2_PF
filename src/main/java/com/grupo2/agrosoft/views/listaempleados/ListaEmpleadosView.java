package com.grupo2.agrosoft.views.listaempleados;

import java.util.List;

import com.grupo2.agrosoft.controller.BaseDatosInteractor;
import com.grupo2.agrosoft.controller.BaseDatosInteractorImpl;
import com.grupo2.agrosoft.data.entity.Proveedor;
import com.grupo2.agrosoft.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Empleados")
@Route(value = "empleados", layout = MainLayout.class)
public class ListaEmpleadosView extends Div implements BeforeEnterObserver{

    private Grid<Proveedor> grid = new Grid<>(Proveedor.class, false);
    private BaseDatosInteractor interactor;

    public ListaEmpleadosView() {
        addClassNames("prueba", "flex", "flex-col", "h-full");
        setSizeFull();

        interactor = new BaseDatosInteractorImpl("https://apex.oracle.com", 30000L);
        List<Proveedor> proveedorList  = interactor.consultarProveedores();

        VerticalLayout layout = new VerticalLayout();
        layout.setPadding(false);
        layout.getStyle().set("background-color", "transparent");
        layout.getStyle().set("background", "transparent");
        layout.setSpacing(true);
        layout.setSizeFull();

        //CONFIGURACION DEL GRID
        grid.addColumn("id").setAutoWidth(true);
        grid.addColumn("nombre").setAutoWidth(true);
        grid.addColumn("direccion").setAutoWidth(true);
        grid.addColumn("telefono").setAutoWidth(true);
        grid.setDataProvider(new ListDataProvider<>(proveedorList));
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setHeightFull();

        createGridLayout(layout);
        add(layout);

        //for(Proveedor pro:proveedorList){
        //    Notification.show(""+pro.getId()+"   "+pro.getNombre()+pro.getDireccion());    
        //}

    }

    private void createGridLayout(VerticalLayout layout) {
        Div wrapper = new Div();
        wrapper.setId("grid-wrapper");
        wrapper.setSizeFull();
        wrapper.add(grid);
        layout.add(wrapper);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        refreshGrid();
    }

    private void refreshGrid() {
        grid.select(null);
        grid.getDataProvider().refreshAll();
    }

}
