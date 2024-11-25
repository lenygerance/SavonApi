package org.ldv.savonapi.controller

import org.ldv.savonapi.model.dao.IngredientDAO
import org.ldv.savonapi.model.entity.Ingredient
import org.springframework.http.HttpStatus


import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api-savon/v1/ingredient")
class IngredientController (private val IngrediantDAO:IngredientDAO)
{
    @GetMapping
    fun getAllIngredient(): List<Ingredient>{
        return IngrediantDAO.findAll()
    }

    @GetMapping("/{id}")
    fun getIngredientById(@PathVariable id: Long): ResponseEntity<Ingredient> {
        val ingredient = IngrediantDAO.findById(id)
        return if (ingredient.isPresent) {
            ResponseEntity.ok(ingredient.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createIngredient(@RequestBody ingredient: Ingredient): ResponseEntity<Ingredient>{
        val savedIngredient = IngrediantDAO.save(ingredient)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIngredient)
    }

    @PutMapping("/{id}")
    fun updateIngredient(@PathVariable id: Long,@RequestBody ingredient: Ingredient):ResponseEntity<Ingredient>{
        return if (IngrediantDAO.existsById(id)) {
            ingredient.ingredientId = id
            val updateIngredient = IngrediantDAO.save(ingredient)
            ResponseEntity.ok(updateIngredient)
        }else{
            ResponseEntity.notFound().build()
        }
    }@DeleteMapping("/id")
fun deleteIngredient(@PathVariable id: Long):ResponseEntity<Void>{
    return if  (IngrediantDAO.existsById(id)) {
        IngrediantDAO.deleteById(id)
        ResponseEntity.noContent().build()
    }else{
        ResponseEntity.notFound().build()
    }

}


}