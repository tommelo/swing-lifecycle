package org.swinglifecycle.lifecycle;

import java.util.Arrays;

import javax.swing.JFrame;

import org.swinglifecycle.view.BoundsPolicy;
import org.swinglifecycle.view.WindowController;

/**
 * 
 */
public class AppLifecycleTest implements Lifecycle {
		
	public void run(WindowController windowController, JFrame frame) {		
		windowController.show(frame, BoundsPolicy.MAXIMIZE);
	}

	public void configure(String[] args) {
		// whatever you want to configure
		System.out.println(Arrays.toString(args));
	}

	public boolean confirmExit() {
		//some logic to confirm the exit
		return true;
	}

	public void exit() {
		//save your stuff
		System.out.println("goodbye!");
		System.exit(0);
	}
    
}
