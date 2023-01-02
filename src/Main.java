public class Main {
    public static void main(String[] args) {

        Book book =new Book(0,"Harry Potter", "Fantasy", true,"JK Rollins");
        LibraryDatabase database = new LibraryDatabase();
        database.addBook(book);
        database.addBook(new Book(0, "Lord of the Rings", "Fantasy", true, "Tolkein"));


        for(Book b : database.getBooks()) {
            System.out.println(b.toString());
        }



        // end
        database.ClearDatabase();
    }
}
