package xing.test.thinking.chap14;
class Toy {
	public Toy() {
	}
	public Toy(int i){
	}
}
class FancyToy extends Toy implements HasBateries,Waterproof,Shoots{
	public FancyToy() {
	}
}
public class ToyTest {
	static void printInfo(Class cc){
		System.out.println("Class name: "+cc.getName());
		System.out.println("Class isInterface: "+cc.isInterface());
		System.out.println("Class simple name: "+cc.getSimpleName());
		System.out.println("Class canonical name: "+cc.getCanonicalName());
	}
	public static void main(String[] args) {
		Class c = null;
		try{
			c = Class.forName("xing.test.thinking.chap14.FancyToy");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		printInfo(c);
		
		for(Class face : c.getInterfaces()){
			printInfo(face);
		}
		
		Class up = c.getSuperclass();
		Object obj = null;
		try{
			obj = up.newInstance();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		printInfo(obj.getClass());
	}
}
