package com.codehotel.RoomRservation.model;



import javax.persistence.*;

@Entity
public class Photo {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String url;
	private String description;
	
	
	@ManyToOne
	@JoinColumn(name = "room_id")
    private Room room;  


	
	

	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Photo(int id, String url, Room room) {
		super();
		this.id = id;
		this.url = url;
		this.room = room;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
