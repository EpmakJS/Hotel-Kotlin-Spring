package rc.hotel.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import rc.hotel.model.Hotel


@Repository
interface HotelRepository : JpaRepository<Hotel, Long>, HotelRepositoryCustom {
    fun findByName(name: String): Hotel?

    @Query("SELECT hotel FROM Hotel hotel WHERE hotel.clients.size < :#{#count} ")
    fun findAllByClientsLessThan(@Param("count") count: Int): List<Hotel>
}