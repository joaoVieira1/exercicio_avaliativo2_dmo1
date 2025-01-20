package br.edu.ifsp.dmo1.exercicio_avaliativo2.data.model

class Usuario(var prontuario: String, var nome: String, var voto: String) {

    object VOTOS {
        const val RUIM = "ruim"
        const val REGULAR = "regular"
        const val BOM = "bom"
        const val OTIMO = "otimo"
    }

}