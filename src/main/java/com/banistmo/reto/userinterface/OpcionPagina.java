package com.banistmo.reto.userinterface;

public enum OpcionPagina {

    WEB("https://www.banistmo.com/wps/portal/banistmo/personas/");
    private final String url;

    OpcionPagina(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }
}
