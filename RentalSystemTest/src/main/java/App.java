import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        //reading the Json File
        Gson gson = new Gson();
        Reader reader = new FileReader("C:\\Users\\MiTi\\Desktop\\Uni\\java\\RentalSystem\\RentalSystemTest\\src\\main\\java\\TestYourFork.json");
        JsonImplements jimp = gson.fromJson(reader, new TypeToken<JsonImplements>(){}.getType());
        reader.close();

        //tested successfully: System.out.println(jimp.books.get(1).getTitle());

        //recreating data to prevent Call by Reference
        Customer johnS = jimp.getCustomers().get(0);
        Customer js = new Customer(johnS.getName(), johnS.getEmail(), johnS.getPhone(), johnS.getAddress(), johnS.getID());

        Customer emilyJ = jimp.getCustomers().get(1);
        Customer ej = new Customer(emilyJ.getName(), emilyJ.getEmail(), emilyJ.getPhone(), emilyJ.getAddress(), emilyJ.getID());

        Customer michealB = jimp.getCustomers().get(2);
        Customer mb = new Customer(michealB.getName(), michealB.getEmail(), michealB.getPhone(), michealB.getAddress(), michealB.getID());

        //replacing new obj in customers
        jimp.getCustomers().set(0, js);
        jimp.getCustomers().set(1, ej);
        jimp.getCustomers().set(2, mb);

        //-------------------------------------------------------

        //rent---------
        Item item = new Item();

        for (Item i: jimp.getBooks()) {
            if (i.getId()==3){
                i.setAvailable(true);
                item.rentItem(i, js);
            }
        }

        for (Item i: jimp.getMovies()) {
            if (i.getId()==6){
                item.rentItem(i, js);
            }
        }

        for (Item i: jimp.getBooks()) {
            if (i.getId()==1){
                item.rentItem(i, ej);
            }
        }

        for (Item i: jimp.getMovies()) {
            if (i.getId()==7){
                item.rentItem(i, ej);
            }
        }

        for (Item i: jimp.getBooks()) {
            if (i.getId()==9){
                i.setAvailable(true);
                item.rentItem(i, mb);
            }
        }

        for (Item i: jimp.getGames()) {
            if (i.getId()==4){
                item.rentItem(i, mb);
            }
        }

        /*for (Customer c:jimp.getCustomers()) {
            System.out.println(c.getName());
            System.out.println(c.getRentals().get(0).getItem().getTitle());
            System.out.println(c.getRentals().get(1).getItem().getTitle());
        }*/

        //------------------------------------------

        //rewriting Json file data
        String path = "C:\\Users\\MiTi\\Desktop\\Uni\\java\\RentalSystem\\RentalSystemTest\\src\\main\\java\\TestYourFork.json";
        String json = gson.toJson(jimp);

        try {
            //ready to write
            FileWriter writer = new FileWriter(path);
            writer.write(json);
            writer.close();

            System.out.println("JSON data has been written to the file successfully.");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}