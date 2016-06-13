package xing.test.thinking.chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
	private Random rand = new Random(47);
	
	public abstract List<Class<? extends Individual>> types();
	
	public Individual randomPet(){
		int n = rand.nextInt(types().size());
		
		try{
			return types().get(n).newInstance();
		}catch(InstantiationException e){
			throw new RuntimeException(e);
		}catch(IllegalAccessException e){
			throw new RuntimeException(e);
		}
	}
	
	public Individual[] createArray(int size){
		Individual[] result = new Individual[size];
		for(int i=0; i<size; i++){
			result[i] = randomPet();
		}
		return result;
	}
	
	public ArrayList<Individual> arrayList(int size){
		ArrayList<Individual> result = new ArrayList<Individual>();
		Collections.addAll(result, createArray(size));
		return result;
	}
}
