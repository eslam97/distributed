package project;
import java.util.InputMismatchException;

public class Circle {
    private int radius;
    private float area;
    private float perimeter;
    public Circle(){
    }

    public float getArea(float radius){
        try{  
            area=3.14f*radius*radius;
        }catch(InputMismatchException e){
            System.out.println("Don't write letter");
        }
        System.gc();
        return area;
    }
    public float getPerimeter(float radius){
        try{
            perimeter=3.14f*2*radius;
        }catch(InputMismatchException e){
            System.out.println("Don't write letter");
        }
            System.gc();
            return perimeter;
    }  
}