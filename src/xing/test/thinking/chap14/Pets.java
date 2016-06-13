package xing.test.thinking.chap14;

import java.util.ArrayList;

public class Pets {
	public static final PetCreator creator = new LiteralPetCreator();
	public static Individual randomPet(){
		return creator.randomPet();
	}
	public static Individual[] createArray(int size){
		return creator.createArray(size);
	}
	public static ArrayList<Individual> arrayList(int size){
		return creator.arrayList(size);
	}
}
