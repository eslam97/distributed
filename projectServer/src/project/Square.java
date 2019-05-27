package project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Square extends Parallelogram implements shapes1{


    public float getArea(float sidelength) {
        float Area = 0;
        try{
        super.getArea(Area); //To change body of generated methods, choose Tools | Templates.
        try{    
         Area = sidelength*sidelength;
        }catch(InputMismatchException e){
            System.out.println("Don't write letter");
        }
        }catch(Exception e){
            System.out.println("Error");
        }
        return Area;
        
    }


    public float getPerimeter(float sidelength) {
         float Perimeter= 0;
        super.getPerimeter(Perimeter);
        try{
         Perimeter  = 4*sidelength;
        }catch(InputMismatchException e){
            System.out.println("Don't write letter");
        }
        return Perimeter;
    }
    
    
}
