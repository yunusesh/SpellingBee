public class WordList{
    public WordNode first = new WordNode(null);
    public WordNode last = first;;
    public int length;
        
    public WordList(){
        WordNode wn = new WordNode();
        first = wn;
        last = wn;
        length = 0;
    }

    public void append(String d){
        if (last == null){
            last = new WordNode(d);
        }

        WordNode n = new WordNode(d);
        last.next = n;
        last = n;
        length++;
    }

    public void prepend(String d){
        if (first == null){
            first = new WordNode(d);
        }

        WordNode n = new WordNode(d);
        first.next = n;
        first = n;
        length++;
    }

    public boolean contains(WordList list, String guess){
        WordNode temp = list.first.next;
        while(temp != null){
            if(guess.equals(temp.data)) return true;
            temp = temp.next;
        }
        return false;
    }

    public String toString() {
		WordNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data + " ";
			p = p.next;
		}
		return returnString;
	}

    public boolean isEmpty(){
        return first.next == null;
    }
}