package classiModels.BDD.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import classiModels.BDD.DAOFactory;
import classiModels.beans.Payments;

public class PaymentsDAO extends AbstractDAO<Payments> {

    // CONSTRUCTEUR
    public PaymentsDAO( DAOFactory daoFactory ) {
        super( daoFactory );
    }

    // METHODE DE CREATION / RECUPERATION DE L'OBJET PAYMENTS
    @Override
    public Payments map( ResultSet result ) throws SQLException {
        Payments payment = new Payments();
        payment.setCustomerNumber( result.getInt( 1 ) );
        payment.setCheckNumber( result.getString( 2 ) );
        payment.setPaymentsDate( result.getDate( 3 ) );
        payment.setAmount( result.getFloat( 4 ) );
        return payment;
    }

}
