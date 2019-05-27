package project;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Trapezium{
    private float a;
    private float b;
    private float c;
    private float d;
    private float Height;

    public float getArea(float a , float b , float Height){  
        float area = 0;
        this.Height=Height;
        this.a=a;
        this.b=b;
        area=0.5f*(a+b)*Height;
         System.gc();
        return area;
    }
    
    public float getPerimeter(float a ,float b, float c ,float d){
         float Perimeter = 0;
        Perimeter =a+b+c+d;
         System.gc();
         return Perimeter;
    }
}
