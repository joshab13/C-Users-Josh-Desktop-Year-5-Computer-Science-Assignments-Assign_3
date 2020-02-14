package Assign_3;


import Media.*;                  // for Turtle and TurtleDisplayer
import java.awt.*;               // for Color objects and methods
import static java.lang.Math.*;  // for math constants and functions
import static java.awt.Color.*;  // for Color constants


/** This class ...
  *
  * Joshua Braganza
  * COSC 1P02: Assignment 3
  * @version 1.0 (February 12th 2019)                                                        */

public class Cityscape {
    
    
    private Turtle yertle;
    private TurtleDisplayer display;
    
    
    /** This constructor ...                                                     */
    
    public Cityscape ( ) {
      
      
      display = new TurtleDisplayer(yertle,500,500);
      yertle = new Turtle(0);
      display.placeTurtle(yertle);
      drawbuildings();
      
        
    }; // constructor

    
    
    /** This method ...                                                          */
    
    private void drawbuildings () {
      
      int numofbuildings;
      int stories;
      int minbuildings = 3;
      int maxbuildings = 6;
      int minstories = 5;
      int maxstories = 15;
      
      //Get the number of buildings to draw
      numofbuildings = (int)(random()*(maxbuildings-minbuildings)+minbuildings); 
      
      //Get the number of stories for each building
      stories = (int)(random()*(maxstories-minstories)+minstories);
      
      
      /*Determine starting position of pointer to ensure cityscape 
       *is horizontally positioned
       */
      calcstartingpoint(numofbuildings); 
      
      
      
      //Drawing the buildings
        for (int i=1; i<= numofbuildings; i++) {
          drawrectangle(stories); //Draws rectangle based on number of stories. Gives the number of stories so height of rectangle can be calculated
          drawwindows(stories); //Draws the windows in the rectangle
          yertle.forward(70); //Position to draw next building 
          stories = (int)(random()*(maxstories-minstories)+minstories);
          
        }  
    }; // drawbuilding
    
    
    
    /**The method below allows us to center the cityscape regardless of 
    the number of buildings the program draws (Max buildings for centering: 6)
    **/
    private void calcstartingpoint(int x){
      double startingpoint;
      
      /*Formula to determine the starting point. Basically determines remaining 
       * space after an x amount of buildings are determined through the random()
       * function. 
       * */
      startingpoint = -250+(500-70*x)/2; 
      
      
      yertle.moveTo(startingpoint,-225); 
      
    } //calcstartingpoint
    
    private void drawrectangle(int stories){
      int height = (stories * 30); //Receives random number of stories to determine height of rectangle
      int width = 70; //Width of each building
      double angle = PI/2;
      
      yertle.penDown();
      yertle.left(angle);
      
      //Drawing the rectangle
      for (int i=1; i<=2; i++){
        yertle.forward(height);
        yertle.right(angle);
        yertle.forward(width);
        yertle.right(angle);
      }
      
      yertle.right(angle); //Bring pointer to original orientation. Turtle always ends on the right
      
      
      yertle.penUp();
    }
    
    
    private void drawwindows(int stories){
      
      /*This stores the location of the x and y coordinates so when the windows 
       * are drawn for each story, pointer goes back to original x position and increment
       * by one story up and repeat the same process up to int stories*/
      System.out.println(yertle.getScreenX()); 
      int x = yertle.getScreenX();
      int y = yertle.getScreenY();
      
      //Position to draw the first window
      for (int l=1; l<=stories; l++) {
           yertle.forward(17.5);
           yertle.left(PI/2);
           yertle.forward(15);
           yertle.right(PI/2);
      
      
       for (int k=1; k<=2; k++) {    //Second inner for loop draws two windows for each story
         yertle.penDown();
         
         //Draws the windows
        for (int j=1; j<=4; j++){     //Third inner for loop positions pointer to draw the next window 
          for (int i=1; i<=4; i++){   //The final inner for loop draws the windows
            yertle.forward(5);
            yertle.right(PI/2);
          }
          yertle.right(PI/2);
        }
        
        //Position to draw the second window
        yertle.penUp();
        yertle.forward(30);
        yertle.penDown();
      }
      
       
       yertle.penUp();
       y = y + 30;  //Increment by one story up
       yertle.moveTo(x,y); //Move to new position to draw next set of windows
       
      }
           
      /*Once all the windows are drawn in a building, returns to original
       * so the next building get be drawn
       * */
      yertle.penUp();
      yertle.moveTo(x,-225);
    }
 
      
    
    
    public static void main ( String[] args ) {
      Cityscape s = new Cityscape();
      
    };
    
    
    
}  // Cityscape