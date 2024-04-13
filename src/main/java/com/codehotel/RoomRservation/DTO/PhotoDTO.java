package com.codehotel.RoomRservation.DTO;

public class PhotoDTO {
    private int id;
    private String url;
    private String description;
	private RoomDTO room;

    public PhotoDTO() {}

    public PhotoDTO(int id, String url, RoomDTO room) {
        this.id = id;
        this.url = url;
        this.room = room;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RoomDTO getRoom() {
        return room;
    }

    public void setRoom(RoomDTO room) {
        this.room = room;
    }
}
