
import java.util.Scanner

fun main() {
    val entradaPersonas = Scanner(System.`in`)
    var erroresPersonas = 0
    val maxIntentosPermitidos = 3
    var accesoId = false

    val empleadosEdificio = (1000..1999).associateWith { "Empleado" }
    val visitantesEdificio = (2000..2999).associateWith { "Visitante" }

    while (erroresPersonas < maxIntentosPermitidos) {
        print("Ingrese su ID por favor: ")
        val codigoAcceso = entradaPersonas.nextInt()

        when {
            /* El método containsKey se utiliza para comprobar si el código de
            acceso que el usuario ha ingresado está presente en los mapas. (Los mapas
            permiten verificar rápidamente si un código de acceso ingresado es válido
            y a qué tipo de usuario pertenece si es de empleadosEdificio o visitantesEdificio)*/

            empleadosEdificio.containsKey(codigoAcceso) -> {
                println("Bienvenido, tu ID es: $codigoAcceso")
                accesoId = true
                break
            }
            visitantesEdificio.containsKey(codigoAcceso) -> {
                print("Ingresa tu nombre: ")
                entradaPersonas.nextLine() // Consumir el salto de línea
                val nombreVisitante = entradaPersonas.nextLine()
                print("El motivo de tu visita es: ")
                val motivoIngreso = entradaPersonas.nextLine()
                println("Acceso autorizado a $nombreVisitante" +
                        "\nMotivo: $motivoIngreso")
                accesoId = true
                break
            }
            else -> {
                erroresPersonas++
                println("Código incorrecto. Intento $erroresPersonas de $maxIntentosPermitidos.")
            }
        }
    }

    if (!accesoId) {
        println("Acceso bloqueado por exceder los intentos permitidos.")
    }
}
