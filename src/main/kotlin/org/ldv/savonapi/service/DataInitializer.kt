package org.ldv.savonapi.service

import org.ldv.savonapi.model.dao.CaracteristiqueDAO
import org.ldv.savonapi.model.dao.IngredientDAO
import org.ldv.savonapi.model.dao.MentionDAO
import org.ldv.savonapi.model.entity.*
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class DataInitializer(
    val ingredientDAO: IngredientDAO,
    val caracteristiqueDAO: CaracteristiqueDAO,
    private val mentionDAO: MentionDAO
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        //Pour importer les ingredients
        if (ingredientDAO.count() == 0L) { // Éviter les doublons
            var huileOlive=  Ingredient(1,"Huile d'olive",9.26f,10.192f,9.838f,9.152f,10.144f,9.298f,10.194f)
            var huileCoco=  Ingredient(2,"Huile de Coco",7.74f,14.462f,13.356f,9.560f,9.560f,11.204f,11.880f)

            var ingredients= listOf<Ingredient>(huileOlive,huileCoco)
            ingredientDAO.saveAll(ingredients)
    }
    // Pour importer les caracteristiques...
        if (caracteristiqueDAO.count() == 0L) {
            var saponification =  Caracteristique(1,"Saponification")
            var iode =  Caracteristique(2,"Iode")
            var ins = Caracteristique(3,"INS")
            var douceur = Caracteristique(4,"Douceur")
            var lavant = Caracteristique(5,"Lavant")
            var volmoussant = Caracteristique(6,"Vol moussant")
            var tenuemoussant = Caracteristique(7,"Tenue moussant")
            var durete = Caracteristique(8,"Dureté")
            var solubilite = Caracteristique(9,"Solubilité")
            var sechage = Caracteristique(10,"Sechage")


            var caracteristique= listOf<Caracteristique>(saponification,iode,ins,douceur,lavant,volmoussant,tenuemoussant,durete,solubilite,sechage)
            caracteristiqueDAO.saveAll(caracteristique)
        }

        if (mentionDAO.count() == 0L) {
           var mentionSaponification1= Mention(1,"Parfaitement équilibré",80f,100f)
            var mentionSaponification2= Mention(2,"Bonne qualité",60f,79f)
            var mentionSaponification3 = Mention(3,"Peut être amelioré",40F,59F)
            var mentionSaponification4= Mention(4,"Déséquilibrer",0F,39F)

            var mentionIode1= Mention(5,"Très stable",0f,50f)
            var mentionIode2= Mention(6,"Stable",51f,70f)
            var mentionIode3= Mention(7,"Légèrement instable",71f,90f)
            var mentionIode4= Mention(8,"Instabilité élevée",91f,null)


            var mentionIns1 = Mention(9,"Formule optimisée",120F,160F)
            var mentionIns2 = Mention(10,"Bonne cohérence",100F,180F)
            var mentionIns3 = Mention(11,"Moyennement équilibré",99F,181F)
            var mentionIns4 = Mention(12,"Déséquilibre marqué",80F,200F)

            var mentionLavant1= Mention(13,"Pouvoir lavant exceptionnel",80f,100f)
            var mentionLavant2= Mention(14,"Bonne capacité nettoyante",60f,79f)
            var mentionLavant3= Mention(15,"Nettoyage modéré",40f,59f)
            var mentionLavant4= Mention(16,"Pouvoir lavant insuffisant",0f,39f)


            var mentionDouceur1 = Mention(17,"Très doux pour la peau",80F,100F)
            var mentionDouceur2 = Mention(18,"Assez doux",60F,79F)
            var mentionDouceur3 = Mention(19,"Légèrement irritant",40F,59F)
            var mentionDouceur4 = Mention(20,"Irritant",0F,39F)

            var mentionTenueMoussante1 = Mention(21,"Excellent",80F,100F)
            var mentionTenueMoussante2 = Mention(22,"Bonne tenue de la mousse",60F,79F)
            var mentionTenueMoussante3 = Mention(23,"Tenue correcte",40F,59F)
            var mentionTenueMoussante4 = Mention(24,"Mousse fugace",0F,39F)

            var mentionSolubilite1 = Mention(25,"très bien soluble",80F,100F)
            var mentionSolubilite2 = Mention(26,"Bonne solubilité",60F,79F)
            var mentionSolubilite3 = Mention(27,"Solubilité moyenne",40F,59F)
            var mentionSolubilite4 = Mention(28,"Dissolution lente",0F,39F)

            var mentionSechage1 = Mention(29,"Séche très rapidement",80F,100F)
            var mentionSechage2 = Mention(30,"Bonne vitesse de séchage",60F,79F)
            var mentionSechage3 = Mention(31,"Séchage modéré",40F,59F)
            var mentionSechage4 = Mention(32,"Séchage lent",0F,39F)

            var mentionVolmoussant1= Mention(33,"Mousse abondante",80f,100f)
            var mentionVolmoussant2= Mention(34,"Mousse généreuse",60f,79f)
            var mentionVolmoussant3= Mention(35,"Mousse légère",40f,59f)
            var mentionVolmoussant4= Mention(36,"Peu de mousse",0f,39f)

            var mentionDurete1= Mention(37,"Très résistant",80f,100f)
            var mentionDurete2= Mention(38,"Résistance correcte",60f,79f)
            var mentionDurete3= Mention(39,"Légèrement friable",40f,59f)
            var mentionDurete4= Mention(40,"Se désagrège facilement",0f,39f)

            var mention= listOf<Mention>(mentionSaponification1, mentionSaponification2,mentionSaponification3,mentionSaponification4, mentionIode1, mentionIode2, mentionIode3, mentionIode4,mentionIns1,mentionIns2,mentionIns3,mentionIns4,mentionLavant1,mentionLavant2,mentionLavant3,mentionLavant4,mentionDouceur1,mentionDouceur2,mentionDouceur3,mentionDouceur4,mentionTenueMoussante1,mentionTenueMoussante2,mentionTenueMoussante3,mentionTenueMoussante4,mentionSolubilite1,mentionSolubilite2,mentionSolubilite3,mentionSolubilite4,mentionSechage1,mentionSechage2,mentionSechage3,mentionSechage4,mentionVolmoussant1,mentionVolmoussant2,mentionVolmoussant3,mentionVolmoussant4,mentionDurete1,mentionDurete2,mentionDurete3,mentionDurete4)
            mentionDAO.saveAll(mention)
        }
    }

}