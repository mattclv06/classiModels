package classiModels.beans;

public class UserConnect {

    private String  Login;
    private String  Password;
    private boolean Client = true;

    public UserConnect() {

    }

    public UserConnect( String login, String password, boolean client ) {
        super();
        Login = login;
        Password = password;
        Client = client;
    }

    public boolean isClient() {
        return Client;
    }

    public void setClient( boolean client ) {
        Client = client;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin( String login ) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword( String password ) {
        Password = password;
    }

}
