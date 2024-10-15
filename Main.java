package program;
import java.util.*;
import java.lang.*;

// Press Shift twice to open the Search Everywhere dialog and type
// `show whitespaces`, then press Enter. You can now see whitespace
// characters in your code.

public class Main
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        ArrayList<CommercialHouse> houses = CommercialHouse.loadHouses();
        Management m = new Management();
        int option;
        option = menu();
        switch(option)
        {
            case 1: insert(m, houses); break;
            case 2: edit(m, houses); break;
            case 3: search(m); break;
            case 4: delete(m); break;
            case 0: System.out.println("Exit"); break;
        }
    }

    public static void insert(Management m, ArrayList<CommercialHouse> houses)
    {
        int id, houseUs;
        String nameUs, descriptionUs, insert, allergenUs, sportUs;
        CommercialHouse house = null;

        id = m.calculateId();
        System.out.println("Id de calculateId:" +id);

        System.out.println("Name:");
        nameUs = sc.nextLine();
        System.out.println("Description:");
        descriptionUs = sc.nextLine();


        System.out.println("HOUSES LIST:");
        for(int i = 0; i < houses.size(); i++)
        {
            System.out.println((i+1) + ". " + houses.get(i).getNameHouse());
        }

        System.out.println("Insert house: ");
        houseUs = sc.nextInt();
        sc.nextLine();
        house = houses.get(houseUs-1);


        System.out.println("Insert: A.Food or B.Sport");
        insert = sc.nextLine();
        if(insert.equals("A"))
        {
            System.out.println("Insert allergen: ");
            allergenUs = sc.nextLine();
            Product pf = new PFood(
                    id, nameUs, descriptionUs, house, allergenUs);
            m.add(pf);
            System.out.println(pf.toString());
        }
        else if(insert.equals("B"))
        {
            System.out.println("Insert sport: ");
            sportUs = sc.nextLine();
            Product ps = new PSport(
                    id, nameUs, descriptionUs, house, sportUs);
            m.add(ps);
            System.out.println(ps.toString());
        }

        m.saveProducts();
        finish();
    }

    public static void edit(Management m, ArrayList<CommercialHouse> houses)
    {
        int idEdit;
        String newName = "", newDescription = "";
        Product productEdit;

        m.showProducts();
        System.out.println("EDIT PRODUCT:");
        System.out.print("Insert id: ");
        idEdit = sc.nextInt();
        sc.nextLine();
        productEdit = m.searchProduct(idEdit);
        System.out.println("Edit: " + productEdit.toString());

        System.out.println(
                "If you want to change the name insert it here:" +
                        "(Enter to exit.)");
        newName = sc.nextLine();
        if(newName.equals(""))
        {
            newName = productEdit.getName();
        }
        productEdit.setName(newName);

        System.out.println(
                "If you want to change the description insert it here:" +
                        "(Enter to exit.)");
        newDescription = sc.nextLine();
        if(newDescription.equals(""))
        {
            newDescription = productEdit.getDescription();
        }
        productEdit.setDescription(newDescription);

        m.saveProducts();
        finish();
    }

    public static void search(Management m)
    {
        int idSearch;

        m.showProducts();
        System.out.println("SEARCH PRODUCT:");
        System.out.print("Insert id: ");
        idSearch = sc.nextInt();
        System.out.println(m.searchProduct(idSearch));

        finish();
    }

    public static void delete(Management m)
    {
        int idDelete;
        Product productDelete = null;

        m.showProducts();
        System.out.println("SEARCH PRODUCT:");
        System.out.print("Insert id: ");
        idDelete = sc.nextInt();

        productDelete = m.searchProduct(idDelete);
        if(productDelete != null)
        {
            m.remove(productDelete);
            m.saveProducts();
        }
        else
        {
            System.out.println("Product null!");
        }
        finish();
    }

    public static void finish()
    {
        System.out.println("Finish task!");
        System.out.println("EXIT");
    }
    public static int menu()
    {
        int optionUs;

        System.out.println("\"HERBALIST PRODUCTS\"");

        System.out.println("1.Insert");
        System.out.println("2.Edit");
        System.out.println("3.Search");
        System.out.println("4.Delete");
        System.out.println("0.Exit");

        System.out.println("INSERT OPTIÓN:");
        optionUs = sc.nextInt();
        sc.nextLine();
        return optionUs;
    }
}

