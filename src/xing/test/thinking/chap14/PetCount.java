package xing.test.thinking.chap14;

import java.util.HashMap;

public class PetCount {
	static class PetCounter extends HashMap<String,Integer> {
		public void count(String type){
			Integer quantity = get(type);
			if(quantity == null){
				put(type,1);
			}else{
				put(type,quantity+1);
			}
		}
	}
	
	public static void countPets(PetCreator creator){
		PetCounter counter = new PetCounter();
		for(Individual pet : creator.createArray(20)){
			System.out.println(pet.getClass().getSimpleName());
			if(pet instanceof Person){
				counter.count("Person");
			}else if(pet instanceof Pet){
				counter.count("Pet");
			}
		}
		System.out.println(counter);
	}
	
	public static void main(String[] args) {
		countPets(new ForNameCreator());
	}
}
