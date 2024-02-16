class Usuario(val name: String, val email: String) {
    // Additional properties and methods can be added here
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    // Additional properties and methods can be added here
}

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()
    
    /**
     * Enrolls a user in the formation.
     * @param usuario The user to be enrolled.
     */
    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("${usuario.name} foi matriculado na formação $nome.")
        } else {
            println("${usuario.name} já está matriculado na formação $nome.")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Lucas", "Lucas@gmail.com")
    val usuario2 = Usuario("Roberto", "Rberto@gmail.com")
    
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 120)
    val conteudo2 = ConteudoEducacional("Algoritmos Avançados", 180)
    
    val formacao = Formacao("Ciência da Computação", listOf(conteudo1, conteudo2))
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1) // Trying to enroll the same user again
    
    println("Inscritos na formação ${formacao.nome}: ${formacao.inscritos.joinToString(", ") { it.name }}")
}
