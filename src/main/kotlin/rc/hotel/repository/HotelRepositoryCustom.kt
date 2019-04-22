package rc.hotel.repository

import rc.hotel.model.Hotel

interface HotelRepositoryCustom {
    fun findHotelsByClientsLessThan(n: Int): List<Hotel>
}