import java.util.*;

public class LibrarySystem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        System.out.print("If you are admin enter 1 or else enter 2 to continue: ");
        int choice = sc.nextInt();
        sc.nextLine(); 
        if (choice == 1) 
            library.adminLogin(sc);
        else
            library.userLogin(sc);
    }
}

class Library 
{
    private ArrayList<Books> bookList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();

    public void adminLogin(Scanner sc) 
    {
        System.out.println("Enter the Admin ID:");
        String user = sc.nextLine();

        if (user.equals("harish")) 
        {
            System.out.println("Enter the Admin Password:");
            String password = sc.nextLine();

            if (password.equals("harish")) 
            {
                Boolean gate = true;
                while(gate)
                {
                    System.out.println("Do you want enter book info (1 = Yes, 2 = No)");
                    int key = sc.nextInt();
                    sc.nextLine(); 
                    if(key == 1)
                        addBook(sc);
                    else
                        gate = false;
                }

                System.out.print("Do you want explore the books in the library (1 = Yes, 2 = No) ");
                int key = sc.nextInt();
                sc.nextLine();
                gate = true;
                while(gate)
                {
                    if(key == 1 )
                    {
                        displayBooks();
                        gate = false;
                    }
                    else if( key > 2 || key <  1)
                        System.out.println("invalid input");
                }
            } 
            else 
                System.out.println("Wrong password!");
        } 
        else
            System.out.println("Wrong Admin ID!");
    }

    public void addBook(Scanner sc) 
    {
        try 
        {
            System.out.println("Enter Book ID:");
            int id = Integer.parseInt(sc.nextLine()); 

            System.out.println("Enter Book Title:");
            String title = sc.nextLine();

            System.out.println("Enter Book Author:");
            String author = sc.nextLine();

            System.out.println("Is Issued (yes/no):");
            String input = sc.nextLine();
            boolean isIssued = input.equalsIgnoreCase("yes");

            Books bookItem = new Books(id, title, author, isIssued);
            bookList.add(bookItem);

            System.out.println("Book added successfully!");
        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Invalid Book ID!");
        }
    }

    public void userLogin(Scanner sc) 
    {
        System.out.println("Enter your userid:");
        String userid = sc.nextLine();

        User existingUser = findUser(userid);

        if (existingUser != null) 
        {
            System.out.println("User already exists! Please enter password:");
            String password = sc.nextLine();

            if (existingUser.checkPassword(password)) 
            {
                System.out.println("Login successful! Welcome " + existingUser.name);

                System.out.print("Do you want explore the books in the library (1 = Yes, 2 = No) ");
                int key = sc.nextInt();
                sc.nextLine();
                Boolean gate = true;
                while(gate)
                {
                    if(key == 1 )
                    {
                        displayBooks();
                        gate = false;
                    }
                    else if( key > 2 || key <  1)
                        System.out.println("invalid input");
                }

                System.out.print("Do you want borrow the books in the library (1 = Yes, 2 = No) ");
                int borrowKey = sc.nextInt();
                sc.nextLine(); 
                if(borrowKey == 1)
                {
                    try 
                    {
                        System.out.println("Enter Book ID:");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.println("Enter Book Title:");
                        String title = sc.nextLine();

                        System.out.println("Enter Book Author:");
                        String author = sc.nextLine();

                    } 
                    catch (NumberFormatException e) 
                    {
                        System.out.println("Invalid Book Details!");
                    }
                }
            } 
            else 
                System.out.println("Wrong password! Try again.");
        } 
        else
        {
            createUser(sc, userid);
        }
    }

    public User findUser(String userid) 
    {
        for (User u : userList) 
        {
            if (u.userid.equals(userid)) 
                return u;
        }
        return null;
    }

    public  void createUser(Scanner sc, String userid) 
    {
        System.out.println("New user. Please create a password:");
        String password = sc.nextLine();

        System.out.println("Enter your name:");
        String name = sc.nextLine();

        User newUser = new User(userid, name, password, false);
        userList.add(newUser);

        System.out.println("Account created successfully!");

        System.out.println("Do you want to know the list of books in the library? (1 = Yes, 2 = No)");
        int gate = sc.nextInt();
        sc.nextLine(); 
        if (gate == 1) 
            displayBooks();
    }

    public void displayBooks() 
    {
        if (bookList.isEmpty()) 
            System.out.println("No books available in the library.");
        for (Books book : bookList) 
            System.out.println(book);
    }
}

class User 
{
    String userid;
    String name;
    String password;
    Boolean issuedBooks;

    public User(String userid, String name, String password, Boolean issuedBooks) 
    {
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.issuedBooks = issuedBooks;
    }

    public boolean checkPassword(String password)
    {
        return this.password.equals(password);
    }
}

class Books 
{
    int id;
    String title;
    String author;
    Boolean isIssued;

    public Books(int id, String title, String author, Boolean isIssued) 
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = isIssued;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued;
    }
}
