package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrator {
    private int adminID;
    private String userName;
    private String password;
    private String email;

    public Administrator(int adminID, String userName, String password, String email) {
        this.adminID = adminID;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    // Getters and setters
    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Administrator login(String email, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Administrator admin = null;

        try {
            conn = DBConnector.getConnection();
            String sql = "SELECT * FROM administrators WHERE email = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                admin = new Administrator(
                    rs.getInt("adminID"),
                    rs.getString("userName"),
                    rs.getString("password"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return admin;
    }

    // Method to create a new administrator
    public boolean create() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = DBConnector.getConnection();
            String sql = "INSERT INTO administrators (userName, password, email) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, this.userName);
            pstmt.setString(2, this.password);
            pstmt.setString(3, this.email);

            int rowsAffected = pstmt.executeUpdate();
            success = (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    // Method to update an existing administrator
    public boolean update() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = DBConnector.getConnection();
            String sql = "UPDATE administrators SET userName = ?, password = ?, email = ? WHERE adminID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, this.userName);
            pstmt.setString(2, this.password);
            pstmt.setString(3, this.email);
            pstmt.setInt(4, this.adminID);

            int rowsAffected = pstmt.executeUpdate();
            success = (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    // Method to delete an administrator
    public boolean delete() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success = false;

        try {
            conn = DBConnector.getConnection();
            String sql = "DELETE FROM administrators WHERE adminID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, this.adminID);

            int rowsAffected = pstmt.executeUpdate();
            success = (rowsAffected > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }

    // Static method to get an administrator by ID
    public static Administrator getAdminById(int adminID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Administrator admin = null;

        try {
            conn = DBConnector.getConnection();
            String sql = "SELECT * FROM administrators WHERE adminID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, adminID);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                admin = new Administrator(
                    rs.getInt("adminID"),
                    rs.getString("userName"),
                    rs.getString("password"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return admin;
    }
}