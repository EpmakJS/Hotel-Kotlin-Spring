package rc.hotel.service.impl

import org.springframework.stereotype.Service
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
}