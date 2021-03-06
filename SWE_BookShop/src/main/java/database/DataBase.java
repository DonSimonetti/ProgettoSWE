package main.java.database;

import main.java.TimeRecord;
import main.java.accountability.Accountability;
import main.java.accountability.AccountabilityType;
import main.java.parties.*;

import java.sql.Time;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/*
*
* DataBase is a Singleton-class that stores and manages all the accountabilities
*
* */

public final class DataBase
{
    public static DataBase getInstance()
    {
        if(instance==null)
            instance=new DataBase();

        return instance;
    }

    public void insertOpera(User publisher, String title, String authorName,int yearFirstPublication)
    {
        try
        {
            checkWritingPermissions(publisher);

            Opera opera=new Opera(title,yearFirstPublication);
            Author author=new Author(authorName);

            createAndRegisterAccountability(author, new AccountabilityType(AccountabilityType.eAccountabilityTypes.AUTHOR_OF), opera,null);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void insertEdition(User user, Opera opera, String editor, int year)
    {
        try
        {
            checkWritingPermissions(user);

            OperaEdition operaEdition=new OperaEdition(opera,editor,year);

            createAndRegisterAccountability(operaEdition,new AccountabilityType(AccountabilityType.eAccountabilityTypes.EDITION),opera,null);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void insertBooksRelation(User user, String name, Opera ... book)
    {
        PartyType.ePartyTypes userType = user.getType().getType();

        switch (userType)
        {
            case MODERATOR, USER:
                Vector<Opera> _vector = new Vector<Opera>();
                Collections.addAll(_vector, book);
                BookList _bookList = new BookList(name, _vector);

                TimeRecord timeRec=new TimeRecord(new Time(System.currentTimeMillis()),null);

                createAndRegisterAccountability(user, new AccountabilityType(AccountabilityType.eAccountabilityTypes.PROPOSES), _bookList, timeRec);

        }

    }

    public void insertPendingComment(User user, String comment)
    {
        Comment _comment=new Comment(user,comment);

        switch (user.getType().getType())
        {
            case PUBLISHER: _comment.setVisible();
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

    public void createNewBookList(User user, String name, List<Opera> books) //TODO implement
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

    public Vector<Accountability> getAccountabilitiesByType(AccountabilityType.eAccountabilityTypes type){
        Vector<Accountability> accountabilityVector=new Vector<Accountability>();
        for (Accountability a: accountabilities)
        {
            if(a.getType().getType()==type)
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
                if(timeRecord.getStartTime().getTime() <= a.getTimeRecord().getStartTime().getTime() && a.getTimeRecord().getStartTime().getTime() <= timeRecord.getEndTime().getTime())
                {
                    accountabilityVector.add(a);
                }
            }
        }
        return accountabilityVector;
    }

    //Private methods

    private static DataBase instance=null;

    private List<Accountability> accountabilities;

    private DataBase()
    {
        accountabilities=new Vector<Accountability>();
    }

    private static void checkWritingPermissions(User user) throws Exception
    {
        PartyType.ePartyTypes userType=user.getType().getType();

        if(!(userType== PartyType.ePartyTypes.PUBLISHER))//PUBLISHER or someone else who have writing permissions TODO
            throw new Exception("'userType' is invalid or doesn't have sufficient permission");
    }
}
