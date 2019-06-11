package classiModels.UserConnectDTO;

import classiModels.UserConnect.UserConnect;

public class UserConnectDTO {
    int    idUserConnect = 0;
    String User          = "";
    String mdp           = "";

    public UserConnectDTO() {
        super();
    }

    public UserConnect getUserConnect() {
        UserConnect user = new UserConnect();
        user.setidUserConnect( idUserConnect );
        user.setUser( User );
        user.setmdp( mdp );

        return user;

    }

    public UserConnectDTO( UserConnect user ) {
        this.idUserConnect = user.getidUserConnect();
        this.User = user.getUser();
        this.mdp = user.getmdp();
    }

    public UserConnectDTO( int idUserConnect, String User, String mdp ) {
        this.idUserConnect = idUserConnect;
        this.User = User;
        this.mdp = mdp;
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