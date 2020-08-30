package main.java.parties;

/*
 *
 *   OperaEdition.java class represents different edition of the same opera
 *
 * */

public class OperaEdition extends Party
{
    private Opera opera;
    private String editor;
    private int year;

    public OperaEdition(Opera opera, String editor, int year)
    {
        super(PartyType.ePartyTypes.EDITION);
        this.opera=opera;
        this.editor=editor;
        this.year=year;
    }

    public String getOperaTitle()
    {
        return opera.getTitle();
    }
    public String getEditor()
    {
        return editor;
    }
    public int getYear()
    {
        return year;
    }
}