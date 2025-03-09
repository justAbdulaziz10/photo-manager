public class BST <T> {
	BSTNode<T> root, current;
	
	/** Creates a new instance of BST */
	public BST() {
		root = current = null;
	}
	
	public boolean empty() {
		return root == null;
	}
	
	public boolean full() {
		return false;
	}
	
	public T retrieve () {
		return current.data;
	}
	
	public boolean findkey(int tkey) {
		BSTNode<T> p = root, q = root;
				
		if(empty())
			return false;
		
		while(p != null) {
			q = p;
			if(p.key == tkey) {
				current = p;
				return true;
			}
			else if(tkey < p.key)
				p = p.left;
			else
				p = p.right;
		}
		
		current = q;
		return false;
	}
	
	public boolean insert(int k, T val) {
		BSTNode<T> p, q = current;
		
		if(findkey(k)) {
			current = q;  // findkey() modified current
			return false; // key already in the BST
		}
		
		p = new BSTNode<T>(k, val);
		if (empty()) {
			root = current = p;
			return true;
		}
		else {
			// current is pointing to parent of the new key
			if (k < current.key)
				current.left = p;
			else
				current.right = p;
			current = p;
			return true;
		}
	}
	
	public BooleanWrapper remove_key (int tkey){
		BooleanWrapper removed = new BooleanWrapper(false);
		BSTNode<T> p;
		p = remove_aux(tkey, root, removed);
		current = root = p;
		return removed;
	}
	
	private BSTNode<T> remove_aux(int key, BSTNode<T> p, BooleanWrapper flag) {
		BSTNode<T> q, child = null;
		if(p == null)
			return null;
		if(key < p.key)
			p.left = remove_aux(key, p.left, flag); //go left
		else if(key > p.key)
			p.right = remove_aux(key, p.right, flag); //go right
		else { // key is found
			flag.set( true);
			if (p.left != null && p.right != null){ //two children
				q = find_min(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove_aux(q.key, p.right, flag);
			}
			else {
				if (p.right == null) //one child
					child = p.left;
				else if (p.left == null) //one child
					child = p.right;
				return child;
			}
		}
		return p;
	}
	
	private BSTNode<T> find_min(BSTNode<T> p){
		if(p == null)
			return null;
		
		while(p.left != null){
			p = p.left;
		}
		
		return p;
	}
	
	public boolean update(int key, T data){
		remove_key(current.key);
		return insert(key, data);
	}
	
	public boolean removeKey(int k) {
		//Search for k
		int k1 =k;
		BSTNode<T> p=root;
		BSTNode<T> q=null;//parent of p
		while (p!=null) {
			if(k1<p.key) {
				q=p;
				p=p.left;
			}
			else if(k1>p.key) {
				q=p;
				p=p.right;
			}
			else {
				if ((p.left != null) && (p.right != null)) { 
					BSTNode<T> min = p.right;
					q=p;
					while(min.left!=null) {
						q=min;
						min=min.left;
					}
					p.key=min.key;
					p.data=min.data;
					k1=min.key;
					p=min;
				}
				if(p.left!=null) {
					p=p.left;
				}
				else {
					p=p.right;
				}
				if(q==null) {
					root=p;
				}
				else {
					if(k1<q.key) {
						q.left=p;
					}
					else {
						q.right=p;
					}
				}
				current=root;
				return true;
			}
		}
		
		return false;
		
	}
	
	

}





