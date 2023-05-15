package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleFileDatabase {

    private static final String METADATA_FILE = "metadata.txt";
    private static final String TABLE_FILE = "table.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter CREATE TABLE query:");
        String createQuery = scanner.nextLine();
        createTable(createQuery);

        System.out.println("Enter INSERT INTO query:");
        String insertQuery = scanner.nextLine();
        insertData(insertQuery);

        scanner.close();
//        createTable("CREATE TABLE my_table (col1 INTEGER, col2 STRING)");
//        insertData("INSERT INTO my_table VALUES (1, 'Hello'), (2, 'World')");
    }

    private static void createTable(String query) {
        String tableName = extractTableName(query);
        List<Column> columns = extractColumns(query);

        // Save metadata to the metadata file
        try (FileWriter writer = new FileWriter(METADATA_FILE, true)) {
            writer.write(tableName + "\n");
            for (Column column : columns) {
                writer.write(column.getName() + "," + column.getType().toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(String query) {
        String tableName = extractTableName(query);
        List<String> values = extractValues(query);

        // Save data to the table file
        try (FileWriter writer = new FileWriter(TABLE_FILE, true)) {
            for (String value : values) {
                writer.write(tableName + "," + value + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractTableName(String query) {
        // Extract table name from the query
        int startIndex = query.indexOf("CREATE TABLE") + 13;
        int endIndex = query.indexOf("(");
        return query.substring(startIndex, endIndex).trim();
    }

    private static List<Column> extractColumns(String query) {
        // Extract column names and types from the query
        List<Column> columns = new ArrayList<>();
        int startIndex = query.indexOf("(") + 1;
        int endIndex = query.indexOf(")");
        String columnStr = query.substring(startIndex, endIndex);
        String[] columnArray = columnStr.split(",");
        for (String column : columnArray) {
            String[] columnParts = column.trim().split(" ");
            String columnName = columnParts[0];
            DataType dataType = DataType.valueOf(columnParts[1].toUpperCase());
            columns.add(new Column(columnName, dataType));
        }
        return columns;
    }

    private static List<String> extractValues(String query) {
        // Extract values from the query
        List<String> values = new ArrayList<>();
        int startIndex = query.indexOf("VALUES") + 6;
        int endIndex = query.lastIndexOf(")");
        String valuesStr = query.substring(startIndex, endIndex);
        String[] valueArray = valuesStr.split(",");
        for (String value : valueArray) {
            values.add(value.trim());
        }
        return values;
    }

    private static class Column {
        private final String name;
        private final DataType type;

        public Column(String name, DataType type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public DataType getType() {
            return type;
        }
    }

    private enum DataType {
        INTEGER,
        STRING
    }
}
