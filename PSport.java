package program;

/* Subclass of "Product" for the classification of sports products. */

class PSport extends Product
{
    private String sport;

    public PSport(int id, String name, String description,
                  CommercialHouse house, String sport)
    {
        super(id, name, description, house);
        this.sport = sport;
    }

    public String getSport()
    {
        return sport;
    }

    public void setSport(String sport)
    {
        this.sport = sport;
    }

    @Override
    public String toString()
    {
        return super.toString() + ";" + sport + ";s";
    }
}

