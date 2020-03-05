package com.pger.de.decorator.gpmenu.tools;


import java.io.*;
import java.util.Properties;

public class GperConfig {
    private Properties prop;
    private String sysFilePath;

    private GperConfig() {
        if (GperConfigHandler.INSTANCE != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
        prop = new Properties();
        sysFilePath = new File(GperConfig.class.getClassLoader().getResource("sys.properties").getFile()).getAbsolutePath();
    }

    public static GperConfig getInstance() {
        return GperConfigHandler.INSTANCE;
    }

    private static class GperConfigHandler {
        private static final GperConfig INSTANCE = new GperConfig();
    }

    public String get(String key) {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(sysFilePath));
            prop.load(new InputStreamReader(in));
            String value = prop.getProperty(key);
            in.close();
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        GperConfig prop = GperConfig.getInstance();
        String viser = prop.get("defaultMenu");
        System.out.println(viser);
    }

}
