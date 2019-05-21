package Assignment;

import Assignment.Controller.*;
import Assignment.View.MenuClass;
import Assignment.View.ViewData;

/******************************************
 * Purpose: This is the main class. Runs the programs.
 * Author: Aaron Gangemi - 19447337
 * Date Modified: 20/05/2019
 **********************************************/
public class Main {

    public static void main(String[] args)
    {
        MenuClass menuObj = new MenuClass();
        FactoryClass factoryObj = new FactoryClass();
        AddController addOption = new AddController(menuObj, factoryObj);
        RemoveController removeOption = new RemoveController(menuObj);
        ViewData viewDataOption = new ViewData();
        NotificationController notification = new NotificationController(menuObj);
        UIController mainController = new UIController(menuObj,addOption,
                                                       removeOption,
                                                       viewDataOption,
                                                       notification);
        mainController.runMain();
    }
}
