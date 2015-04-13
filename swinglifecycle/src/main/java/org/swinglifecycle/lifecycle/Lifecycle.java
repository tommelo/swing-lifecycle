package org.swinglifecycle.lifecycle;

import javax.swing.JFrame;

import org.swinglifecycle.view.WindowController;

/**
 * 
 * @author Tom
 *
 */
public interface Lifecycle 
{
	/**
	 * 
	 * @param windowController
	 */
	public void run(WindowController windowController, JFrame frame);
	
	/**
	 * 
	 * @param args
	 */
	public void configure( String [] args );
	
	/**
	 * 
	 * @return
	 */
	public boolean confirmExit();
	
	/**
	 * 
	 */
	public void exit();
	
}
