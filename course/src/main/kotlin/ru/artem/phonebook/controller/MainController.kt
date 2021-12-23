package ru.artem.phonebook.controller

import ru.artem.phonebook.model.PhonebookRow
import ru.artem.phonebook.service.PhonebookService
import ru.artem.phonebook.view.CellEditEvent
import tornadofx.Controller
import tornadofx.asObservable
import kotlin.reflect.KMutableProperty0
import kotlin.reflect.jvm.javaField

class MainController : Controller() {
    val phonebook = PhonebookService.getAll().asObservable()

    fun onClearAction() {
        phonebook.clear()
    }

    fun onSaveAction() {
        PhonebookService.save(phonebook)
    }

    fun onDeleteAction(selectedRow: PhonebookRow) {
        phonebook.remove(selectedRow)
    }

    fun onEditAction(event: CellEditEvent, fieldRef: KMutableProperty0<String>) {
        when (fieldRef.javaField) {
            PhonebookRow::name.javaField -> {
                fieldRef.set(event.newValue)
            }
            PhonebookRow::phone.javaField -> {
                if (phonebook.find { it.phone == event.newValue } == null && PhonebookRow.phoneRegex.matches(event.newValue))
                    fieldRef.set(event.newValue)
                else {
                    fieldRef.set(event.oldValue)
                }
            }
        }
        event.tableView.refresh()
    }

    fun onAddAction(name: String, phone: String) {
        phonebook.add(PhonebookRow(name, phone))
    }
}