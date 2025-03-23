// represents a list of Person's buddies
package lab7;


interface ILoBuddy {
	ILoBuddy insert(Person p);

	boolean contain(Person p);
	//Check if this person in the this list
	// Buddies person --> boolean
	boolean checkDirectFriend(Person p);

	int countCommon(Person that);

	boolean hasExtendedBuddyHelper(Person that, ILoBuddy consLoBuddy);

}


