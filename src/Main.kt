import kotlin.random.Random

fun main() {
    val numerosAleatorios = Random

    println("Bienvenido al juego Apuesta y gana, ¡esperamos sea tu día de suerte!")
    print("Por favor, introduce cuál es la cantidad inicial de dinero con la que vas a apostar: ")
    var plata = readLine()!!.toDouble()
    /*
    El método toDouble() en Kotlin convierte una cadena (String) en un número decimal (Double).
    En el código, readLine()!! obtiene la entrada del usuario y el operador !! asegura que no sea nula.
    Luego, toDouble() transforma esa entrada en un número que puede utilizarse en cálculos matemáticos.*/

    var continuarApostando = true

    while (continuarApostando) {
        val numeroAleatorio = numerosAleatorios.nextInt(1, 4)
        println("\nEl número aleatorio es: $numeroAleatorio")

        when (numeroAleatorio) {
            3 -> {
                println("Qué mala suerte, perdiste todo tu dinero. El juego ha terminado.")
                plata = 0.0
                continuarApostando = false
            }
            2 -> {
                plata /= 2
                println("Perdiste la mitad de tu dinero. Ahora tienes $plata.")
                continuarApostando = preguntarSiContinuarApostando()
            }
            1 -> {
                plata *= 2
                println("¡Multiplicaste tu dinero, felicitaciones! Ahora tienes $plata.")
                continuarApostando = preguntarSiContinuarApostando()
            }
        }
    }

    println("Gracias por jugar. Te quedaste con $plata.")
}

fun preguntarSiContinuarApostando(): Boolean {
    print("¿Quieres seguir apostando? (sí/no): ")
    val resultado = readLine()!!
    return resultado.equals("sí", ignoreCase = true)
    /* return resultado.equals("sí", ignoreCase = true) compara la variable resultado con la cadena "sí" sin importar
    las mayúsculas o minúsculas. Utiliza el método equals con ignoreCase = true, asegurando que "sí",
    "Sí", "SÍ", y "sÍ" sean consideradas iguales. El código devolverá true si coinciden y false si no.
     */

}
