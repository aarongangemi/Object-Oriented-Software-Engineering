package Assignment.Controller;

import Assignment.Model.Person;
import Assignment.Model.PolicyArea;
import Assignment.Model.PolicyExistsException;
import Assignment.View.DisplayError;
import Assignment.View.MenuClass;
import java.util.*;

/*************************************************
 * Purpose: The purpose of the add class is used with the strategy Pattern.
 * It is a subclass of MenuOptionInterface which contains all the add methods
 * for each Person, policy area, talking point and keyword.
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 19/05/2019
 *************************************************/

public class AddController implements MenuOptionInterface
{
	private MenuClass menuObj;  //Dependency Injection of menu object
	private FactoryClass factoryObj;

	/**************************************
	 * Purpose: To set the menu object
	 * @param menuObj
	 *************************************/
	public AddController(MenuClass menuObj, FactoryClass factoryObj)
	{
		this.menuObj = menuObj;
		this.factoryObj = factoryObj;
	}

	/*************************************
	 * Purpose: The runPersonOption is a void method which calls the
	 * required input methods to construct and person, then calls the
	 * factory method in person to create a specific type of person
	 **********************************************/
	@Override
	public void runPersonOption(Map<Integer,Person> personMap, Map<String,
			PolicyArea> policyAreaMap)
	{
		char charType;
		Person person;
		charType = menuObj.getPersonType();  //gets the type
		String name = menuObj.getInputData( "Person name"); //get name
		person = factoryObj.createPerson(name,charType);
		menuObj.getPersonContacts(person); //get contact details
		if(personMap.containsKey(person.getIdNumber()))
		{
			DisplayError.showError("Person already exists, please try again");
		}
		else
		{
			personMap.put(person.getIdNumber(), person);
			//Add the person to the map
		}
	}

	/************************************************
	 * Purpose: The runPolicyAreaOption method creates a policy area by passing
	 * the policy name into the policy constructor. This is then passed into
	 * the map of policies if valid.
	 ************************************************/
	@Override
	public void runPolicyAreaOption(Map<String, PolicyArea> policyAreaMap)
	{
		String policyName = menuObj.getInputData("Policy name");
		//get policy name to know which policy it adds to
		//create policy
		PolicyArea policyArea;
		if(!policyAreaMap.containsKey(policyName))
		{
			policyArea = factoryObj.createPolicy(policyName);
			policyAreaMap.put(policyName, policyArea);
			//Add specified policy to map with name as key
		}
		else
		{
			DisplayError.showError("Policy already exists");
		}
	}

	/********************************************
	 * Purpose: The purpose of the runTalkingPointOption is to get the
	 * talking point name from the user then pass it into the set of
	 * talking points if it is valid.
	 * @param policyAreaName
	 * @throws PolicyExistsException
	 *********************************************/
	public void runTalkingPointOption(String policyAreaName, Map<String,
			PolicyArea> policyAreaMap) throws PolicyExistsException
	{
		//check if specified policy actually exists
		if(policyAreaMap.containsKey(policyAreaName))
		{
			String talkingPoint = menuObj.getInputData("Talking point");
			//Gets the name of the talking point
			if(policyAreaMap.get(policyAreaName).getTalkingPoints().
					contains(talkingPoint))
			{
				//Print line if talking point doesn't exist
				DisplayError.showError("Unable to add, talking point " +
											   "already exists");
			}
			else
			{
				policyAreaMap.get(policyAreaName).addTalkingPoint
												(talkingPoint);
				//Add talking point
			}
		}
		else
		{
			throw new PolicyExistsException("Policy area doesn't exist");
			//Throw exception if policy doesn't exist
		}
	}

	/***********************************************
	 * Purpose: The purpose of runKeywordOption is to check add the keyword
	 * to the set of keywords after the keyword and policy is specified.
	 * @param policyAreaName
	 * @throws PolicyExistsException
	 ************************************************/
	@Override
	public void runKeywordOption(String policyAreaName, Map<String,
					PolicyArea> policyAreaMap) throws PolicyExistsException
		{
		//check if policy exists
		if(policyAreaMap.containsKey(policyAreaName))
		{
			//if policy exists, get the keyword name
			String keyword = menuObj.getInputData("keyword");
			if(policyAreaMap.get(policyAreaName).getKeywords().contains
															(keyword))
			{
				DisplayError.showError("Unable to add keyword because keyword"+
											   " already exists");
				//if keyword already exists
			}
			else
			{
				policyAreaMap.get(policyAreaName).addKeyword(keyword);
				//if keyword doesn't exist
			}
		}
		else
		{
			throw new PolicyExistsException("Policy doesn't exist. Try again");
		}
	}






}