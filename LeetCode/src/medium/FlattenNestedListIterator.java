package medium;

import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator {

    class NestedIterator implements Iterator<Integer> {

        private List<NestedInteger> list;
        private NestedIterator itr;
        int cursor;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.list = nestedList;
            this.itr = null;
            this.cursor = 0;
        }

        @Override
        public Integer next() {

            //This hasNext() is needed if the user does not call hasNext before calling next() method.
            //After calling hasNext() the pointer will always be at a nested list (in this case nested iterator will be assigned) or at an integer
            if (hasNext()) {

                //If there is any nested list we first call its next method
                if (itr != null) {
                    return itr.next();
                } else {

                    //We get the current integer and move the pointer to next element
                    NestedInteger n = list.get(cursor);
                    cursor++;
                    return n.getInteger();
                }
            }

            return null;

        }

        //this method assigns the nested iterator if there are any nested list present.
        @Override
        public boolean hasNext() {

            //If there is already any nested Iterator we call its hasNext method
            if (itr != null) {
                if (itr.hasNext()) {
                    return true;
                } else {

                    //If there are no more elements in the nested list we move the cursor and check the next element
                    itr = null;
                    cursor++;
                }
            }

            //If we reach the end of the list means theres no more element
            if (cursor >= list.size()) {
                return false;
            }

            //Else we check the current element if its an integer then simply return true
            NestedInteger n = list.get(cursor);
            if (n.isInteger()) {
                return true;
            } else {
                //If its a nested list then assign this list to the nestedIterator and check if it has any elements
                List<NestedInteger> l = n.getList();
                itr = new NestedIterator(l);
                return hasNext();
            }
        }
    }

}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}



