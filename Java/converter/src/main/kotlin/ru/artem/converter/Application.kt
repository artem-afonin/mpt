package ru.artem.converter

import ru.artem.converter.view.MainView
import tornadofx.*

class Application : App(MainView::class)

fun main(args: Array<String>) {
    launch<Application>(args)
}
