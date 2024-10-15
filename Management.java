package program;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/* Class management. */
public class Management {

    public ArrayList<Product> products;
    private static final String FILE_PRODUCTS = "products.txt";
    public Management()
    {
        loadProducts();
    }

    public void add(Product p)
    {
        products.add(p);
    }

    public void remove(Product p)
    {
        products.remove(p);
    }

    public int calculateId()
    {
        int id = 0;
        if(products.size() > 0)
        {
            products.sort((p1, p2) -> Integer.compare(p2.getId(), p1.getId()));
            id = products.get(0).getId();
        }
        return id + 1;
    }

    public List<Product> showProducts()
    {
        System.out.println("LIST PRODUCTS:");
        for(int i = 0; i < products.size(); i++)
        {
            System.out.println("PRODUCT ID \" " + (i+1) + " \":");
            System.out.println(products.get(i).toString());
        }
        return products;
    }
    public Product searchProduct(int id)
    {
        Product prodSearch = null;
        for(int i = 0; i < products.size(); i++)
        {
            if(products.get(i).getId() == id)
            {
                prodSearch = products.get(i);
            }
        }
        return prodSearch;
    }

    public void loadProducts()
    {
        products = new ArrayList<>();
        try
        {
            Path path = Paths.get(FILE_PRODUCTS);
            List<String> lines = Files.readAllLines(path,
                    StandardCharsets.UTF_8);

            for(int i = 0; i < lines.size(); i++)
            {
                int id;
                String line;
                line = lines.get(i);
                String[] parts = line.split(";");

                id = Integer.parseInt(parts[0]);
                CommercialHouse house = new CommercialHouse(
                        parts[3], parts[4], parts[5], parts[6], parts[7]);
                if(parts[9].toLowerCase().equals("a"))
                {
                    Product c = new PFood(id , parts[1],
                            parts[2], house, parts[8]);
                    products.add(c);
                }
                else if(parts[9].toLowerCase().equals("s"))
                {
                    Product c = new PSport(id , parts[1],
                            parts[2], house, parts[8]);
                    products.add(c);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void saveProducts()
    {
        try (PrintWriter printWriter = new PrintWriter (FILE_PRODUCTS))
        {
            for(Product p: products)
            {
                printWriter.println (p.toString());
            }
        }
        catch (Exception e)
        {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}

