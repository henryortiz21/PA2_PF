package com.grupo2.agrosoft.views.inicio;

import com.grupo2.agrosoft.data.entity.ImageCard;
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

@PageTitle("Inicio")
@Route(value = "inicio", layout = MainLayout.class)
//@RouteAlias(value = "", layout = MainLayout.class)
public class InicioView extends Div {

    public InicioView() {
        addClassNames("inicio-view", "flex", "h-full");

        add(createCard(new ImageCard("Semillas", "images/semillas.png"),ProveedoresView.class));
        add(createCard(new ImageCard("Siembra", "images/siembra.png"),ProveedoresView.class));
        add(createCard(new ImageCard("Manteminiento", "images/mantenimiento.png"),ProveedoresView.class));
        add(createCard(new ImageCard("Productos", "images/img3.png"),ListaEmpleadosView.class));

    }

    public Component createCard(ImageCard imagecard, Class nav) {
        Div con = new Div();
        con.addClassName("card");
        Image img = new Image(imagecard.getImagen(), "");
        Span badge = new Span(imagecard.getTitulo());
        badge.setEnabled(false);
        con.add(img, badge);
        con.addClickListener(e->{
            UI.getCurrent().navigate(nav);
        });
        return con;
    }
}