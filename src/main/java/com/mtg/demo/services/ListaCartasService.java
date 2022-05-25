package com.mtg.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.mtg.demo.dto.CartasUpdateDto;
import com.mtg.demo.dto.ListaDto;
import com.mtg.demo.dto.NewListaCartas;
import com.mtg.demo.entities.Cartas;
import com.mtg.demo.entities.ListaCartas;
import com.mtg.demo.entities.Usuario;
import com.mtg.demo.repositories.CartasRepository;
import com.mtg.demo.repositories.ListaCartasRepository;
import com.mtg.demo.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaCartasService {

    @Autowired
    private ListaCartasRepository repository;

    @Autowired
    private CartasService cartasService;

    @Autowired
    private CartasRepository cartasRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ListaDto save(NewListaCartas newListaCartas) throws Exception {
        if (!repository.existsByListName(newListaCartas.getListName())) {
           if(usuarioRepository.existsById(newListaCartas.getUserId())) {
               Usuario usuario = usuarioRepository.findById(newListaCartas.getUserId()).get();
               ListaCartas listaCartas = new ListaCartas();
               listaCartas.setListName(newListaCartas.getListName());
               listaCartas.setUsuarioDono(usuario);    
            }else throw new Exception("Usuario não encontrado!");
        } else throw new Exception("Este nome de carta já existe!");
        return null;
    }
    public List<ListaDto> getAll() {
        List<ListaDto> listas = new ArrayList<>();
        List<ListaCartas> listaCartas = repository.findAll();
        for(ListaCartas l : listaCartas) {
            listas.add(ListaDto.ToDto(l));

        }
        return listas;

    }
    public ListaDto findById(int id) throws Exception {
        if(repository.existsById(id)) {
            return ListaDto.ToDto(repository.findById(id).get());
        } else throw new Exception("Carta não encontrada!");
    }
    public ListaDto findByListName(String listName) throws Exception {
        if(repository.existsByListName(listName)) {
            return ListaDto.ToDto(repository.findByListName(listName));
        } else throw new Exception("Carta não encontrada!");
    }

	
	public ListaDto addCartas(int listId, int usuarioId, Cartas cartas) throws Exception{
		
		if(repository.existsById(listId)) {
			
			ListaCartas cartasList = repository.getById(listId);
			
			if(cartasList.getUsuarioDono().getId() == usuarioId) {
				

				cartasService.save(cartas); 
				cartasList.getCartas().add(cartas);
				repository.save(cartasList);
				
				
				return ListaDto.ToDto(cartasList);
				
			}else throw new Exception("Essa lista não pertence a este userId!");
			
		}else throw new Exception("Lista não encontrada, tente novamente!");
		
	}
	
	public boolean removeCartas(int listId, int usuarioId, int cartasId) throws Exception{
		
		if(repository.existsById(listId)) {
			
			ListaCartas listaCartas = repository.getById(listId);
			
			if(listaCartas.getUsuarioDono().getId() == usuarioId) {
				
				if(cartasRepository.existsById(cartasId)) {
					
					if(cartasRepository.findById(cartasId).get().getListaCartas().contains(listaCartas)) {
						
						listaCartas.getCartas().remove(cartasRepository.findById(cartasId).get());
						repository.save(listaCartas);
						cartasRepository.deleteById(cartasId);
						return true;
						
					}else throw new Exception("this cartas does not belong to this list!");
					
				}else throw new Exception("Cartas not found!");
				
			} else throw new Exception("This list does not belong to this usuarioId!");
			
		}else throw new Exception("List not found!");
	}
	
	public boolean updateCartas(CartasUpdateDto cartasUpdateDto) throws Exception{
		
		if(repository.existsById(cartasUpdateDto.getListId())) {
			
			ListaCartas listaCartas = repository.getById(cartasUpdateDto.getListId());
			
			if(listaCartas.getUsuarioDono().getId() == cartasUpdateDto.getUserId()) {
				
				if(cartasRepository.existsById(cartasUpdateDto.getCardId())) {
					
					if(cartasRepository.findById(cartasUpdateDto.getCardId()).get().getListaCartas().contains(listaCartas)) {
						
						Cartas cartas = cartasRepository.findById(cartasUpdateDto.getCardId()).get();
						
						if(cartasUpdateDto.getNewPrice() != 0) {
							cartas.setPrice(cartasUpdateDto.getNewPrice());
						}
						if(cartasUpdateDto.getNewQuantity() != 0 ) {
							cartas.setQuantity(cartasUpdateDto.getNewQuantity());
						}
						
						cartasRepository.save(cartas);
						return true;
						
					}else throw new Exception("this cartas does not belong to this list!");
					
				}else throw new Exception("Cartas not found!");
				
			} else throw new Exception("This list does not belong to this usuarioId!");
			
		}else throw new Exception("List not found!");
		
	}
}
