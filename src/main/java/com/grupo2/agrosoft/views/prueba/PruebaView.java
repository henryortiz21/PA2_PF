package com.grupo2.agrosoft.views.prueba;

import java.util.Arrays;
import java.util.List;

import com.grupo2.agrosoft.data.entity.Proveedor;
import com.grupo2.agrosoft.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Prueba GRID")
@Route(value = "prueba", layout = MainLayout.class)
public class PruebaView extends Div {

    private Grid<Proveedor> grid;
    private ListDataProvider<Proveedor> dataProvider;
    private String ID_pro="";

    private Grid.Column<Proveedor> idColumn;
    private Grid.Column<Proveedor> clientColumn;
    // private Grid.Column<Proveedor> amountColumn;
    // private Grid.Column<Proveedor> statusColumn;
    // private Grid.Column<Proveedor> dateColumn;

    public PruebaView() {
        addClassName("hello-world-view");
        setSizeFull();
        createGrid();
        add(grid);

        grid.addItemClickListener(e->{
            ID_pro=e.getItem().getId().toString();
            Notification.show(ID_pro);
        });
    }

    private void createGrid() {
        createGridComponent();
        addColumnsToGrid();
        // addFiltersToGrid();
    }

    private void createGridComponent() {
        grid = new Grid<>();
        // grid.setSelectionMode(SelectionMode.MULTI);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_COLUMN_BORDERS);
        grid.setHeight("100%");

        dataProvider = new ListDataProvider<>(getProveedores());
        grid.setDataProvider(dataProvider);
    }

    private void addColumnsToGrid() {
        createIdColumn();
        createNombreColumn();
        // createAmountColumn();
        // createStatusColumn();
        // createDateColumn();
    }

    private void createIdColumn() {
        idColumn = grid.addColumn(Proveedor::getId, "id").setHeader("ID").setWidth("120px").setFlexGrow(0);
    }

    private void createNombreColumn() {
        clientColumn = grid.addColumn(new ComponentRenderer<>(proveedor -> {
            HorizontalLayout hl = new HorizontalLayout();
            hl.setAlignItems(Alignment.CENTER);
            Image img = new Image(proveedor.getLogo(), "");
            img.setClassName("grid-img");
            Span span = new Span();
            span.setClassName("name");
            span.setText(proveedor.getNombre());
            hl.add(img, span);
            return hl;
        })).setComparator(proveedor -> proveedor.getNombre()).setHeader("Client");
    }

    /*
     * private void createStatusColumn() {
     * statusColumn = grid.addEditColumn(Client::getClient, new
     * ComponentRenderer<>(client -> {
     * Span span = new Span();
     * span.setText(client.getStatus());
     * span.getElement().setAttribute("theme", "badge " +
     * client.getStatus().toLowerCase());
     * return span;
     * })).select((item, newValue) -> item.setStatus(newValue),
     * Arrays.asList("Pending", "Success", "Error"))
     * .setComparator(client -> client.getStatus()).setHeader("Status");
     * }
     */
    // private void createDateColumn() {
    // dateColumn = grid
    // .addColumn(new LocalDateRenderer<>(client ->
    // LocalDate.parse(client.getDate()),
    // DateTimeFormatter.ofPattern("M/d/yyyy")))
    // .setComparator(client ->
    // client.getDate()).setHeader("Date").setWidth("180px").setFlexGrow(0);
    // }

    // private boolean areStatusesEqual(Client client, ComboBox<String>
    // statusFilter) {
    // String statusFilterValue = statusFilter.getValue();
    // if (statusFilterValue != null) {
    // return StringUtils.equals(client.getStatus(), statusFilterValue);
    // }
    // return true;
    // }
    /*
     * private boolean areDatesEqual(Client client, DatePicker dateFilter) {
     * LocalDate dateFilterValue = dateFilter.getValue();
     * if (dateFilterValue != null) {
     * LocalDate clientDate = LocalDate.parse(client.getDate());
     * return dateFilterValue.equals(clientDate);
     * }
     * return true;
     * }
     */
    private List<Proveedor> getProveedores() {
        return Arrays.asList(
                createProveedor(1, "Proveedor de prueba 1", "San pedro sula, Honduras", "88484567",
                        "","https://www.dropbox.com/s/oizmlg9fiqrho1d/agro.png?dl=1"),
                createProveedor(2, "Proveedor de prueba 2", "San pedro sula, Honduras", "88484567",
                        "", "https://randomuser.me/api/portraits/women/43.jpg"));
    }

    private Proveedor createProveedor(int id, String nombre, String direccion,
            String telefono, String web, String logo) {
        Proveedor p = new Proveedor();
        p.setId(id);
        p.setNombre(nombre);
        p.setDireccion(direccion);
        p.setTelefono(telefono);
        p.setWeb(web);
        p.setLogo(logo);
        return p;
    }
}