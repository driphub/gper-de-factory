package com.pger.de.decorator.gpmenu;

import com.pger.de.decorator.gpmenu.tools.GperConfig;

public class GperDefaultMenu extends GperMenu {
    @Override
    protected String getMenu() {
        GperConfig prop = GperConfig.getInstance();
        String viser = prop.get("defaultMenu");
        return viser;
    }

}
