package com.ohmmx.learn.tutorial;

/** 单例模式 */
public class SingletonDemo {
	public static void main(String[] args) {
		// 不合法的构造函数
		// 编译时错误：构造函数 SingleObject() 是不可见的
		// SingleObject object = new SingleObject();

		// 获取唯一可用的对象
		SingleObject1 object1 = SingleObject1.getInstance();
		object1.showMessage();

		SingleObject2 object2 = SingleObject2.getInstance();
		object2.showMessage();

		SingleObject3 object3 = SingleObject3.getInstance();
		object3.showMessage();

		SingleObject4 object4 = SingleObject4.getInstance();
		object4.showMessage();

		SingleObject5 object5 = SingleObject5.getInstance();
		object5.showMessage();
	}
}

// 懒汉式，线程不安全，LazyInit:Y，ThreadSafe:N
class SingleObject1 {
	// 创建 SingleObject 的一个对象
	private static SingleObject1 instance;

	// 让构造函数为 private，这样该类就不会被实例化
	private SingleObject1() {
	}

	// 获取唯一可用的对象
	public static SingleObject1 getInstance() {
		if (instance == null) {
			instance = new SingleObject1();
		}
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello SingleObject1!");
	}
}

// 懒汉式，线程安全，LazyInit:Y，ThreadSafe:Y。缺点：效率低
class SingleObject2 {
	private static SingleObject2 instance;

	private SingleObject2() {
	}

	public static synchronized SingleObject2 getInstance() {
		if (instance == null) {
			instance = new SingleObject2();
		}
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello SingleObject2!");
	}
}

// 饿汉式，LazyInit:N，ThreadSafe:Y。缺点：类加载时就初始化，浪费内存。<推荐>
class SingleObject3 {
	private static SingleObject3 instance = new SingleObject3();

	private SingleObject3() {
	}

	public static SingleObject3 getInstance() {
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello SingleObject3!");
	}
}

// 双重校验锁 double-checked locking，LazyInit:Y，ThreadSafe:Y
class SingleObject4 {
	private volatile static SingleObject4 singleton;

	private SingleObject4() {
	}

	public static SingleObject4 getInstance() {
		if (singleton == null) {
			synchronized (SingleObject4.class) {
				if (singleton == null) {
					singleton = new SingleObject4();
				}
			}
		}
		return singleton;
	}

	public void showMessage() {
		System.out.println("Hello SingleObject4!");
	}
}

// 静态内部类，LazyInit:Y，ThreadSafe:Y
class SingleObject5 {
	private static class SingletonHolder {
		private static final SingleObject5 INSTANCE = new SingleObject5();
	}

	private SingleObject5() {
	}

	public static final SingleObject5 getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public void showMessage() {
		System.out.println("Hello SingleObject5!");
	}
}
