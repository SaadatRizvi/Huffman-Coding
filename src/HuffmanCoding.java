import java.util.HashMap;

public class HuffmanCoding {
	
	public static HashMap<Character,String> WrapperAssignCodeAndTraverse(Node root,int size){
	
		HashMap<Character,String> codes = new HashMap<Character,String>(size);
		System.out.println("Assigned codes: ");
		assignCodeAndTraverse(root,"",codes);
		return codes;
		
	}


	private static void assignCodeAndTraverse(Node node, String code,HashMap<Character,String> codes){
		
		if(node.left == null && node.right == null){
			codes.put(node.c, code);
			System.out.println(node.c+": "+code);
			return;
		}
		
		assignCodeAndTraverse(node.left,code+"0",codes);
		assignCodeAndTraverse(node.right,code+"1",codes);
		
	}
	
	public static Node createHuffmanTree(char[] array, int[] frequency){
		
			int n=array.length;

			MinHeap heap = new MinHeap(n);
	        
	        for(int i=0;i<n;i++){
	        	heap.add(new Node(frequency[i],array[i]));
	        }
	        
	        Node root = null;
	        
	        while(heap.getSize() > 1){
	        	
	        	Node t1 = heap.poll();
	        	Node t2 = heap.poll();
	        
	        	Node t3 = new Node(t1.frequency+t2.frequency,'-');
	        	t3.left = t1;
	        	t3.right = t2;
	        	root = t3;
	        	heap.add(t3);
	        }
	      return root;
	}
	
	public static String calculateHuffmanCode(HashMap<Character,String> codes, String input){
		
		String answer="";		
		for(int i=0;i<input.length();i++){
			answer+=codes.get(input.charAt(i));
		}
		
		return answer;
	}
	
	public static void main(String[] args) {

		
		char[] array    = { 's', 'y', 'e', 'd' };
        int[]  frequency = { 4,   3,   7,   0};
		int n=array.length;
		String input="syed";
		Node root = createHuffmanTree(array, frequency);
        HashMap<Character,String> codes;
       codes = WrapperAssignCodeAndTraverse(root,n);
       System.out.println("Huffman Code: "+ calculateHuffmanCode(codes, input));
	}

}
