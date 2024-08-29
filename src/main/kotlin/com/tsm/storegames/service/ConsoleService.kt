package com.tsm.storegames.service

import com.tsm.storegames.entity.ConsoleEntity
import com.tsm.storegames.repository.ConsoleRepository
import com.tsm.storegames.web.request.ConsoleRequest
import org.springframework.stereotype.Service

@Service
class ConsoleService (
    private val consoleRepository: ConsoleRepository
) {
    fun getById(id: Long) : ConsoleEntity {
        return consoleRepository.findById(id).orElseThrow {RuntimeException("Console with id:$id not found")}
    }

    fun getAll() : List<ConsoleEntity> {
        return consoleRepository.findAll()
    }

    fun createConsole(request: ConsoleRequest) : ConsoleEntity {
        val console =
            ConsoleEntity(
                name = request.name,
                releaseDate = request.releaseDate,
                price = request.price
            )
        return consoleRepository.save(console)
    }
}