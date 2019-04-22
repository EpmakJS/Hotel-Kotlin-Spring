package rc.hotel.controller

import org.springframework.web.bind.annotation.*
import rc.hotel.dto.ClientDto
import rc.hotel.dto.HotelDto
import rc.hotel.service.HotelService

@RestController
@RequestMapping("/hotels")
class HotelController(
        private val hotelService: HotelService
) {

//    @GetMapping
//    fun findAllHotels(): List<HotelDto> = hotelService.findAllByClientsLessThan(2)

    @GetMapping
    fun findAllHotels(): List<HotelDto> = hotelService.findHotelsByClientsLessThan(1)

//    @GetMapping
//    fun findAllHotels(): List<HotelDto> = hotelService.findAll()

    @GetMapping("/{name}")
    fun findHotelByName(@PathVariable(value = "name") name: String): HotelDto? {
        return hotelService.findByName(name)
    }

    @PostMapping
    fun createHotel(@RequestBody hotelDto: HotelDto) = hotelService.createHotel(hotelDto)

    @PostMapping("/{name}/checkin")
    fun checkIn(@PathVariable(value = "name") name: String, @RequestBody clientDto: ClientDto) =
            hotelService.checkIn(name, clientDto)

    @PostMapping("/{name}/checkout")
    fun checkOut(@PathVariable(value = "name") name: String, @RequestBody clientDto: ClientDto) =
            hotelService.checkOut(name, clientDto)

    @PutMapping("/{name}")
    fun updateHotelByName(@PathVariable(value = "name") name: String, @RequestBody hotelDto: HotelDto) : HotelDto {
        return hotelService.updateHotelByName(name, hotelDto)
    }

    @DeleteMapping("/{name}")
    fun deleteHotelByName(@PathVariable(value = "name") name: String) = hotelService.deleteHotelByName(name)
}