# swing-lifecycle
A simple Java Swing App Lifecycle

### Example

The app lifecycle 

```java
public class AppLifecycle implements Lifecycle {
		
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
```
Launcher

```java
public class AppTest {
	
	public static void main(String [] args){
		Launcher.launch(args, new AppLifecycle());
	}
	
}
```
