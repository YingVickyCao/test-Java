package com.hades.example.java._object._reusing._3_delegation;

public class SpaceShipDelegation {
    private String name;
    private SpaceShipControls shipControls = new SpaceShipControls();

    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    public void up(int velocity) {
        shipControls.up(velocity);
    }

    public static void main(String[] args) {
        SpaceShipDelegation delegation = new SpaceShipDelegation("S");
        delegation.up(5);
    }
}