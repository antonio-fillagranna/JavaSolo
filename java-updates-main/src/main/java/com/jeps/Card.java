package com.jeps;

public non-sealed class Card extends Payment {

    protected String cardNumber;

    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
