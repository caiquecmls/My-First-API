package com.caique.myapi.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.caique.myapi.domain.Usuario;
import com.caique.myapi.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired

	private UsuarioService usuarioService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		Usuario obj = this.usuarioService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = usuarioService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario obj) {
		Usuario newObj = usuarioService.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}

	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario obj) {
		Usuario newObj = usuarioService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
