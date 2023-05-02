package com.ohmmx.learn.tutorial;

/**
 * 内部类
 */
public class OuterClass {
	private int age = 18;
	private static int age2 = 22;

	/** 成员内部类/普通内部类 */
	private class InnerMember {
		private int age = 15;

		public void showAge() {
			int age = 10;
			System.out.println("InnerMember[A]: " + age); // 10
			System.out.println("InnerMember[B]: " + this.age); // 15
			System.out.println("InnerMember[C]: " + OuterClass.this.age); // 18
		}
	}

	/** 局部内部类/方法内部类 */
	public void method() {
		// 为避免随方法调用结束数据消失，添加final修饰
		// 如果没有final修饰，多次调用会多次初始化，不影响结果，但影响性能
		final int age3 = 20;

		class InnerLocal {
			public void show() {
				System.out.println("InnerLocal[A]: " + age); // 18
				// 从内部类中访问方法内变量age2，需要将变量声明为最终类型。
				System.out.println("InnerLocal[B]: " + age3); // 20
			}
		}

		InnerLocal i = new InnerLocal();
		i.show();
	}

	/** 静态内部类 */
	static class InnerStatic {
		public void method() {
			// System.out.println(age); // 错误，静态内部类无法调用父类的非静态参数
			System.out.println("InnerStatic[A]: " + age2); // 22 正确
		}
	}

	public static void main(String[] args) {
		// 成员内部类
		OuterClass outer = new OuterClass();
		OuterClass.InnerMember innerMember = outer.new InnerMember();
		innerMember.showAge();

		// 局部内部类
		outer.method();

		// 静态内部类，不用初始化外部类直接初始化内部类
		OuterClass.InnerStatic innerStatic = new OuterClass.InnerStatic();
		innerStatic.method();

		// 匿名内部类
		OuterAnonymousClass outerAnonymous = new OuterAnonymousClass();
		outerAnonymous.method();
	}
}

interface InnerAnonymous {
	public abstract void show();
}

/** 匿名内部类 */
class OuterAnonymousClass {
	public void method() {
		new InnerAnonymous() {
			public void show() {
				System.out.println("Hello World!");
			}
		}.show();
	}
}
