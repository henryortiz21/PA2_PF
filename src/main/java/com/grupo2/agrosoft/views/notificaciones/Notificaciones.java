package com.grupo2.agrosoft.views.notificaciones;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;

public class Notificaciones {

    public Notificaciones(String mensaje, int codigo, int pos) {
        Notification notification = new Notification();
        notification.setDuration(3000);// Duracion
        Icon icono = null;
        /*
         * 1=error
         * 2=Success
         * 3=Informacion
         */
        switch (codigo) {
            case 1: // ERROR
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                icono = new Icon(VaadinIcon.CLOSE_CIRCLE_O);
                break;
            case 2: // SUCCESS
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                icono = new Icon(VaadinIcon.CHECK_CIRCLE_O);
                break;
            case 3: // INFORMACION
                notification.addThemeVariants(NotificationVariant.LUMO_PRIMARY);
                icono = new Icon(VaadinIcon.INFO_CIRCLE_O);
                break;
        }
        if (pos == 1) // Arriba izquierda
            notification.setPosition(
                    com.vaadin.flow.component.notification.Notification.Position.TOP_START);
        else if (pos == 2) // Abajo izquierda
            notification.setPosition(
                    com.vaadin.flow.component.notification.Notification.Position.BOTTOM_START);
        else if (pos == 3) // Arriba derecha
            notification.setPosition(com.vaadin.flow.component.notification.Notification.Position.TOP_END);
        else if (pos == 4) // Abajo derecha
            notification.setPosition(
                    com.vaadin.flow.component.notification.Notification.Position.BOTTOM_END);
        else if (pos == 5) // Abajo centrado
            notification.setPosition(
                    com.vaadin.flow.component.notification.Notification.Position.BOTTOM_CENTER);
        else if (pos == 6) // centradp
            notification.setPosition(com.vaadin.flow.component.notification.Notification.Position.MIDDLE);
        else if (pos == 7) // Arriba
            notification.setPosition(
                    com.vaadin.flow.component.notification.Notification.Position.TOP_STRETCH);
        else if (pos == 8) // Abajo
            notification.setPosition(
                    com.vaadin.flow.component.notification.Notification.Position.BOTTOM_STRETCH);
        Span label = new Span(mensaje);
        label.getStyle().set("margin", "0px");
        label.getStyle().set("padding", "0px");

        notification.add(icono, label);

        notification.open();
    }
}
