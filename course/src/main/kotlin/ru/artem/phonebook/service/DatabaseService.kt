package ru.artem.phonebook.service

import java.nio.file.Paths
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

object DatabaseService {
    private val con: Connection

    init {
        val dbPath = Paths.get("db/phonebook.sqlite")
        con = DriverManager.getConnection("jdbc:sqlite:${dbPath.toAbsolutePath()}")
    }

    fun query(query: String): ResultSet {
        return con.createStatement().executeQuery(query)
    }

    fun update(query: String) {
        con.createStatement().executeUpdate(query)
    }
}