package com.clarit.hs.controller;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.clarit.hs.service.items.Room;
/**
 * Created by mnachiappan on 1/4/23.
 */
@RestController
@RequestMapping(value = "/rooms")
public interface IAdminService {

	@GetMapping(produces = { "application/hal+json" })
	public CollectionModel<Room> getAll(boolean occupied) ;

	@PostMapping(produces = { "application/hal+json" })
	@ResponseStatus(code = HttpStatus.CREATED)
	public Room book(@RequestBody Room room);

	@GetMapping(value = "/{number}")
	public CollectionModel<Room>  get(@PathVariable int number);

	@DeleteMapping(value = "/{number}")
	public void cancelBooking(@PathVariable int number);

}
