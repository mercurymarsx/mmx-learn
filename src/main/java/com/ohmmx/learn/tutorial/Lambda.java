package com.ohmmx.learn.tutorial;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

public class Lambda {
	public static void main(String[] args) {
		int i1 = Integer.MAX_VALUE;
		long l1 = Long.MAX_VALUE;
		double d1 = Double.MAX_VALUE;
		String s1 = "hello, kitty!";

		NoReturnNoParam noReturnNoParam = () -> {
			System.out.println("00: 无参无返回");
		};
		noReturnNoParam.method();

		Consumer<String> consumer = a -> {
			System.out.println("01: 输入一个泛型参数无返回: " + a);
		};
		consumer.accept(s1);

		IntConsumer intConsumer = a -> {
			System.out.println("02: 输入一个int参数无返回: " + a);
		};
		intConsumer.accept(i1);

		LongConsumer longConsumer = a -> {
			System.out.println("03: 输入一个long参数无返回: " + a);
		};
		longConsumer.accept(l1);

		DoubleConsumer doubleConsumer = a -> {
			System.out.println("04: 输入一个double参数无返回: " + a);
		};
		doubleConsumer.accept(d1);

		ObjIntConsumer<String> objIntConsumer = (a, b) -> {
			System.out.println(String.format("05: 输入一个泛型参数[%s]和一个int参数[%s]无返回", a, b));
		};
		objIntConsumer.accept(s1, i1);

		ObjLongConsumer<String> objLongConsumer = (a, b) -> {
			System.out.println(String.format("06: 输入一个泛型参数[%s]和一个long参数[%s]无返回", a, b));
		};
		objLongConsumer.accept(s1, l1);

		ObjDoubleConsumer<String> objDoubleConsumer = (a, b) -> {
			System.out.println(String.format("07: 输入一个泛型参数[%s]和一个double参数[%s]无返回", a, b));
		};
		objDoubleConsumer.accept(s1, d1);

		BiConsumer<Integer, String> biConsumer = (a, b) -> {
			System.out.println(String.format("08: 输入一个泛型参数[%s]和另一个泛型参数[%s]无返回", a, b));
		};
		biConsumer.accept(i1, s1);

		Function<Integer, String> function = a -> {
			return String.format("09: 输入一个泛型参数[%s]返回一个泛型值", a);
		};
		System.out.println(function.apply(i1));

		IntFunction<String> intFunction = a -> {
			return String.format("10: 输入一个int参数[%s]返回一个泛型值", a);
		};
		System.out.println(intFunction.apply(i1));

		IntToLongFunction intToLongFunction = a -> {
			return Long.valueOf(a);
		};
		System.out.println(String.format("11: 输入一个int参数[%s]返回一个long值[%s]", i1, intToLongFunction.applyAsLong(i1)));

		IntToDoubleFunction intToDoubleFunction = a -> {
			return Double.valueOf(a);
		};
		System.out.println(String.format("12: 输入一个int参数[%s]返回一个double值[%s]", i1, intToDoubleFunction.applyAsDouble(i1)));

		LongFunction<String> longFunction = a -> {
			return String.format("13: 输入一个long参数[%s]返回一个泛型值", a);
		};
		System.out.println(longFunction.apply(l1));

		LongToIntFunction longToIntFunction = a -> {
			String s = String.valueOf(a);
			return Integer.valueOf(s.substring(s.length() - 9, s.length()));
		};
		System.out.println(String.format("14: 输入一个long参数[%s]返回一个int值[%s]", l1, longToIntFunction.applyAsInt(l1)));

		LongToDoubleFunction longToDoubleFunction = a -> {
			return Double.valueOf(a);
		};
		System.out.println(String.format("15: 输入一个long参数[%s]返回一个double值[%s]", l1, longToDoubleFunction.applyAsDouble(l1)));

		DoubleFunction<String> doubleFunction = a -> {
			return String.format("16: 输入一个double参数[%s]返回一个泛型值", a);
		};
		System.out.println(doubleFunction.apply(d1));

		DoubleToIntFunction doubleToIntFunction = a -> {
			BigDecimal b = new BigDecimal(a);
			b = b.setScale(0, RoundingMode.HALF_UP);
			String s = b.toString();
			return Integer.valueOf(s.substring(s.length() - 9, s.length()));
		};
		System.out.println(String.format("17: 输入一个double参数[%s]返回一个int值[%s]", d1, doubleToIntFunction.applyAsInt(d1)));

		DoubleToLongFunction doubleToLongFunction = a -> {
			BigDecimal b = new BigDecimal(a);
			b = b.setScale(0, RoundingMode.HALF_UP);
			String s = b.toString();
			return Long.valueOf(s.substring(s.length() - 18, s.length()));
		};
		System.out.println(String.format("18: 输入一个double参数[%s]返回一个long值[%s]", d1, doubleToLongFunction.applyAsLong(d1)));

		BiFunction<Integer, Long, String> biFunction = (a, b) -> {
			return String.format("19: 输入一个泛型参数[%s]和另一个泛型参数[%s]返回一个泛型值", a, b);
		};
		System.out.println(biFunction.apply(i1, l1));

		ToIntFunction<String> toIntFunction = a -> {
			System.out.println(String.format("20: 输入一个泛型参数[%s]返回一个int值[%s]", a, i1));
			return i1;
		};
		toIntFunction.applyAsInt(s1);

		ToIntBiFunction<Long, String> toIntBiFunction = (a, b) -> {
			System.out.println(String.format("21: 输入一个泛型参数[%s]和另一个泛型参数[%s]返回一个int值[%s]", a, b, i1));
			return i1;
		};
		toIntBiFunction.applyAsInt(l1, s1);

		ToLongFunction<String> toLongFunction = a -> {
			System.out.println(String.format("22: 输入一个泛型参数[%s]返回一个long值[%s]", a, l1));
			return l1;
		};
		toLongFunction.applyAsLong(s1);

		ToLongBiFunction<Double, String> toLongBiFunction = (a, b) -> {
			System.out.println(String.format("23: 输入一个泛型参数[%s]和另一个泛型参数[%s]返回一个long值[%s]", a, b, l1));
			return l1;
		};
		toLongBiFunction.applyAsLong(d1, s1);

		ToDoubleFunction<String> toDoubleFunction = a -> {
			System.out.println(String.format("24: 输入一个泛型参数[%s]返回一个double值[%s]", a, d1));
			return d1;
		};
		toDoubleFunction.applyAsDouble(s1);

		ToDoubleBiFunction<Integer, String> toDoubleBiFunction = (a, b) -> {
			System.out.println(String.format("25: 输入一个泛型参数[%s]和另一个泛型参数[%s]返回一个double值[%s]", a, b, d1));
			return d1;
		};
		toDoubleBiFunction.applyAsDouble(i1, s1);

		UnaryOperator<Integer> unaryOperator = a -> {
			return a + 1;
		};
		System.out.println(String.format("26: 输入泛型参数[%s]返回泛型值[%s].两个泛型相同,等价于Function<T,T>", //
				1, unaryOperator.apply(1)));

		BinaryOperator<Integer> binaryOperator = (a, b) -> {
			return a + b;
		};
		System.out.println(String.format("27: 输入泛型参数[%s]和泛型参数[%s]返回泛型值[%s].三个泛型相同,等价于BiFunction<T,T,T>", //
				1, 2, binaryOperator.apply(1, 2)));

		IntUnaryOperator intUnaryOperator = a -> {
			return a + 1;
		};
		System.out.println(String.format("28: 输入int参数[%s]返回int值[%s]", //
				1, intUnaryOperator.applyAsInt(1)));

		IntBinaryOperator intBinaryOperator = (a, b) -> {
			return a + b;
		};
		System.out.println(String.format("29: 输入int参数[%s]和int参数[%s]返回int值[%s]", //
				1, 2, intBinaryOperator.applyAsInt(1, 2)));

		LongUnaryOperator longUnaryOperator = a -> {
			return a + 1;
		};
		System.out.println(String.format("30: 输入long参数[%s]返回long值[%s]", //
				100, longUnaryOperator.applyAsLong(100)));

		LongBinaryOperator longBinaryOperator = (a, b) -> {
			return a + b;
		};
		System.out.println(String.format("31: 输入long参数[%s]和long参数[%s]返回long值[%s]", //
				100, 200, longBinaryOperator.applyAsLong(100, 200)));

		DoubleUnaryOperator doubleUnaryOperator = a -> {
			return a + 1;
		};
		System.out.println(String.format("32: 输入double参数[%s]返回double值[%s]", //
				10000, doubleUnaryOperator.applyAsDouble(10000)));

		DoubleBinaryOperator doubleBinaryOperator = (a, b) -> {
			return a + b;
		};
		System.out.println(String.format("33: 输入double参数[%s]和double参数[%s]返回double值[%s]", //
				10000, 20000, doubleBinaryOperator.applyAsDouble(10000, 20000)));

		Predicate<String> predicate = a -> {
			return "1".equals(a);
		};
		System.out.println(String.format("34: 输入泛型参数[%s]返回布尔值[%s]", s1, predicate.test(s1)));

		BiPredicate<Integer, String> biPredicate = (a, b) -> {
			return String.valueOf(a).equals(b);
		};
		System.out.println(String.format("35: 输入泛型参数[%s]和泛型参数[%s]返回布尔值[%s]", i1, s1, biPredicate.test(i1, s1)));

		IntPredicate intPredicate = a -> {
			return a == 1;
		};
		System.out.println(String.format("36: 输入int参数[%s]返回布尔值[%s]", i1, intPredicate.test(i1)));

		LongPredicate longPredicate = a -> {
			return a == 1;
		};
		System.out.println(String.format("37: 输入long参数[%s]返回布尔值[%s]", l1, longPredicate.test(l1)));

		DoublePredicate doublePredicate = a -> {
			return a == 1;
		};
		System.out.println(String.format("38: 输入double参数[%s]返回布尔值[%s]", d1, doublePredicate.test(d1)));

		Supplier<String> supplier = () -> {
			return s1;
		};
		System.out.println(String.format("39: 无参数返回泛型值[%s]", supplier.get()));

		BooleanSupplier booleanSupplier = () -> {
			return true;
		};
		System.out.println(String.format("40: 无参数返回布尔值[%s]", booleanSupplier.getAsBoolean()));

		IntSupplier intSupplier = () -> {
			return i1;
		};
		System.out.println(String.format("41: 无参数返回int值[%s]", intSupplier.getAsInt()));

		LongSupplier longSupplier = () -> {
			return l1;
		};
		System.out.println(String.format("42: 无参数返回long值[%s]", longSupplier.getAsLong()));

		DoubleSupplier doubleSupplier = () -> {
			return d1;
		};
		System.out.println(String.format("43: 无参数返回double值[%s]", doubleSupplier.getAsDouble()));

		// 创建多线程
		// new Thread(() -> System.out.println("Hello world !")).start();

		// 简单的使用场景
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		// 可以将以上基本方法作为参数传递，例：
		System.out.println("输出所有数据:");
		eval(list, n -> true);
		System.out.println("输出所有偶数:");
		eval(list, n -> n % 2 == 0);
		System.out.println("输出大于 3 的所有数字:");
		eval(list, n -> n > 3);
	}

	public static void eval(List<Integer> list, Predicate<Integer> predicate) {
		for (Integer n : list) {
			if (predicate.test(n)) {
				System.out.println(String.valueOf(n));
			}
		}
	}
}

/** 无参无返回值 */
@FunctionalInterface
interface NoReturnNoParam {
	void method();
}
