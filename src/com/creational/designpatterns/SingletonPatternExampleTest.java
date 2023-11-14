package com.creational.designpatterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.creational.designpatterns.singleton.SingletonEagerPattenExample;
import com.creational.designpatterns.singleton.SingletonLazyPatternExample;

public class SingletonPatternExampleTest {
	public static void main(String[] args) {

		/*
		 * Eager intilization test
		 */
		// fetching single ton object in loops
		for (int i = 0; i <= 2; i++) {
			SingletonEagerPattenExample obj = SingletonEagerPattenExample.getInstance();
			System.out.println(obj.toString() + " :: " + obj.hashCode());
		}

		// Creating a fixed-size thread pool with 2 threads
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// Submitting tasks to the thread pool
		for (int i = 1; i <= 5; i++) {
			final int taskId = i;
			executorService.submit(() -> {
				System.out.println("Task " + taskId + " executed by thread: " + Thread.currentThread().getName());
				SingletonEagerPattenExample obj = SingletonEagerPattenExample.getInstance();
				System.out.println(obj.toString() + " :: " + obj.hashCode());
			});
		}

		// Shutting down the thread pool when it's no longer needed
		executorService.shutdown();

		/*
		 * Lazy intilization test
		 */

		// fetching single ton object in loops
		System.out.println("loop lazy test ");
		for (int i = 0; i <= 2; i++) {
			SingletonEagerPattenExample obj = SingletonEagerPattenExample.getInstance();
			System.out.println(obj.toString() + " :: " + obj.hashCode());
		}

		// Creating a fixed-size thread pool with 2 threads
		ExecutorService executorService1 = Executors.newFixedThreadPool(2);

		// Submitting tasks to the thread pool
		for (int i = 1; i <= 5; i++) {
			final int taskId = i;
			executorService1.submit(() -> {
				System.out.println("Task " + taskId + " executed by thread: " + Thread.currentThread().getName());
				SingletonLazyPatternExample obj = SingletonLazyPatternExample.getLazyInstance();
				System.out.println(obj.toString() + " :: " + obj.hashCode());
			});
		}

		// Shutting down the thread pool when it's no longer needed
		executorService1.shutdown();

	}
}
