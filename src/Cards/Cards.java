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
                     "cardID integer PRIMARY KEY," +
                     "name text NOT NULL," + 
                     "strength integer NOT NULL," +
                     "picture text NOT NULL," +
                     "power integer NOT NULL," + 
                     "row integer NOT NULL,"+
                     "ability text);";
        
        String deleteDeck = "DROP TABLE IF EXISTS deck;";
        String sqlDeck = "CREATE TABLE IF NOT EXISTS deck ("+
                         "id integer PRIMARY KEY," +
                         "cardID integer NOT NULL);";
        
        String deleteCards = "DROP TABLE IF EXISTS mycards;";
        String sqlCards = "CREATE TABLE IF NOT EXISTS mycards ("+
                          "id integer PRIMARY KEY," +
                          "cardID integer NOT NULL);";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) { 
                if (conn != null) {
                    stmt.execute(delete);
                    stmt.execute(sql);
                    
                    stmt.execute(deleteDeck);
                    stmt.execute(sqlDeck);
                    
                    stmt.execute(deleteCards);
                    stmt.execute(sqlCards);
                    //System.out.println("The driver name is " + meta.getDriverName());
                    System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static void insertNewCard(String name,int strength,String picture,int power, int row,String ability){
        String sql = "INSERT INTO cards(name,strength,picture,power,row,ability) VALUES (?,?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, name);
                pstmt.setInt(2, strength);
                pstmt.setString(3, "cards/"+picture);
                pstmt.setInt(4, power);
                pstmt.setInt(5, row);
                pstmt.setString(6, ability);
                pstmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void insertNewCard(String name,int strength,String picture,int power, int row){
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
    
    private static void insertIntoMyCards(int cardID){
        String sql = "INSERT INTO mycards(cardID) VALUES (?)";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, cardID);
                pstmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void insertIntoDeck(int cardID){
        
        String sql = "INSERT INTO deck(cardID) VALUES (?)";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, cardID);
                pstmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void moveToDeck(int id){
        String sqlDelete = "DELETE FROM mycards WHERE id="+id+";";
        String sqlGet = "SELECT * FROM mycards WHERE id="+id+";";
        String sql = "INSERT INTO deck(cardID) VALUES (?);";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlGet)){
                if(rs.next()){
                    int cardID = rs.getInt("cardID");
                    pstmt.setInt(1, cardID);
                    pstmt.executeUpdate();
                    stmt.execute(sqlDelete);
                }       
        }catch (SQLException ex) {
            Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void moveToMycards(int id) {
        String sqlDelete = "DELETE FROM deck WHERE id="+id+";";
        String sqlGet = "SELECT * FROM deck WHERE id="+id+";";
        String sql = "INSERT INTO mycards(cardID) VALUES (?);";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlGet)){
                if(rs.next()){
                    int cardID = rs.getInt("cardID");
                    pstmt.setInt(1, cardID);
                    pstmt.executeUpdate();
                    stmt.execute(sqlDelete);
                }       
        }catch (SQLException ex) {
            Logger.getLogger(Cards.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Card getCard(int ID){
        String sql = "SELECT * FROM cards WHERE cardID=" + ID + ";";
        //System.out.println(sql);
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            
            if(rs.next()){
                int id = rs.getInt("cardID");
                String name = rs.getString("name");
                int strength = rs.getInt("strength");
                String picture = rs.getString("picture");
                int power = rs.getInt("power");   
                int row = rs.getInt("row");
                String ability = rs.getString("ability");
                //System.out.println(name + ", " + strength + ", " + picture);
                return new Card(id,id, name, strength, picture, power, row,ability);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println("NULL CARD!!!!! ID: " + ID);
        return null;
    } 
    
    public static void init(){
        createDatabase("cards.db");
        insertNewCard("Knight", 6, "knight.png", 0, 0);
        insertNewCard("Commander", 8, "commander.png", 1, 0);
        insertNewCard("Sorcerer", 6, "sorcerer.png", 2, 1);
        insertNewCard("Archer", 5, "archer.png", 0, 1);
        insertNewCard("King", 8, "king.png", 2, 0);
        insertNewCard("Peasant", 2, "peasant.png", 0, 0);
        insertNewCard("Rider", 6, "rider.png", -2, 0);
        insertNewCard("Plague", 0, "plague.png", 0, 10, "plague");
        insertNewCard("Frost", 0, "frost.png", 0, 10, "frost");
        insertNewCard("Fog", 0, "fog.png", 0, 10, "fog");
        //knights
        insertIntoMyCards(1);
        insertIntoMyCards(1);        
        //commander
        insertIntoMyCards(2);        
        //peasants
        insertIntoMyCards(6);
        insertIntoMyCards(6);      
        //king
        insertIntoMyCards(5);       
        //archers
        insertIntoMyCards(4);
        insertIntoMyCards(4);       
        //riders
        insertIntoMyCards(7);
        insertIntoMyCards(7);
        //sorcerer
        insertIntoMyCards(3);
        //plague,frost,fog
        insertIntoMyCards(8);
        insertIntoMyCards(9);
        insertIntoMyCards(10);
    }
/*
    public static Card getCard(int i){
        return selectCardByID(i,"cards");
    }
*/
    public static List<Card> getCards(String table){
        String sql = "SELECT * FROM cards INNER JOIN " + table + " ON cards.cardID= " + table + ".cardID;";
        ArrayList<Card> cards = new ArrayList<Card>();
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            
            while(rs.next()){
                int id = rs.getInt("id");
                int cardID = rs.getInt("cardID");
                String name = rs.getString("name");
                int strength = rs.getInt("strength");
                String picture = rs.getString("picture");
                int power = rs.getInt("power");   
                int row = rs.getInt("row");
                String ability = rs.getString("ability");
                //System.out.println(id + ", " + name + ", " + strength + ", " + picture);
                cards.add(new Card(id,cardID, name, strength, picture, power, row,ability));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cards;
    }
}
