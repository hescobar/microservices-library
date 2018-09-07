package fr.hugoescobar.library.client.book.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "author_name")
	private String authorName;
	
	@Column(name = "genre")
	@Enumerated(EnumType.STRING)
	private Genre genre;

	protected Book() {
	}

	public Book(String name, String authorName, Genre genre) {
		this.name = name;
		this.authorName = authorName;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return String.format("Book [id='%d', name='%s', author_name='%s', genre='%s']", id, name, authorName, genre.toString());
	}
}