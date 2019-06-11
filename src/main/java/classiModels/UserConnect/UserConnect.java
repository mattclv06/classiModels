package classiModels.UserConnect;

public class UserConnect {

    private int    idUserConnect = 0;
    private String User          = "";
    private String mdp           = "";

    public UserConnect( int idUserConnect, String User, String mdp ) {
        this.idUserConnect = idUserConnect;
        this.User = User;
        this.mdp = mdp;
    }

    public UserConnect() {

    }

    public int getidUserConnect() {
        return idUserConnect;
    }

    public void setidUserConnect( int idUserConnect ) {
        this.idUserConnect = idUserConnect;
    }

    public String getUser() {
        return User;
    }

    public void setUser( String User ) {
        this.User = User;
    }

    public String getmdp() {
        return mdp;
    }

    public void setmdp( String mdp ) {
        this.mdp = mdp;
    }

}
