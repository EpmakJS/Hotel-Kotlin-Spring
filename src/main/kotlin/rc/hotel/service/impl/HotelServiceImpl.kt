package rc.hotel.service.impl

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import rc.hotel.Hotel
import rc.hotel.HotelRepository
import rc.hotel.dto.HotelDto
import rc.hotel.service.HotelService
import rc.hotel.service.transformer.HotelTransformer

@Service
class HotelServiceImpl(
        private val hotelRepository: HotelRepository,
        private val hotelTransformer: HotelTransformer
) : HotelService {

    override fun findAll(): List<HotelDto> = hotelRepository.findAll().map { hotelTransformer.transform(it) }

    override fun findByName(name: String): HotelDto {
        return hotelRepository.findByName(name).let { hotelTransformer.transform(it) }
    }

    override fun createHotel(newHotelDto: HotelDto): HotelDto {
        return hotelTransformer.transform(newHotelDto)
                .let {  hotelRepository.save(it) }
                .let { hotelTransformer.transform(it) }
    }

    override fun updateHotelByName(name : String, updatedHotelDto: HotelDto): HotelDto {
        return hotelRepository.findByName(name).let { existingHotel ->
            existingHotel.name = updatedHotelDto.name
            existingHotel.classification = updatedHotelDto.classification
            existingHotel.nbRooms = updatedHotelDto.nbRooms
            hotelRepository.save(existingHotel)
        }
                .let { hotelTransformer.transform(it) }
    }

    override fun deleteHotelByName(name: String) {
        return hotelRepository.findByName(name).let { hotelRepository.delete(it) }
    }

}