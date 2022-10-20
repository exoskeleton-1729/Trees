
public class BST_Tester {
	public static void main(String[] args)
	{
		MyBST bst = new MyBST();
		System.out.println(bst.add(51));
		bst.add(41);
		bst.add(32);
		bst.add(20);
		bst.add(12);
		bst.add(120);
		bst.add(200);
		bst.add(320);
		bst.add(410);
		System.out.println(bst.toString());
		bst.remove(41);
		bst.remove(32);
		bst.remove(20);
		bst.remove(12);
		bst.remove(120);
		bst.remove(200);
		bst.remove(320);
		bst.remove(410);
		bst.remove(51);
		System.out.println(bst.toString());
	}
}
