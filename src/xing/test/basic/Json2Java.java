package xing.test.basic;

import com.alibaba.fastjson.JSON;

class Person{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
public class Json2Java {
	public static void main(String[] args) {
		Person person = new Person();
		person.setAge(30);
		person.setName("xingoo");
		System.out.println(JSON.toJSONString(person));
		
		String p = "{\"age\":30,\"name\":\"xingoo\"}";
		Person person2 = JSON.parseObject(p, Person.class);
		System.out.println(JSON.toJSONString(person2));
		
	}
}
