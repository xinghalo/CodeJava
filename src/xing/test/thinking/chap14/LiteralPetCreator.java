package xing.test.thinking.chap14;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator{
	public static final List<Class<? extends Individual>> allTypes = Collections.unmodifiableList(Arrays.asList(
			Person.class,Pet.class
	));
	private static final List<Class<? extends Individual>> types = allTypes.subList(
			allTypes.indexOf(Person.class), 
			allTypes.size()
	);
	public List<Class<? extends Individual>> types() {
		return types;
	}
	public static void main(String[] args) {
		System.out.println(types);
	}
}
