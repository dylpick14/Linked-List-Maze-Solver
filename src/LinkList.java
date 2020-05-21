public class LinkList{					//class created to create linklist
		private Coord firstCoord = null;//sets first node globally to null
		private Coord lastCoord = null;//sets last node globally to null


		public void placeFirst(Coord newCoord) {//places a coordinate in the front
			newCoord.next = firstCoord;//makes the next coord equal to null
			firstCoord = newCoord; //makes the Coord equal to firstNode putting it in front
		}

		public Coord removeFirst() { //method to remove the first Coord for stack
			Coord temp = firstCoord; //creats local coord and sets it equal to the first node
			firstCoord = firstCoord.next;//makes the new first Coord
			return temp;
		}

		public boolean isEmpty() {//checks to see if the list is empty
			return firstCoord == null;//returns whether or not the firstCoord was null
		}

		public Coord getFirst() {	//function to get the first Coord
			Coord first = firstCoord;//sets local coord first = to firstCoord
			while(!isEmpty()) {//checks to see if the list was empty
				if(first.next != null)//if statement to see if the next Coord in the list isnt null,
					first = firstCoord.next;//first = the next coord
				else {//if the next node is null
					first = first.next; //first is the first node in the list
					break;//breaks the loop
				}
			}
			return first;//returns first Coord
		}
		
		 public void addLast (Coord newCoord) {//function to add a coord to the end of the list
			 if(isEmpty()) {//checks to see if the list is empty to add a first coord
				 newCoord.next = firstCoord; //sets the pointer to point at first coord
				 firstCoord = newCoord; //first Coord = the new coord
				 lastCoord = newCoord;//the last coord also = the new coord because it is the only coord in the list
			 }else {//if the list is not empty
				 lastCoord.next = newCoord;//the new coord that is after the current last coord equals the new coord
				 lastCoord = newCoord;// the new last coord is equal to the new Coord
				 lastCoord.next = null;//the coord after last coord is now null signifying the end of the list
				 
			 }
		 }
		 
		 public Coord queueRemoveFirst() {//function to remove the first coord for the queue
			 Coord current = firstCoord; //makes the current node = to firstCoord
			 if(firstCoord.next == null) {// if the next coord after firstcoord is null, then
				 lastCoord = null;//the last coord is also null
			 }
			 firstCoord = firstCoord.next;//the new first coord is the coord after the removed coord
			 return current;//returns the current coord which is the coord that was removed
		 }
		
		
		
	}
