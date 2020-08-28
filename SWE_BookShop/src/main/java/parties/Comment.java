package main.java.parties;

public class Comment extends Party
{
    private User user;
    private String text;
    private boolean visible;

    public Comment(User user, String text)
    {
        super(PartyType.ePartyTypes.COMMENT);
        this.user=user;
        this.text=text;
        this.visible=false;
    }

    public boolean isVisible()
    {
        return visible;
    }

    public void setVisible()
    {
        this.visible = true;
    }

    public User getSubmitter()
    {
        return user;
    }

    public String getText()
    {
        return text;
    }
}
