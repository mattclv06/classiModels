package classiModels.beans;

public class Employees {

    private int    employeeNumber, reportsTo;
    private String lastName, firstName, extension, officeCode, email, jobTitle;

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber( int employeeNumber ) {
        this.employeeNumber = employeeNumber;
    }

    public int getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo( int reportsTo ) {
        this.reportsTo = reportsTo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension( String extension ) {
        this.extension = extension;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode( String officeCode ) {
        this.officeCode = officeCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle( String jobTitle ) {
        this.jobTitle = jobTitle;
    }
}
