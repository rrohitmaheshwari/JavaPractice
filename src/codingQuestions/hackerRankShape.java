package codingQuestions;

import java.awt.*;
import java.util.Scanner;

class Shape {
    public void drawShape() {
        System.out.println("Drawing a Shape");
    }
}

// abstract class Shaper{
//     abstract void drawShape();
// }
class Square extends Shape{
    @Override
    public  void drawShape(){
        System.out.println("Now drawing a Square");
    }
}
class Circle extends Shape{
    public  void drawShape(){
        System.out.println("Now drawing a Circle");
    }
}
class Rectangle extends Shape{
    public  void drawShape(){
        System.out.println("Now drawing a Rectangle");
    }
}
class ShapeFactory{
    public Shape drawShape(String shape){
        if(shape == null){
            return null;
        }
        if(shape.equals("Square")){
            System.out.println("Now drawing a Square");
            return new Square();
        }else if(shape.equals("Rectangle")){
            System.out.println("Now drawing a Rectangle");
            return new Rectangle();
        }else if(shape.equals("Circle")){
            System.out.println("Now drawing a Circle");
            return new Circle();
        }else{
            System.out.println("Drawing "+ shape+ "is not supported");
            return null;
        }
    }
}

public class hackerRankShape {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Square square = new Square();
        Rectangle rectangle = new Rectangle();

        ((Shape)circle).drawShape();
        ((Shape)square).drawShape();
        ((Shape)rectangle).drawShape();

        System.out.println();

        ShapeFactory factory = new ShapeFactory();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String type = in.next();
            factory.drawShape(type);
        }
    }
}
