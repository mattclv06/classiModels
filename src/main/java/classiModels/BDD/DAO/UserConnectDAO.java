package classiModels.BDD.DAO;

import classiModels.beans.UserConnect;

public interface UserConnectDAO {

    UserConnect trouver( String login, String password );

}
