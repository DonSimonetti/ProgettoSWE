package main.java.parties;

import java.util.List;

public class BookList extends Party
{
    private String name;
    private List<Opera> books;

    public BookList(String name, List<Opera> books)
    {
        super(PartyType.ePartyTypes.BOOK_LIST);
        this.name=name;
        this.books=books;
    }

    public String getName()
    {
        return name;
    }

    public boolean insertBook(Opera opera)
    {
        return books.add(opera);
    }

    public boolean removeOpera(Opera opera)
    {
        return books.remove(opera);
    }
}
