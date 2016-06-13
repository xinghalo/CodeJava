package xing.test.thinking.chap14;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator{
	private static List<Class<? extends Individual>> types = new ArrayList<Class<? extends Individual>>();
	
	private static String[] typesNames = {
			"xing.test.thinking.chap14.Person",
			"xing.test.thinking.chap14.Pet"
	};
	
	@SuppressWarnings("unchecked")
	private static void loader(){
		try{
			for(String name : typesNames){
				types.add((Class<? extends Individual>)Class.forName(name));
			}
		}catch(ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	
	static {
		loader();
	}

	@Override
	public List<Class<? extends Individual>> types() {
		return types;
	}
}
