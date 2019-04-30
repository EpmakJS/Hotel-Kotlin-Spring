package rc.hotel.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "hotel")
class Hotel : AbstractEntity(){

    lateinit var name: String

    var classification: Int = 0

    var nbRooms: Int = 0

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hotel")
    @JsonIgnore
    var clients: List<Client> = emptyList()

}