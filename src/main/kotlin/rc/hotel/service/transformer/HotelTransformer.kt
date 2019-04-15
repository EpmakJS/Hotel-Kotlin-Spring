package rc.hotel.service.transformer

import org.springframework.stereotype.Component
import rc.hotel.Hotel
import rc.hotel.dto.HotelDto

@Component
class HotelTransformer {

    fun transform(dto: HotelDto): Hotel =
            Hotel().apply {
                name = dto.name
                classification = dto.classification
                nbRooms = dto.nbRooms
            }

    fun transform(entity: Hotel): HotelDto =
            HotelDto(
                    name = entity.name,
                    classification = entity.classification,
                    nbRooms = entity.nbRooms
            )
}