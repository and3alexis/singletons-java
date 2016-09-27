package com.own.proyect.singletons.nonthreadsafty;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import com.own.proyect.singletons.ThreadSingletonThree;
import com.own.proyect.singletons.nonthreadsafety.SingletonThree;

public class SingletonThreeTest {

	@Test
	public void test() {
		SingletonThree singletonThree = SingletonThree.getInstance();
		SingletonThree singletonThree2 = SingletonThree.getInstance();
		SingletonThree singletonThree3 = SingletonThree.getInstance();
		SingletonThree singletonThree4 = SingletonThree.getInstance();
		assertSame(singletonThree, singletonThree2);
		assertSame(singletonThree2, singletonThree3);
		assertSame(singletonThree3, singletonThree4);
	}
	
	@Test
	public void test1() {
		
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		List<ThreadSingletonThree> list = new ArrayList<>();
		list.add(new ThreadSingletonThree());
		list.add(new ThreadSingletonThree());
		list.add(new ThreadSingletonThree());
		list.add(new ThreadSingletonThree());
		list.add(new ThreadSingletonThree());
		
		List<Future<SingletonThree>> futures = null;
		
		try {
			futures = executor.invokeAll(list);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		List<SingletonThree> singletonThrees = new ArrayList<>();
		
		try {
			if(futures != null && !futures.isEmpty()){
				for (Iterator<Future<SingletonThree>> iterator = futures.iterator(); iterator.hasNext();) {
					Future<SingletonThree> future = (Future<SingletonThree>) iterator.next();
					singletonThrees.add(future.get());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		
		assertSame(singletonThrees.get(0), singletonThrees.get(1));
		assertSame(singletonThrees.get(1), singletonThrees.get(2));
		assertSame(singletonThrees.get(2), singletonThrees.get(3));
		assertSame(singletonThrees.get(3), singletonThrees.get(4));
	}

}
