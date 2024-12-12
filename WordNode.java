
public class WordNode {
    public String data;
    public WordNode next;

    public WordNode(String w){
        if(w != null && w != w.toLowerCase()){
            throw new IllegalWordException("Your word must contain all lowercase letters.");
        }
        else{
        data = w;
        next = null;
        }
    }

    public WordNode(){
        data = null;
        next = null;
    }

    public WordNode(String w, WordNode n){
        if(w != w.toLowerCase()){
            throw new IllegalWordException("Your word must contain all lowercase letters.");
        }
        else{
        data = w;
        next = n;
        }
    }

}
