package Assignment.Controller;

import Assignment.Model.Person;
import Assignment.Model.PersonIDException;
import Assignment.Model.PolicyArea;
import Assignment.Model.PolicyExistsException;
import Assignment.View.*;
import edu.curtin.messaging.FacebookChild;
import edu.curtin.messaging.FacebookMessenger;

import java.util.*;

/******************************************
 * Purpose: The purpose of the MainController is to hold the function
 * in which main can call to run the program.
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 19/05/2019
 *********************************************/
public class UIController
{
	private Map<Integer, Person> personMap;
	private Map<Integer, MenuOptionInterface> menuMap;
	private Map<String, PolicyArea> policyAreaMap;
	private Map<String, IOInterface> IOMap;
	private MenuClass menuObject;
	private AddController addOption;
	private RemoveController removeOption;
	private ViewData viewOption;
	private NotificationController notification;
	//All fields declared to be used for dependency injection
	public UIController(MenuClass menuObject, AddController addOption,
						RemoveController removeOption,
						ViewData viewOption,
						NotificationController notification)
	{
		personMap = new HashMap<>();
		policyAreaMap = new HashMap<>();
		menuMap = new HashMap<>();
		IOMap = new HashMap<>();
		this.menuObject = menuObject;
		this.addOption = addOption;
		this.removeOption = removeOption;
		this.viewOption = viewOption;
		this.notification = notification;

		//fields set in constructor
	}

	/****************************************
	 * Purpose: run() is called in the main. First the run() function
	 * calls the load method which acts as a stub. Then it switches between
	 * the electoral menu after asking the user for their desired option. It
	 * stores add, view and remove options which utilizes the strategy pattern
	 * to then switch between the add, view and remove and notification
	 * functionality. Following this, the menu is looped until the user selects
	 * exit at which run saves the data.
	 *******************************************/
	public void runMain()
	{
		IOMap.put("Load", new Load());
		IOMap.put("Save", new Save());
		IOMap.get("Load").IOOption(IOMap, "TEST"); //load data
		String policyName, personID, fileName;
		PolicyArea policyArea;
		int startMenuOption;
		//Each option is added to the map. This uses the strategy pattern to
		//decipher between the menu
		int menuOption = menuObject.electoralMenu(); //call first menu
		menuMap.put(1, addOption);  //adds data
		menuMap.put(2, removeOption); //removes data
		menuMap.put(3, viewOption); //view data
		while (menuOption != 7)
		{
			try
			{
				switch (menuOption)
				{
					//by storing the functionality objects in a map, I call
					//the required option from the map using the returned
					//data from the menu, then call the method
					case 1:
						startMenuOption = menuObject.startMenu(); //get the option
						menuMap.get(startMenuOption).runPersonOption
											(personMap,policyAreaMap);
						break;
					case 2:
						startMenuOption = menuObject.startMenu(); //get the option
						menuMap.get(startMenuOption).runPolicyAreaOption
													(policyAreaMap);
						break;
					case 3:
						startMenuOption = menuObject.startMenu(); //get the option
						policyName = menuObject.getInputData("Policy Name");
						//First we require the policy name to access the
						//set of talking points
						menuMap.get(startMenuOption).runTalkingPointOption
											(policyName, policyAreaMap);
						break;
					case 4:
						startMenuOption = menuObject.startMenu();
						//get the option
						//First we require the policy name to access the
						//set of keywords
						policyName = menuObject.getInputData("Policy Name");
						menuMap.get(startMenuOption).runKeywordOption
													(policyName, policyAreaMap);
						break;
					case 5:
						startMenuOption = menuObject.notificationMenu();
						//get the option
						if(startMenuOption == 1)
						{
							notification.createNotification
										(personMap, policyAreaMap);
						}
						else if(startMenuOption == 2)
						{
							notification.removeNotification
									(policyAreaMap,personMap);
						}
						break;
					case 6:
						fileName = menuObject.getInputData("File name");
						IOMap.get("Save").IOOption(IOMap, fileName);
						break;
				}

				menuOption = menuObject.electoralMenu();
				//called again to loop the menu
			}
			catch (PolicyExistsException ex)
			{
				DisplayError.showError("Policy doesn't exist, try again");
				menuOption = menuObject.electoralMenu();
				//Error if the policy doesn't exist in functions called above
			}
			catch (PersonIDException ex2)
			{
				DisplayError.showError("Person ID doesn't exist, try again");
				menuOption = menuObject.electoralMenu();
				//Error if the person doesn't exist in functions called above
			}
		}
		//Once user exits then call save which is to be implemented
	}
}
