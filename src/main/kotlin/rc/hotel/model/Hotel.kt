package rc.hotel.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "hotel")
class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    lateinit var name: String

    var classification: Int = 0

    var nbRooms: Int = 0

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
    @JsonIgnore
    var clients: List<Client> = emptyList()

//    override fun toString(): String {
//        return "{name: ${this.name}, clients: ${clients.map { it.firstName + it.lastName}}}"
//    }

//    var nbFreeRooms: Int = this.nbRooms

//    fun checkIn(nbGuests: Int) {
//        if (this.nbFreeRooms >= nbGuests) {
//            this.nbFreeRooms -= nbGuests
//        }
//    }
//
//    fun checkOut(nbGuests: Int) {
//        this.nbFreeRooms += nbGuests
//    }
}