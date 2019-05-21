package edu.curtin.messaging;

import Assignment.View.DisplayDetails;

public class SMS extends Thread
{
	public SMS()
	{

	}

	/** Sends an SMS to a given phone number. */
	public void sendSMS(long mobileNumber, String message)
	{
		DisplayDetails.showData("SMS sent to " + mobileNumber + ": " + message);
	}
}
