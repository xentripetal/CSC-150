package birthdayproject;

import java.util.Arrays;

public class BirthdayList {
	final int DEFAULT_SIZE = 5;
	
  	private int[] populatedList;
	private int size;
	
	//default constructor that sets size to default size and
	//populates a birthdaylist
	BirthdayList() {
		size = DEFAULT_SIZE;
		regenerateBirthdays();
	}
	
	//alternative constructor that sets given size and
	// populates a birthdaylist
	BirthdayList(int people_size) {
		size = people_size;
 		regenerateBirthdays(); 
	}
	
	//internal method for populating internal list of birthdays
	private void populateBirthdays() {
		for (int i = 0 ; i < size ; i++) {
			//set current position in list to a random number between 1-365 (inclusive)
			populatedList[i] = (int)(Math.random() * 365) + 1;
		}
		//Use Java's pre-built solution for sorting arrays
		Arrays.sort(populatedList);	
	}
	
	//size setter that automatically generates a new list
	public void setSize(int newSize) {
		size = newSize;
		regenerateBirthdays();
	}
	//size setter with option to generate new list
	public void setSize(int newSize, boolean regenerate) {
		size = newSize;
		if (regenerate) {
			regenerateBirthdays();
		}
	}

	//Checks for atleast 2 of the same birthdays in the birthdayList
	// and returns true if one is found and false if none are found
	public boolean matchInList() {
		boolean matchFound = false;
		
		//iterate through list
		for (int i = 0 ; i < populatedList.length - 1 ; i++) {
			//Assumes the list is properly sorted (all internal methods have it
			//sorted and it cannot be accessed publicly, so safe assumption) and
			// checks if the current position is equal to the next position.
			if (populatedList[i] == populatedList[i+1]) {
				matchFound = true;
				break;
			}
		}
		return matchFound;
  	}

	//Regenerates the current birthday list with the internal size.
	public void regenerateBirthdays() {
		populatedList = new int[size];
		populateBirthdays();
	}


}
