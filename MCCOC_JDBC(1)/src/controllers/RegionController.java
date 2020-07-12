/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import java.util.ArrayList;
import java.util.List;
import models.Region;


public class RegionController {
    //panggil class DAO nya
    //membuat stribut/properti dr regiondao
    
    private RegionDAO rdao;
    
    //buat contructornya

    public RegionController() {
        //inisialisasi u/ rdao nya dengan region dao nya
        // RegionDAO akan memanggil dari class RegionDAO yang koneksi
        this.rdao = new RegionDAO();
    }
    
    //panggil List lagi
    //Region dr model Region
    //karena controller yang digunakan u/ user interface nya
    //binding = mau tampilkan didepan
    
    /* ini memanggil  fungsi get all fata regions from dao
    @return daftar region*/
    public List<Region> binding() {
        List<Region> regions = new ArrayList<>();
        //bru kita panggil 
        regions = this.rdao.getRegions();
        return regions;
        //return this.rdao.getRegions();
    }
    
    //meggunakan string karena hubungannnya dengan user, yang autput nya berhasil atau gagal
    /* string id, sting name karena jk kita mendapatkan data dari user(user interface)
    itu bentuknya pasti string 
    tugas controller adalah memastikan bahwa id ini berupa integer*/
    public String save(String id, String name) {
        //variabel penampung
        String result = "simpan data gagal";
        
        //id region adalah int, maka atur dr string ke int
        //dicoba saat buat country
        //karena di DB auto increment mk id boleh di skip
        //Region region = new Region(idRegion, name);
        //int idRegion = Integer.parseInt(id);
        
        Region region = new Region(name);
        
        if(this.rdao.insert(region)) 
        return "simpan data berhasil";
        return "simpan data gagal";
    }
    
    //meggunakan string karena hubungannnya dengan user, yang autput nya berhasil atau gagal
    /* string id, sting name karena jk kita mendapatkan data dari user(user interface)
    itu bentuknya pasti string 
    tugas controller adalah memastikan bahwa id ini berupa integer*/
    public String edit(String id, String name) {
        //variabel penampung
        String result = "simpan data gagal";
        
        int regionId = Integer.parseInt(id);
        Region region = new Region(regionId, name);
        
        if(this.rdao.update(region)) 
        return "ubah data berhasil";
        return "ubah data gagal";
    }
    
    //DELETE QUERY
    public String delete(String id) {
        int regionId = Integer.parseInt(id);
        if (this.rdao.delete(regionId)) 
        return "Hapus data gagal";
        return "Hapus data berhasil";
        
    }
    
    //SEARCH
    public List<Region> search(String keyword) {
        return this.rdao.search(keyword);
    }
    
    public Region getById(String id) {
       //int getById = Integer.parseInt(id);
       //if(this.rdao.getById(getById))
       //return "get by id";
       //return "";
       return this.rdao.getById(Integer.parseInt(id));
       
    }
    
    
    
    
            
}
