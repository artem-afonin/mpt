package ru.artem.phonebook

import ru.artem.phonebook.view.MainView
import tornadofx.App
import tornadofx.launch

class MainApplication : App(MainView::class)

fun main(args: Array<String>) {
    launch<MainApplication>()
}
