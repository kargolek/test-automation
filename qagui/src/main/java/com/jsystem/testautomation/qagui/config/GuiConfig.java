package com.jsystem.testautomation.qagui.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

//TODO NEED TO IMPL
public class GuiConfig {
    private static final Config CONFIG = ConfigFactory.load("qaguiconfig.conf");
    private static final Config ENVIRONMENT = CONFIG.getConfig("environment");
}
