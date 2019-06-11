package classiModels.DAOFactory;

import java.sql.Statement;

public abstract class AbstractDAO<T> {

    Statement            statement = null;
    protected DAOFactory daofactory;

    public AbstractDAO( DAOFactory daofactory ) {
        this.daofactory = daofactory;
    }
}