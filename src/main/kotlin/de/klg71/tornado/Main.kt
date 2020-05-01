package de.klg71.tornado

import javafx.application.Application
import javafx.scene.layout.*
import javafx.beans.property.SimpleIntegerProperty
import tornadofx.*





class MyApp: App(MyView::class)

fun main(args: Array<String>) {
    println("Hello....")
    Application.launch(MyApp::class.java, *args)
}






class MyView : View() {

    private val number1 = SimpleIntegerProperty()
    private val number2 = SimpleIntegerProperty()
    private val result = SimpleIntegerProperty()

    override val root = hbox {
        hbox {
            form {
                fieldset {
                    text = "Calculator"

                    field {
                        text = "Number 1"
                        textfield().bind(number1)
                    }
                    field {
                        text = "Number 2"
                        textfield().bind(number2)
                    }
                    hbox {
                        spacing = 2.0

                        button {
                            text = "add"
                            action(::add)
                        }
                        button {
                            text = "subtract"
                            action(::subtract)
                        }
                        button {
                            text = "multiply"
                            action(::multiply)
                        }
                    }
                    field {
                        text = "Result"
                        label().bind(result)

                    }

                }

            }
        }
    }

    private fun add() {
        result.value = number1.value + number2.value
    }

    private fun subtract() {
        result.value = number1.value - number2.value
    }

    private fun multiply() {
        result.value = number1.value * number2.value
    }

}

