/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;
import tools.DConnection;


public class RegionDAO {
    //panggil koneksi yang sudah kita buat
      private Connection connection = null;
        
   //tambahkan constractor nya
   /*jadi pertama kali class REgionDAO dipanggil dia akan build akan mengcreate 
    objek baru dan akan mneginsisialisasi bahwa ini koneksi nya */
    public RegionDAO() {
      //insialisasi dr connection dengan memanggil getConnection yang dibuat
      this.connection = new DConnection().getConnection();
    }
    
    //membuat fungsi List, Pakai List = karena kita akan panggil data
    //ctrl+shift+i
    
    //membuat variabel penampung dulu, biasakan membuat variabel penampung dulu
        /* bikin dulu 
        1. fungsi nya apa, 
        2. variabel penampung dulu, 
        3. return nya apa, 
        4. mengnuliskan dokumentasi kode program
        kemudian baru kita buat isinya, dalam menuliskan isi biasakan gunakan try catch*/
        
        /* ini merupakan suatu fungsi untuk mengambil data semua region
        yang ada di DB
        @return semua data dari region List<Region>*/
    public List<Region> getRegions() {
        List<Region> regions = new ArrayList<>();
        //string query untuk mengambil data yang dibutuhkan
        String query = "SELECT * FROM Region";
        try {
            //PS untuk membuat satu stament yang akan dieksekusi
            //statement dan preparestatement
            //PrepareStatement dari java.sql
            PreparedStatement statement = connection.prepareStatement(query);
            
            /* untuk mendapatkan sesuatu misal List u/ mendapatkan data gunakan
                resultSet = variabel penampung untuk apa yang kita dapatkan dr database */
            ResultSet resultSet = statement.executeQuery();
            
            //buat perulangan, jika resultSet masih ada next2 kita akan ambil nilainya
            /* line 59 - digunakan untuk membuat perulangan sebanyak 
            data yang berada di dalam tabel region
            setiap kali perulangan akan membuat objek baru yaitu id dan nama
            setelah objek tsb dibuat kemudian ditambahkan ke List region*/
            while (resultSet.next()) {                
                Region region = new Region(resultSet.getInt(1), resultSet.getString(2));
                //getInt column index
                //region.setId(resultSet.getInt(1));
                //region.setName(resultSet.getString(2));
                //masukkan kedalam List regions
                regions.add(region);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
   
    }
    
    /* untuk memasukkan data  region baru 
    @param region satu objek utuh dari region, 
    yang memilikki id, name
    @return boolean true jika berhasil, false jika gagal*/
    
    //INSERT QUERY
    //menggunakan boolean agar mengetahui masuk atau tidak datanya
    //yang diinsert kan region
    
    public boolean insert(Region region) {
        //variabel penampung
        boolean result = false;
        //string u/ quert
        //penggunaan values ?,? digunakan untuk meminimalisir sqlinjection
        String query = "INSERT INTO Region(id,name) VALUES (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            //set tanda ? (1) (id)
            statement.setInt(1, region.getId());
            //set tanda ? (2) (name)
            statement.setString(2, region.getName());
            //excequte update karena digunakan DML
            statement.executeUpdate();
            //result diset true
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /* untuk mengubah data  region baru 
    @param region satu objek utuh dari region, 
    yang memilikki id, name
    @return boolean true jika berhasil, false jika gagal*/
    
    //UPDATE QUERY
    //menggunakan boolean agar mengetahui update atau tidak datanya
    //yang diupdate kan region
    
    public boolean update(Region region) {
        //variabel penampung
        boolean result = false;
        //string u/ quert
        //penggunaan values ?,? digunakan untuk meminimalisir sqlinjection
        String query = "UPDATE Region SET name=? WHERE id= ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            //set tanda ? (1) (name)
            statement.setString(1, region.getName());
            //set tanda ? (2) (id)
            statement.setInt(2, region.getId());
            //excequte update karena digunakan DML
            statement.executeUpdate();
            //result diset true
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /* DELETE QUERY
   boolean  mengetahui terhapus tidaknya data*/
    
    //parameter delete menggunakan id saja karena yang diperlukan untuk delete hanya PK id
    public boolean delete(int id){
        //variabel penampung
        boolean result = false;
        String query = "DELETE FROM Region WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            //id sesuai dengan param delete yaitu id saja 
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
     /* ini merupakan suatu fungsi untuk mengambil data semua region
        yang ada di DB
        @return semua data dari region List<Region>*/
    public Region getById(int id){
        Region region = null;
        String query = "SELECT * FROM Region WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            
            //set id 
            statement.setInt(1, id);
            //variabel penampung
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                region  = new Region(resultSet.getInt(1), resultSet.getString(2)); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return region; 
        
    }
    
    /* ini merupakan suatu fungsi untuk mengambil data semua region
        yang ada di DB
        @return semua data dari region List<Region>*/
    public List<Region> search(String keyword){
        List<Region> regions = new ArrayList<>();
        //string query untuk mengambil data yang dibutuhkan
        String query = "SELECT * FROM Region WHERE id LIKE ? OR name LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            
            //set id itu LIKE jadi set nya String tidak perlu int
            statement.setString(1, "%"+keyword+"%");
            //set name
            statement.setString(2, "%"+keyword+"%");
            
            /* untuk mendapatkan sesuatu misal List u/ mendapatkan data gunakan
                resultSet = variabel penampung untuk apa yang kita dapatkan dr database */
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {                
                Region region = new Region(resultSet.getInt(1), resultSet.getString(2));
                regions.add(region);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regions;
   
    }
    
   
    
   
        
    
}
