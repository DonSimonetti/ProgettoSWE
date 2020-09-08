package main.java.database;

import main.java.TimeRecord;
import main.java.accountability.Accountability;
import main.java.accountability.AccountabilityType;
import main.java.parties.*;

import java.sql.Time;
import java.util.List;
import java.util.Vector;

/*
*
* DataBase is a Singleton-class that stores and manages all the accountabilities
*
* */

public class DataBase //TODO implement methods
{
    private static DataBase instance=null;

    private List<Accountability> accountabilities;

    private DataBase()
    {
        accountabilities=new Vector<Accountability>();
    }

    public DataBase getInstance()
    {
        if(instance==null)
            instance=new DataBase();

        return instance;
    }

    public void insertOpera(User publisher, String title, String authorName,int yearFirstPublication) throws Exception
    {
        PartyType.ePartyTypes userType=publisher.getType().getType();

        switch (userType)
        {
            case PUBLISHER -> {//PUBLISHER or someone else who have writing permissions TODO

                Opera opera=new Opera(title,yearFirstPublication);
                Author author=new Author(authorName);

                createAndRegisterAccountability(author, new AccountabilityType(AccountabilityType.eAccountabilityTypes.AUTHOR_OF), opera,null);
            }
            default -> throw new Exception("'userType' is invalid or doesn't have sufficient permission");
        }
    }

    public void insertEdition(User user, String editor, int year)
    {

    }

    public void insertBooksRelation(User user, Opera book1, Opera book2)
    {

    }

    public void insertPendingComment(User user, String comment)
    {
        Comment _comment=new Comment(user,comment);

        switch (user.getType().getType())
        {
            case PUBLISHER -> _comment.setVisible();
        }
    }

    /*
    * Questo metodo viene chiamato dal moderatore quando approva un commento fino ad allora invisibile.
    *
    */
    public void setCommentVisible(User user, Comment comment) throws Exception
    {
        if (user.getType().getType()== PartyType.ePartyTypes.MODERATOR)
            comment.setVisible();
        else throw new Exception("'userType' is invalid or doesn't have sufficient permission");
    }

    public void insertRecommendation(User user,Party party)
    {
        //TODO Add some checks?
        createAndRegisterAccountability(user,new AccountabilityType(AccountabilityType.eAccountabilityTypes.RECOMMENDS),party,null);
    }

    public void createNewBookList(User user, String name, List<Opera> books)
    {

    }

    public void signUserToGroup(User user, Group group)
    {
        TimeRecord timeRec=new TimeRecord(new Time(System.currentTimeMillis()),null);
        createAndRegisterAccountability(user,new AccountabilityType(AccountabilityType.eAccountabilityTypes.JOINS),group,timeRec);
    }

    /*
    * Questo metodo viene chiamato quando l'utente 'user' si disiscrive volontariamente da un gruppo 'group', cliccando sul tasto "Disiscriviti" in un'ipotetica GUI
    * L'accountability non viene cancellata dal database, ma viene conclusa aggiornando 'endTime' del TimeRecord
    *
    */
    public void removeUserFromGroup(User user, Group group)
    {
        for (Accountability a : accountabilities)
        {
            if(a.getPrimary().equals(user) && a.getSecondary().equals(group) && a.getTimeRecord().getEndTime()==null)
            {
                a.getTimeRecord().getEndTime().setTime(System.currentTimeMillis());
            }
        }
    }

    private Accountability createAndRegisterAccountability(Party primary, AccountabilityType type, Party secondary, TimeRecord timeRecord)
    {
        Accountability accountability=new Accountability(primary,type,secondary,timeRecord);
        accountabilities.add(accountability);
        return accountability;
    }

    /*
    / se timeRecord è null ritorna tutte le accountabilities di quel tipo, altrimenti restituisce le accountabilities
    / create nel timeRecord (e.g. gli utenti iscritti in un certo periodo)
     */
    public Vector<Accountability> getAccountabilitiesByType(AccountabilityType type){
        Vector<Accountability> accountabilityVector=new Vector<Accountability>();
        for (Accountability a: accountabilities)
        {
            if(a.getType()==type)
            {
                accountabilityVector.add(a);
            }
        }
        return accountabilityVector;
    }

    public Vector<Accountability> getAccountabilitiesByType(AccountabilityType type, TimeRecord timeRecord){
        Vector<Accountability> accountabilityVector=new Vector<Accountability>();
        for (Accountability a: accountabilities)
        {
            if(a.getType()==type)
            {
                if(timeRecord.getStartTime() <= a.getTimeRecord().getStartTime() && a.getTimeRecord().getStartTime() <= timeRecord.getEndTime())
                {
                    accountabilityVector.add(a);
                }
            }
        }
        return accountabilityVector;
    }
}
