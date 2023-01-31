package com.example.demo.object;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/object")
@CrossOrigin(origins = { "http://localhost:3000", "http://127.0.0.1:3000" })

public class ObjectController {

	@Autowired
	ObjectService objectService;

	@GetMapping("/{id}")
	public ObjectDto findById(@PathVariable(name = "id") Long id) {

		return objectService.findById(id);
	}

	@PostMapping("/post")
	public ObjectDto createObject(@Valid @RequestBody ObjectDto objectDto) {

		return objectService.createObject(objectDto);
	}

	@PutMapping("/{id}")
	public ObjectDto updateObject(@Valid @RequestBody ObjectDto objectDto, @PathVariable(name = "id") Long id) {

		return objectService.updateObject(objectDto, id);

	}

	@DeleteMapping("/{id}")
	public void deleteObject(@PathVariable(name = "id") Long id) {

		objectService.deleteObject(id);
	}

	@GetMapping("")
	public List<ObjectDto> findAllObjects() {

		return objectService.findAllObjects();
	}

}
