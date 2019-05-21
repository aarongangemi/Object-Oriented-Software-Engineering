package Assignment.View;

import Assignment.Model.Person;
import Assignment.Model.PolicyArea;

import java.util.*;

/************************************************
 * Purpose: The purpose of the MenuClass is to store all the menu's for the
 * program. Each menu contains the corresponding validation to validate the
 * input
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 20/05/2019
 *************************************************/
public class MenuClass
{
	/****************************************
	 * Purpose: This is the startMenu. It asks the user whether they would like
	 * to add,view or remove data.
	 * @return optionSelected
	 ******************************************/
	public int startMenu()
	{
		Scanner sc = new Scanner(System.in); //Create Scanner
		int optionSelected = 0;
		try
		{
			System.out.println("Please enter one of the following options");
			System.out.println("1. Add");
			System.out.println("2. Remove");
			System.out.println("3. View");
			//Display menu
			optionSelected = sc.nextInt();
			while (optionSelected < 1 || optionSelected > 3)
			{
				//Loop until valid number is entered
				System.out.println("Please enter a number between 1 and 3");
				optionSelected = sc.nextInt(); //re-enter value
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Invalid option, please try again");
			//If the user enters a string rather than an integer
		}
		return optionSelected;
	}

	/*********************************************
	 * Purpose: This menu asks the user which data they would
	 * like to manage/modify.
	 * @return optionSelected
	 ******************************************/
	public int electoralMenu()
	{
		Scanner sc = new Scanner(System.in);
		//Create Scanner
		int optionSelected = 0;
		try
		{
			//Display all menu options
			System.out.println("Please enter one of the following options");
			System.out.println("1. Person");
			System.out.println("2. Policy Area");
			System.out.println("3. Talking Point");
			System.out.println("4. Keywords");
			System.out.println("5. Add Notification Setting for person");
			System.out.println("6. Save data to file");
			System.out.println("7. Exit");
			optionSelected = sc.nextInt();
			//User enters menu
			while (optionSelected < 1 || optionSelected > 7)
			{
				System.out.println("Please enter a number between 1 and 7");
				optionSelected = sc.nextInt();
				//Re-enter value if invalid integer
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Invalid option, please try again");
			//If user enters the string
		}
		return optionSelected;
	}

	/*******************************************
	 * Purpose: To ask the user for the person type then return the
	 * character representing the person type
	 * @return type
	 ****************************************/
	public Character getPersonType()
	{
		Scanner sc = new Scanner(System.in);
		//Create the scanner
		char type;
		System.out.println("Please enter a character representing the " +
								   "person type");
		System.out.println("C = Candidate");
		System.out.println("S = Strategist");
		System.out.println("V = Volunteer");
		//Ask the user for the Type they would like to enter
		type = sc.next().charAt(0);
		while((type != 'C' && type != 'V' && type != 'S'))
		{
			//Check it's a valid character
			System.out.println("Please enter a valid character from the menu");
			type = sc.next().charAt(0);
			//Get the character representing the type
		}
		return type;
	}


	/**********************************************
	 * Purpose: To ask the user for the persons contacts then if they enter
	 * it then add it to the map. The map is used to display the menu.
	 * Validation is done on each contact detail in this method
	 * @param person
	 ***********************************************************/
	public void getPersonContacts(Person person)
	{

		boolean mobileEntered = false;
		boolean facebookEntered = false;
		boolean twitterEntered = false;
		String mobileNumber, facebookID, twitterUsername;
		HashMap<Integer, String> menuList = new HashMap<>();
		//Map used to store menu options
		int contactOption;
		Scanner sc = new Scanner(System.in);
		//Create scanner
		System.out.println("Please select one or more of the below to enter");
		menuList.put(1, "Mobile Number");
		menuList.put(2, "Facebook ID");
		menuList.put(3, "Twitter username");
		menuList.put(4, "Exit");
		//Add menu options to map
		for(Integer i : menuList.keySet())
		{
			System.out.println(i + "." + menuList.get(i));
		}
		//Print menu
		contactOption = sc.nextInt();
		//Get menu option as integer
		while (contactOption != 4) //Check if student doesn't enter exit
		{
			if (contactOption == 1 && !mobileEntered)
			{
				//If mobile is selected and isn't already entered
				System.out.println("Please enter a mobile number");
				sc.nextLine();
				//User enters a mobile number
				mobileNumber = sc.nextLine();
				while ((mobileNumber.length() < 8 ||
						mobileNumber.length() > 15)
						|| !(mobileNumber.matches("[0-9]+")))
				{
					System.out.println("Please enter a valid mobile number" +
											   " between 8 and 15 characters");
					mobileNumber = sc.nextLine();
					//Get valid input if invalid number
				}
				mobileEntered = true; //mobile number entered is true
				person.addContact(1,mobileNumber); //Add contact
				menuList.remove(contactOption); //remove from menu
			}
			else if (contactOption == 2 && !facebookEntered)
			{
				System.out.println("Please enter a Facebook ID");
				sc.nextLine();
				facebookID = sc.nextLine();
				//User enter facebook ID
				while (facebookID.isEmpty() && facebookID.trim().isEmpty())
				{
					System.out.println("Please enter a valid facebook ID "
											   + "that is not empty ");
					facebookID = sc.nextLine();
					//Check if facebook ID is empty
				}
				facebookEntered = true;
				//Facebook is valid, add contact, then remove from map
				person.addContact(2,facebookID);
				menuList.remove(contactOption);
			}
			else if (contactOption == 3 && !twitterEntered)
			{
				//if user enters twitter
				System.out.println("Please enter a Twitter username");
				sc.nextLine();
				twitterUsername = sc.nextLine();
				//users enters ID
				while (twitterUsername.isEmpty() &&
						twitterUsername.trim().isEmpty())
				{
					System.out.println("Please enter a valid twitter username"
											   + " that is not empty ");
					twitterUsername = sc.nextLine();
					//If twitter is empty then loop
				}
				twitterEntered = true; //twitter is valid
				person.addContact(3, twitterUsername);
				menuList.remove(contactOption);
				//remove from map and add to contact
			}
			System.out.println("Please enter one of the following");
			for(Integer i : menuList.keySet())
			{
				System.out.println(i + "." + menuList.get(i));
			}
			//Loop new menu
			contactOption = sc.nextInt();
			//User enters menu option
		}
	}


	/***********************************************
	 * Purpose: To ask the user whether they would like to confirm they
	 * whether they would like to delete the policy Area
	 * @param policy
	 * @return remove
	 ***************************************************/
	public boolean confirmPolicyRemoval(PolicyArea policy)
	{
		boolean remove = false;
		char option;
		Scanner sc = new Scanner(System.in); //Create scanner
		if((policy.getTalkingPoints().size() > 0)) //check talking points exist
		{
			System.out.println("The following Talking points exist:");
			policy.viewTalkingPoints(); //show talking points
		}
		if(policy.getKeywords().size() > 0) //check keywords exist
		{
			System.out.println("The following keywords exist: ");
			policy.viewKeywords(); //show keywords
		}
		System.out.println("Would you like to remove the policy? (Y/N)");
		option = sc.next().charAt(0); //User enters Yes or No
		while (!(option == 'Y' ) && !(option == 'N')) //check if yes/no
		{
			System.out.println("Would you like to remove them? (Y/N)");
			option = sc.next().charAt(0);
			//Continue asking until valid
		}
		if(option == 'Y')
		{
			remove = true; //if Yes, then remove true
		}
		return remove;
	}

	/******************************************
	 * Purpose: Asks the user for a string and validates the string
	 * is not empty
	 * @param str1
	 * @return str1
	 *******************************************/
	public String getInputData(String str1)
	{
		String str;
		Scanner sc = new Scanner(System.in); //Create Scanner
		System.out.println("Please enter the " + str1);
		str = sc.nextLine(); //User enters string
		while (str.isEmpty() && str.trim().isEmpty())
		{
			System.out.println("Please enter a valid name");
			str = sc.nextLine();
			//If empty string then re-ask user
		}
		return str;
	}

	/**********************************************
	 * Purpose:Ask the user whether they would like to add or remove
	 * notifications.
	 * @return optionSelected
	 */
	public int notificationMenu()
	{
		Scanner sc = new Scanner(System.in);
		//Create Scanner
		int optionSelected = 0;
		try
		{
			System.out.println("Please enter one of the following options");
			System.out.println("1. Add");
			System.out.println("2. Remove");
			optionSelected = sc.nextInt();
			//User selects add or remove
			while (optionSelected < 1 || optionSelected > 2)
			{
				System.out.println("Please enter a number between 1 and 2");
				optionSelected = sc.nextInt();
				//Re-enter valid number
			}
		}
		catch (InputMismatchException e)
		{
			//If user enters a string
			System.out.println("Invalid option, please try again");
		}
		return optionSelected;
	}

	/********************************************
	 * Purpose: To ask the user for the person ID
	 * @return personID
	 ********************************************/
	public int getPersonID()
	{
		Scanner sc = new Scanner(System.in);
		//Create scanner
		int personID = 0;
		boolean isValid = false;
		while(!isValid) //While integer isn't valid
		{
			try
			{
				System.out.println("Please enter the ID as an integer");
				personID = sc.nextInt();
				//Continue asking for ID
				isValid = true;
			}
			catch (InputMismatchException ex)
			{
				System.out.println("Please enter a valid ID as an integer");
				sc.nextLine();
				//Check if string
			}
		}
		return personID;
	}



}
