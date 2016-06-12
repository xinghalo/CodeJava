package xing.test.thinking.chap14;
class Building{}
class House extends Building{}
public class ClassCasts {
	public static void main(String[] args) {
		Building b = new House();
		Class<House> houseType = House.class;
		House h = houseType.cast(b);//适用反射进行转换
		h = (House)b;
	}
}
