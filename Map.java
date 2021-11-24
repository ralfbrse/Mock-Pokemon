import java.awt.Point;
import java.io.*;
import java.util.Scanner;


public class Map {
  private char [][] map; //character ARRAY
  private boolean [][] revealed; //boolean ARRAY
  
  
  public Map(){
    map = new char[5][5];
    revealed = new boolean[5][5];
    for (boolean[] row : revealed) {
      java.util.Arrays.fill(row, false);
    }
  }
  
  /**
   * Loads up map text file into playable map
   * @param mapNum option 1, 2, or 3
   */
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

    


    //System.out.println(dispMap);
  }

 /**
  * Checks position character
  * @param p point to check
  * @return character on map
  */
  public char getCharAtLoc(Point p){
    //return the char/letter at point
    double x = p.getX();
    double y = p.getY();
    return map[(int) x][(int) y];
  }

  /**
   * Displays entire map with current location as *
   * @param p point to reveal
   * @return map as string
   */
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

  /**
   * Scans map for S and places character on it
   * @return starting point
   */
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

  /**
   * Reveals the character hidden under Xs
   * @param p hidden point to reveal
   */
  public void reveal(Point p){
    double x = p.getX();
    double y = p.getY();
    revealed[(int) x][(int) y] = true;
  }

  /**
   * Clears spot of any character after interaction is over (besides shop, start, finish, and n)
   * @param p point to clear
   */
  public void removeCharAtLoc(Point p){
    double x = p.getX();
    double y = p.getY();
    map[(int) x][(int) y] = 'n';
  }
}