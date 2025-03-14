package com.jeps;

public final class Pix extends Payment {

    private String pixKey;

    public Pix(String pixKey) {
        this.pixKey = pixKey;
    }

    public String getPixKey() {
        return pixKey;
    }
}
