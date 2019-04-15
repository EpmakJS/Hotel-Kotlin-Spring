package rc.hotel.service

import rc.hotel.Hotel
import rc.hotel.dto.HotelDto

interface HotelService {

    fun findAll(): List<HotelDto>

    fun findByName(name: String): HotelDto?

    fun createHotel(newHotelDto: HotelDto): HotelDto

    fun updateHotelByName(name: String, updatedHotelDto: HotelDto) : HotelDto

    fun deleteHotelByName(name: String)
}