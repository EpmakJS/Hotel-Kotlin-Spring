package rc.hotel.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rc.hotel.dto.HotelDto
import rc.hotel.service.HotelService

@RestController
@RequestMapping("/hotels")
class HotelController(
        private val hotelService: HotelService
) {

    @GetMapping
    fun findAll(): List<HotelDto> = hotelService.findAll()

//    @GetMapping("/{name}")
//    fun byName(@PathVariable(value = "name") name: String): List<Hotel> {
//        return hotelRepository.findByName(name)
//    }

//    @PostMapping
//    fun create() = hotelRepository.save(Hotel("test", 5, 5))

//    @PostMapping("/checkin")
//    fun checkIn(@RequestBody checkInRequest: CheckInRequest) {
//        val hotel = this.hotelRepository.findByName(checkInRequest.hotelName)[0]
////        hotel.checkIn(checkInRequest.nbGuests)
//        this.hotelRepository.save(hotel)
//    }
}