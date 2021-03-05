package com.jpa.LabEx2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class AuthorBookMain {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CAP-DB");
		EntityManager entityManager = factory.createEntityManager();
		
//		Author author1=new Author();
//		author1.setId(1);
//		author1.setName("Shreya");
		
		Book book1=new Book();
		book1.setIsbn(101);
		book1.setPrice(500);
		book1.setTitle("Geography");
		
		Book book2=new Book();
		book2.setIsbn(203);
		book2.setPrice(1000);
		book2.setTitle("Maths");
		
		Author author1=new Author();
		author1.setId(1);
		author1.setName("Shreya");
		
		author1.addBook(book1);
		author1.addBook(book2);
		
		EntityTransaction txn = entityManager.getTransaction();
		txn.begin();
		
		entityManager.persist(author1);
		
		System.out.println("Added author along with book details to database.");

		txn.commit();
		entityManager.close();		
		factory.close();
		
		
		
		
		
		
	}

}
