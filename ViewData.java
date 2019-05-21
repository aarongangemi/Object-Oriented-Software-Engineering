package Assignment.View;
import Assignment.Model.Person;
import Assignment.Model.PolicyArea;
import Assignment.Model.PolicyExistsException;
import Assignment.Controller.MenuOptionInterface;
import java.util.*;

/**********************************************
 * Purpose: The purpose of view data is to store all methods which
 * are used when the user selects view. This uses the strategy pattern
 * and the interface switches between option
 ************************************************/
public class ViewData implements MenuOptionInterface
{

	/**********************************************
	 * Purpose: The purpose is to view all people in the person map
	 * @param personMap
	 * @param policyAreaMap
	 *********************************************/
	@Override
	public void runPersonOption(Map<Integer,Person> personMap,
								Map<String, PolicyArea> policyAreaMap)
	{
		if (personMap.size() != 0)  //If person map isn't empty
		{
			for (Person p : personMap.values()) //view all people
			{
				System.out.print("[" + p.getName() + ", " + p.getType()
										 + ", " + p.getIdNumber());
				p.viewContacts();
			}
		}
		else //if not person exists
		{
			System.out.println("No results found");
		}
	}

	/********************************************
	 * Purpose: The purpose is to view all policy areas
	 * @param policyAreaMap
	 *******************************************/
	@Override
	public void runPolicyAreaOption(Map<String, PolicyArea> policyAreaMap)
	{
		if (policyAreaMap.size() != 0) //check policy map isn't empty
		{
			for (String policyName : policyAreaMap.keySet())
			{
				System.out.println(policyName);
				//view all policy areas
			}
		}
		else
		{
			//if empty then no results found
			System.out.println("No results found");
		}
	}

	/************************************************
	 * Purpose: To view all talking points for the policy area specified
	 * @param policyAreaName
	 * @param policyAreaMap
	 * @throws PolicyExistsException
	 **********************************************/
	@Override
	public void runTalkingPointOption(String policyAreaName,
									  Map<String, PolicyArea> policyAreaMap)
										throws PolicyExistsException
	{
		if(policyAreaMap.size() != 0) //check policy map isn't empty
		{
			if(policyAreaMap.containsKey(policyAreaName)) //check policy exists
			{
				for (String talkingPoint : policyAreaMap.get(policyAreaName).
						getTalkingPoints())
				{
					System.out.println(talkingPoint);
					//view all talkingPoints of policy area
				}
			}
			else //
			{
				throw new PolicyExistsException("Policy doesn't exist");
			}
		}
		else
		{
			System.out.println("No results found");
		}
	}

	/***************************************
	 * Purpose: The purpose of this is to view all keywords in the specified
	 * policy area
	 * @param policyAreaName
	 * @param policyAreaMap
	 * @throws PolicyExistsException
	 *******************************************/
	@Override
	public void runKeywordOption(String policyAreaName,
								 Map<String, PolicyArea> policyAreaMap)
								throws PolicyExistsException
	{
		if (policyAreaMap.size() != 0) //if policy area map has elements
		{
			if(policyAreaMap.containsKey(policyAreaName)) //if policy exists
			{
				for (String keyword : policyAreaMap.get
									(policyAreaName).getKeywords())
				{
					System.out.println(keyword); //view all keywords
				}
			}
			else //if policy doesn't exist, throw exception.
			{
				throw new PolicyExistsException("Policy doesn't exist");
			}
		}
		else //if no results are found
		{
			System.out.println("No results found");
		}

	}
}
