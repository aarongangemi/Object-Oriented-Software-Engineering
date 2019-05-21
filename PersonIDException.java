package Assignment.Model;

/**************************************
 * Purpose: An exception class if the person ID doesn't exist
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 20/05/2019
 *****************************************/
public class PersonIDException extends Exception
{
	/*************************************
	 * Purpose: Construct the exception
	 * @param message
	 **************************************/
	public PersonIDException(String message)
	{
		super(message);
	}
}
