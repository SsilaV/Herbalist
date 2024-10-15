package program;

/* Parent and abstract class "Product":
 * Products entered must belong to a Product subtype.*/

public abstract class Product
{
    protected int id;
    protected String name;
    protected String description;
    protected CommercialHouse house;

    public Product(int id, String name, String description,
                   CommercialHouse house)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.house = house;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public CommercialHouse getHouse()
    {
        return house;
    }

    public void setHouse(CommercialHouse house)
    {
        this.house = house;
    }

    @Override
    public String toString()
    {
        return
                id + ";" +
                name + ";" +
                description + ";" +
                house.toString();
    }
}


