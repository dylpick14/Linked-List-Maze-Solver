public class StackMaze {//class for the maze using stack

	LinkList list = new LinkList();//initializes a linklist by the name of list
	private int counter = 0;//setting a counter = 0 to later see what turn it is
	private int fullChecker = 0;
	
	public void push(Coord newCoord) {//push function to put new coords in the stack
		list.placeFirst(newCoord);//places the newCoord onto the top of the stack
		fullChecker++;//adds to the full checker because a coord was added to the stack
	}

	public Coord pop() {//function to pop coord out of the stack
		if(!list.isEmpty()) {	//used only if the list is not empty
			Coord remCoord = list.removeFirst();// creates a new coordinate to represent to removed coordinate
			fullChecker--;//subtracts from the full tracker because a coord was removed from the stack
			return remCoord;//returns the coord that was removed
		}
		return null;//if the list is empty auto returns null
	}

	public Coord peek() {	//used to see what  coordinate is first	
		if (!isEmpty()) {// checks to make sure the stack is not empty
			Coord first = list.getFirst();//creates Coord first and sets it equal to the first Coord in the stack
			return first; //returns first coordinate in stack
		}else {//checks for empty stack
			return null;	//returns null if stack is empty
		}
	}
	
	public boolean isFull() {//checks to see if the stack is full
		if(fullChecker == 1000000000) {//if the fullChecker has reached this number, then too much memory has been used and the stack is full
			return true;//returns true
		}else {//if there is room in the stack
			return false;//return false
		}
	}

	public boolean isEmpty() { //function to see if the stack is empty
		return list.isEmpty();//returns whether or not the stack is empty
	}

	public void printMaze(char[][] maze) {//function to print out the grid
		for (int i = 0; i < maze.length; i++) {//forloop to iterate through rows
			for (int j = 0; j < maze[i].length; j++) {//for loop to iterate trhough each column
				System.out.print(maze[i][j]);//prints out grid
			}
			System.out.println();//returns to next line
			
		}
		System.out.println();//styling
	}
	
	public void turnReset() {
		counter = 0;
	}
	
	public void turn() {//function to check what turn it is
		
		counter++;//increments the counter that starts at 0
		System.out.println("Current turn: " + counter);//prints out what turn
	}
	
	public void printCurrentCoord(Coord current) {// function to print out current coordinate
		System.out.println("Current Coord: (" + current.getRow() + ", " + current.getCol() + ")");//prints out current coordinate
	}


	public boolean pathExists(char [][] maze, Coord start, Coord end ) {//function to see if a path exists
		Coord current;//creates current coord
		push(start);//pushes starting coord into stack
		maze[start.getRow()][start.getCol()] = 'S';//sets the starting coord in maze to S
		maze[end.getRow()][end.getCol()] = 'E';//sets the end coord in maze to E
		
		while (!isEmpty()) {//while loop while the stack is not empty
			current = pop();//pops off the top value of the stack and sets it to the current coord
			printMaze(maze);//prints the maze grid
			turn();// states what turn it is
			printCurrentCoord(current);//prints current coord
			
			maze[current.getRow()][current.getCol()] = 'o';//current position on maze = o
			if(current.getRow() == end.getRow() && current.getCol() == end.getCol()) {	//checking to see if the current coord is at the end
				maze[end.getRow()][end.getCol()] = 'F';//sets end coord = F to show maze is finished
				printMaze(maze);//prints out final maze
				System.out.println("There is a possible solution!");//states a possible solution
				System.out.println();//styling
				System.out.println();//styling
				System.out.println();//styling
				turnReset();//resets turn counter
				return true;
			}
			if(maze[current.getRow()][current.getCol()+ 1] == '.' || maze[current.getRow()][current.getCol()+ 1] == 'E') {//if statement to see if the current coord can go north or if it is the end
				Coord north = new Coord(current.getRow(), current.getCol()+1);//creates north coord to be put into stack	
				push(north);//pushes north coord into stack
				
			}
			if(maze[current.getRow()][current.getCol()- 1] == '.' || maze[current.getRow()][current.getCol()- 1] == 'E') {////if statement to see if the current coord can go south or if it is the end
				Coord south = new Coord(current.getRow(), current.getCol()-1);	//creates south coord to be put into stack
				push(south);//pushes south coord into stack
			}
			if(maze[current.getRow()+1][current.getCol()] == '.' || maze[current.getRow() + 1][current.getCol()] == 'E') {//if statement to see if the current coord can go east or if it is the end
				Coord east = new Coord(current.getRow()+1, current.getCol());//creates east coord to be put into stack
				push(east);//pushes east into stack
			}
			if(maze[current.getRow()-1][current.getCol()] == '.' || maze[current.getRow() -1][current.getCol()] == 'E') {//if statement to see if the current coord can go west or if it is the end
				Coord west = new Coord(current.getRow()-1, current.getCol());//creates west coord to be put into stack
				push(west);//pushes west into stack
			}


			if (isEmpty()) {//if statement to see if the stack is empty and hasnt reached the end coord 
				System.out.println("There is no possible solution");//prints no solution
				return false;//returns false;
			}
		}

		return false;//if the stack was empty from the start, then auto returns false
	}
}

