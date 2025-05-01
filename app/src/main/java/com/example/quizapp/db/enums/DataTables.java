package com.example.quizapp.db.enums;

/**
 * <p>Created on 01.05.2025<\p>
 *
 * @author Maciej
 * @version 0.1
 */
public enum DataTables {
    /**
     * Enum representing different data tables.
     * Each enum constant corresponds to a specific table name.
     */
    USER("user"),
    TABLES("tables"),
    QUESTIONS("questions");

    private final String tableName;

    DataTables(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }
}
