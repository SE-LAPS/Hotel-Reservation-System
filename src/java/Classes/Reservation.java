package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reservation {

    private int resId;
    private int room;
    private String checkInDate;
    private String checkOutDate;
    private String status;
    private int userId;
    private int num_guests;
    private String special_requests;

    public Reservation() {
    }

    public Reservation(int room, String checkInDate, String checkOutDate, String status, int num_guests, String special_requests) {
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
        this.num_guests = num_guests;
        this.special_requests = special_requests;
    }
    public Reservation(int room, String checkInDate, String checkOutDate, String status, int num_guests, String special_requests, int userId) {
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
        this.num_guests = num_guests;
        this.special_requests = special_requests;
        this.userId = userId;
    }

    // Getters and Setters
    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNum_guests() {
        return num_guests;
    }

    public void setNum_guests(int num_guests) {
        this.num_guests = num_guests;
    }

    public String getSpecial_requests() {
        return special_requests;
    }

    public void setSpecial_requests(String special_requests) {
        this.special_requests = special_requests;
    }

    // Retrieve user reservations
    public List<Reservation> getUserReservations(int userId) {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations WHERE userId = ? ORDER BY checkInDate DESC";
        Connection con = DBConnector.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setResId(rs.getInt("resId"));
                reservation.setRoom(rs.getInt("room"));
                reservation.setCheckInDate(rs.getString("checkInDate"));
                reservation.setCheckOutDate(rs.getString("checkOutDate"));
                reservation.setStatus(rs.getString("status"));
                reservation.setUserId(rs.getInt("userId"));
                reservation.setNum_guests(rs.getInt("num_guests"));
                reservation.setSpecial_requests(rs.getString("special_requests"));
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservations;
    }

    // Save reservation
    public boolean saveReservation() {
        Connection con = DBConnector.getConnection();
        String query = "INSERT INTO reservations (room, checkInDate, checkOutDate, status, userId, special_requests, num_guests) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, this.room);
            pstmt.setString(2, this.checkInDate);
            pstmt.setString(3, this.checkOutDate);
            pstmt.setString(4, this.status);
            pstmt.setInt(5, this.userId);
            pstmt.setString(6, this.special_requests);
            pstmt.setInt(7, this.num_guests);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update reservation
    public boolean updateReservation(Connection con) {
        String query = "UPDATE reservations SET room = ?, checkInDate = ?, checkOutDate = ?, status = ?, special_requests = ?, num_guests = ? WHERE resId = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, this.room);
            pstmt.setString(2, this.checkInDate);
            pstmt.setString(3, this.checkOutDate);
            pstmt.setString(4, this.status);
            pstmt.setString(5, this.special_requests);
            pstmt.setInt(6, this.num_guests);
            pstmt.setInt(7, this.resId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete reservation
    public boolean deleteReservation(Connection con) {
        String query = "DELETE FROM reservations WHERE resId = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, this.resId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve a single reservation
    public void getAReservation(Connection con) {
        String query = "SELECT * FROM reservations WHERE resId = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, this.resId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                this.room = rs.getInt("room");
                this.checkInDate = rs.getString("checkInDate");
                this.checkOutDate = rs.getString("checkOutDate");
                this.status = rs.getString("status");
                this.userId = rs.getInt("userId");
                this.num_guests = rs.getInt("num_guests");
                this.special_requests = rs.getString("special_requests");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
