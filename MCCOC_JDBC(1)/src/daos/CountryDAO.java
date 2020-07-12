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
import models.Country;
import tools.DConnection;


public class CountryDAO {
    private Connection connection = null;
    
    //constructor

    public CountryDAO() {
        this.connection = new DConnection().getConnection();
    }
    
    /* ini merupakan suatu fungsi untuk mengambil data semua country
        yang ada di DB
        @return semua data dari region List<Country>*/
    
    public List<Country> getCountry() {
        List<Country>countrys = new ArrayList<>();
        String query = "SELECT * FROM Country";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(resultSet.getString(1), resultSet.getString(2), 
                        resultSet.getInt(3));
                
                countrys.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countrys;
    }
    
    /* untuk memasukkan data  country baru 
    @param country satu objek utuh dari country, 
    yang memilikki id, name, region
    @return boolean true jika berhasil, false jika gagal*/
    
    //INSERT QUERY
    public  boolean insert(Country country) {
        boolean result = false;
        String query = "INSERT INTO Country(id, name, region) VALUES (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            //set (id)
            statement.setString(1, country.getId());
            //set name
            statement.setString(2, country.getName());
            //set region
            statement.setInt(3, country.getRegion());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    //UPDATE QUERY
    public boolean update(Country country) {
        boolean result = false;
        String query = "UPDATE Country SET name=? , region=? WHERE id=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, country.getName());
            if(country.getName().isEmpty())
            {
                System.out.println("Id Country Tidak Boleh Kosong");
            }
            statement.setInt(2, country.getRegion());
            statement.setString(3, country.getId());
            statement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    //DELETE QUERY
    public boolean delete(String id){
        //variabel penampung
        boolean result = false;
        String query = "DELETE FROM Country WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            //id sesuai dengan param delete yaitu id saja 
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /* ini merupakan suatu fungsi untuk mengambil data semua region
        yang ada di DB
        @return semua data dari region List<Region>*/
    public List<Country> search(String keyword){
        List<Country> countrys = new ArrayList<>();
        //string query untuk mengambil data yang dibutuhkan
        String query = "SELECT * FROM Country WHERE id LIKE ? OR name LIKE ?";
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
                Country country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                countrys.add(country);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countrys;
    }
    
    
}
