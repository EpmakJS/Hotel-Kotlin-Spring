package rc.hotel.controller

import org.springframework.web.bind.annotation.*
import rc.hotel.dto.ClientDto
import rc.hotel.service.ClientService

@RestController
@RequestMapping("/clients")
class ClientController(
        private val clientService: ClientService
) {

    @GetMapping
    fun findAllClients(): List<ClientDto> = clientService.findAll()

    @PostMapping
    fun createClient(@RequestBody clientDto: ClientDto): ClientDto = clientService.createClient(clientDto)

    @GetMapping("/{id}")
    fun findClientById(@PathVariable(value = "id") id: Long): ClientDto? {
        return clientService.findClientById(id)
    }

    @DeleteMapping("/{id}")
    fun deleteClientById(@PathVariable(value = "id") id: Long) = clientService.deleteClientById(id)
}