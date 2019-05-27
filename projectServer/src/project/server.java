package project;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket; 
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static project.database.con;

class server{  
    
public static void main(String args[]) throws SQLException{  
                
        try {
     
            ServerSocket  s= new ServerSocket(8090);
            Socket h = s.accept();
            multithread t = new multithread(h);
            t.start();
            
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}  
