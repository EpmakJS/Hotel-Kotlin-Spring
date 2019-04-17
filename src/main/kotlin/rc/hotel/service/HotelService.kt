package rc.hotel.service

import rc.hotel.dto.ClientDto
import rc.hotel.dto.HotelDto
import javax.persistence.Id

interface HotelService {

    fun findAll(): List<HotelDto>

    fun findByName(name: String): HotelDto?

    fun createHotel(newHotelDto: HotelDto)

    fun updateHotelByName(name: String, updatedHotelDto: HotelDto) : HotelDto

    fun deleteHotelByName(name: String)

    fun checkIn(hotelName: String, clientDto: ClientDto)

    fun checkOut(hotelName: String, clientDto: ClientDto)
}