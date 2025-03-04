fun main() {
    val votosPublicidadInternet = IntArray(3)
    val votosPublicidadRadio = IntArray(3)
    val votosPublicidadTelevision = IntArray(3)
    var votosTotales = 0

    fun costoCampaña(candidato: Int) =
        (votosPublicidadInternet[candidato] * 700000) + (votosPublicidadRadio[candidato] * 200000) + (votosPublicidadTelevision[candidato] * 600000)

    while (true) {
        println("Menú:\n1. Votar\n2. Calcular costo de la campaña del cadidato\n3. Vaciar urnas\n4. Total votos\n5. Porcentaje votos\n6. Costo promedio campaña\n7. Salir")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Candidato (1: Camila, 2: Omar, 3: Heyder):")
                val candidato = readLine()?.toIntOrNull()?.minus(1) ?: continue
                println("Medio (1: Internet, 2: Radio, 3: Televisión):")
                when (readLine()?.toIntOrNull()) {
                    1 -> votosPublicidadInternet[candidato]++
                    2 -> votosPublicidadRadio[candidato]++
                    3 -> votosPublicidadTelevision[candidato]++
                }
                votosTotales++
            }
            2 -> (0..2).forEach { println("Candidato ${it + 1}: ${costoCampaña(it)}") } /*${it + 1} convierte el índice del candidato (0, 1, 2) en un número más comprensible para el usuario (1, 2, 3) al mostrar el costo de campaña.
            Esto hace que la salida sea más clara y fácil de entender.*/
            3 -> {
                votosPublicidadInternet.fill(0); votosPublicidadRadio.fill(0); votosPublicidadTelevision.fill(0); votosTotales = 0
                println("Urnas vaciadas")
            }
            4 -> println("Total votos: $votosTotales")
            5 -> (0..2).forEach { println("Candidato ${it + 1}: ${if (votosTotales == 0) 0 else (votosPublicidadInternet[it] + votosPublicidadRadio[it] + votosPublicidadTelevision[it]) * 100 / votosTotales}%") }
            6 -> println("Costo promedio campaña: ${if (votosTotales == 0) 0 else (0..2).sumOf { costoCampaña(it) } / votosTotales}")
            7 -> return

        }
    }
}
