package Cards;

import Common.Types;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cards {
    
    private static List<Card> cards = new ArrayList<Card>();
    private static final String url = "jdbc:sqlite:data/cards.db";
    private static final String userName = "root";
    private static final String password = "root";
    
    public static void createDatabase(String name){
        
        String delete = "DROP TABLE IF EXISTS cards;";
        String sql = "CREATE TABLE IF NOT EXISTS cards ("+
                     "id integer PRIMARY KEY," +
                     "name text NOT NULL," + 
                     "strength integer NOT NULL," +
                     "picture text NOT NULL," +
                     "power integer NOT NULL," + 
                     "row integer NOT NULL );";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) { 
                if (conn != null) {
                    stmt.execute(delete);
                    stmt.execute(sql);
                    //System.out.println("The driver name is " + meta.getDriverName());
                    System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void insertCard(String name,int strength,String picture,int power, int row){
        String sql = "INSERT INTO cards(name,strength,picture,power,row) VALUES (?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, name);
                pstmt.setInt(2, strength);
                pstmt.setString(3, "cards/"+picture);
                pstmt.setInt(4, power);
                pstmt.setInt(5, row);
                pstmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Card selectByID(int ID,String table){
        String sql = "SELECT * FROM " + table + " where id = " + ID + ";";

        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int strength = rs.getInt("strength");
                String picture = rs.getString("picture");
                int power = rs.getInt("power");   
                int row = rs.getInt("row");
                //System.out.println(name + ", " + strength + ", " + picture);
                return new Card(id, name, strength, picture, power, row);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    } 
    /*
        this.id = card.id;
       this.name = card.name;
       this.baseStregth = card.strength;
       this.strength = card.strength;
       this.pictureLoc = card.pictureLoc;
       this.power = card.power;
       this.row = card.row;
    */
    
    public static void init(){
        /*createDatabase("cards.db");
        insertCard("Knight", 6, "knight.png", 0, 0);
        insertCard("Commander", 8, "commander.png", 1, 0);
        selectByID(2);*/
    }
    
    public static void addCard(Card card){
        Cards.cards.add(new Card(card));
    }
    
    public static Card getCard(int i){
        return selectByID(i,"cards");
    }
}
