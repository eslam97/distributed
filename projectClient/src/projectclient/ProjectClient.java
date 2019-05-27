package projectclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectClient {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Socket s = new Socket("localhost", 8090);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            ObjectInputStream mapInputStream = new ObjectInputStream(s.getInputStream());
            System.out.println("please choose what do you do ?\n1-insert\n2-select");
            Scanner scan = new Scanner(System.in);
            int operation = scan.nextInt();
            switch (operation) {
                case 1: {
                    dos.writeUTF("insert");
                    System.out.println("please choose Type of shape");
                    System.out.println("1-Circle \n2-Square\n3-Trapezium\n4-Rectangle\n");
                    int n = scan.nextInt();
                    dos.write(n);
                    System.out.println("please give the shape any name to invoke it by this name");
                    String nameOfShape = scan.next();
                    dos.writeUTF(nameOfShape);
                    switch (n) {
                        case 1: {
                            System.out.println("please enter radius");
                            float radius = scan.nextFloat();
                            dos.writeFloat(radius);
                        }
                        break;
                        case 2: {
                            System.out.println("please enter sidelength of Square");
                            float sidelength = scan.nextInt();
                            dos.writeFloat(sidelength);
                        }
                        break;

                        case 3: {
                            System.out.println("Please Enter 1st Length");
                            float side1 = scan.nextInt();
                            System.out.println("Please Enter 2st Length");
                            float side2 = scan.nextInt();
                            System.out.println("Please Enter 3st Length");
                            float side3 = scan.nextInt();
                            System.out.println("Please Enter 4st Length");
                            float side4 = scan.nextInt();
                            System.out.println("Please Enter the Height");
                            float Height = scan.nextInt();
                            dos.writeFloat(side1);
                            dos.writeFloat(side2);
                            dos.writeFloat(side3);
                            dos.writeFloat(side4);
                            dos.writeFloat(Height);
                        }
                        break;

                        case 4: {
                            System.out.println("Please Enter base");
                            float base = scan.nextFloat();
                            System.out.println("Please Enter sidelength");
                            float side_length = scan.nextFloat();
                            dos.writeFloat(base);
                            dos.writeFloat(side_length);

                        }
                        break;
                        default: {
                            System.out.println("That shape is not in the list");
                        }

                    }

                }
                break;

                case 2: {
                    dos.writeUTF("select");
                    System.out.println("please choose Type of shape");
                    System.out.println("1-Circle \n2-Square\n3-Trapezium\n4-Rectangle\n");
                    int t = scan.nextInt();
                    dos.write(t);
                    switch (t) {
                        case 1: {
                            dos.writeUTF("hi");
                            //   ArrayList<String> titleList = (ArrayList<String>) mapInputStream.readObject();
                            //System.out.println(titleList);
                            System.out.println("enter name of the shape");
                            String name = scan.next();
                            dos.writeUTF(name);
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                        }
                        case 2: {
                            System.out.println("enter the name of shape");
                            String name = scan.next();
                            dos.writeUTF(name);
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                        }
                        break;
                        case 3: {
                            System.out.println("enter the name of shape");
                            String name = scan.next();
                            dos.writeUTF(name);
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                        }
                        break;
                        case 4: {
                            System.out.println("enter the name of Rectangle");
                            String name = scan.next();
                            dos.writeUTF(name);
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                            System.out.print(dis.readUTF());
                        }
                        break;
                        default: {
                            System.out.println("DataBase don't contains this shape");
                        }
                    }

                }
                break;
                default: {
                    System.out.println("This operation is not in the list");
                }

            }

        } catch (IOException ex) {
            Logger.getLogger(ProjectClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
