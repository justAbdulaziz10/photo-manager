public class BST <T> {
	BSTNode<T> root, current;
	static int bstComparisons=0;
	
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
			bstComparisons++;
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
			current = q;  
			return false; 
		}
		
		p = new BSTNode<T>(k, val);
		if (empty()) {
			root = current = p;
			return true;
		}
		else {
			if (k < current.key)
				current.left = p;
			else
				current.right = p;
			current = p;
			return true;
		}
	}
	
	public boolean remove_key(int tkey) {
	    boolean wasRemoved = false;
	    root = remove_aux(tkey, root, wasRemoved);
	    current = root;
	    return wasRemoved;
	}
	
	private BSTNode<T> remove_aux(int key, BSTNode<T> p, boolean wasRemoved) {
		BSTNode<T> q, child = null;
		if(p == null)
			return null;
		if(key < p.key)
			p.left = remove_aux(key, p.left, wasRemoved); 
		else if(key > p.key)
			p.right = remove_aux(key, p.right, wasRemoved); 
		else { 
			wasRemoved= true;
			if (p.left != null && p.right != null){ 
				q = find_min(p.right);
				p.key = q.key;
				p.data = q.data;
				p.right = remove_aux(q.key, p.right, wasRemoved);
			}
			else {
				if (p.right == null) 
					child = p.left;
				else if (p.left == null) 
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
		int k1 =k;
		BSTNode<T> p=root;
		BSTNode<T> q=null;
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





