/**
 * 
 */
package com.own.proyect.singletons;

import java.util.concurrent.Callable;

import com.own.proyect.singletons.threadsafety.SingletonOne;

/**
 *
 */
public class ThreadSingletonOne implements Callable<SingletonOne> {

	public SingletonOne call() throws Exception {
		return SingletonOne.getInstance();
	}

}
