/**
 * 
 */
package com.own.proyect.singletons;

import java.util.concurrent.Callable;

import com.own.proyect.singletons.threadsafety.SingletonTwo;

/**
 *
 */
public class ThreadSingletonTwo implements Callable<SingletonTwo> {

	public SingletonTwo call() throws Exception {
		return SingletonTwo.getInstance();
	}

}
