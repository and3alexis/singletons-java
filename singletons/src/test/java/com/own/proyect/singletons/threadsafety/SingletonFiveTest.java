package com.own.proyect.singletons.threadsafety;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import com.own.proyect.singletons.ThreadSingletonFive;

public class SingletonFiveTest {

	@Test
	public void test() {
		SingletonFive singleton = SingletonFive.getInstance();
		SingletonFive singleton2 = SingletonFive.getInstance();
		SingletonFive singleton3 = SingletonFive.getInstance();
		SingletonFive singleton4 = SingletonFive.getInstance();
		assertSame(singleton, singleton2);
		assertSame(singleton2, singleton3);
		assertSame(singleton3, singleton4);
	}
	
	@Test
	public void test1() {
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		List<ThreadSingletonFive> list = new ArrayList<>();
		list.add(new ThreadSingletonFive());
		list.add(new ThreadSingletonFive());
		list.add(new ThreadSingletonFive());
		list.add(new ThreadSingletonFive());
		list.add(new ThreadSingletonFive());
		
		List<Future<SingletonFive>> futures = null;
		
		try {
			futures = executor.invokeAll(list);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		List<SingletonFive> singletones = new ArrayList<>();
		
		try {
			if(futures != null && !futures.isEmpty()){
				for (Iterator<Future<SingletonFive>> iterator = futures.iterator(); iterator.hasNext();) {
					Future<SingletonFive> future = (Future<SingletonFive>) iterator.next();
					singletones.add(future.get());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		
		assertSame(singletones.get(0), singletones.get(1));
		assertSame(singletones.get(1), singletones.get(2));
		assertSame(singletones.get(2), singletones.get(3));
		assertSame(singletones.get(3), singletones.get(4));
	}

}
