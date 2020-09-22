package task02;


import java.util.Iterator;

public class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }


     class Iterator {
        private int counter =0;

        private Iterator() {
        }
        public boolean hasNext() {
            return names.length >counter;
        }

        public String next() {
            String result = null;
            if (hasNext()) {
                result = names[counter];
                counter++;
            }
            return result;
        }
    }
}


