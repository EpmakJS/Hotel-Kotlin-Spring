package rc.hotel.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rc.hotel.model.Client
import java.util.*

@Repository
interface ClientRepository: JpaRepository<Client, Long> {
//    fun findClientByFirstNameAndLastName(firstName: String, lastName: String): Client
    fun findClientById(id: Long): Client
}