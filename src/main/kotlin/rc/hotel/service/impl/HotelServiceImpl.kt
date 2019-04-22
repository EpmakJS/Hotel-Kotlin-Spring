package rc.hotel.service.impl

import org.springframework.stereotype.Service
import rc.hotel.dto.ClientDto
import rc.hotel.dto.HotelDto
import rc.hotel.model.Client
import rc.hotel.repository.ClientRepository
import rc.hotel.repository.HotelRepository
import rc.hotel.service.HotelService
import rc.hotel.service.transformer.HotelTransformer
import javax.persistence.EntityNotFoundException

@Service
class HotelServiceImpl(
        private val hotelRepository: HotelRepository,
        private val hotelTransformer: HotelTransformer,
        private val clientRepository: ClientRepository
) : HotelService {

//    override fun findAllByClientsLessThan(n: Int): List<HotelDto> =
//            hotelRepository.findAllByClientsLessThan(n).map { hotelTransformer.transform(it) }

    override fun findHotelsByClientsLessThan(n: Int): List<HotelDto> {
        return hotelRepository.findHotelsByClientsLessThan(n).map { hotelTransformer.transform(it) }
    }

    override fun findAll(): List<HotelDto> =
            hotelRepository.findAll().map { hotelTransformer.transform(it) }

    override fun findByName(name: String): HotelDto {
        return findOne(name)
                .let { hotelTransformer.transform(it) }
    }

    override fun createHotel(newHotelDto: HotelDto) {
        return hotelTransformer.transform(newHotelDto)
                .let {  hotelRepository.save(it) }
    }

    override fun updateHotelByName(name : String, updatedHotelDto: HotelDto): HotelDto {
        return findOne(name)
                .let { existingHotel ->
                    existingHotel.name = updatedHotelDto.name
                    existingHotel.classification = updatedHotelDto.classification
                    existingHotel.nbRooms = updatedHotelDto.nbRooms
                    existingHotel.clients = updatedHotelDto.clients
                    hotelRepository.save(existingHotel)
                }
                .let { hotelTransformer.transform(it) }
    }

    override fun deleteHotelByName(name: String) =
            findOne(name).let { hotelRepository.delete(it) }

    override fun checkIn(hotelName: String, clientDto: ClientDto) {
        val client = clientDto.id?.let { clientRepository.findById(it).orElseThrow() } ?: Client().apply {
            firstName = clientDto.firstName
            lastName = clientDto.lastName
        }
        client.hotel = findOne(hotelName)
        clientRepository.save(client)
    }

    override fun checkOut(hotelName: String, clientDto: ClientDto) {
        val client = clientDto.id?.let { clientRepository.findById(it).orElseThrow() } ?: throw EntityNotFoundException()
        client.hotel = null
        clientRepository.save(client)
    }

    private fun findOne(hotelName: String) =
            hotelRepository.findByName(hotelName) ?: throw EntityNotFoundException()

}