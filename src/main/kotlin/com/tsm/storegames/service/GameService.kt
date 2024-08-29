package com.tsm.storegames.service

import com.tsm.storegames.entity.GameEntity
import com.tsm.storegames.repository.GameRepository
import com.tsm.storegames.web.request.GameRequest
import org.springframework.stereotype.Service

@Service
class GameService(
    private val gameRepository: GameRepository
) {
    fun getById(id: Long) : GameEntity {
        return gameRepository.findById(id).orElseThrow {RuntimeException("Game with id:$id not found")}
    }

    fun getAll() : List<GameEntity> {
        return gameRepository.findAll()
    }

    fun createGame(request: GameRequest) : GameEntity {
        val game =
            GameEntity(
                name = request.name,
                genre = request.genre,
                releaseDate = request.releaseDate,
                price = request.price,
            )
        return gameRepository.save(game)
    }
}