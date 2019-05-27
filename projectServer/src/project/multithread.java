package project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static project.database.con;

public class multithread extends Thread {

    Socket s;

    public multithread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            ObjectOutputStream mapOutputStream = new ObjectOutputStream(s.getOutputStream());

            String operation = dis.readUTF();
            //System.out.println(operation);
            switch (operation) {
                case "insert": {
                    int number = dis.read();
                    System.out.println(number);
                    String nameOfShape = dis.readUTF();
                    String Type = "";
                    switch (number) {
                        case 1: {
                            Type = "Circle";
                            float radius = dis.readFloat();
                            Circle c = new Circle();
                            float area = c.getArea(radius);
                            float perimeter = c.getPerimeter(radius);
                            database.getConnection();
                            PreparedStatement stmt = con.prepareStatement("insert into Circle values(?,?,?,?)");
                            stmt.setString(1, nameOfShape);
                            stmt.setFloat(2, radius);
                            stmt.setFloat(3, area);
                            stmt.setFloat(4, perimeter);

                            int i = stmt.executeUpdate();
                            System.out.println(i + " records inserted");

                            con.close();

                        }
                        break;
                        case 2: {
                            Type = "Square";
                            float sidelength = dis.readFloat();
                            Square s = new Square();
                            float area = s.getArea(sidelength);
                            float perimeter = s.getPerimeter(sidelength);
                            database.getConnection();
                            PreparedStatement stmt = con.prepareStatement("insert into square values(?,?,?,?)");
                            stmt.setString(1, nameOfShape);
                            stmt.setFloat(2, sidelength);
                            stmt.setFloat(3, area);
                            stmt.setFloat(4, perimeter);
                            int i = stmt.executeUpdate();
                            System.out.println(i + " records inserted");
                            con.close();
                        }
                        break;

                        case 3: {
                            Type = "Trapezium";
                            float side1 = dis.readFloat();
                            float side2 = dis.readFloat();
                            float side3 = dis.readFloat();
                            float side4 = dis.readFloat();
                            float Height = dis.readFloat();
                            Trapezium s = new Trapezium();
                            float area = s.getArea(side1, side2, Height);
                            float perimeter = s.getPerimeter(side1, side2, side3, side4);
                            database.getConnection();
                            PreparedStatement stmt = con.prepareStatement("insert into trapezium values(?,?,?,?,?,?,?,?)");
                            stmt.setString(1, nameOfShape);
                            stmt.setFloat(2, side1);
                            stmt.setFloat(3, side2);
                            stmt.setFloat(4, side3);
                            stmt.setFloat(5, side4);
                            stmt.setFloat(6, Height);
                            stmt.setFloat(7, area);
                            stmt.setFloat(8, perimeter);
                            int i = stmt.executeUpdate();
                            System.out.println(i + " records inserted");
                            con.close();

                        }
                        break;
                        case 4: {
                            Type = "Rectangle";
                            float base = dis.readFloat();
                            float side_length = dis.readFloat();
                            Rectangle s = new Rectangle();
                            float area = s.getArea(base, side_length);
                            float perimeter = s.getPerimeter(side_length);
                            database.getConnection();
                            PreparedStatement stmt = con.prepareStatement("insert into rectangle values(?,?,?,?,?)");
                            stmt.setString(1, nameOfShape);
                            stmt.setFloat(2, base);
                            stmt.setFloat(3, side_length);
                            stmt.setFloat(4, area);
                            stmt.setFloat(5, perimeter);
                            int i = stmt.executeUpdate();
                            System.out.println(i + " records inserted");
                            con.close();
                        }
                        break;
                        default: {
                            System.out.println("That shape is not in the list");
                        }

                    }

                }
                break;
                case "select": {

                    int s = dis.read();
                    switch (s) {
                        case 1: {
                            String test = dis.readUTF();
                            String name = dis.readUTF();
                            database.getConnection();
                            Statement stmt1 = con.createStatement();
                            ResultSet rs1 = stmt1.executeQuery("select name from circle");
                            ArrayList<String> titleList = new ArrayList<String>();
                            while (rs1.next()) {
                                titleList.add(rs1.getString(1));
                            }
                            System.out.println("name is " + titleList);
                            // mapOutputStream.writeObject(titleList);        
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("select * from circle where name = " + "'" + name + "'" + "");
                            while (rs.next()) {
                                dos.writeUTF("name : " + rs.getString(1) + "\n");
                                dos.writeUTF("radius = " + rs.getFloat(2) + "\n");
                                dos.writeUTF("area = " + rs.getFloat(2) + "\n");
                                dos.writeUTF("perimeter = " + rs.getFloat(4) + "\n");
                            }
                            con.close();
                        }
                        break;
                        case 2: {
                            String name = dis.readUTF();
                            database.getConnection();
                            Statement stmt1 = con.createStatement();
                            ResultSet rs1 = stmt1.executeQuery("select name from square");
                            ArrayList<String> listofsquare = new ArrayList<String>();
                            while (rs1.next()) {
                                listofsquare.add(rs1.getString(1));
                            }
                            System.out.println("name is " + listofsquare);
                            // mapOutputStream.writeObject(listofsquare);        
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("select * from square where name = " + "'" + name + "'" + "");
                            while (rs.next()) {
                                dos.writeUTF("name : " + rs.getString(1) + "\n");
                                dos.writeUTF("Side Length = " + rs.getFloat(2) + "\n");
                                dos.writeUTF("area = " + rs.getFloat(2) + "\n");
                                dos.writeUTF("perimeter = " + rs.getFloat(4) + "\n");
                            }
                            con.close();
                        }
                        break;
                        case 3: {
                            String name = dis.readUTF();
                            database.getConnection();
                            Statement stmt1 = con.createStatement();
                            ResultSet rs1 = stmt1.executeQuery("select name from trapezium");
                            ArrayList<String> listofTrapezium = new ArrayList<String>();
                            while (rs1.next()) {
                                listofTrapezium.add(rs1.getString(1));
                            }
                            System.out.println("name is " + listofTrapezium);
                            // mapOutputStream.writeObject(listofTrapezium);        
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("select * from trapezium where name = " + "'" + name + "'" + "");
                            while (rs.next()) {
                                dos.writeUTF("name : " + rs.getString(1) + "\n");
                                dos.writeUTF("Side1 = " + rs.getFloat(2) + "\n");
                                dos.writeUTF("Side2 = " + rs.getFloat(3) + "\n");
                                dos.writeUTF("Side3 = " + rs.getFloat(4) + "\n");
                                dos.writeUTF("Side4 = " + rs.getFloat(5) + "\n");
                                dos.writeUTF("height = " + rs.getFloat(6) + "\n");
                                dos.writeUTF("area = " + rs.getFloat(7) + "\n");
                                dos.writeUTF("perimeter = " + rs.getFloat(8) + "\n");
                            }
                            con.close();
                        }
                        case 4: {
                            String name = dis.readUTF();
                            database.getConnection();
                            Statement stmt1 = con.createStatement();
                            ResultSet rs1 = stmt1.executeQuery("select name from rectangle");
                            ArrayList<String> listofRectangle = new ArrayList<String>();
                            while (rs1.next()) {
                                listofRectangle.add(rs1.getString(1));
                            }
                            System.out.println("name is " + listofRectangle);
                            // mapOutputStream.writeObject(titleList);        
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("select * from rectangle where name = " + "'" + name + "'" + "");
                            while (rs.next()) {
                                dos.writeUTF("name : " + rs.getString(1) + "\n");
                                dos.writeUTF("base = " + rs.getFloat(2) + "\n");
                                dos.writeUTF("side length = " + rs.getFloat(3) + "\n");
                                dos.writeUTF("area = " + rs.getFloat(4) + "\n");
                                dos.writeUTF("perimeter = " + rs.getFloat(5) + "\n");
                            }
                            con.close();
                        }
                        default: {
                            System.out.println("no no");
                        }
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(multithread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(multithread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
