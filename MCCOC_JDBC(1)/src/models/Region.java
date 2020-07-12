/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

public class Region {
    //membuat variable sesuai dengan field dalam tabel Region yang dibutuhkan
    private int id;
    private String name;
    
    //constructor itu simpel set
    //constructor berisi parameter2 yang akan digunakan
    //polimorfisme overload
    //alt+insert pilih constructor
    public Region(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Region(String name) {
        this.name = name;
    }
    
    
    
    //membuat enkapsulasi
    //klik kanan refactor, encapsulate
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    

    
    
}
