package rc.hotel.dto

import rc.hotel.model.Client

data class HotelDto(
        var id: Long,
        var name: String,
        var classification: Int,
        var nbRooms: Int,
        var clients: List<Client>
)