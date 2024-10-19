# FacultyManager

**FacultyManager** is a Java-based system designed to manage faculty members, including both full-time (Titular) and substitute (Suplente) teachers. The system allows users to add new faculty members, assign attributes such as salary, seniority, and rural area assignments for substitutes. It also offers functionality to apply salary bonuses, check faculty details, and handle validation of user inputs like age, salary, and seniority.

This project demonstrates the use of **Object-Oriented Programming** principles, design patterns like **Command**, and a structured approach to handling menu-driven applications.

## Features

- Add new **Titular** (full-time) and **Suplente** (substitute) faculty members.
- Assign attributes such as:
  - Salary
  - Seniority
  - Rural area assignment (for substitutes)
- Apply salary bonuses based on certain conditions.
- Consult faculty details, both with and without salary bonuses.
- Input validation for fields such as:
  - Age
  - Salary
  - Seniority (ensuring it doesn't exceed the age)

## Design Patterns Used

The **Command Pattern** is used to decouple the system's operations (such as adding a teacher or applying bonuses) from the menu structure, making the code more maintainable and flexible.

## Installation & Usage

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/FacultyManager.git
   cd FacultyManager
2. **Build the project:**
- Ensure you have a working Java environment installed.
- Use your preferred IDE (like IntelliJ IDEA or VSCode) or command-line tools to compile the project.
3. **Run the application:**

- If using a terminal:
    ```bash
    javac -d bin src/App.java
    java -cp bin App

4. **Using the system**:
- The system provides a menu-driven interface to perform the following actions:

  - Add full-time or substitute faculty members.
  - Apply salary bonuses.
  - View faculty details.
  - Insert default sample data.

## Project Structure
- `App.java`: The main entry point for the application.
- `Classes/`: Contains all the class files for `Docente` (Faculty) and the individual command classes implementing the `ICommand` interface.
- `Commands/`: Contains implementations of the various commands used in the system.

## How to Contribute
1. **Fork the repository.**
2. **Create a new branch** (`git checkout -b feature-branch`)

3. **Make your changes and commit** (`git commit -am 'Add some feature'`)

4. **Push to the branch** (`git push origin feature-branch`)

5. **Create a new Pull Request.**