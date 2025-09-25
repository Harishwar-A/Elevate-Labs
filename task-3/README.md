# 📚 Library Management System (Java - Console Based)

This is a simple **Library Management System** implemented in Java using **Object-Oriented Programming (OOP)** concepts.  
It runs in the **console** and allows two types of users:
- **Admin** (who can add books to the library)
- **Normal Users** (who can create an account, log in, and explore books)

---

## 🚀 Features
- Admin authentication (`ID` + `Password`)
- Add new books (with ID, title, author, issued status)
- User account creation
- User login with password validation
- View list of available books
- Borrowing books (basic flow included, can be extended)

---

## 🔑 How It Works

When the program starts, the user is asked:
If you are admin enter 1 or else enter 2 to continue:

### 1️⃣ Admin Flow
- Admin enters ID and password.
- If correct:
  - Admin can add new books to the library.
  - Each book requires:
    - **Book ID**
    - **Book Title**
    - **Book Author**
    - **Issued status** (yes/no)
  - Admin can then choose to **view the list of books** in the library.
- If incorrect:
  - The system displays **Wrong Admin ID/Password**.

👉 Default admin credentials are:
- **Admin ID** → `harish`
- **Password** → `harish`

---

### 2️⃣ New User Flow
- If a user chooses option `2`, they must enter a **User ID**.
- If this is a **new user**:
  - They will be asked to create a password and provide their name.
  - Their account will be saved in the system.
  - They can then explore the library books.

---

### 3️⃣ Existing User Flow
- If the entered **User ID already exists**:
  - The user will be asked to enter their password.
  - If correct:
    - They log in successfully.
    - They can view available books.
    - They will also be asked if they want to **borrow a book** (feature in progress).
  - If wrong password:
    - They will see **Wrong password! Try again.**

---

## ⚙️ Classes Used

### `LibrarySystem`
- Main class with the entry point (`main` method).
- Decides whether the user is **Admin** or **User**.

### `Library`
- Manages the **list of books** and **list of users**.
- Handles admin login, adding books, user login, creating new users, and displaying books.

### `Books`
- Represents a single book with:
  - `id`, `title`, `author`, and `isIssued`.

### `User`
- Represents a library user with:
  - `userid`, `name`, `password`, and `issuedBooks`.

---

## 🛠️ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/library-system-java.git
📌 Example Run
If you are admin enter 1 or else enter 2 to continue: 1
Enter the Admin ID:
harish
Enter the Admin Password:
harish
Do you want enter book info (1 = Yes, 2 = No)
1
Enter Book ID:
101
Enter Book Title:
Java Basics
Enter Book Author:
James Gosling
Is Issued (yes/no):
no
Book added successfully!
Do you want explore the books in the library (1 = Yes, 2 = No) 1
Book ID: 101, Title: Java Basics, Author: James Gosling, Issued: false
If you are admin enter 1 or else enter 2 to continue: 2
Enter your userid:
user1
New user. Please create a password:
1234
Enter your name:
Alice
Account created successfully!
Do you want to know the list of books in the library? (1 = Yes, 2 = No) 1
Book ID: 101, Title: Java Basics, Author: James Gosling, Issued: false
📖 Notes

This project is console-based (no database). Data is lost once the program ends.

Admin can only be logged in with ID: harish and Password: harish.

Borrow functionality is basic and can be extended further (like marking a book as issued).

✨ Future Improvements

Save data permanently (using file storage or database).

Implement return-book functionality.

Prevent duplicate Book IDs.

Improve borrow/issue logic.

Add proper menu-driven interface.
