package xing.test.thinking.chap19;

import java.util.EnumSet;

public class CarWash {
	public enum Cycle {
		UNDERBODY{
			void action(){
				System.out.println("Spraying the underbody");
			}
		},
		WHEELWASH{
			void action(){
				System.out.println("Washing the wheels");
			}
		},
		PREWASH{
			void action(){
				System.out.println("Loosening the dirt");
			}
		},
		BASIC {
			void action(){
				System.out.println("The basic wash");
			}
		},
		HOTWAX {
			void action(){
				System.out.println("Applying hot wax");
			}
		},
		RINSE {
			void action(){
				System.out.println("Rinsing");
			}
		},
		BLOWDRY {
			void action(){
				System.out.println("Blowing dry");
			}
		};
		abstract void action();
	}
	EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC,Cycle.RINSE);
	public void add(Cycle cycle){
		cycles.add(cycle);
	}
	public void washCar(){
		for(Cycle c : cycles){
			c.action();
		}
	}
	public String toString(){
		return cycles.toString();
	}
	//test123456
	public static void main(String[] args) {
		CarWash wash = new CarWash();
		System.out.println(wash);
		wash.washCar();
		wash.add(Cycle.BLOWDRY);
		wash.add(Cycle.BLOWDRY);
		wash.add(Cycle.RINSE);
		wash.add(Cycle.HOTWAX);
		System.out.println(wash);
		wash.washCar();
	}
}
