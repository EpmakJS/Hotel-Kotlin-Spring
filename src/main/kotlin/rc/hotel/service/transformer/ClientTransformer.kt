package rc.hotel.service.transformer

import org.springframework.stereotype.Component
import rc.hotel.dto.ClientDto
import rc.hotel.model.Client

@Component
class ClientTransformer {

    fun transform(dto: ClientDto): Client =
            Client().apply {
                firstName = dto.firstName
                lastName = dto.lastName
            }

    fun transform(entity: Client): ClientDto =
            ClientDto(
                    id = entity.id,
                    firstName = entity.firstName,
                    lastName = entity.lastName
            )
}