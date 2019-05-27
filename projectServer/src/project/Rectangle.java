package project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rectangle extends Parallelogram implements shapes1{

  
    public float getArea(float base , float sidelength) {   
        float Area =0;
        try{        
         Area = base*sidelength;
        }catch(InputMismatchException e){
            System.out.println("Don't write letter");
        }
        return Area;
    }

    @Override
    public float getPerimeter(float sidelength) {
         float Perimeter = 0;
        super.getPerimeter(Perimeter); //To change body of generated methods, choose Tools | Templates.
         try{
         Perimeter  = 4*sidelength;
         }catch(InputMismatchException e){
            System.out.println("Don't write letter");
        }
         return Perimeter;
    }
    
}
