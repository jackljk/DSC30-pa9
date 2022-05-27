import java.util.*;

/**
 * Node class to answer problem 1 -  huffman tree
 */
class HuffmanNode{
    char c;
    int freq;
    String path;

    public HuffmanNode(char c, int freq, String path){
        this.c = c;
        this.freq = freq;
        this.path = path;
    }
}

/**
 * Node class for B-tree
 */
class BNode{
    List data;
    List<BNode> children;

    public BNode(List data){
        this.data = data;
        this.children = new ArrayList<BNode>();
    }
    public void setChildren(List<BNode> children){
        this.children = children;
    }

    public void addChildren(BNode node){
        this.children.add(node);
    }
}




/**
 * Java file that stores answers to problem 1(huffman encoding) and problem 2(B-tree)
 */
public class Worksheet {


    /**
     * Answer to q1(a)
     * @return arrayList consisting HuffmanNodes, where each node stores info about an encoded character
     */
    public static ArrayList<HuffmanNode> q1aEncodeChar(){
        /*TODO: insert nodes into an ArrayList, where each node stores the frequency and path of a character */
        ArrayList<HuffmanNode> nodeList = new ArrayList<HuffmanNode>();
        //Example code on adding nodes: nodeList.add(new HuffmanNode('p', 2, "0001"));
        nodeList.add(new HuffmanNode('p',  6, "01"));
        nodeList.add(new HuffmanNode('a', 6, "00"));
        nodeList.add(new HuffmanNode('0', 6, "111"));
        nodeList.add(new HuffmanNode('1', 1, "10000"));
        nodeList.add(new HuffmanNode('\n', 4, "110"));
        nodeList.add(new HuffmanNode('2', 1, "10001"));
        nodeList.add(new HuffmanNode('3', 1, "10010"));
        nodeList.add(new HuffmanNode('4', 1, "10011"));
        nodeList.add(new HuffmanNode('5', 1, "10100"));
        nodeList.add(new HuffmanNode('o', 1, "10110"));
        nodeList.add(new HuffmanNode('r', 1, "10111"));
        nodeList.add(new HuffmanNode('6', 1, "10101"));
        return nodeList;
    }

    /**
     * Answer to q1(b)
     * @return arrayList consisting HuffmanNodes, where each node stores info about an encoded character
     */
    public static ArrayList<HuffmanNode> q1bEncodeChar(){
        /*TODO: insert nodes into an ArrayList, where each node stores the frequency and path of a character */
        ArrayList<HuffmanNode> nodeList = new ArrayList<HuffmanNode>();
        //Example code on adding nodes: nodeList.add(new HuffmanNode('p', 2, "0001"));
        nodeList.add(new HuffmanNode('T', 1, "01010"));
        nodeList.add(new HuffmanNode('h', 2, "1000"));
        nodeList.add(new HuffmanNode('i', 3, "1101"));
        nodeList.add(new HuffmanNode('s', 6, "00"));
        nodeList.add(new HuffmanNode(' ', 4, "011"));
        nodeList.add(new HuffmanNode('c', 2, "1010"));
        nodeList.add(new HuffmanNode('l', 2, "1001"));
        nodeList.add(new HuffmanNode('a',  3, "1100"));
        nodeList.add(new HuffmanNode('e', 2, "1011"));
        nodeList.add(new HuffmanNode('r', 2, "1111"));
        nodeList.add(new HuffmanNode('f', 1, "01011"));
        nodeList.add(new HuffmanNode('v', 1, "0100"));
        nodeList.add(new HuffmanNode('o', 1, "11100"));
        nodeList.add(new HuffmanNode('t', 1, "11101"));
        return nodeList;
    }

    /**
     * Answer to 2(a)
     * @return a list of BNodes
     */
    public static ArrayList<BNode> q2EncodeTree(){
        /*TODO: insert BNodes into a nodeList, where each node stores the data and path of a character */
        ArrayList<BNode> nodeList = new ArrayList<BNode>();
        //example of adding nodes to nodeList : nodeList.add(new BNode(Arrays.asList(17,24)));
        //Leafs
        nodeList.add(new BNode(Arrays.asList(16, 17, 24)));//0
        nodeList.add(new BNode(Arrays.asList(36)));//1
        nodeList.add(new BNode(Arrays.asList(43, 50)));//2
        nodeList.add(new BNode(Arrays.asList(60, 67, 70)));//3
        nodeList.add(new BNode(Arrays.asList(103)));//4
        //Internals
        nodeList.add(new BNode(Arrays.asList(32, 42)));//5
        nodeList.add(new BNode(Arrays.asList(78)));//6
        //root
        nodeList.add(new BNode(Arrays.asList(55)));//7
        //Root to its children
        nodeList.get(7).addChildren(nodeList.get(5));
        nodeList.get(7).addChildren(nodeList.get(6));
        //Internal node at index 5 to its children
        nodeList.get(5).addChildren(nodeList.get(0));
        nodeList.get(5).addChildren(nodeList.get(1));
        nodeList.get(5).addChildren(nodeList.get(2));
        //Internal node at index 6 to its children
        nodeList.get(6).addChildren(nodeList.get(3));
        nodeList.get(6).addChildren(nodeList.get(4));
        return nodeList;

    }

    public static void main(String[] args) {
        ArrayList<BNode> nodes = q2EncodeTree();
        System.out.println("number of nodes  = "+nodes.size());
        for(int i = nodes.size()-1;i>=0;i--){
            List<BNode> children = nodes.get(i).children;
            String output = "";
            output+="current data = "+nodes.get(i).data+"\n";
            output+="children = ";
            if(children.size()==0){
                output+="None";
            }
            for(int j=0;j<children.size();j++){
                output+=children.get(j).data;
            }
            System.out.println(output);
            System.out.println("____________________");
        }
    }
}
