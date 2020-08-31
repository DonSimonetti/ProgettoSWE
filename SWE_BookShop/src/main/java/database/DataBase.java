package main.java.database;

import main.java.accountability.Accountability;
import main.java.parties.Opera;
import main.java.parties.User;

import java.util.List;

/*
*
* DataBase is a Singleton-class that stores and manage all the accountabilities
*
* */

public class DataBase //TODO implement methods
{
    private DataBase instance=null;
    private List<Accountability> accountabilities;

    private DataBase() {}

    public DataBase getInstance()
    {
        if(instance==null)
            instance=new DataBase();

        return instance;
    }

    public void insertOpera(String title, String author,int yearFirstPublication, String editor, int yearEditionPublication)
    {

    }

    public void insertBooksRelation(Opera book1, Opera book2)
    {

    }

    public void insertPendingComment(User user, String comment)
    {

    }

    public void insertRecommendation(User user,Opera opera)
    {

    }
}
