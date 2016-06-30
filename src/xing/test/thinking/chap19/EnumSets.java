package xing.test.thinking.chap19;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

enum AlarmPoints {
	STAIR1,STAIR2,LOBBY,OFFICE1,OFFICE2,OFFICE3,OFFICE4,BATHROOM,UTILITY,KITCHEN
}
interface Command {
	void action();
}
public class EnumSets {
	public static void main(String[] args) {
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		points.add(AlarmPoints.BATHROOM);
		System.out.println(points);
		points.addAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN));
		System.out.println(points);
		
		EnumMap<AlarmPoints,Command> em = new EnumMap<AlarmPoints,Command>(AlarmPoints.class);
		em.put(AlarmPoints.OFFICE1, new Command(){
			public void action(){
				System.out.println("office1");
			}
		});
		em.put(AlarmPoints.OFFICE2, new Command(){
			public void action(){
				System.out.println("office2");
			}
		});
		for(Map.Entry<AlarmPoints, Command> e : em.entrySet()){
			System.out.println(e.getKey() + ":");
			e.getValue().action();
		}
		try{
			em.get(AlarmPoints.OFFICE1).action();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}

