/**
 * 
 */
package com.own.proyect.singletons;

import java.util.concurrent.Callable;

import com.own.proyect.singletons.threadsafety.SingletonFour;

/**
 *
 */
public class ThreadSingletonFour implements Callable<SingletonFour> {

	public SingletonFour call() throws Exception {
		return SingletonFour.getInstance();
	}

}
