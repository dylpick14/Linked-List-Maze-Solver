
public class QueueMaze {
	LinkList list = new LinkList(); //initializes a linklist named list
	private int counter = 0;//initializes a counter to 0 used for turn method later
	private int fullChecker = 0;
	
	public void turnReset() {
		counter = 0;
	}
	
	public void enqueue(Coord newCoord) {//function to enqueue onto the queue
		list.addLast(newCoord);//adds the new coord to the queue
		fullChecker++;//adds one to the stack to see if the queue is full
	}
	
	public Coord dequeue() {//function to remove the first or dequque a coord
		if(!list.isEmpty()) {//checks to see if the queue is not empty
			Coord remCoord;//creates a new temporary coord
			remCoord = list.queueRemoveFirst();//removes the first coord from the list and sets it equal to remCoord
			fullChecker--;//subtracts 1 from the counter because a coord has been removed from the queue
			return remCoord;//returns remCoord
		}
		return null;//if the list is empty returns null
	}
	
	public Coord peek() {		//peek function to see what coord is first
		if (!isEmpty()) {// checks to see if the queue is not empty
			Coord first = list.getFirst();// creates the first coord and gets the first coord in the queue
			return first;//returns the first coord
		}else {
			return null;// if the queue is empty returns null
		}
	}
	
	public boolean isFull() {//checks to see if the stack is full
		if(fullChecker == 1000000000) {//if the fullChecker has reached this number, then too much memory has been used and the queue is full
			return true;//returns true
		}else {//if there is room in the stack
			return false;//return false
		}
	}
	
	public boolean isEmpty() {//function to see if the queue is empty
		return list.isEmpty();//returns if the queue is empty
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
	
	public void turn() {//function to see what turn it is
		counter++;//increments the counter because counter starts off = 0
		System.out.println("Current turn: " + counter);//prints out the current turn
	}
	
	public void printCurrentCoord(Coord current) {//function that prints the current coord
		System.out.println("Current Coord: (" + current.getRow() + ", " + current.getCol() + ")");//prints current coord
	}

	public boolean pathExists(char [][] maze, Coord start, Coord end ) {//function to see if a path exists
		Coord current;//creates current coord
		enqueue(start);//enqueue or puts starting coord into queue
		maze[start.getRow()][start.getCol()] = 'S';//sets the starting coord in maze to S
		maze[end.getRow()][end.getCol()] = 'E';//sets the end coord in maze to E
		
		while (!isEmpty()) {//while loop while the queue is not empty
			current = dequeue();//dequeues off the first value of the queue and sets it to the current coord
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
				Coord north = new Coord(current.getRow(), current.getCol()+1);//creates north coord to be put into queue	
				enqueue(north);//enqueue north coord into queue
				
			}
			if(maze[current.getRow()][current.getCol()- 1] == '.' || maze[current.getRow()][current.getCol()- 1] == 'E') {////if statement to see if the current coord can go south or if it is the end
				Coord south = new Coord(current.getRow(), current.getCol()-1);	//creates south coord to be put into queue
				enqueue(south);//enqueues south coord into queue
			}
			if(maze[current.getRow()+1][current.getCol()] == '.' || maze[current.getRow() + 1][current.getCol()] == 'E') {//if statement to see if the current coord can go east or if it is the end
				Coord east = new Coord(current.getRow()+1, current.getCol());//creates east coord to be put into queue
				enqueue(east);//enqueues east into stack
			}
			if(maze[current.getRow()-1][current.getCol()] == '.' || maze[current.getRow() -1][current.getCol()] == 'E') {//if statement to see if the current coord can go west or if it is the end
				Coord west = new Coord(current.getRow()-1, current.getCol());//creates west coord to be put into queue
				enqueue(west);//enqueues west into queue
			}


			if (isEmpty()) {//if statement to see if the queue is empty and hasnt reached the end coord 
				System.out.println("There is no possible solution");//prints no solution
				return false;//returns false;
			}
		}

		return false;//if the queue was empty from the start, then auto returns false
	}
	
		
	
}
