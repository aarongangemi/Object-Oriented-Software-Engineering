package Assignment.Controller;

import Assignment.Model.Person;
import Assignment.Model.PolicyArea;

/**************************************
 * Purpose: This is the observer for the talking point added event observer
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 19/05/2019
 ***************************************/
public interface ObserverTalkingPointAdded
{
	void update(PolicyArea policyArea);
	boolean checkTalkingPoints(Person p);
}
