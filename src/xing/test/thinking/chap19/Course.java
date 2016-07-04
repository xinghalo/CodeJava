package xing.test.thinking.chap19;
public enum Course {
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	
	private Food[] values;
	/**
	 * 声明构造方法
	 * @param kind
	 */
	private Course(Class<? extends Food> kind){
		values = kind.getEnumConstants();
	}
	/**
	 * 返回随机的course enum
	 * @return
	 */
	public Food randomSelection(){
		return Enums.random(values);
	}
	public static void main(String[] args) {
		for( int i=0; i<5; i++){
			for(Course course:Course.values()){
				Food food = course.randomSelection();
				System.out.println(food);
			}
			System.out.println("- -");
		}
	}
}
