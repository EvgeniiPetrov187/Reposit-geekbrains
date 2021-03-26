package level3_lesson7;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Drive {

    @Test
    @Anno(id = 1)
    public void drive(){
        System.out.println("2. I am driving");
    }

    @Test
    @Anno(id = 2)
    public void driveFast(){
        System.out.println("3. I am driving fast");
    }

    @Test
    @Anno(id = 3)
    public void driveVeryFast(){
        System.out.println("4. I am driving very fast");
    }

    @BeforeSuite
    public void walk(){
        System.out.println("1. I am walking");
    }

    @AfterSuite
    public void swim(){
        System.out.println("5. I am swimming");
    }

}
