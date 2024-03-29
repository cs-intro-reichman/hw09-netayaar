/** A linked list of character data objects.
 *  (Actually, a list of Node objects, each holding a reference to a character data object.
 *  However, users of this class are not aware of the Node objects. As far as they are concerned,
 *  the class represents a list of CharData objects. Likwise, the API of the class does not
 *  mention the existence of the Node objects). */
public class List {

    // Points to the first node in this list
    private Node first;

    // The number of elements in this list
    private int size;
	
    /** Constructs an empty list. */
    public List() {
        first = null;
        size = 0;
    }

    /** Returns the number of elements in this list. */
    public int getSize() {
 	      return size;
    }

    /** Returns the first element in the list */
    public CharData getFirst() {
        return first.cp;
    }

    public Node getFirstNode() {
        return first;
    }
    

    /** GIVE Adds a CharData object with the given character to the beginning of this list. */
    public void addFirst(char chr) {
        CharData chd =new CharData(chr);
         Node newNode = new Node(chd);
         newNode.next = first;
         first= newNode;
         size++;
        
    }
    
    /** GIVE Textual representation of this list. */
    public String toString() {
        if (size == 0) {
            return "()";
        }
        StringBuilder str = new StringBuilder("(");
        // String str = "(";
        Node current = first;
        while (current != null) {
            // str = str+ current.cp.chr + " ";
            if (current.next == null)
            {
                str.append(current.cp.toString());
            }
            else {
                str.append(current.cp.toString()).append(" ");
            }
            
            current = current.next;
        }
        str = str.append(")");
        return str.toString();
    }

    /** Returns the index of the first CharData object in this list
     *  that has the same chr value as the given char,
     *  or -1 if there is no such object in this list. */
    public int indexOf(char chr) {
        Node current = first ; 
        int index = 0;
        while (current != null){
            if (current.cp.chr == chr){
                return index ;
            }
            current = current.next;
            index++;
        }
        return  -1;
    }

    /** If the given character exists in one of the CharData objects in this list,
     *  increments its counter. Otherwise, adds a new CharData object with the
     *  given chr to the beginning of this list. */
    public void update(char chr) {
        Node current = first ; 
        int index = 0;
        boolean exists = false;
        while (current != null){
            if (current.cp.chr == chr){
                current.cp.count++;
                exists=true;
            }
            current = current.next;
        }
        if (exists==false){
            addFirst(chr);
        }
    }

    /** GIVE If the given character exists in one of the CharData objects
     *  in this list, removes this CharData object from the list and returns
     *  true. Otherwise, returns false. */
    public boolean remove(char chr) {
        Node current = first.next ; 
        Node prev = first;
        if (indexOf(chr)==0){
            first=first.next;
            size--;
            return true;

        }
        else if (indexOf(chr)!=-1){
            for (int i=1; i<indexOf(chr); i++){
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
            size--;
            return true;

            // while (current != null && current.cp.chr != chr){
            //     prev = current;
            //     current = current.next;
            // }
            // if (current == null) return false;
            // if (prev  == null) {
            //     first = first.next;
            // }
            // else
            //     {
            //         prev.next = current.next;
            //     }
            //     size--;
            //     return true;
            }
            return false;
        
    }

    /** Returns the CharData object at the specified index in this list. 
     *  If the index is negative or is greater than the size of this list, 
     *  throws an IndexOutOfBoundsException. */
    public CharData get(int index) {
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        else{
            if (index==0){
                return first.cp;
            }
            Node current = first.next ; 
            for (int i=1;i<index;i++){
                current=current.next;
            }
            return current.cp;
        }
    }

    /** Returns an array of CharData objects, containing all the CharData objects in this list. */
    public CharData[] toArray() {
	    CharData[] arr = new CharData[size];
	    Node current = first;
	    int i = 0;
        while (current != null) {
    	    arr[i++]  = current.cp;
    	    current = current.next;
        }
        return arr;
    }

    /** Returns an iterator over the elements in this list, starting at the given index. */
    public ListIterator listIterator(int index) {
	    // If the list is empty, there is nothing to iterate   
	    if (size == 0) return null;
	    // Gets the element in position index of this list
	    Node current = first;
	    int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        // Returns an iterator that starts in that element
	    return new ListIterator(current);
    }
    public static void main(String[] args) {
    CharData chd =new CharData('o');
    Node newNode = new Node(chd);
    System.out.println(newNode.toString());
    }
}
