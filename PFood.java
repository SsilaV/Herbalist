package program;

/* Product subclass so that Food type products can be included. */

public class PFood extends Product
{
    protected String allergen;

    public PFood(int id, String name, String description, CommercialHouse house,
                 String allergen)
    {
        super(id, name, description, house);
        this.allergen = allergen;
    }

    public String getAllergen()
    {
        return allergen;
    }

    public void setAllergen(String allergen)
    {
        this.allergen = allergen;
    }

    @ Override
    public String toString()
    {
        return super.toString() + ";" + allergen + ";a";
    }
}

