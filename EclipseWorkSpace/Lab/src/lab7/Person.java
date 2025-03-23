// represents a Person with a user name and a list of buddies
package lab7;


class Person {

    String username;
    ILoBuddy buddies;

    Person(String username) {
        this.username = username;
        this.buddies = new MTLoBuddy();
    }

    // returns true if this Person has that as a direct buddy
    boolean hasDirectBuddy(Person that) {
        return this.buddies.checkDirectFriend(that);
    }
    
    boolean contain(Person p) {
    	return this.buddies.contain(p);
    }

    // returns the number of people who will show up at the party 
    // given by this person
    int partyCount(){
        return 1;
    }

    // returns the number of people that are direct buddies 
    // of both this and that person
    int countCommonBuddies(Person that) {
        return this.buddies.countCommon(that);
    }

    // will the given person be invited to a party 
    // organized by this person?
    boolean hasExtendedBuddy(Person that) {
        return this.hasExtendedBuddyHelper(that, new MTLoBuddy());
    }
    
    boolean hasExtendedBuddyHelper(Person that, ILoBuddy visited) {
    	if (this == that) return true;
    	if( (visited.contain(this))) return false;
    	return this.buddies.hasExtendedBuddyHelper(that, new ConsLoBuddy(this, visited));
    }
    
    void addBuddy(Person buddy) {
       this.buddies = this.buddies.insert(buddy);
    }
}


