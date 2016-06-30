package xing.test.thinking.chap19;
/**
 * 枚举跟普通的类差不多，也可以有构造方法以及普通方法。
 * 不过枚举的变量后面要用分号标识结束才行。
 * 
 * @author xxh
 */
public enum OzWitch {
	WEST("west constructor"),
	NORTH("north constructor"),
	EAST("east constructor"),
	SOUTH("south constructor");
	
	private String description;
	private OzWitch(String description) {
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public static void main(String[] args) {
		for(OzWitch witch : OzWitch.values()){
			System.out.println(witch + " : " + witch.getDescription());
		}
	}
}
