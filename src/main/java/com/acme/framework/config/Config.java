package com.acme.framework.config;

public final class Config {
    private Config(){}

    public static String baseUrl() {
        return get("baseUrl","http://localhost:5173");
    }

    public static String browser() {
        return get("browser", "chrome");
    }

    public static boolean headless() {
        return Boolean.parseBoolean(get("headless", "false"));
    }

    private static String get(String key, String defaultValue) {

        String env = System.getenv(key);
        if (env != null && !env.isBlank()) return env;

        String sys = System.getProperty(key);
        if (sys != null && !sys.isBlank()) return sys;

        return defaultValue;
    }

}
