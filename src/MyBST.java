// Implements a BST with BinaryNode nodes

public class MyBST
{
	public BinaryNode root;  // holds the root of this BST
	private StringBuilder sb;

	// Constructor: creates an empty BST.
	public MyBST()
	{
		root = null;
		sb = new StringBuilder("[");
	}

	public BinaryNode getRoot() {
		return root;
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(Comparable value)
	{
		if(root == null)
			return false;
		return containsHelper(root, value);
	}
	
	public boolean containsHelper(BinaryNode node, Comparable value)
	{
		if(node == null)
			return false;
		else if (node.getValue().equals(value))
			return true;
		if(node.getValue().compareTo(value) < 0)
			return containsHelper(node.getRight(), value);
		else
			return containsHelper(node.getLeft(), value);
	}
	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(Comparable value)
	{
		if(contains(value))
			return false;
		else if(root == null)
		{
			root = new BinaryNode(value);
			return true;
		}
		else
		{
			addHelper(root, value);
			return true;
		}
	}
	
	public BinaryNode addHelper(BinaryNode node, Comparable value)
	{
		if (node == null)
        {
            node = new BinaryNode(value);
            return node;
        }
        if (node.getValue().compareTo(value) > 0)
        	node.setLeft(addHelper(node.getLeft(), value));
        else if (node.getValue().compareTo(value) < 0)
        	node.setRight(addHelper(node.getRight(), value));
        return node;
	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	public boolean remove(Comparable value)
	{
		if(!contains(value))
			return false;
		else if(root.getValue().equals(value) && root.getLeft() == null && root.getRight() == null)
			root = null;
		else
			removeHelper(root, value);
		return true;
	}
	
	public BinaryNode removeHelper(BinaryNode node, Comparable value)
	{
        BinaryNode parent = null;
        BinaryNode currentNode = node;
        while (currentNode != null && !currentNode.getValue().equals(value))
        {
            parent = currentNode;
            if (value.compareTo(currentNode.getValue()) < 0)
                currentNode = currentNode.getLeft();
            else 
                currentNode = currentNode.getRight();
        }
        if (currentNode == null) 
        {
            return node;
        }
        if (currentNode.getLeft() == null && currentNode.getRight() == null)
        {
            if (!currentNode.equals(node))
            {
                if (currentNode.equals(parent.getLeft())) 
                    parent.setLeft(null);
                else
                    parent.setRight(null);
            }
            else
                node = null;
        }
        else if (currentNode.getLeft() != null && currentNode.getRight() != null)
        {
            BinaryNode next = getMin(currentNode.getRight());
            Comparable nextValue = next.getValue();
            removeHelper(node, next.getValue());
            currentNode.setValue(nextValue);
        }
        else 
        {
        	BinaryNode child = currentNode.getLeft();
        	if(currentNode.getLeft() == null)
        	{	
        		child = currentNode.getRight();
        	}
            if (!currentNode.equals(node))
            {
                if (currentNode.equals(parent.getLeft()))
                	parent.setLeft(child);
                else
                    parent.setRight(child);
            }
            else {
            	if(node.equals(root))
            	{
            		root = child;
            	}
                node = child;
            }
        }
        return node;
	}
	
	public BinaryNode getMin(BinaryNode node)
	{
		BinaryNode min = node;
		while(node.getLeft() != null)
		{
			min = node.getLeft();
			node = node.getLeft();
		}
		return min;
	}

	// Returns a bracket-surrounded, comma separated list of the contents of the nodes, in order
	// e.g. ["Apple", "Cranberry", "Durian", "Mango"]
	public String toString()
	{
		String temp;
		if(root != null)
		{
			order(root);

			sb.deleteCharAt(sb.length() - 1);
			sb.deleteCharAt(sb.length() - 1);
		}
		temp = sb.toString();
		sb.delete(1, sb.length());
		return (temp + "]");
	}
	
	public void order(BinaryNode node)
	{
		if(node != null)
		{
			order(node.getLeft());
            sb.append(node.getValue() + ", ");
            order(node.getRight());
		}
    }


}
