package com.grupo2.agrosoft.views;

import java.util.ArrayList;
import java.util.List;

import com.grupo2.agrosoft.views.Inicio.InicioView;
import com.grupo2.agrosoft.views.ListaControlSiembras.ListaControlSiembrasView;
import com.grupo2.agrosoft.views.ListaParcelas.ListaParcelasView;
import com.grupo2.agrosoft.views.ListaSemillas.ListaSemillasView;
import com.grupo2.agrosoft.views.ListaSiembras.ListaRegistroSiembrasView;
import com.grupo2.agrosoft.views.ViewControlSiembras.ControlSiembrasAddView;
import com.grupo2.agrosoft.views.ViewParcelas.ParcelasAddView;
import com.grupo2.agrosoft.views.ViewRegistroSiembras.RegistroSiembrasAddView;
import com.grupo2.agrosoft.views.ViewSemillas.NuevaSemillaView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

/**
 * The main view is a top-level placeholder for other views.
 */
@PWA(name = "AgroSoft", shortName = "AgroSoft", enableInstallPrompt = false)
@Theme(themeFolder = "agrosoft")
@PageTitle("Main")
public class MainLayout extends AppLayout {

    public static class MenuItemInfo {

        private String text;
        private String iconClass;
        private Class<? extends Component> view;

        public MenuItemInfo(String text, String iconClass, Class<? extends Component> view) {
            this.text = text;
            this.iconClass = iconClass;
            this.view = view;
        }

        public String getText() {
            return text;
        }

        public String getIconClass() {
            return iconClass;
        }

        public Class<? extends Component> getView() {
            return view;
        }

    }

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        addToDrawer(createDrawerContent());
    }

    private Component createHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.addClassName("text-secondary");
        toggle.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames("m-0", "text-l");

        Header header = new Header(toggle, viewTitle);
        //header.getStyle().set("background", "url('images/franja_verde.png')");
        //header.getStyle().set("background-repeat", "no-repeat");
        //background-repeat: no-repeat;
        //header.getStyle().set("background-size", "contain");
        header.addClassNames("header_background","bg-base", "border-b", "border-contrast-10", "box-border", "flex", "h-xl", "items-center",
                "w-full");
        return header;
    }

    private Component createDrawerContent() {
        H2 appName = new H2("AgroSoft");
        appName.addClassNames("flex", "items-center", "h-xl", "m-0", "px-m", "text-m");

        com.vaadin.flow.component.html.Section section = new com.vaadin.flow.component.html.Section(appName,
                createNavigation(), createFooter());
        section.addClassNames("flex", "flex-col", "items-stretch", "max-h-full", "min-h-full");
        return section;
    }

    private Nav createNavigation() {
        Nav nav = new Nav();
        nav.addClassNames("border-b", "border-contrast-10", "flex-grow", "overflow-auto");
        nav.getElement().setAttribute("aria-labelledby", "views");

        // Wrap the links in a list; improves accessibility
        UnorderedList list = new UnorderedList();
        list.addClassNames("list-none", "m-0", "p-0");
        nav.add(list);

        for (RouterLink link : createLinks()) {
            ListItem item = new ListItem(link);
            list.add(item);
        }
        return nav;
    }

    private List<RouterLink> createLinks() {
        MenuItemInfo[] menuItems = new MenuItemInfo[]{ //
                new MenuItemInfo("Inicio", "la la-home", InicioView.class), //
                new MenuItemInfo("Nueva Parcela", "la la-plus-circle", ParcelasAddView.class), //
                new MenuItemInfo("Nueva Semilla", "la la-plus-circle", NuevaSemillaView.class), //
                new MenuItemInfo("Nuevo Registro Siembra", "la la-plus-circle", RegistroSiembrasAddView.class), //
                new MenuItemInfo("Nuevo Control Siembra", "la la-plus-circle", ControlSiembrasAddView.class), //
                new MenuItemInfo("Lista Parcelas", "la la-th-list", ListaParcelasView.class), //
                new MenuItemInfo("Lista Semillas", "la la-th-list", ListaSemillasView.class), //
                new MenuItemInfo("Lista Registro Siembras", "la la-th-list", ListaRegistroSiembrasView.class), //
                new MenuItemInfo("Lista Control Siembras", "la la-th-list", ListaControlSiembrasView.class), //

        };
        List<RouterLink> links = new ArrayList<>();
        for (MenuItemInfo menuItemInfo : menuItems) {
            links.add(createLink(menuItemInfo));

        }
        return links;
    }

    private static RouterLink createLink(MenuItemInfo menuItemInfo) {
        RouterLink link = new RouterLink();
        link.addClassNames("flex", "mx-s", "p-s", "relative", "text-secondary");
        link.setRoute(menuItemInfo.getView());

        Span icon = new Span();
        icon.addClassNames("me-s", "text-l");
        if (!menuItemInfo.getIconClass().isEmpty()) {
            icon.addClassNames(menuItemInfo.getIconClass());
        }

        Span text = new Span(menuItemInfo.getText());
        text.addClassNames("font-medium", "text-s");

        link.add(icon, text);
        return link;
    }

    private Footer createFooter() {
        Footer layout = new Footer();
        H5 grupoName = new H5("Grupo 2");
        layout.add(grupoName);
        layout.addClassNames("flex", "items-center", "my-s", "px-m", "py-xs");

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
