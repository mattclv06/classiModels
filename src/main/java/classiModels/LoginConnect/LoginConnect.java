package classiModels.LoginConnect;

public class LoginConnect {

    private int    idLoginConnect = 0;
    private String Login         = "";
    private String Password      = "";

    public LoginConnect( int idLoginConnect, String Login, String Password ) {
        this.idLoginConnect = idLoginConnect;
        this.Login = Login;
        this.Password = Password;
    }

    public LoginConnect() {

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
