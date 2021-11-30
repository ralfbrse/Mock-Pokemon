import java.awt.Point;
import java.io.*;
import java.util.Scanner;

public class Map {
  private char [][] map; //character ARRAY
  private boolean [][] revealed; //boolean ARRAY
  private static Map instance = null;
    
  public Map(){
    map = new char[5][5];
    revealed = new boolean[5][5];
    for (boolean[] row : revealed) {
      java.util.Arrays.fill(row, false);
    }
  }

  public static Map getInstance() {
    if( instance == null ) {
         instance = new Map( );
    }
    return instance;
  }
  
  public void loadMap(int mapNum){
    String dispMap = "";
    int row = -1;
    int column = 0;
    if (mapNum == 1){
      try (Scanner read = new Scanner( new File( "Area1.txt" ) )){
        while (read.hasNextLine()){

          String lines = read.nextLine();
          String[] letter = lines.split(" ");
          column = 0;
          row += 1;
          for(String a : letter){

            this.map[row][column] =  a.charAt(0);
            column+=1;
          }
          dispMap += lines + "\n";
        }
        for (boolean[] rows : revealed) {
          java.util.Arrays.fill(rows, false);
        }
        read.close();
      } catch (FileNotFoundException fnf) {
        System.out.println("file not found");
      }
    }
    if (mapNum == 2) {
      try (Scanner read = new Scanner( new File( "Area2.txt" ) )){
        while (read.hasNextLine()){

          String lines = read.nextLine();
          String[] letter = lines.split(" ");
          column = 0;
          row += 1;
          for(String a : letter){

            this.map[row][column] =  a.charAt(0);
            column+=1;
          }
          dispMap += lines + "\n";
        }
        for (boolean[] rows : revealed) {
          java.util.Arrays.fill(rows, false);
        }
        read.close();
      } catch (FileNotFoundException fnf) {
        System.out.println("file not found");
      }
    }
    if (mapNum == 3){
      try (Scanner read = new Scanner( new File( "Area3.txt" ) )){
        while (read.hasNextLine()){

          String lines = read.nextLine();
          String[] letter = lines.split(" ");
          column = 0;
          row += 1;
          for(String a : letter){

            this.map[row][column] =  a.charAt(0);
            column+=1;
          }
          dispMap += lines + "\n";
        }
        for (boolean[] rows : revealed) {
          java.util.Arrays.fill(rows, false);
        }
        read.close();
      } catch (FileNotFoundException fnf) {
        System.out.println("file not found");
      }
    }
  }

 
  public char getCharAtLoc(Point p){
    //return the char/letter at point
    double x = p.getX();
    double y = p.getY();
    return map[(int) x][(int) y];
  }

  
  public String mapToString(Point p) {
    //Use the boolean 2D revealed array to decide whether a space on the map
    //is shown or hidden when writing the mapToString method (which also displays the
    //trainer’s position as a * using the Point location passed in as a parameter).
    double x = p.getX();
    double y = p.getY();
    String dispMap = "";
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {

        if (x == i && y == j ) {
          dispMap += "*";
          //dispMap = dispMap + map[i][j];
        }
        if ( !(x == i && y == j) &&(revealed[i][j] == false)) {
          dispMap += "X";
          //dispMap = dispMap + map[i][j];
        } 
        if ( !(x == i && y == j) &&(revealed[i][j] == true)){
          dispMap += map[i][j];
        }

        if (j == 4) {
          dispMap += "\n";
        } 
      }
    }
    return dispMap;    
  }

  
  public Point findStart() {
    Point start = new Point();
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (this.map[i][j] == 's') {
            start.setLocation(i,j);
          }
        }
      } 
      return start;
  }

 
  public void reveal(Point p){
    double x = p.getX();
    double y = p.getY();
    revealed[(int) x][(int) y] = true;
  }

 
  public void removeCharAtLoc(Point p){
    double x = p.getX();
    double y = p.getY();
    map[(int) x][(int) y] = 'n';
  }
}