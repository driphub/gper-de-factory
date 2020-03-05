package com.pger.de.decorator.gpmenu;

public class GperVisitorDecorator extends GperMenuDecorator {

    public GperVisitorDecorator(GperMenu gperMenu) {
        super(gperMenu);
    }

    @Override
    protected String getMenu(String login) {
        return ">>>>  " + super.getMenu(login);
    }

}
