package test;

import main.java.accountability.Accountability;
import main.java.accountability.AccountabilityType;
import main.java.database.DataBase;
import main.java.parties.Author;
import main.java.parties.Opera;
import main.java.parties.PartyType;
import main.java.parties.User;
import org.junit.jupiter.api.Test;

import java.util.Vector;

public class ObjectModelTest
{
    @Test
    void ObjectModel() throws Exception //TODO add junit checks
    {
        try
        {
            DataBase dataBase=DataBase.getInstance();
            User me = new User("Matt", PartyType.ePartyTypes.PUBLISHER); //I am the User



            dataBase.insertOpera(me, "Barone Rampante", "Italo Calvino", 1957);

            dataBase.insertOpera(me,"Le cosmicomiche","Italo Calvino", 1965);

            String authorName = null;
            Vector<Accountability> authors = dataBase.getAccountabilitiesByType(AccountabilityType.eAccountabilityTypes.AUTHOR_OF);
            for(Accountability a : authors)
            {
                if(a.getSecondary() instanceof Opera)
                {
                    Opera opera = (Opera) a.getSecondary();
                    if (opera.getTitle() == "Barone Rampante")
                    {
                        authorName = ((Author) a.getPrimary()).getName();
                        break;
                    }
                }
            }
            if(authorName!=null)
                dataBase.insertOpera(me,"L'Orlando furioso raccontato da Italo Calvino",authorName,1970);

            dataBase.insertOpera(me,"Orlando furioso","Torquato Tasso",1516);//Tasso non ha scritto l'orlando furioso. (???)


            //.....
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
