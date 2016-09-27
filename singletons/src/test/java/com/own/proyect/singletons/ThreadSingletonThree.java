/**
 * 
 */
package com.own.proyect.singletons;

import java.util.concurrent.Callable;

import com.own.proyect.singletons.nonthreadsafety.SingletonThree;

/**
 *
 */
public class ThreadSingletonThree implements Callable<SingletonThree> {

	public SingletonThree call() throws Exception {
		return SingletonThree.getInstance();
	}

}
