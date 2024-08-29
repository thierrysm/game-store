package com.tsm.storegames.web.resource

import com.tsm.storegames.entity.GameEntity
import com.tsm.storegames.service.GameService
import com.tsm.storegames.util.orThrow
import com.tsm.storegames.web.request.GameRequest
import com.tsm.storegames.web.response.GameResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/game")
class GameResource(
    private val gameService: GameService
) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id:Long) : GameResponse {
        val game = gameService.getById(id)
        return toResponse(game)
    }

    @GetMapping
    fun getAll() : List<GameResponse> {
        val games = gameService.getAll()
        return games.map { x -> toResponse(x) }
    }

    @PostMapping
    fun createGame(@RequestBody request: GameRequest) : ResponseEntity<GameResponse>{
        gameService.createGame(request)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    private fun toResponse(entity: GameEntity) : GameResponse {
        return GameResponse(
            id = entity.id.orThrow(),
            name = entity.name.orThrow(),
            genre = entity.genre.orThrow(),
            releaseDate = entity.releaseDate.orThrow(),
            price = entity.price.orThrow()
        )
    }
}