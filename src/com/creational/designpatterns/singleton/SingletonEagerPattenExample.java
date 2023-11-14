package com.creational.designpatterns.singleton;

public class SingletonEagerPattenExample {
	private static SingletonEagerPattenExample stepe = new SingletonEagerPattenExample();

	private SingletonEagerPattenExample() {

	}

	public static SingletonEagerPattenExample getInstance() {
		return stepe;
	}

}
