package rc.hotel.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rc.hotel.model.Client

@Repository
interface ClientRepository: JpaRepository<Client, Long> {
    fun findClientById(id: Long): Client
}