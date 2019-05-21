package Assignment.Controller;

import Assignment.Model.Person;
import Assignment.Model.PolicyArea;

/************************************
 * Purpose: This is the observer for the keywords trending event
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 19/05/2019
 ***************************************/
public interface ObserverKeywordsTrending
{
	void update(PolicyArea policyArea);
	boolean checkPerson(Person person);
}
