/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import java.util.ArrayList;
import java.util.List;
import models.Country;


/**
 *
 * @author TOSHIBA
 */
public class CountryController {
    private CountryDAO cdao;
    
    //contructor

    public CountryController() {
        this.cdao = new CountryDAO();
    }
    
    /* ini memanggil  fungsi get all data country from dao
    @return daftar country*/
    
    public List<Country> binding() {
        List<Country> countrys = new ArrayList<>();
        countrys = this.cdao.getCountry();
        return countrys;
    }
    
    /* ini memanggil  fungsi insert data country from dao
    @return */
    //INSERT
   public String save(String id, String name, String region) {
       String result = "simpan data gagal";
       int idRegion = Integer.parseInt(region);
       Country country = new Country(id, name, idRegion);
        if (this.cdao.insert(country)) 
        return "simpan data berhasil";
        return "simpan data gagal";
        
    }
    
    //UPDATE
    
    public String edit(String id, String name, String region) {
        //variabel penampung
        String result = "simpan data gagal";
        int regionId = Integer.parseInt(region);
        Country country = new Country(id, name, regionId);
        if(this.cdao.update(country)) 
        return "ubah data berhasil";
        return "ubah data gagal";
    }
    
    //DELETE QUERY
    public String delete(String id) {
        if (this.cdao.delete(id)) 
        return "Hapus data gagal";
        return "Hapus data berhasil";
        
    }
    
    //SEARCH
    public List<Country> search(String keyword) {
        return this.cdao.search(keyword);
    }
    
    
}
