package com.pger.de.decorator.gpmenu;

import com.pger.de.decorator.gpmenu.tools.GperConfig;

public class GperLoginDecorator extends GperMenuDecorator {

    public GperLoginDecorator(GperMenu gperMenu) {
        super(gperMenu);
    }

    @Override
    protected String getMenu() {
        GperConfig config = GperConfig.getInstance();
        String info = config.get("loginMenu");
        return super.getMenu() + "," + info;
    }

}
