package br.com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Produto {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String music1;
	private String music2;
	private String music3;
	private String music4;
	private String nomeMusic;
	private String urlMusic;
	
	public String getNomeMusic() {
		return nomeMusic;
	}
	public void setNomeMusic(String nomeMusic) {
		this.nomeMusic = nomeMusic;
	}
	public String getUrlMusic() {
		return urlMusic;
	}
	public void setUrlMusic(String urlMusic) {
		this.urlMusic = urlMusic;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMusic1() {
		return music1;
	}
	public void setMusic1(String music1) {
		this.music1 = music1;
	}
	public String getMusic2() {
		return music2;
	}
	public void setMusic2(String music2) {
		this.music2 = music2;
	}
	public String getMusic3() {
		return music3;
	}
	public void setMusic3(String music3) {
		this.music3 = music3;
	}
	public String getMusic4() {
		return music4;
	}
	public void setMusic4(String music4) {
		this.music4 = music4;
	}
	
}
