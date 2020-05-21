/**************************Program Identification******************************
 * COURSE: CS260
 * PROJECT#: 3
 * DUE DATE: 
 * SOURCE FILE: CS260_Project3_DylanAttridge.java
 * Instructor: Dr. Samuel Sambasivam
 * 
 * STUDENT NAME: Dylan Attridge
 * STUDENT ID: 002633915
 * ******************************************************************************
 * 
 * ********************Program Description***************************************
 * INPUT: none
 * OUTPUT:maze steps to be solved using stack and queue
 * USER-DEFINED MODULES: push, pop, enqueue, dequeue, isfull, isempty, getfirst, peek, queueRemoveFirst
 * addLast, getFirst, removeFirst, printMaze, printCurrentCoord, turn
 * PROCESS: uses the stack and queue to go through a maze and sees how many turns it takes for each while 
 * printing the maze grid each turn and where the current coord is at
 * **********************************************************************************************
 * */
 
public class CS260_Project3_DylanAttridge {
	
	public static char[][] Maze1 = {
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
			{'X', '.', '.', '.', '.', '.', '.', '.', '.', 'X'},
			{'X', 'X', '.', 'X', '.', 'X', 'X', 'X', 'X', 'X'},
			{'X', '.', '.', 'X', '.', 'X', '.', '.', '.', 'X'},
			{'X', '.', '.', 'X', '.', '.', '.', 'X', '.', 'X'},
			{'X', 'X', 'X', 'X', '.', 'X', 'X', 'X', '.', 'X'},
			{'X', '.', 'X', '.', '.', '.', '.', 'X', 'X', 'X'},
			{'X', '.', '.', 'X', 'X', '.', 'X', 'X', '.', 'X'},
			{'X', '.', '.', '.', 'X', '.', '.', '.', '.', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
	};
	public static char[][] Maze1Clone = {
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
			{'X', '.', '.', '.', '.', '.', '.', '.', '.', 'X'},
			{'X', 'X', '.', 'X', '.', 'X', 'X', 'X', 'X', 'X'},
			{'X', '.', '.', 'X', '.', 'X', '.', '.', '.', 'X'},
			{'X', '.', '.', 'X', '.', '.', '.', 'X', '.', 'X'},
			{'X', 'X', 'X', 'X', '.', 'X', 'X', 'X', '.', 'X'},
			{'X', '.', 'X', '.', '.', '.', '.', 'X', 'X', 'X'},
			{'X', '.', '.', 'X', 'X', '.', 'X', 'X', '.', 'X'},
			{'X', '.', '.', '.', 'X', '.', '.', '.', '.', 'X'},
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
	};

	public static char[][] Maze2 = {
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},//1
			{'X', 'X', '.', '.', '.', '.', '.', 'X', '.', 'X'},//2
			{'X', 'X', '.', 'X', 'X', '.', 'X', 'X', '.', 'X'},//3
			{'X', 'X', '.', '.', 'X', '.', '.', '.', '.', 'X'},//4
			{'X', 'X', '.', 'X', '.', 'X', 'X', 'X', 'X', 'X'},//5
			{'X', 'X', '.', 'X', '.', 'X', 'X', 'X', 'X', 'X'},//6
			{'X', '.', '.', 'X', 'X', '.', '.', 'X', '.', 'X'},//7
			{'X', '.', 'X', 'X', '.', 'X', '.', 'X', '.', 'X'},//8
			{'X', '.', '.', '.', '.', '.', '.', '.', '.', 'X'},//9
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},//10
	};
	
	public static char[][] Maze2Clone = {
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},//1
			{'X', 'X', '.', '.', '.', '.', '.', 'X', '.', 'X'},//2
			{'X', 'X', '.', 'X', 'X', '.', 'X', 'X', '.', 'X'},//3
			{'X', 'X', '.', '.', 'X', '.', '.', '.', '.', 'X'},//4
			{'X', 'X', '.', 'X', '.', 'X', 'X', 'X', 'X', 'X'},//5
			{'X', 'X', '.', 'X', '.', 'X', 'X', 'X', 'X', 'X'},//6
			{'X', '.', '.', 'X', 'X', '.', '.', 'X', '.', 'X'},//7
			{'X', '.', 'X', 'X', '.', 'X', '.', 'X', '.', 'X'},//8
			{'X', '.', '.', '.', '.', '.', '.', '.', '.', 'X'},//9
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},//10
	};
	
	public static char[][] Maze3 = {
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},//1
			{'X', 'X', 'X', 'X', 'X', '.', '.', 'X', '.', 'X'},//2
			{'X', 'X', 'X', 'X', '.', 'X', 'X', 'X', 'X', 'X'},//3
			{'X', 'X', '.', '.', '.', '.', '.', '.', '.', 'X'},//4
			{'X', '.', '.', 'X', 'X', '.', '.', 'X', '.', 'X'},//5//
			{'X', 'X', '.', 'X', 'X', 'X', 'X', 'X', '.', 'X'},//6
			{'X', 'X', 'X', 'X', '.', '.', '.', 'X', '.', 'X'},//7
			{'X', '.', '.', 'X', '.', 'X', '.', 'X', '.', 'X'},//8
			{'X', 'X', '.', 'X', '.', '.', 'X', 'X', 'X', 'X'},//9
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},//10
	};
	
	public static char[][] Maze3Clone = {
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},//1
			{'X', 'X', 'X', 'X', 'X', '.', '.', 'X', '.', 'X'},//2
			{'X', 'X', 'X', 'X', '.', 'X', 'X', 'X', 'X', 'X'},//3
			{'X', 'X', '.', '.', '.', '.', '.', '.', '.', 'X'},//4
			{'X', '.', '.', 'X', 'X', '.', '.', 'X', '.', 'X'},//5//
			{'X', 'X', '.', 'X', 'X', 'X', 'X', 'X', '.', 'X'},//6
			{'X', 'X', 'X', 'X', '.', '.', '.', 'X', '.', 'X'},//7
			{'X', '.', '.', 'X', '.', 'X', '.', 'X', '.', 'X'},//8
			{'X', 'X', '.', 'X', '.', '.', 'X', 'X', 'X', 'X'},//9
			{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},//10
	};
	
	public static void heading() {//header function
		System.out.println();
		System.out.println("Dylan Attridge\t002633915\tCS260");
		System.out.println("Spring 2018 Project#3");
		System.out.println();
		System.out.println();
	}
	
	public static void footing() {//header function
		System.out.println();
		System.out.println();
		System.out.println("END OUTPUT");
		System.out.println();
	}

	public static void main(String[] args)
	{
		heading();
		//Coord startCoord = new Coord(7,5); for testing
		//Coord endCoord = new Coord(1,1);for testing
		//Coord startCoord2 = new Coord(1,1); for testing
		//Coord endCoord2 = new Coord(1,5);for testing
		Coord startCoord1 = new Coord(7,8);
		Coord endCoord1 = new Coord(1,8);
		Coord startCoord2 = new Coord(7,1);
		Coord endCoord2 = new Coord(6,2);
		Coord startCoord3 = new Coord(8,4);
		Coord endCoord3 = new Coord(8,2);
		StackMaze mazeStack1 = new StackMaze();
		QueueMaze mazeQueue1 = new QueueMaze();
		StackMaze mazeStack2 = new StackMaze();
		QueueMaze mazeQueue2 = new QueueMaze();
		StackMaze mazeStack3 = new StackMaze();
		QueueMaze mazeQueue3 = new QueueMaze();
		//System.out.println("Generic Maze 1 test using stack:"); for testing
		//mazeStack.pathExists(GenericMaze, startCoord, endCoord);for testing
		//System.out.println("Generic Maze 2 test using stack:"); for testing
		//mazeStack.pathExists(GenericMaze2, startCoord2, endCoord2); for testing
		System.out.println("Maze 1 test using stack:"); //tells us which maze is being used and that we are using stack
		mazeStack1.pathExists(Maze1, startCoord1, endCoord1);//calls the path exists method to see if a path exists
		System.out.println("Maze 1 test using queue:");//tells us which maze is being used and that we are using the queue
		mazeQueue1.pathExists(Maze1Clone, startCoord1, endCoord1);//calls the path exists method to see if a path exists
		System.out.println("Maze 2 test using stack:"); //tells us which maze is being used and that we are using stack
		mazeStack2.pathExists(Maze2, startCoord2, endCoord2);//calls the path exists method to see if a path exists
		System.out.println("Maze 2 test using queue:");//tells us which maze is being used and that we are using the queue
		mazeQueue2.pathExists(Maze2Clone, startCoord2, endCoord2);//calls the path exists method to see if a path exists
		System.out.println("Maze 3 test using stack:"); //tells us which maze is being used and that we are using stack
		mazeStack3.pathExists(Maze3, startCoord3, endCoord3);//calls the path exists method to see if a path exists
		System.out.println("Maze 3 test using queue:");//tells us which maze is being used and that we are using the queue
		mazeQueue3.pathExists(Maze3Clone, startCoord3, endCoord3);//calls the path exists method to see if a path exists
		
		footing();
	}
}
