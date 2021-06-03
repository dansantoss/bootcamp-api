package com.project.bootcamp.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDTO;

@Component
public class StockMapper {

	public Stock toEntity(StockDTO dto) {
		Stock stock = new Stock();
		stock.setId(dto.getId());
		stock.setName(dto.getName());
		stock.setPrice(dto.getPrice());
		stock.setVariation(dto.getVariation());
		stock.setDate(dto.getDate());

		return stock;
	}
	
	public StockDTO toDto(Stock stock) {
		StockDTO dto = new StockDTO();
		dto.setId(stock.getId());
		dto.setName(stock.getName());
		dto.setPrice(stock.getPrice());
		dto.setVariation(stock.getVariation());
		dto.setDate(stock.getDate());
		return dto;
	}

	public List<StockDTO> toDto(List<Stock> listStock){
		
		/*
		 * stream -> Percorre a lista
		 * map -> Nesse caso, ele chama a função toDto e passando a lista que está percorrendo e já retorna ela convertida
		 * collect -> transforma os itens recebidos no .map em um retorno de lista
		 * */
		return listStock.stream().map(this::toDto).collect(Collectors.toList());
		
	}
	
}
