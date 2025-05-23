package com.mjc813.studyjava;

public enum ERam {
    RAM_4GB(4),
    RAM_8GB(8),
    RAM_16GB(16),
    RAM_32GB(32);

    private int value;
    ERam(int val) {
        this.value = val;
    }
    public int getValue() {
        return this.value;
    }
}
