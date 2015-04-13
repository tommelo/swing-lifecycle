package org.swinglifecycle.lifecycle;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.swinglifecycle.view.WindowController;
import org.swinglifecycle.view.WindowControllerImpl;

/**
 * 
 * @author Tom
 *
 */
public class Launcher implements Runnable 
{	
	private String [] args;
	private Lifecycle lifecycle;
	private WindowController windowController;
	private JFrame frame;
	
	/**
	 * 
	 * @param args
	 * @param lifecycle
	 */
	private Launcher(String [] args, Lifecycle lifecycle)
	{
		this.args = args;
		this.lifecycle = lifecycle;
		
		windowController = new WindowControllerImpl();
		frame = new JFrame();
	}
	
	/**
	 * 
	 */
	protected void launch()
	{
		EventQueue.invokeLater(this);
	}
	
	/**
	 * 
	 * @param args
	 * @param lifecycle
	 */
	public static void launch(String [] args, Lifecycle lifecycle)
	{
		Launcher launcher = new Launcher(args, lifecycle);
		launcher.launch();
	}
		
	public void run() 
	{
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (lifecycle.confirmExit()){
					frame.dispose();
					lifecycle.exit();
				}					
			}
		});
		
		lifecycle.configure(args);
		lifecycle.run(windowController, frame);		
	}
	
	
	
	
}
