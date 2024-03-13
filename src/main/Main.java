/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import management.Management;

/**
 * The Main class serves as the entry point for the program.
 * 
 * @author he151168
 */
public class Main {

    /**
     * The main method for the Main class.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Management manager = new Management();
        manager.displayMenu();
    }
}
