package ru.artem.phonebook.view

import javafx.event.EventHandler
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextField
import javafx.scene.layout.VBox
import ru.artem.phonebook.controller.MainController
import ru.artem.phonebook.model.PhonebookRow
import tornadofx.*

typealias CellEditEventHandler = EventHandler<TableColumn.CellEditEvent<PhonebookRow, String>?>
typealias CellEditEvent = TableColumn.CellEditEvent<PhonebookRow, String>

class MainView : View() {
    override val root = VBox()

    private var tableView: TableView<PhonebookRow> by singleAssign()
    private var nameField: TextField by singleAssign()
    private var phoneField: TextField by singleAssign()

    private val controller: MainController by inject()

    init {
        val phonebook = controller.phonebook
        root.apply {
            vbox {
                hbox {
                    tableView = tableview(phonebook) {
                        isEditable = true
                        column("Name", PhonebookRow::nameProperty).apply {
                            makeEditable()
                            onEditCommit = CellEditEventHandler { event ->
                                event?.rowValue?.let {
                                    controller.onEditAction(
                                        event,
                                        event.rowValue::name
                                    )
                                }
                            }
                        }
                        column("Phone number", PhonebookRow::phoneProperty).apply {
                            makeEditable()
                            onEditCommit = CellEditEventHandler { event ->
                                event?.rowValue?.let {
                                    controller.onEditAction(
                                        event,
                                        event.rowValue::phone
                                    )
                                }
                            }
                        }
                    }
                    vbox {
                        button("Save") {
                            action { controller.onSaveAction() }
                        }
                        button("Delete") {
                            action { tableView.selectedItem?.let { controller.onDeleteAction(it) } }
                        }
                        button("Clear") {
                            action { controller.onClearAction() }
                        }
                    }
                }
                hbox {
                    label("Name:")
                    nameField = textfield()
                    label("Phone:")
                    phoneField = textfield()
                    button("Add") {
                        action {
                            controller.onAddAction(nameField.text, phoneField.text)
                            nameField.text = ""
                            phoneField.text = ""
                        }
                    }
                }
            }
        }
    }
}