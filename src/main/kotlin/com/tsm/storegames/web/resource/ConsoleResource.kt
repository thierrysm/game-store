package com.tsm.storegames.web.resource

import com.tsm.storegames.entity.ConsoleEntity
import com.tsm.storegames.service.ConsoleService
import com.tsm.storegames.util.orThrow
import com.tsm.storegames.web.request.ConsoleRequest
import com.tsm.storegames.web.response.ConsoleResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/console")
class ConsoleResource(
    private val consoleService: ConsoleService
) {

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ConsoleResponse {
        val console = consoleService.getById(id)
        return toResponse(console)
    }

    @GetMapping
    fun getAll() : List<ConsoleResponse> {
        val consoles = consoleService.getAll()
        return consoles.map { x -> toResponse(x) }
    }

    @PostMapping
    fun createConsole(@RequestBody request: ConsoleRequest) : ResponseEntity<ConsoleResponse> {
        consoleService.createConsole(request)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    private fun toResponse(entity: ConsoleEntity) : ConsoleResponse {
        return ConsoleResponse(
            id = entity.id.orThrow(),
            name = entity.name.orThrow(),
            releaseDate = entity.releaseDate.orThrow(),
            price = entity.price.orThrow()
        )
    }
}