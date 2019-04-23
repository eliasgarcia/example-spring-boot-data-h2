package com.example.abmBasico.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.abmBasico.domain.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	Book findByName(String name);// nuevoBranch modif 2, mergeado
	//me agregaron en el branch develop
	//me agregaron en master
	//un push a develop
	//sigo en master
	//hice el merge desde develop haciendo pull en origin master
	//otro mensaje desde develop
	//otro otro desde develop
}
