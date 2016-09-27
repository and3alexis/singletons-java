package com.own.proyect.singletons.threadsafety;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import com.own.proyect.singletons.ThreadSingletonTwo;

public class SingletonTwoTest {

	@Test
	public void test() {
		SingletonTwo singleton = SingletonTwo.getInstance();
		SingletonTwo singleton2 = SingletonTwo.getInstance();
		SingletonTwo singleton3 = SingletonTwo.getInstance();
		SingletonTwo singleton4 = SingletonTwo.getInstance();
		assertSame(singleton, singleton2);
		assertSame(singleton2, singleton3);
		assertSame(singleton3, singleton4);
	}
	
	@Test
	public void test1() {
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		List<ThreadSingletonTwo> list = new ArrayList<>();
		list.add(new ThreadSingletonTwo());
		list.add(new ThreadSingletonTwo());
		list.add(new ThreadSingletonTwo());
		list.add(new ThreadSingletonTwo());
		list.add(new ThreadSingletonTwo());
		
		List<Future<SingletonTwo>> futures = null;
		
		try {
			futures = executor.invokeAll(list);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		List<SingletonTwo> singletones = new ArrayList<>();
		
		try {
			if(futures != null && !futures.isEmpty()){
				for (Iterator<Future<SingletonTwo>> iterator = futures.iterator(); iterator.hasNext();) {
					Future<SingletonTwo> future = (Future<SingletonTwo>) iterator.next();
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
