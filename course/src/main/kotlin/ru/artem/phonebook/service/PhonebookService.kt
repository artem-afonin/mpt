package ru.artem.phonebook.service

import ru.artem.phonebook.model.Phonebook
import ru.artem.phonebook.model.PhonebookRow

object PhonebookService {
    fun getAll(): Phonebook {
        val phonebook = mutableListOf<PhonebookRow>()
        val resultSet = DatabaseService.query("SELECT * FROM phonebook")
        while (resultSet.next()) {
            val row = PhonebookRow(resultSet.getString("name"), resultSet.getString("phone"))
            phonebook.add(row)
        }
        return phonebook
    }

    fun insert(row: PhonebookRow) {
        DatabaseService.update("insert into phonebook(name, phone) values ('${row.name}', '${row.phone}')")
    }

    fun update(row: PhonebookRow, name: String = row.name, phone: String = row.phone) {
        DatabaseService.update(
            """update phonebook
            set name = '$name', phone = '$phone'
            where name = '${row.name}' and phone = '${row.phone}'"""
        )
    }

    fun delete(row: PhonebookRow) {
        DatabaseService.update(
            "delete from phonebook where name = '${row.name}' and phone = '${row.phone}'"
        )
    }

    fun save(phonebook: Phonebook) {
        DatabaseService.update("delete from phonebook")
        phonebook.forEach { insert(it) }
    }
}