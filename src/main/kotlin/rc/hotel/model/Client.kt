package rc.hotel.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "client")
class Client : AbstractEntity() {

    lateinit var firstName: String

    lateinit var lastName: String

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    var hotel: Hotel? = null

}