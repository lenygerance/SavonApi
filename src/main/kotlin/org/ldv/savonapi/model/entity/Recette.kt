package org.ldv.savonapi.model.entity

import jakarta.persistence.*
import org.springframework.context.annotation.Description


@Entity
@Table (name="recette")
class Recette (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var recetteId: Long,
    var titreId: Long,
    var description: String,
    var surgraissage: Float,
    var qteEau: Float,
    var qteAlcalin: Float,
    var concentrationAlcalin: Float,
    var typeAlcalin: String,

    @ManyToOne
    @JoinColumn(name ="utilisateurId")
    var utilisateur: Utilisateur? = null,

    @OneToMany(mappedBy = "recetteId")
    var resultat: MutableList<Resultat> = mutableListOf(),

    @OneToMany(mappedBy = "recetteId")
    var ligne: MutableList<Ligne> = mutableListOf(),

    ){
    fun calculQteAlcalin(){
        var qteAlcalinNormal: Float= 0.0f
        if (typeAlcalin=="soude"){
            qteAlcalinNormal = this.ligne.sumOf{ ligne: Ligne ->  ligne.quantite.toDouble()*ligne.ingredient!!.sapo*(40.0/56/1000)}.toFloat()
        }
        else{ //typeAlcalin=="potasse"
            qteAlcalinNormal = this.ligne.sumOf{ ligne: Ligne -> (ligne.quantite.toDouble()*ligne.ingredient!!.sapo)*100 }.toFloat()
        }
        qteAlcalin = qteAlcalinNormal / (concentrationAlcalin / 100)

        qteAlcalin -= (qteAlcalin * surgraissage / 100)
    }

    fun calculApportEau(){
        var concentrationEau = (100 - concentrationAlcalin / 100)
        var apportEau = qteAlcalin * concentrationEau
    }

    fun calculScoreNonPondere(){
        var ins = this.ligne.sumOf{ it.ingredient!!.ins.toDouble() * it.pourcentage / 100}
        var iode = this.ligne.sumOf{ it.ingredient!!.iode.toDouble() * it.pourcentage / 100}

        //cherche dans la liste "resultat" les caracteristiques qui ont comme nom "ins" et mettre leurs score en float
        this.resultat.find { it.caracteristique!!.nom=="ins" }!!.score=ins.toFloat()
        this.resultat.find { it.caracteristique!!.nom=="iode" }!!.score=iode.toFloat()
    }
    
    fun calculScorePondere(){


    }
}