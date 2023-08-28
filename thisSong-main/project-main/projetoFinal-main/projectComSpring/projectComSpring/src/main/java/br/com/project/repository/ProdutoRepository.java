package br.com.project.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.project.model.Produto;


	@Repository
	public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {
		
		
	}
	
