package Assignment.Model;

/********************************************
 * Purpose: Custom exception class which is used when a policy doesn't exist
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 20/05/2019
 ******************************************/
public class PolicyExistsException extends Exception
{

	/******************************************
	 * Purpose: Constructs the exception
	 * @param message
	 **********************************************/
	public PolicyExistsException(String message)
	{
		super(message);
	}

}
