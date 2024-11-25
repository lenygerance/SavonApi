package org.ldv.savonapi.controller

import org.ldv.savonapi.model.dao.MentionDAO
import org.ldv.savonapi.model.entity.Mention
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api-savon/v1/mention")
class MentionController(
    private val MentionDAO: MentionDAO,
    private val mentionDAO: MentionDAO
) {

    @GetMapping
    fun getAllMention(): List<Mention>{
        return MentionDAO.findAll()
    }

    @GetMapping("/{id}")
        fun getMentionById(@PathVariable id: Long):ResponseEntity<Mention> {
            val mention = MentionDAO.findById(id)
            return if (mention.isPresent) {
                ResponseEntity.ok(mention.get())
            } else {
                ResponseEntity.notFound().build()
            }
        }
    @PostMapping("/mention")
    fun createMention(@RequestBody mention:Mention): ResponseEntity<Mention>{
        val savedMention = MentionDAO.save(mention)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMention)
    }

    @PutMapping("/{id}")
    fun updateMention(@PathVariable id: Long,@RequestBody mention: Mention):ResponseEntity<Mention>{
        return if (mentionDAO.existsById(id)) {
            mention.mentionId = id
            val updateMention = mentionDAO.save(mention)
            ResponseEntity.ok(updateMention)
        }else{
            ResponseEntity.notFound().build()
        }
    }@DeleteMapping("/id")
    fun deleteMention(@PathVariable id: Long):ResponseEntity<Void>{
        return if  (mentionDAO.existsById(id)) {
            mentionDAO.deleteById(id)
            ResponseEntity.noContent().build()
        }else{
            ResponseEntity.notFound().build()
        }

    }

    }






