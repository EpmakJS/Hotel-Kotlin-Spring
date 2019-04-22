package rc.hotel.service

import rc.hotel.dto.ClientDto
import rc.hotel.dto.HotelDto

interface HotelService {

//    fun findAllByClientsLessThan(n: Int): List<HotelDto>

    fun findHotelsByClientsLessThan(n: Int): List<HotelDto>

    fun findAll(): List<HotelDto>

    fun findByName(name: String): HotelDto?

    fun createHotel(newHotelDto: HotelDto)

    fun updateHotelByName(name: String, updatedHotelDto: HotelDto) : HotelDto

    fun deleteHotelByName(name: String)

    fun checkIn(hotelName: String, clientDto: ClientDto)

    fun checkOut(hotelName: String, clientDto: ClientDto)
}