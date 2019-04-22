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

}