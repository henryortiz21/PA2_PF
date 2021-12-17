package com.grupo2.agrosoft.views.Inicio;

import com.grupo2.agrosoft.views.ListaControlSiembras.ListaControlSiembrasView;
import com.grupo2.agrosoft.views.ListaParcelas.ListaParcelasView;
import com.grupo2.agrosoft.views.ListaSemillas.ListaSemillasView;
import com.grupo2.agrosoft.views.ListaSiembras.ListaRegistroSiembrasView;
import com.grupo2.agrosoft.views.MainLayout;
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

        add(createCard("Parcelas", "images/parcelas.jpg", ListaParcelasView.class));
        add(createCard("Semillas", "images/semillas.png", ListaSemillasView.class));
        add(createCard("Siembra", "images/siembra.png", ListaRegistroSiembrasView.class));
        add(createCard("Control Siembras", "images/mantenimiento.png", ListaControlSiembrasView.class));

    }

    public <T> Component createCard(String titulo, String imagen, Class<T> nav) {
        Div con = new Div();
        con.addClassName("card");
        Image img = new Image(imagen, "");
        Span badge = new Span(titulo);
        badge.setEnabled(false);
        con.add(img, badge);
        con.addClickListener(e->{
            UI.getCurrent().navigate((Class<? extends Component>)nav);
        });
        return con;
    }
}