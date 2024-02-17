package Grocery;

//TODO:
// 1. addGroceryItem
// 2. printGroceryList
// 3. removeGroceryItem
// 4. modifyGroceryItem
// 5. searchItem


import java.util.ArrayList;
import java.util.regex.Pattern;


public class GroceryList {

    //Fields
    private ArrayList<String> groceryList = new ArrayList<>();

    //Constructor
    public GroceryList() {
        //Default items in the list
        groceryList.add("Bananas");
        groceryList.add("Apple");
        groceryList.add("Water");
    }

    //Methods
    public void addGroceryItem(String item) {

        if (checkIfValid(item)){
            groceryList.add(item);
        }else {
            System.out.println("Item is not valid");
        }
    }

    public void printGroceryList() {
        System.out.println("You have: " + groceryList.size() + " items in grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i+1) + ". " + groceryList.get(i));
        }

    }
    public void removeGroceryItem(String item){
        int position = findItem(item);

        if (position >= 0) {
            groceryList.remove(position);
            System.out.println(item + " Deleted");
        }else {
            System.out.println("Item is not in the list");
        }

    }
    public void modifyGroceryItem(int position, String newItem){
        if (checkIfValid(newItem)){
            if (position >= 0 && position < groceryList.size()){
                groceryList.set(position, newItem);
                System.out.println("Grocery item " + groceryList.get(position) + " was modified");
            }else {
                System.out.println("Item number is not valid");
            }
        }else {
            System.out.println("Item name is not valid");
        }
    }
    public void deleteAllItems(){
        groceryList.clear();
        System.out.println("All items in the list are deleted");
    }
    public boolean searchItem(String searchItem){
        if (findItem(searchItem) >= 0){
            return true;
        }else {
            return false;
        }
    }
    private int findItem(String searchItem){
        return groceryList.indexOf(searchItem);
    }
    private boolean checkIfValid(String input){
        return Pattern.matches("[a-zA-Z ]+[0-9 ]*[a-zA-Z ]*", input);
    }

}
