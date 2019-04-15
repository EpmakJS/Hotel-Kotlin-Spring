package rc.hotel.controller

import org.springframework.web.bind.annotation.*
import rc.hotel.Hotel
import rc.hotel.dto.HotelDto
import rc.hotel.service.HotelService

@RestController
@RequestMapping("/hotels")
class HotelController(
        private val hotelService: HotelService
) {

    @GetMapping
    fun findAll(): List<HotelDto> = hotelService.findAll()

    @GetMapping("/{name}")
    fun findByName(@PathVariable(value = "name") name: String): HotelDto? {
        return hotelService.findByName(name)
    }

    @PostMapping
    fun createHotel(@RequestBody hotelDto: HotelDto) : HotelDto = hotelService.createHotel(hotelDto)

    @PutMapping("/{name}")
    fun updateHotelByName(@PathVariable(value = "name") name: String, @RequestBody hotelDto: HotelDto) : HotelDto = hotelService.updateHotelByName(name, hotelDto)

    @DeleteMapping("/{name}")
    fun deleteHotelByName(@PathVariable(value = "name") name: String) = hotelService.deleteHotelByName(name)
}