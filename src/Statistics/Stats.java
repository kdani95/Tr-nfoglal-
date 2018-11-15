package Statistics;

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

public class Stats {
    
    private static List<Stat> stats = new ArrayList<Stat>();
    private static final String url = "jdbc:sqlite:data/stats.db";
    private static final String userName = "root";
    private static final String password = "root";
    
    public static void createDatabase(){
        
        String delete = "DROP TABLE IF EXISTS statistics;";
        String sql = "CREATE TABLE IF NOT EXISTS statistics ("+
                     "name text PRIMARY KEY," +
                     "average float NOT NULL," +
                     "max integer NOT NULL," +
                     "min integer NOT NULL," + 
                     "samples integer NOT NULL,"+
                     "mult float NOT NULL," +
                     "exp float NOT NULL);";
        
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) { 
                if (conn != null) {
                    stmt.execute(delete);
                    stmt.execute(sql);

                    System.out.println("A new statistics database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void init(){
        createDatabase();
        insertNewStat("Plague", 0.0, 0, 500, 0, 0, 0);
        insertNewStat("Frost", 0.0, 0, 500, 0, 0, 0);
        insertNewStat("Fog", 0.0, 0, 500, 0, 0, 0);
    }
    
    private static void insertNewStat(String name,double avg,int max, int min,int smpls, double mult, double exp){
        String sql = "INSERT INTO statistics(name,average,max,min,samples,mult,exp) VALUES (?,?,?,?,?,?,?)";
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setString(1, name);
                pstmt.setDouble(2, avg);
                pstmt.setInt(3, max);
                pstmt.setInt(4, min);
                pstmt.setInt(5, smpls);
                pstmt.setDouble(6, mult);
                pstmt.setDouble(7, exp);
                pstmt.executeUpdate();
        }catch (SQLException ex) {
            System.err.println("Error at inserting new stat" + ex.toString());
        }
    }

    public static Stat getStat(String name){
        String sql = "SELECT * FROM statistics WHERE name=\"" + name + "\";";
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)){
            
            if(rs.next()){
                String cardName = rs.getString("name");
                double avg = rs.getDouble("average");
                int max = rs.getInt("max");
                int min = rs.getInt("min");
                int smpls = rs.getInt("samples");   
                double mult = rs.getDouble("mult");
                double exp = rs.getDouble("exp");
                System.out.println(cardName + ", "+ avg + ", " + max + ", "+ min + ", " + smpls);
                return new Stat(cardName,avg,max,min,smpls,mult,exp);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    } 

    static void refreshStat(Stat s) {
       String sql = "UPDATE statistics "
               + "SET "
               + " average =" + s.getAvg() + ","
               + " max =" + s.getMax()+ ","
               + " min =" + s.getMin()+ ","
               + " samples =" + s.getSmpls()+ ","
               + " mult =" + s.getMult()+ ","
               + " exp =" + s.getExp()
               + " WHERE name =\"" +s.getName() + "\";";
        System.out.println(sql);
        try(Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.executeUpdate();
        }catch (SQLException ex) {
            System.err.println("Error at updating stat" + ex.toString());
        }
    }
    
}
