package com.example.abmBasico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.abmBasico.domain.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	Book findByName(String name);// nuevoBranch modif 2, mergeado
	//sigo en master
	//otro cambio en master
	//otro otro desde master
	//cambio en github mismo
	//merge de los dos comentario anteriores!
	//mensaje desde master
	//otro mensaje desde master
}
