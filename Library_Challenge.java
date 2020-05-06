package libtest;

import java.util.Map;
import java.util.HashMap;

class Person{
   String name = null;
   Person(String fullname){
      this.name = fullname;  
   }
}

class Book{
   String title = null;
   String author = null;
   Book(String bookTitle, String bookAuthor){
       this.title = bookTitle;
       this.author = bookAuthor;
   }
   public boolean matchtitle(String testTitle){
       return this.title.equals(testTitle);
   }
}

class Constants{
    public static String AVAILABLE = "AVAILABLE";
    public static String NOT_IN_CATALOUGE = "Not in Catalouge";
    public static String CHECKED_OUT_BY_NAME = "Checked out by: ";
    public static String CHECKOUT_SUCCESS = "Successfully Checked out";
    public static String CHECKOUT_ERROR = "Error: Book already checked out";
    public static String NOT_EXISTS = "Book Doesn't exists";
    public static String CHECKIN_ERROR = "Error: Can't check-in book that hasn't been checked out";
    public static String CHECKIN_SUCCESS = "Successfully checked in";
}
class Library{
    Map<String, Book> catalouge = new HashMap<>();
    Map<String, Person> checkedOutBooks = new HashMap<>();
    public Library(){
         catalouge.put("ORW", new Book("1985", "George Orwell"));
         catalouge.put("RAY", new Book("Farenheit 451", "Ray Bradbury"));
    }
    public String searchByTitle(String title){
         boolean checkout = false;
         boolean exists = false;
         Book tempBook = null;
         String bookKey = null;
         for(Map.Entry<String, Book> entry: catalouge.entrySet()){
              tempBook = entry.getValue();
              if(tempBook.matchtitle(title)){
                  exists = true;
                  bookKey = entry.getKey();
                  break;
              }
         }
         checkout = checkedOutBooks.containsKey(bookKey);
         if(exists && checkout)
            return Constants.CHECKED_OUT_BY_NAME + checkedOutBooks.get(bookKey).name;
         if(exists)
            return Constants.AVAILABLE;
         return Constants.NOT_IN_CATALOUGE;
    }

    public String checkout(String bookID, Person person){
        if(!catalouge.containsKey(bookID))
            return Constants.NOT_EXISTS;
        if(checkedOutBooks.containsKey(bookID))
            return Constants.CHECKOUT_ERROR;     
        checkedOutBooks.put(bookID, person);
        return Constants.CHECKOUT_SUCCESS;
    }

    public String checkIn(String bookID){
        if(!catalouge.containsKey(bookID))
            return Constants.NOT_EXISTS;
        if(!checkedOutBooks.containsKey(bookID))
            return Constants.CHECKIN_ERROR;
        checkedOutBooks.remove(bookID);
        return Constants.CHECKIN_SUCCESS;     
    }

}

public class Library_Challenge{
    public static void main(String args[]) throws Exception{
        Library library = new Library();
        Person borrower1 = new Person("Curious George");
        Person borrower2 = new Person("Mark Twain");
        System.out.println(library.searchByTitle("1985"));
        System.out.println(library.checkout("ORW", borrower1));
        System.out.println(library.searchByTitle("1985"));
        System.out.println(library.checkout("ORW", borrower2));
        System.out.println(library.checkIn("RAY"));
        System.out.println(library.checkIn("ORW"));
        System.out.println(library.checkout("ORW", borrower2));
    }
}