
public class SortedWordList extends WordList{
    public SortedWordList(){

    }

    public void add(String guess, WordList list) {
        WordNode newNode = new WordNode(guess);
        if (list.isEmpty() || guess.compareTo(list.first.next.data) < 0) {
            newNode.next = list.first.next;
            list.first.next = newNode;
            if (list.last == null) {
                list.last = newNode;
            }
            return;
        }


        WordNode current = list.first.next;
        WordNode previous = null;

        while (current != null && guess.compareTo(current.data) > 0) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            newNode.next = list.first.next;
            list.prepend(guess); 
        }   
        else {
        newNode.next = current;
        previous.next = newNode;
        if (current == null) {
            list.last = newNode; 
        }
    }
}
}
