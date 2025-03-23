// represents an empty list of Person's buddies
package lab7;


class MTLoBuddy implements ILoBuddy {
    MTLoBuddy() {}

		@Override
		public ILoBuddy insert(Person p) {
			// TODO Auto-generated method stub
			return new ConsLoBuddy(p, this);
		}

		@Override
		public boolean contain(Person p) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean checkDirectFriend(Person p) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int countCommon(Person that) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean hasExtendedBuddyHelper(Person that, ILoBuddy consLoBuddy) {
			// TODO Auto-generated method stub
			return false;
		}




}
