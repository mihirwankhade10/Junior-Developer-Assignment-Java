# Junior-Developer-Assignment-Java
## Simple File-based One-Table Database

This project is a simple file-based one-table database implementation in Java. It allows users to create a table and insert data into it using SQL-like syntax. The metadata about the table (column names and types) is stored in a separate metadata file, and the data is stored in a table file.

## Usage

1. Clone the repository or download the source code.

2. Compile the Java source files.

3. Run the program.

4. Follow the on-screen instructions to create a table and insert data. Enter the CREATE TABLE and INSERT INTO queries when prompted.

5. Screenshots:- 

### img1
<img width="960" alt="sc1" src="https://github.com/mihirwankhade10/Junior-Developer-Assignment-Java/assets/87888969/3076b707-8a7f-49d5-b2b4-e2ed76306979">

### img2
<img width="960" alt="sc2" src="https://github.com/mihirwankhade10/Junior-Developer-Assignment-Java/assets/87888969/46a61fcc-29db-4f99-97d6-fea668645c44">

### img3
<img width="960" alt="sc3" src="https://github.com/mihirwankhade10/Junior-Developer-Assignment-Java/assets/87888969/629e37ad-860b-4f9a-9282-43213136626e">

## File Structure

- `SimpleFileDatabase.java`: The main Java class containing the database implementation.
- `metadata.txt`: The file that stores the metadata about the table.
- `table.txt`: The file that stores the data in the table.

## Example

Here's an example of how to use the program:

1. Create a table:

This will create a table named `my_table` with two columns: `col1` of type INTEGER and `col2` of type STRING.

2. Insert data into the table:

This will insert two rows into the `my_table` table.

3. The metadata and data will be saved in the respective files (`metadata.txt` and `table.txt`).

## Notes

- This implementation is a simplified example and does not include error handling or advanced database features. It serves as a starting point for understanding basic file-based database operations.

- Feel free to extend and modify the code to add more functionality or handle additional data types as per your requirements.

- For any issues or suggestions, please open an issue or submit a pull request.



