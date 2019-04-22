package rc.hotel.repository

import rc.hotel.model.Client
import rc.hotel.model.Hotel
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.JoinType

class HotelRepositoryImpl : HotelRepositoryCustom {
    @PersistenceContext
    lateinit var em: EntityManager

    override fun findHotelsByClientsLessThan(n: Int): List<Hotel> {
        val cb = em.criteriaBuilder
        val cq = cb.createQuery(Hotel::class.java)

        val rootHotel = cq.from(Hotel::class.java)
        val rootClient = cq.from(Client::class.java)

        cq.select(rootHotel)
        cq.where(cb.equal(rootHotel.get<Long>("id"), rootClient.get<Long>("hotel")))
        cq.groupBy(rootHotel.get<Long>("id"))
        cq.having(cb.le(cb.size(rootHotel.get<Collection<Client>>("clients")), n))

        val query = em.createQuery(cq)
        return query.resultList
    }
}