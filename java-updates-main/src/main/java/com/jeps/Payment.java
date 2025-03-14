package com.jeps;

public abstract sealed class Payment permits Card, Pix {
}
