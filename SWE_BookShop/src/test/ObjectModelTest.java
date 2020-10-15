package test;

import main.java.database.DataBase;
import main.java.parties.Author;
import main.java.parties.Opera;
import main.java.parties.PartyType;
import main.java.parties.User;
import org.junit.jupiter.api.Test;

public class ObjectModelTest
{
    @Test
    void ObjectModel() throws Exception
    {
        try
        {
            User me = new User("Matt", PartyType.ePartyTypes.PUBLISHER); //I am the User

            DataBase.getInstance();

            DataBase.getInstance().insertOpera(me, "Barone Rampante", "Italo Calvino", 1957);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
