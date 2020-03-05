package com.pger.de.decorator.gpmenu;

import com.pger.de.decorator.gpmenu.tools.GperConfig;

public class GperDefaultMenu extends GperMenu {
    @Override
    protected String getMenu(String login) {
        GperConfig prop = GperConfig.getInstance();
        login = "defaultMenu";
        String viser = prop.get(login);
        return viser;
    }

}
