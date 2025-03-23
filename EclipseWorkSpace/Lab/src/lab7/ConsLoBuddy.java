// represents a list of Person's buddies
package lab7;

class ConsLoBuddy implements ILoBuddy {

    Person first;
    ILoBuddy rest;

    ConsLoBuddy(Person first, ILoBuddy rest) {
        this.first = first;
        this.rest = rest;
    }

		@Override
		public ILoBuddy insert(Person p) {
			return new ConsLoBuddy(p, this);
		}

		@Override
		public boolean contain(Person p) {
			// TODO Auto-generated method stub
			if (this.first.equals(p)) { 
				return true;
			} else { 
				return this.rest.contain(p);
			}
		}

		@Override
		public boolean checkDirectFriend(Person p) {
			// TODO Auto-generated method stub
			return this.first.equals(p) || this.rest.checkDirectFriend(p);
		}

		@Override
		public int countCommon(Person that) {
			// TODO Auto-generated method stub
			if (that.contain(this.first)) {
				return 1 + this.rest.countCommon(that); 
			} else {
				return this.rest.countCommon(that);
			}
		}

		@Override
		public boolean hasExtendedBuddyHelper(Person that, ILoBuddy consLoBuddy) {
			// TODO Auto-generated method stub
			return this.first.hasExtendedBuddyHelper(that, consLoBuddy) ||
					this.rest.hasExtendedBuddyHelper(that, consLoBuddy);
		}
}
