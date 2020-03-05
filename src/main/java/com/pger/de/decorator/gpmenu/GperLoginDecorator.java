package com.pger.de.decorator.gpmenu;

import com.pger.de.decorator.gpmenu.tools.GperConfig;

public class GperLoginDecorator extends GperMenuDecorator {

    public GperLoginDecorator(GperMenu gperMenu) {
        super(gperMenu);
    }

    @Override
    protected String getMenu(String login) {
        GperConfig config = GperConfig.getInstance();
        String info = config.get(login);
        return super.getMenu(login) + "," + info;
    }

}
