package ru.artem.phonebook.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

class PhonebookRow(name: String, phone: String) {
    val nameProperty = SimpleStringProperty(name)
    var name: String by nameProperty

    val phoneProperty = SimpleStringProperty(phone)
    var phone: String by phoneProperty

    init {
        if (!phoneRegex.matches(phone)) {
            throw RuntimeException("Invalid phone string: $phone")
        }
    }

    override fun toString(): String {
        return "PhonebookRow(name='$name', phone='$phone')"
    }

    companion object {
        val phoneRegex = Regex("^\\+?\\d{11}|\\d{5,7}$")
    }
}

typealias Phonebook = List<PhonebookRow>
