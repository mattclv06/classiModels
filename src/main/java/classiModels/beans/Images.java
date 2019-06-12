package classiModels.beans;

public class Images {

    private int    id;
    private String nom, label, tags;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel( String label ) {
        this.label = label;
    }

    public String getTags() {
        return tags;
    }

    public void setTags( String tags ) {
        this.tags = tags;
    }

}
