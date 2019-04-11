package rc.hotel

import javax.persistence.*

@Entity
@Table(name = "HOTELS")
class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    lateinit var name: String

    var classification: Int = 0

    var nbRooms: Int = 0

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