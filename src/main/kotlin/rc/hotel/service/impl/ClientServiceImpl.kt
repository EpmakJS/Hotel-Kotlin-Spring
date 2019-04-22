package rc.hotel.service.impl

import org.springframework.stereotype.Service
import rc.hotel.dto.ClientDto
import rc.hotel.repository.ClientRepository
import rc.hotel.service.ClientService
import rc.hotel.service.transformer.ClientTransformer

@Service
class ClientServiceImpl(
        private val clientRepository: ClientRepository,
        private val clientTransformer: ClientTransformer
): ClientService {

    override fun findAll(): List<ClientDto> {
        return clientRepository.findAll()
                .map { clientTransformer.transform(it) }
    }

    override fun createClient(newClientDto: ClientDto): ClientDto {
        return clientTransformer.transform(newClientDto)
                .let {  clientRepository.save(it) }
                .let { clientTransformer.transform(it) }
    }

    override fun findClientById(id: Long): ClientDto {
        return clientRepository.findClientById(id)
                .let { clientTransformer.transform(it) }
    }

    override fun deleteClientById(id: Long) {
        return clientRepository.findClientById(id)
                .let { clientRepository.delete(it) }
    }

}