package classiModels.beans;

/* (1)
 * Création du Beans de l'utilisateur
 * param ==> login, password et client ou employée? 
 */
public class UserConnect {

    private String  Login;
    private String  Password;
    private boolean ClientOrEmployee = true;

    public UserConnect() {

    }

    public UserConnect( String login, String password, boolean clientoremployee ) {
        super();
        Login = login;
        Password = password;
        ClientOrEmployee = clientoremployee;
    }

    public boolean isClient() {
        return ClientOrEmployee;
    }

    public void setClient( boolean clientoremployee ) {
        ClientOrEmployee = clientoremployee;
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
