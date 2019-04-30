package rc.hotel.model

import javax.persistence.GenerationType
import javax.persistence.GeneratedValue
import java.io.Serializable
import javax.persistence.Id
import javax.persistence.MappedSuperclass


@MappedSuperclass
abstract class AbstractEntity : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

}