package Assignment.Controller;
import Assignment.Model.Person;
import Assignment.Model.PersonIDException;
import Assignment.Model.PolicyArea;
import Assignment.Model.PolicyExistsException;

import java.util.*;

/*****************************************
 * Purpose: The MenuOptionInterface contains the method signatures
 * for the Person, Policy Area, Talking Point and keyword Options.
 * Each option is run using the strategy pattern in the Main Controller.
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 19/05/2019
 *********************************************/
public interface MenuOptionInterface
{
	void runPersonOption(Map<Integer,Person> personMap,
						 Map<String, PolicyArea> policyAreaMap)
						throws PersonIDException;
	void runPolicyAreaOption(Map<String, PolicyArea> policyAreaMap)
						throws PolicyExistsException;
	void runTalkingPointOption(String policyAreaName,
							   	Map<String, PolicyArea> policyAreaMap)
						throws PolicyExistsException;
	void runKeywordOption(String policyAreaName,
						  Map<String, PolicyArea> policyAreaMap)
						throws PolicyExistsException;
}
