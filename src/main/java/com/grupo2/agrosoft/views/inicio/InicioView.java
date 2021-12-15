package com.grupo2.agrosoft.views.inicio;

import com.grupo2.agrosoft.views.MainLayout;
import com.grupo2.agrosoft.views.listaempleados.ListaEmpleadosView;
import com.grupo2.agrosoft.views.listaproveedores.ProveedoresView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Inicio")
@Route(value = "inicio", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class InicioView extends Div {

    public InicioView() {
        addClassNames("inicio-view", "flex", "h-full");

        add(createCard("Semillas", "images/semillas.png",ProveedoresView.class));
        add(createCard("Siembra", "images/siembra.png",ProveedoresView.class));
        add(createCard("Manteminiento", "images/mantenimiento.png",ProveedoresView.class));
        add(createCard("Productos", "images/img3.png",ListaEmpleadosView.class));

    }

    public Component createCard(String titulo, String imagen, Class nav) {
        Div con = new Div();
        con.addClassName("card");
        Image img = new Image(imagen, "");
        Span badge = new Span(titulo);
        badge.setEnabled(false);
        con.add(img, badge);
        con.addClickListener(e->{
            UI.getCurrent().navigate(nav);
        });
        return con;
    }
}