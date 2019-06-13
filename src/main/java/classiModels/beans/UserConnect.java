package classiModels.beans;

/* (1)
 * Création du Beans de l'utilisateur
 * param ==> login, password et client ou employée? 
 */
public class UserConnect {

    private String login;
    private String Password;

    public UserConnect() {

    }

    public UserConnect( String login, String password ) {
        super();
        this.login = login;
        this.Password = password;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin( String login ) {
        this.login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword( String password ) {
        Password = password;
    }

}
