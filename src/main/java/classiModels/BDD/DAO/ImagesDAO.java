package classiModels.BDD.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classiModels.BDD.DAOFactory;
import classiModels.beans.Images;

public class ImagesDAO extends AbstractDAO<Images> {

    // REQUETES
    private static final String FIND_IMG = "SELECT * FROM images inner join  liensimages on imageId = id where productCode = ?";

    // CONSTRUCTEUR
    public ImagesDAO( DAOFactory daoFactory ) {
        super( daoFactory );
    }

    // RECUPERATION DE L'OBJET IMAGES
    public Images findImage( String productCode, Connection connexion ) {
        Images img = null;
        PreparedStatement state = null;
        ResultSet result = null;
        try {
            state = initialisationRequetePreparee( connexion, FIND_IMG, false, productCode );
            result = state.executeQuery();

            if ( result.first() )
                img = map( result );

        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            fermeturesSilencieuses( result, state );
        }
        return img;
    }

    // METHODE DE CREATION / RECUPERATION DE L'OBJET IMAGES
    @Override
    public Images map( ResultSet result ) throws SQLException {
        Images img = new Images();
        img.setId( result.getInt( 1 ) );
        img.setNom( result.getString( 2 ) );
        img.setLabel( result.getString( 3 ) );
        img.setTags( result.getString( 4 ) );
        return img;
    }

}
