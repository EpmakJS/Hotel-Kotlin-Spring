package rc.hotel.service.transformer

import org.springframework.stereotype.Component
import rc.hotel.dto.HotelDto
import rc.hotel.model.Hotel

@Component
class HotelTransformer {

    fun transform(dto: HotelDto): Hotel =
            Hotel().apply {
                id = dto.id
                name = dto.name
                classification = dto.classification
                nbRooms = dto.nbRooms
                clients = dto.clients
            }

    fun transform(entity: Hotel): HotelDto =
            HotelDto(
                    id = entity.id,
                    name = entity.name,
                    classification = entity.classification,
                    nbRooms = entity.nbRooms,
                    clients = entity.clients
            )
}