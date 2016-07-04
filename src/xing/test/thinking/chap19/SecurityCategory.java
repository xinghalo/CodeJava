package xing.test.thinking.chap19;

public enum SecurityCategory {
	STOCK(Security.Stock.class),BOND(Security.Bond.class);
	Security[] values;
	SecurityCategory(Class<? extends Security> kind){
		values = kind.getEnumConstants();
	}
	public Security randomSelection(){
		return Enums.random(values);
	}
	interface Security{
		enum Stock implements Security{
			SHORT,LONG,MARGIN
		}
		enum Bond implements Security{
			MUNICIPAL,JUNK
		}
	}
	public static void main(String[] args) {
		for( int i=0; i<10; i++){
			SecurityCategory random = Enums.random(SecurityCategory.class);
			System.out.println(random + ":" + random.randomSelection());
		}
	}
}
