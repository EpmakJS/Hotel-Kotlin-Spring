package rc.hotel.service

import rc.hotel.dto.ClientDto

interface ClientService {

    fun findAll(): List<ClientDto>

    fun createClient(newClientDto: ClientDto): ClientDto

    fun findClientById(id: Long): ClientDto?

    fun deleteClientById(id: Long)
}