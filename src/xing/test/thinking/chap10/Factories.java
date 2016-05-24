package xing.test.thinking.chap10;
interface Service{
	void method1();
	void method2();
}
interface ServiceFactory{
	Service getService();
}
class Implementation1 implements Service {
	private Implementation1(){}
	@Override
	public void method1() {
		System.out.println("implementation1 method1");
	}
	@Override
	public void method2() {
		System.out.println("implementation1 method2");
	}
	public static ServiceFactory factory = new ServiceFactory(){
		public Service getService(){
			return new Implementation1();
		}
	};
}
class Implementation2 implements Service {
	private Implementation2(){}
	@Override
	public void method1() {
		System.out.println("implementation2 method1");
	}
	@Override
	public void method2() {
		System.out.println("implementation2 method2");
	}
	public static ServiceFactory factory = new ServiceFactory(){
		public Service getService(){
			return new Implementation2();
		}
	};
}
public class Factories {
	public static void serviceConsumer(ServiceFactory fact){
		Service s = fact.getService();
		s.method1();
		s.method2();
	}
	public static void main(String[] args) {
		serviceConsumer(Implementation1.factory);
		serviceConsumer(Implementation2.factory);
	}
}
