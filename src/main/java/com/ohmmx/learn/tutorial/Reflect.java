package com.ohmmx.learn.tutorial;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import com.google.gson.Gson;

public class Reflect {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();

		// 1.获取一个类的结构信息（类对象 Class对象）
		Class<?> clazz = Class.forName("com.ohmmx.learn.tutorial.Dog");
		// 2.从类对象中获取类的各种结构信息
		// 2.1 获取基本结构信息
		System.out.println("Class name: " + clazz.getName());
		System.out.println("Class simple name: " + clazz.getSimpleName());
		System.out.println("Class super class: " + clazz.getSuperclass());
		System.out.println("Class interfaces: " + Arrays.toString(clazz.getInterfaces()));
		// 2.2 获取构造方法
		// 只能得到public修饰的构造方法
		// Constructor[] constructors = clazz.getConstructors();
		// 可以得到所有的构造方法
		Constructor[] constructors = clazz.getDeclaredConstructors();
		System.out.println("Constructor length: " + constructors.length);
		for (Constructor con : constructors) {
			// System.out.println(con.toString());
			System.out.println("Constructor: " + con.getName() + " || " //
					+ Modifier.toString(con.getModifiers()) + " || " + Arrays.toString(con.getParameterTypes()));
		}
		// Constructor con = clazz.getConstructor(); // 获取无参数构造方法
		// Constructor con = clazz.getConstructor(String.class, String.class);
		Constructor con = clazz.getDeclaredConstructor(String.class, int.class);
		System.out.println("Constructor (String, int): " + con);
		// 2.3 获取属性
		// Field[] fields = clazz.getFields();
		Field[] fields = clazz.getDeclaredFields();
		System.out.println("Fields length: " + fields.length);
		for (Field f : fields) {
			System.out.println("Field: " + f);
		}
		// Field f = clazz.getField("color");
		// private 默认 protecte public 都可以获取，但不包括父类的
		Field f = clazz.getDeclaredField("age");
		System.out.println("Field age: " + f);
		// 2.3 获取方法
		// Method[] methods = clazz.getMethods();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.println("Method: " + m);
		}
		// Method m = clazz.getMethod("shout",String.class);
		// Method m = clazz.getMethod("run"); // public
		Method m = clazz.getDeclaredMethod("run");
		System.out.println("Method run: " + m);

		// Example
		// 得到类对象
		Class<?> dog = Class.forName("com.ohmmx.learn.tutorial.Dog");
		// 使用反射创建对象
		Constructor dogCon = dog.getDeclaredConstructor();
		Object dogObj = dogCon.newInstance();
		// 获取属性
		Field f1 = dog.getField("color"); // 包含父类public字段
		Field f2 = dog.getDeclaredField("age"); // 不包含父类字段
		// 给属性赋值
		f1.set(dogObj, "黑色1"); // dog.color = "黑色"
		f2.setAccessible(true); // 突破权限的控制
		f2.set(dogObj, 10);
		// 输出属性
		System.out.println("Field dog.color: " + f1.get(dogObj)); // dog.color
		System.out.println("Field dog.age: " + f2.get(dogObj)); // dog.age
		System.out.println("Dog object: " + gson.toJson(dogObj));
		// 获取方法
		Method m1 = dog.getDeclaredMethod("shout", String.class); // 不包含父类方法
		Method m2 = dog.getDeclaredMethod("run");
		Method m3 = dog.getMethod("calc", int.class, int.class); // 包含父类public方法
		// 使用反射执行方法
		m1.invoke(dogObj, "嗷呜"); // dog.shout("嗷呜");
		m2.invoke(dogObj); // dog.run();
		Object result = m3.invoke(dogObj, 11, 123); // dog.calc(11, 123);
		System.out.println("Method return: " + result);
	}
}

abstract class Animal {
	public String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract void shout(String msg);

	public abstract void run();

	public int calc(int a, int b) {
		return a + b;
	}
}

class Dog extends Animal implements Serializable {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Dog() {
	}

	public Dog(String color, int age) {
		this.color = color;
		this.age = age;
	}

	@Override
	public void shout(String msg) {
		System.out.println("shout: " + msg);
	}

	@Override
	public void run() {
		System.out.println("run run run");
	}
}
