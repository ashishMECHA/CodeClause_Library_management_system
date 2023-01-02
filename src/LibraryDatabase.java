import org.w3c.dom.stylesheets.LinkStyle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LibraryDatabase {

   Connection connection;
   PreparedStatement statement;
   public LibraryDatabase(){

   }

   public void addBook(Book book)  {
     try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        connection = DriverManager.getConnection("jdbc:ucanaccess://D://Library.accdb");
        statement = connection.prepareStatement("insert into Books(Title,Genre,Available,Author) values(?,?,?,?)");
        statement.setString(1,book.getTitle());
        statement.setString(2,book.getGenre());
        statement.setString(3,book.getAvailable()?"true":"false");
        statement.setString(4, book.getAuthor());
        statement.execute();
     } catch(Exception e){
        System.out.println("error: "+ e.getMessage());
     }
   }

   public void addStudent(Student student)  {
      try{
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         connection = DriverManager.getConnection("jdbc:ucanaccess://D://Library.accdb");
         statement = connection.prepareStatement("insert into Students(Name,PhoneNo,Address) values(?,?,?)");
         statement.setString(1, student.getName());
         statement.setString(2,student.getAddress());
         statement.setString(3, student.getPhoneNo());
         statement.execute();
      } catch(Exception e){
         System.out.println("error: "+ e.getMessage());
      }
   }

   public List<Book> getBooks(){
      try {
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         connection = DriverManager.getConnection("jdbc:ucanaccess://D://Library.accdb");
         statement = connection.prepareStatement("Select * from Books");
         statement.execute();
         ResultSet result = statement.getResultSet();
         List<Book> books = new ArrayList<>();
         while (result.next()) {
            Book book = new Book();
            book.setId(Long.parseLong(result.getString(1)));
            book.setTitle(result.getString(2));
            book.setGenre(result.getString(3));
            book.setAvailable(result.getBoolean(4));
            book.setAuthor(result.getString(5));
            books.add(book);
         }
         return books;
      } catch(Exception e){
         System.out.println("error: "+ e.getMessage());
      }
      return null;
   }

   // Todo: Delete this
   public void ClearDatabase() {
      try{
         Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
         connection = DriverManager.getConnection("jdbc:ucanaccess://D://Library.accdb");
         statement = connection.prepareStatement("delete * from Books;");
         statement.execute();
         statement = connection.prepareStatement("delete * from Students;");
         statement.execute();
      } catch(Exception e){
         System.out.println("error: "+ e.getMessage());
      }
   }

}


