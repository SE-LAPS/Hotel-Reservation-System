
package Classes;

import java.util.List;
import java.util.ArrayList;

public class Room {
    private int roomID;
    private String roomNumber;
    private String roomType;
    private String status;
    private double pricePerNight;

    // Constructor
    public Room(int roomID, String roomNumber, String roomType, String status, double pricePerNight) {
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;
        this.pricePerNight = pricePerNight;
    }

    // Getters and Setters
    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
    
    // CRUD Operations

    // Create
    public void createRoom(Room room) {
        // Code to insert a room into the database
        String sql = "INSERT INTO Room (roomID, roomNumber, roomType, status, pricePerNight) VALUES (?, ?, ?, ?, ?)";
        // Use PreparedStatement to set values and execute the query
    }

    // Read (Get Room by ID)
    public Room getRoomById(int roomID) {
        // Code to get a room from the database
        String sql = "SELECT * FROM Room WHERE roomID = ?";
        // Execute query, fetch results, and return a Room object
        return new Room(roomID, "exampleRoomNumber", "exampleRoomType", "Available", 150.00);
    }

    // Update
    public void updateRoom(Room room) {
        // Code to update a room in the database
        String sql = "UPDATE Room SET roomNumber = ?, roomType = ?, status = ?, pricePerNight = ? WHERE roomID = ?";
        // Use PreparedStatement to set values and execute the query
    }

    // Delete
    public void deleteRoom(int roomID) {
        // Code to delete a room from the database
        String sql = "DELETE FROM Room WHERE roomID = ?";
        // Use PreparedStatement to execute the query
    }

    // Get All Rooms
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        // Code to retrieve all rooms from the database
        String sql = "SELECT * FROM Room";
        // Execute query, loop through results, and add to the list
        rooms.add(new Room(1, "101", "Single", "Available", 100.00));
        rooms.add(new Room(2, "102", "Double", "Booked", 200.00));
        return rooms;
    }
}
