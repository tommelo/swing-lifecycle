
package org.swinglifecycle.view;

import java.awt.Window;

import javax.swing.JApplet;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author tom
 */
public interface WindowController 
{
	/**
	 * 
	 * @param frame
	 * @param boundsPolicy
	 */
    public void show( JFrame frame, BoundsPolicy boundsPolicy );
    
    /**
     * 
     * @param dialog
     * @param boundsPolicy
     */
    public void show( JDialog dialog, BoundsPolicy boundsPolicy );
    
    /**
     * 
     * @param applet
     * @param boundsPolicy
     */
    public void show( JApplet applet, BoundsPolicy boundsPolicy );
    
    /**
     * 
     * @return
     */
    public Window getActiveWindow();
    
    /**
     * 
     * @return
     */
    public JFrame getRootFrame();
}
