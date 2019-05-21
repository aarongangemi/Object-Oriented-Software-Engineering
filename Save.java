package Assignment.View;

import Assignment.Controller.IOInterface;

import java.io.*;
import java.util.*;

/***************************************
 * Purpose: This is a stub which will save data to file
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 20/05/2019
 ****************************************/
public class Save implements IOInterface
{
	@Override
	public void IOOption(Map<String, IOInterface> IOMap, String fileName)
	{
		FileOutputStream fileOutputStream = null;
		PrintWriter pw;
		try
		{
			fileOutputStream = new FileOutputStream(fileName);
			pw = new PrintWriter(fileOutputStream); //Open file for writing
			pw.println("FILE WILL BE WRITTEN HERE - TO BE IMPLEMENTED");
			pw.close(); //close printwriter
			fileOutputStream.close(); //close file
		}
		catch (IOException ex)
		{ //Catch IO Exception if IO Error
			if(fileOutputStream != null)
			{
				try
				{
					fileOutputStream.close();
				}
				catch (IOException ex2)
				{

				}
			}
			System.out.println("Error in file writing");
		}
		System.out.println("Data was saved: To be implemented");
	}
}
