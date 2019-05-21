package Assignment.View;
import Assignment.Controller.IOInterface;

import java.util.*;

/******************************************
 * Purpose: The Load class is a subclass of the IOInterface. It will be used
 * in the implementation of the strategy pattern. This class will only
 * contain a stub which will be implemented later on.
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 19/05/2019
 ***********************************************/
public class Load implements IOInterface
{
	/************************************
	 * Purpose: The IOOption method is currently a stub which states when the
	 * data is read in to the program. The actual purpose of the stub will
	 * be to load the data into each component of the program from where the
	 * user left off.
	 * @param IOMap
	 **************************************/
	@Override
	public void IOOption(Map<String, IOInterface> IOMap, String fileName)
	{
		System.out.println("Data was loaded: To be implemented");
	}
}
