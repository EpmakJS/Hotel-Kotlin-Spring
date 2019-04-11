package rc.hotel.service

import rc.hotel.dto.HotelDto

interface HotelService {

    fun findAll(): List<HotelDto>
}