import java.util.Random

fun main() {
    val generadorAleatorio = Random()

    var puntajeKaren = 0
    var puntajeHeyder = 0
    val rondasLanzamiento = 4

    println("🎲 ¡Comienza el lanzamiento de dados! 🎲")

    for (ronda in 1..rondasLanzamiento) {
        val dado1Karen = generadorAleatorio.nextInt(6) + 1
        val dado2Karen = generadorAleatorio.nextInt(6) + 1
        val totalKaren = dado1Karen + dado2Karen

        val dado1Heyder = generadorAleatorio.nextInt(6) + 1
        val dado2Heyder = generadorAleatorio.nextInt(6) + 1
        val totalHeyder = dado1Heyder + dado2Heyder

        println("Ronda $ronda: Karen obtuvo $totalKaren, Heyder obtuvo $totalHeyder")

        puntajeKaren += totalKaren
        puntajeHeyder += totalHeyder
    }

    println("\nPuntuación final: Karen = $puntajeKaren, Heyder = $puntajeHeyder")

    when {
        puntajeKaren > puntajeHeyder -> println("🏆 ¡Karen es la ganadora!")
        puntajeHeyder > puntajeKaren -> println("🏆 ¡Heyder es el ganador!")
        else -> println("🤝 ¡Es un empate!")
    }
}
