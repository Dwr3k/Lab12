
public class BSTNode<K extends Comparable<K>,V> extends BinaryNode<K,V>{

	BSTNode(K aKey, V aValue) {
		super(aKey, aValue);
	}

	BSTNode(K aKey, V aValue, BinaryNode<K,V> aLeft, BinaryNode<K,V> aRight){
		super(aKey,aValue,aLeft,aRight);
	}

	public void add(K aKey, V aValue) {
		add(aKey,aValue,this);
	}

	private void add(K aKey, V aValue, BinaryNode<K,V> root) {		
		if(aKey.compareTo(root.key) < 0) 
		{
			if(root.left != null)
			{
				add(aKey, aValue, root.left);
			}
			else
			{
				root.left = new BinaryNode<K,V>(aKey, aValue);
			}
		}
		else if(aKey.compareTo(root.key) > 0) 
		{
			if(root.right != null)
			{
				add(aKey, aValue, root.right);
			}
			else
			{
				root.right = new BinaryNode<K,V>(aKey, aValue);
			}
		}
		else 
		{
			throw new IllegalStateException("All keys must be unique");
		}
	}

	public V search(K aKey) {
		return search(aKey,this);
	}

	private V search(K aKey,BinaryNode<K,V> root) 
	{
		if (root == null) 
		{
			return null;
		}
		else if(aKey.compareTo(root.key) < 0) 
		{
			return search(aKey, root.left);
		}
		else if(aKey.compareTo(root.key) > 0) 
		{
			return search(aKey, root.right);
		}
		else 
		{
			return root.value;
		}
	}

	public V remove(K aKey) {
		return remove(aKey,this,null,true);
	}

	private V remove(K aKey, BinaryNode<K,V> root, BinaryNode<K,V> parent, boolean left) 
	{
		//Use recursion to find the node being removed. If the node is not in the tree return null.
		//Recursive calls keep track of the current node, its parent, 
		//and if the current node is the left or right child of the parent. 
		if(aKey.compareTo(root.key) < 0) 
		{
			if(root.left == null)
			{
				return null;
			}

			return remove(aKey, root.left, root, true);
		}
		else if(aKey.compareTo(root.key) > 0) 
		{
			if(root.right == null)
			{
				return remove(aKey, root.right, root, false);
			}
		}
		//This condition is only reached when the node to be removed is found. 
		else 
		{
			//newChild is the node replacing the removed node. 
			//More formally, it is the new child of the removed nodes parent. 
			//Which child (left or right) is determined by the left parameter. 
			BinaryNode <K,V> newChild = null;
			//Here we implement our removal algorithms
			//In the following code the "root" is the node being removed
			//If the root has no children, the newChild is null
			if(root.left == null && root.right == null) {
				newChild = null;
			}
			//If the root has both a left and right child...
			else if(root.left != null && root.right != null) {
				//We find the smallest node in the removed nodes right subtree

				BinaryNode<K,V> rootNode = root;
				BinaryNode<K,V> smallestNode = root.right;

				//If the root of the removed nodes right subtree is the smallest value in the subtree
				//Set the removed node's right child to its right grand-child. 

				if(smallestNode.left == null)
				{
					root.right = smallestNode.right;
				}

				//Else, find the smallest value in the removed nodes right subtree 
				//When the smallest node is found, take its right subtree and make it it's parents left child.
				//If the smallest node does not have a right subtree, then we make its parents left child null.
				//This is done to remove the smallest node from the tree (so it doesn't show up twice)

				else	
				{
					while (smallestNode.left != null)	
					{
						rootNode = smallestNode;
						smallestNode = smallestNode.left;
					}
					if(smallestNode.right != null)
					{
						rootNode.left = smallestNode.right;
					}
					else
					{
						rootNode.left = null;
					}
				}

				//Make the newChild the smallest node in the removed nodes right subtree

				newChild = smallestNode;

				//Make the newChild's children the children of the removed node

				newChild.right = rootNode.left;
				newChild.left = rootNode.right;

			}
			//If the root has a left child, make the new child the root's left child
			else if(root.left != null) 
			{
				newChild = root.left;
			}
			//If the root has a right child, make the new child the roots' right child
			else if(root.right != null) 
			{
				newChild = root.right;
			}

			//Edge case for handling the removal of the root
			if(parent == null) 
			{
				if(newChild == null) {
					throw new IllegalStateException("Can't remove root from tree of height zero");
				}
				//TODO Make this warning go away! 
				V toReturn = root.value;
				this.key = newChild.key; this.value = newChild.value; this.left = newChild.left; this.right = newChild.right;
				return toReturn;
			}

			//Replace the root (node being removed) with the new child. 
			//We have both a reference to the removed node's parent and a boolean indicating if the removed node is a 
			//left or right child
			if(left) {parent.left = newChild;}
			else {parent.right = newChild;}
			return root.value;
		}
		return null;
	}

}
