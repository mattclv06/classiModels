package classiModels.LoginConnectDTO;

import classiModels.LoginConnect.LoginConnect;

public class LoginConnectDTO {
    int    idLoginConnect = 0;
    String Login          = "";
    String Password       = "";

    public LoginConnectDTO() {
        super();
    }

    public LoginConnect getLoginConnect() {
        LoginConnect login = new LoginConnect();
        login.setidLoginConnect( idLoginConnect );
        login.setLogin( Login );
        login.setPassword( Password );

        return login;

    }

    public LoginConnectDTO( LoginConnect Login ) {
        this.idLoginConnect = Login.getidLoginConnect();
        this.Login = Login.getLogin();
        this.Password = Login.getPassword();
    }

    public LoginConnectDTO( int idLoginConnect, String Login, String Password ) {
        this.idLoginConnect = idLoginConnect;
        this.Login = Login;
        this.Password = Password;
    }

    public int getidLoginConnect() {
        return idLoginConnect;
    }

    public void setidLoginConnect( int idLoginConnect ) {
        this.idLoginConnect = idLoginConnect;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin( String Login ) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword( String Password ) {
        this.Password = Password;
    }
}