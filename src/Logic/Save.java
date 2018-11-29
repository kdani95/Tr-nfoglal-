package Logic;

import Statistics.Stat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Save {
    private static List<Stat> stats = new ArrayList<Stat>();
    private static final String url = "jdbc:sqlite:data/saves.db";
    private static final String userName = "root";
    private static final String password = "root";
    private static String name;
    
    public static void createDatabase(){
        
        String delete = "DROP TABLE IF EXISTS saves;";
        String sql = "CREATE TABLE IF NOT EXISTS saves ("+
                     "name text PRIMARY KEY," +
                     "map integer NOT NULL);";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) { 
                if (conn != null) {
                    stmt.execute(delete);
                    stmt.execute(sql);

                    System.out.println("A new saves database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void init(){
        createDatabase();
    }
    
    public static void reset(String name){
        String sql = "UPDATE saves "
               + "SET "
               + " map =" + 0
               + " WHERE name =\"" + name + "\";";
        
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.executeUpdate();
        }catch (SQLException ex) {
            System.err.println("Error at updating save" + ex.toString());
        }
    }
    
    public static void refreshSave(String name, int map){
        String sql = "UPDATE saves "
               + "SET "
               + " map =" + map
               + " WHERE name =\"" + name + "\";";
        
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.executeUpdate();
        }catch (SQLException ex) {
            System.err.println("Error at updating save" + ex.toString());
        }
    }
    
    public static void addNewSave(String name){
        String sql = "INSERT INTO saves(name,map) VALUES (?,?)";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, name);
                pstmt.setInt(2, 0);
                pstmt.executeUpdate();
        }catch (SQLException ex) {
            System.err.println("Error at inserting new save" + ex.toString());
        }
    }
    
    public static int getSave(String name){
        String sql = "SELECT * FROM saves WHERE name=\"" + name + "\";";
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            
            if(rs.next()){        
                int map = rs.getInt("map");
                return map;
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        addNewSave(name);
        return getSave(name);
    }
}
