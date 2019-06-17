<%@ page import="java.sql.*"%>

<%
    String s = request.getParameter( "val" );
    if ( s == null || s.trim().equals( "" ) ) {
        out.print( "Please enter id" );
    } else {
        int id = Integer.parseInt( s );
        out.print( id );
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/classicmodels", "root", "root" );
            PreparedStatement ps = con.prepareStatement( "SELECT nom FROM images inner join  liensimages on imageId = id where customerNumber = ?" );
            ps.setInt( 1, id );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                out.print( rs.getInt( 1 ) + " " + rs.getString( 2 ) );
            }
            con.close();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
%>