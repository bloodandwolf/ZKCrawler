package com.gy.wm.util;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by TianyuanPan on 5/4/16.
 */
public class ConfigUtils {

    private String hostname;
    private int port;
    private String dbName;
    private String user;
    private String password;


    private static ResourceBundle rb;

    ConfigUtils() {

    }

    public static ConfigUtils getConfigUtils(String prefix) {

        ResourceBundle rb;

        ConfigUtils configUtils = new ConfigUtils();

        rb = PropertyResourceBundle.getBundle("config");

        configUtils.hostname = rb.getString(prefix + "HOSTNAME");
        configUtils.port = Integer.parseInt(rb.getString(prefix + "PORT"));
        configUtils.dbName = rb.getString(prefix + "DBNAME");
        configUtils.user = rb.getString(prefix + "USER");
        configUtils.password = rb.getString(prefix + "PASSWORD");


        return configUtils;
    }

    public static ConfigUtils getConfigUtils(String prefix, String configName) {

        ResourceBundle rb;

        ConfigUtils configUtils = new ConfigUtils();

        rb = PropertyResourceBundle.getBundle(configName);

        configUtils.hostname = rb.getString(prefix + "HOSTNAME");
        configUtils.port = Integer.parseInt(rb.getString(prefix + "PORT"));
        configUtils.dbName = rb.getString(prefix + "DBNAME");
        configUtils.user = rb.getString(prefix + "USER");
        configUtils.password = rb.getString(prefix + "PASSWORD");


        return configUtils;
    }



    public static ResourceBundle getResourceBundle() {

        rb = PropertyResourceBundle.getBundle("config");
        return rb;
    }


    public static ResourceBundle getResourceBundle(String configName) {


        rb = PropertyResourceBundle.getBundle(configName);

        return rb;
    }


    public String getHostname() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

}
