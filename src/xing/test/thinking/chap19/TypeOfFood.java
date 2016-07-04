package xing.test.thinking.chap19;

import xing.test.thinking.chap19.Food.Appetizer;
import xing.test.thinking.chap19.Food.Coffee;
import xing.test.thinking.chap19.Food.Dessert;
import xing.test.thinking.chap19.Food.MainCourse;

public class TypeOfFood {
	public static void main(String[] args) {
		Food food = Appetizer.SALAD;
		food = MainCourse.LASAGNE;
		food = Dessert.BLACK_FOREST_CAKE;
		food = Coffee.CAPPUCCINO;
	}
}
