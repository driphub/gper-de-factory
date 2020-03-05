package com.pger.de.decorator.gpmenu;

public class GperMenuTest extends GperDefaultMenu {

    public static void main(String[] args) {
        GperMenu gperMenu;

        gperMenu = new GperDefaultMenu();
        String info = gperMenu.getMenu(null);
        System.out.println("-------> 默认导航条：" + info);

        gperMenu = new GperVisitorDecorator(gperMenu);
        info = gperMenu.getMenu("defaultMenu");
        System.out.println("-------> 游客导航条：" + info);

        gperMenu = new GperLoginDecorator(gperMenu);
        info = gperMenu.getMenu("loginMenu");
        System.out.println("-------> 登录后导航条：" + info);
    }

}
