
package org.swinglifecycle.view;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.WindowEvent;

import javax.swing.JApplet;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author tom
 */
public class WindowControllerImpl implements WindowController, AWTEventListener 
{
	private Window window;
	private JFrame root;
	
    public void show(JFrame frame, BoundsPolicy boundsPolicy) 
    {
    	Toolkit.getDefaultToolkit().
			addAWTEventListener(this, AWTEvent.WINDOW_EVENT_MASK);
    	
    	this.root = frame;
        initBounds(frame, boundsPolicy);               
    }


    public void show(JDialog dialog, BoundsPolicy boundsPolicy) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public void show(JApplet applet, BoundsPolicy boundsPolicy) 
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    private void initBounds(JFrame frame, BoundsPolicy boundsPolicy) 
    {
    	if ( !EventQueue.isDispatchThread() ) 
    	{
			throw new IllegalStateException(
				"WindowController.show() should be called from the Event Dispatch Thread =(");
		}
    	
        switch( boundsPolicy ) 
        {          
            case CENTER_ONLY :
            	frame.setLocationRelativeTo(null); 
				break;
                
            case MAXIMIZE :
            	Toolkit toolKit = Toolkit.getDefaultToolkit();
				Dimension d = toolKit.getScreenSize();
				
				Insets in = Toolkit.getDefaultToolkit().
					getScreenInsets( frame.getGraphicsConfiguration() );
				
				int width  = d.width - (in.left + in.top);
				int height = d.height - (in.top + in.bottom);	
				int x      = in.left;
				int y      = in.top; 
				
				frame.pack();
				frame.setSize( width, height );
				frame.setLocation(x, y);
				
				break;
                
            case MAXIMIZE_BOOTH :
            	frame.setState(JFrame.MAXIMIZED_BOTH);
                break;
                
            case PACK_AND_CENTER :
            	frame.pack();
            	frame.setLocationRelativeTo(null);
				break;
            
            case PACK_ONLY :
            	frame.pack();
                break;
                
            case RESTORE_LAST_STATE :

                break;
                
            default:
                break;                                                    
        }
                        
        frame.setVisible(true);        
    }
    
    public void eventDispatched( AWTEvent awtEvent ) 
	{
		if ( awtEvent instanceof WindowEvent ) 
		{
			WindowEvent we = (WindowEvent) awtEvent;		
			switch( we.getID() ) 
			{			
				case WindowEvent.WINDOW_ACTIVATED:
					window = we.getWindow(); 
					break;
					
				case WindowEvent.WINDOW_DEACTIVATED:
					window = null; 
					break;
					
				default:					
					break;					
			}			
		}		
	}
    
    public Window getActiveWindow() 
	{
		return window;
	}


	public JFrame getRootFrame() 
	{
		return root;
	}
}
