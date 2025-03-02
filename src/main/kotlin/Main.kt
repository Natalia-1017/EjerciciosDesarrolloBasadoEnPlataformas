fun main() {

    var totalAhorrado = 0
    val monedas: MutableMap<Int, Int> = mutableMapOf(
        20 to 0,
        50 to 0,
        100 to 0,
        200 to 0,
        500 to 0
    )

    var seleccionUsuario: Int


    do {
        println(
            """
            --- Menú de la Alcancía ---
            1. Agregar moneda
            2. Contar monedas
            3. Calcular total ahorrado
            4. Romper alcancía
            5. Salir
        """.trimIndent()
        )

        print("Seleccione una opción: ")
        seleccionUsuario = readln().toIntOrNull() ?: 0

        when (seleccionUsuario) {
            1 -> {
                print("Ingrese el valor de la moneda (20, 50, 100, 200, 500): ")
                val valor = readln().toIntOrNull()

                if (valor != null && valor in monedas.keys) {
                    monedas[valor] = monedas[valor]!! + 1
                    totalAhorrado += valor
                    println("Se agregó una moneda de $valor a la alcancía.")
                } else {
                    println("Valor no válido.")
                }
            }

            2 -> {
                println("\nCantidad de monedas en la alcancía:")
                for ((valor, cantidad) in monedas) {
                    println("$valor: $cantidad monedas")
                }
            }

            3 -> {
                println("\nTotal ahorrado: ${formatCurrency(totalAhorrado)}")
            }

            4 -> {
                println("\n¡La alcancía ha sido rota! Contenido vaciado.")
                for (key in monedas.keys) {
                    monedas[key] = 0
                }
                totalAhorrado = 0
            }

            5 -> println("Saliendo del programa...")

            else -> println("Opción no válida, intente nuevamente.")
        }

    } while (seleccionUsuario != 5)
}

fun formatCurrency(amount: Int): String {
    return "%,d".format(amount)
}

