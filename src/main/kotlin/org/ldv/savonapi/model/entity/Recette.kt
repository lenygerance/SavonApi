package org.ldv.savonapi.model.entity

import jakarta.persistence.*


@Entity
@Table (name="recette")
class Recette (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var recetteId: Long,
    var titre: String,
    var description: String,
    var surgraissage: Float,
    var qteEau: Float,
    var qteAlcalin: Float,
    var concentrationAlcalin: Float,
    var typeAlcalin: String,


    @ManyToOne
    @JoinColumn(name ="utilisateurId")
    var utilisateur: Utilisateur? = null,

    @OneToMany(mappedBy = "recette")
    var resultats: MutableList<Resultat> = mutableListOf(),

    @OneToMany(mappedBy = "recette")
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
        this.resultats.find { it.caracteristique!!.nom=="ins" }!!.score=ins.toFloat()
        this.resultats.find { it.caracteristique!!.nom=="iode" }!!.score=iode.toFloat()
    }
    
    fun calculScorePondere(){
        var douceur =this.ligne.sumOf { it.ingredient!!.douceur.toDouble() * it.pourcentage / 100 }
        var lavant =this.ligne.sumOf { it.ingredient!!.lavant.toDouble() * it.pourcentage / 100 }
        var volmousse =this.ligne.sumOf { it.ingredient!!.volmousse.toDouble() * it.pourcentage / 100 }
        var tenuemousse =this.ligne.sumOf { it.ingredient!!.tenuemousse.toDouble() * it.pourcentage / 100 }
        var durete =this.ligne.sumOf { it.ingredient!!.durete.toDouble() * it.pourcentage / 100 }
        var solubilite =this.ligne.sumOf { it.ingredient!!.solubilite.toDouble() * it.pourcentage / 100 }
        var sechage =this.ligne.sumOf { it.ingredient!!.sechage.toDouble() * it.pourcentage / 100 }

        douceur = douceur * (1 + 0.01494 * surgraissage)
        lavant = lavant * (1 + -0.01203 * surgraissage)
        volmousse = volmousse * (1 + -0.00702 * surgraissage)
        tenuemousse = tenuemousse * (1 + 0.01016 * surgraissage)
        durete = durete * (1 + -0.00602 * surgraissage)
        solubilite = solubilite * (1 + 0.00250 * surgraissage)
        sechage = sechage * (1 + -0.00503 * surgraissage);

        this.resultats.find { it.caracteristique!!.nom=="douceur" }!!.score=douceur.toFloat()
        this.resultats.find { it.caracteristique!!.nom=="lavant" }!!.score=lavant.toFloat()
        this.resultats.find { it.caracteristique!!.nom=="volmousse" }!!.score=volmousse.toFloat()
        this.resultats.find { it.caracteristique!!.nom=="tenuemousse" }!!.score=tenuemousse.toFloat()
        this.resultats.find { it.caracteristique!!.nom=="durete" }!!.score=durete.toFloat()
        this.resultats.find { it.caracteristique!!.nom=="solubilite" }!!.score=solubilite.toFloat()
        this.resultats.find { it.caracteristique!!.nom=="sechage" }!!.score=sechage.toFloat()








    }
}