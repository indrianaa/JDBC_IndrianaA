
package tools;

import controllers.CountryController;
import java.util.List;
import models.Country;


public class ManualTest {
    
    //buat void name nya
    //pvsm ctrl+space
    public static void main(String[] args) {
        
        //langsung panggil aja
        //insisiasi class DConnection dengan new
        //inisiasi method Connection
        //System.out.println(new DConnection().getConnection());
        
      
       //RegionController controller = new RegionController();
       CountryController controller = new CountryController();
       
       //REGION
       
       //  untuk insert data region
        //System.out.println(controller.save("", "ANTARTICA"));
        
        //  untuk update data region
       // System.out.println(controller.edit("2", "JAMAICA"));
        
        //DELETE
        //System.out.println(controller.delete("10"));
        
        //SEARCH
        //mencari id dengan huruf A
        //List<Region> daftarRegions = controller.search("e");
      
         //panggil regioncontroller untuk get all
       // List<Region> daftarRegions = controller.binding();
        //perulangaan for each atau untuk setiap
        //untuk setiap Region yang ada di dalam List Region 
        //List Region didapat dari regioncontroller.binding
        //for (Region region : daftarRegions) {
         //   System.out.println("id : " +region.getId()
          //  +", name : "+region.getName()); 
          
          //get by id
          //Region region = controller.getById("1");
          //System.out.println(region.getId());
          //System.out.println(region.getName());
          
          
          //COUNTRY
          
          //panggil regioncontroller untuk get all
       //List<Country> daftarCountrys = controller.binding();
        //perulangaan for each atau untuk setiap
        //untuk setiap Country yang ada di dalam List Country 
        //List Country didapat dari controller.binding
       // for (Country country : daftarCountrys) {
       // System.out.println("id : " +country.getId()
       //         +" name : "+country.getName() + "region :" +country.getRegion()); 
          
          //  untuk insert data country
        //System.out.println(controller.save("C06", "MALAYSIA","1"));
        
        //  untuk update data country
        System.out.println(controller.edit("", "MALAYSIA", "2"));
        
        //DELETE
       // System.out.println(controller.delete("C05"));
        
        //SEARCH
        //mencari id dengan huruf A
      //  List<Country> daftarCountrys = controller.search("C05");
          
        }
            
   }
    


