package xing.test.thinking.chap08;

import com.alibaba.fastjson.JSON;

class A123{
	private String remove;

	public String getRemove() {
		return remove;
	}

	public void setRemove(String remove) {
		this.remove = remove;
	} 
} 
class B123 extends A123{
	private String add;

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}
}
public class ExtendJson {
	public static void main(String[] args) {
		String params = "{\"add\":\"123\",\"remove\":\"456\"}";
		B123 b = JSON.parseObject(params, B123.class);
		System.out.println(JSON.toJSONString(b));
	}
}
