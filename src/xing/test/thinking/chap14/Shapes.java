package xing.test.thinking.chap14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Shape{
	void draw() {
		System.out.println(this + ".draw()");
	}
}
class Circle extends Shape{
	public String toString(){
		return "Circle";
	}
}
class Square extends Shape{
	public String toString(){
		return "Square";
	}
}
class Triangle extends Shape{
	public String toString(){
		return "Triangle";
	}
}
public class Shapes {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Shape> shapeList = (List) Arrays.asList(new Circle(),new Square(),new Triangle());
		for(Shape shape : shapeList){
			shape.draw();
		}
	}
}
