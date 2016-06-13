package xing.test.thinking.chap14;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount3 {
	static class PetCounter extends LinkedHashMap<Class<? extends Individual>,Integer> {
		public void count(Individual pet){
			for(Map.Entry<Class<? extends Individual>, Integer> pair : entrySet()){
				if(pair.getKey().isInstance(pet)){
					
				}else{
					
				}
			}
			Class<?> baseType = null;
			baseType.isAssignableFrom(Person.class);
		}
	}
	
}
