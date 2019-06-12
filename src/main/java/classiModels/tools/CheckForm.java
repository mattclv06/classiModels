package classiModels.tools;

public class CheckForm {

    public CheckForm( String log, String Pass ) {
        if ( log.isEmpty() && Pass.isEmpty() ) {
            System.out.println( "erreur" );
        }
    }

}
