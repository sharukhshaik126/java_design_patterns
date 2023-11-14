package com.creational.designpatterns.singleton;

public class SingletonLazyPatternExample {
	private static SingletonLazyPatternExample stlpe = null;

	private SingletonLazyPatternExample() {

	}

	public static SingletonLazyPatternExample getLazyInstance() {
		if (stlpe == null) {
			return new SingletonLazyPatternExample();
		}
		return stlpe;
	}

}
