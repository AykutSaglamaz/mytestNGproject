package com.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day09_C25_DataProvider1 {
    /*DataProvider ile test
    1. 2D object array donduren bir getData method olusturun
    2. Method'ta @DataProvider annotation kullan
    3. test datayi bu method'ta saklamak icin 2d object array olustur
    4. test method olustur
    5.   @Test(dataProvider = "getData") annotation kullan
    ----------------------------------
    @DataProvider annotation, test classlara data'yi iletir
    * */
    //DataProvider'dan data almak icin bir method olustur
    //Bu methodun return type 2D array olsun

    @DataProvider
    public Object[][] getData(){
//                manager	Manager1!
//                manager2	Manager2!
//                manager3	Manager3!

/*    Way 1 to add data
        Object [][] managerProfile = new Object[3][2]; //3 rows(outer) 2 columns(inner)
        //1st row
        managerProfile[0][0]="manager";
        managerProfile[0][1]="Manager1!";
        //2nd row
        managerProfile[1][0]="manager2";
        managerProfile[1][1]="Manager2!";
        //3rd row
        managerProfile[2][0]="manager3";
        managerProfile[2][1]="Manager3!";
*/

        /*     Way 2 to add data- Short way- Recommended way */
        Object [][] managerProfile= {
                {"manager","Manager1!"},
                {"manager5","Manager5!"},
                {"manager12","Manager12!"}
        };
        return managerProfile;
    }


    @Test(dataProvider = "getData")
    public void managerInfo(String userName, String password){
        //Manager kullanici bilgilerini almak icin Excel kullan
        System.out.println("User Name : "+userName+"\nPassword : "+password);
    }

}
