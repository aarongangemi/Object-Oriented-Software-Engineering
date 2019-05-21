package Assignment.Model;
import Assignment.View.DisplayDetails;
import Assignment.View.DisplayError;
import edu.curtin.messaging.*;
import java.util.*;

/*************************************
 * Purpose: To construct a person with the required fields.
 * Author: Aaron Gangemi
 * Date Modified: 20/05/2019
 **************************************/
public abstract class Person
{
	private String name;
	protected String type;
	protected static int count = 0;
	protected int idNumber;
	private HashMap<Integer, String> contactDetails;

	//Classfields

	/****************************************
	 * Purpose: Creates a person
	 * @param name
	 **************************************/
	public Person(String name)
	{
		this.name = name;
		contactDetails = new HashMap<>();
		//Contact details stored in map
		type = getType();
	}

	/*****************************************
	 * Purpose: Accessor for name
 	 * @return name
	 ******************************************/
	public String getName()
	{
		return name;
	}

	/*******************************************
	 * Purpose: Accessor for ID
	 * @return idNumber
	 *******************************************/
	public int getIdNumber()
	{
		return idNumber;
	}

	/*******************************************
	 * Add a contact with integer key in map
	 * @param i
	 * @param contact
	 ****************************************/
	public void addContact(int i, String contact)
	{
		contactDetails.put(i, contact);
	}

	/*******************************************
	 * Purpose: Accessor for contact details
	 * @return contactDetails
	 ******************************************/
	public HashMap<Integer, String> getContactDetails()
	{
		return contactDetails;
	}

	/*********************************************
	 * Purpose: Views Contacts Details - string join is for format
	 ********************************************/
	public void viewContacts()
	{
		DisplayDetails.showContacts(contactDetails);

	}

	/***********************************************
	 * Purpose: Accessor for type
	 * @return type
	 **************************************************/
	public String getType()
	{
		return type;
	}

	/*******************************************
	 * Purpose: To use the persons contact details to notify them
	 * @param policyAreaName
	 */
	public void notifyPerson(String policyAreaName)
	{
		SMS text;
		String mobileString;
		Long mobileNumber;
		FacebookMessenger facebookMessage;
		TwitterMessenger twitterMessage;
		String id = Integer.toString(idNumber); //convert ID to string
		if (getContactDetails().containsKey(1)) //check if person has number
		{
			text = new SMS(); //Create new SMS
			mobileString = getContactDetails().get(1);
			mobileNumber = Long.parseLong(mobileString); //convert to number
			text.sendSMS(mobileNumber, policyAreaName + " has new data");
			//Send the SMS to given number - stub
		}
		if (getContactDetails().containsKey(2))
		{
			facebookMessage = new FacebookChild();
			facebookMessage.sendPrivateMessage(contactDetails.get(2), policyAreaName
						+ " has new data");
			//Send a private message if facebook exists
		}
		if (getContactDetails().containsKey(3))
		{
			twitterMessage = new TwitterChild();
			twitterMessage.sendPrivateMessage(contactDetails.get(3), policyAreaName
														+ " has new data");
			//Send a private message if twitter exists
		}
	}

	public void isTrending(String policyAreaName)
	{
		FacebookMessenger facebookMessenger = new FacebookChild();
		TwitterMessenger twitterMessenger = new TwitterChild();
		if(contactDetails.containsKey(2))
		{
			facebookMessenger.sendPrivateMessage(contactDetails.get(2), policyAreaName + " has data trending");
		}
		if (contactDetails.containsKey(3))
		{
			twitterMessenger.sendPrivateMessage(contactDetails.get(3), policyAreaName + " has data trending");
		}
	}

	/********************************
	 * Purpose: an abstract method which is implemented by the subclasses to
	 * add a notification
	 * @param policyArea
	 */
	public abstract void addNotification(PolicyArea policyArea);

}
