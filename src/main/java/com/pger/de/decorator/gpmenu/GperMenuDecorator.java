package com.pger.de.decorator.gpmenu;

public class GperMenuDecorator extends GperMenu {

    private GperMenu gperMenu;

    public GperMenuDecorator(GperMenu gperMenu) {
        this.gperMenu = gperMenu;
    }

    @Override
    protected String getMenu() {
        return this.gperMenu.getMenu();
    }

}
