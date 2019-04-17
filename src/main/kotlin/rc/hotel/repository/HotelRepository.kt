package rc.hotel.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rc.hotel.model.Hotel

@Repository
interface HotelRepository : JpaRepository<Hotel, Long> {
    fun findByName(name: String): Hotel?
}