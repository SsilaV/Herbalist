package program;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

/* Class for the registration of commercial houses from which
 * products are ordered. */

public class CommercialHouse {

    private String cif;
    private String nameHouse;
    protected String phone;
    protected String email;
    protected String address;
    private static ArrayList<CommercialHouse> houses;
    private static final String FILE_HOUSES = "houses.txt";

    public CommercialHouse(String cif, String nameHouse, String phone,
                           String email, String address)
    {
        this.cif = cif;
        this.nameHouse = nameHouse;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public static ArrayList<CommercialHouse> loadHouses()
    {
        houses = new ArrayList<>();
        Path path = Paths.get(FILE_HOUSES);

        try
        {
            List<String> lines = Files.readAllLines(path,
                    StandardCharsets.UTF_8);
            // Aquí recorres la lista y procesas cada línea

            for(int i = 0; i < lines.size(); i++)
            {
                String line;
                line = lines.get(i);
                String[] parts = line.split(";");
                CommercialHouse c = new CommercialHouse(parts[0], parts[1],
                        parts[2], parts[3], parts[4]);
                houses.add(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return houses;
    }
    public String getCif()
    {
        return cif;
    }

    public void setCif(String cif)
    {
        this.cif = cif;
    }

    public String getNameHouse()
    {
        return nameHouse;
    }

    public void setNameHouse(String nameHouse)
    {
        this.nameHouse = nameHouse;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @ Override
    public String toString()
    {
        return
                nameHouse + ";" +
                cif + ";" +
                phone + ";" +
                email + ";" +
                address;
    }
}

