
package tools;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;

/*ini adalah method untuk melakukan atau mengkonfigurasi ke DB
yang perlu diset: servername, port, databasename, user dan password yang akan digunakan
untuk return type nya adalah connection dari java.sql */

public class DConnection {
   //membuat variabel connection
    //Connection itu bawaan dari java.sql.Connection
    //diinsialisasi langsung null maka jika dia gagal mk return nya akan null
    private Connection connection = null;
    
    //membuat classuntuk mendapatkan koneksinya
    //method getConnection
    public Connection getConnection() {
     //setting database, server, port, nama database
     //karena kemungkinan mysqldatasource ada kesalahan maka dibuat dalam exception
     //mysqldatasource = 
        try {
            //mengambil dan mengkonfigurasi dari driver database
            //tambahkan return dalam try catch
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("mccoc");
            dataSource.setUser("root");
            dataSource.setPassword("12345");
            connection = dataSource.getConnection();
            return connection;
            
        } catch (Exception e) {
            //e.getMessage itu pesannya
            //hanya akan meng highlight error nya karena apa
            System.out.println(e.getMessage());
            //e.print itu lebih detail error nya kerana apa, line berapa, dll
            //binary root, kesalahannya dimana
            e.printStackTrace();
        }
        return connection;
        
    }
}
