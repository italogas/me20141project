package com.br.italogas.me20141project.bst.adt.bst;


/**
 * Implementacao de BST utilizada em LEDA
 * @author Ítalo
 *
 * @param <T>
 */
public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected  BSTNode<T> root;
	private T[] arrayPercurso;
	private int indice;
	
	
	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot(){
		return this.root;
	}
	
	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}

	private int height(BSTNode<T> node) {
		if(node.isEmpty()){
			return -1;
		} else {
			int he = height((BSTNode<T>) node.getLeft());
			int hd = height((BSTNode<T>) node.getRight());
			if(he < hd){
				return hd + 1;
			} else {
				return he + 1;
			}
		}
	}
	
	// exercise list
	public int numberOfLeafs(){
		return numberOfLeafs(root);
	}
	
	private int numberOfLeafs(BSTNode<T> node){
		if(!node.isEmpty()){
			if(node.getLeft().isEmpty() && node.getRight().isEmpty()){
				return 1;
			} else {
				int l = numberOfLeafs((BSTNode<T>) node.getLeft());
				int r = numberOfLeafs((BSTNode<T>) node.getRight());
				
				return l + r;
			}
		} else {
			return 0;
		}
	}
	
	// exercise list
	// it checks if two BStrees are equal
	public boolean equalTrees(BST<T> tree){
		return equalNodes(root, tree.getRoot());
	}

	private boolean equalNodes(BTNode<T> thisNode, BTNode<T> node) {
		if(thisNode.isEmpty() && node.isEmpty()){
			return true;
		} else if(!thisNode.equals(node)){
			return false;
		}
		return equalNodes(thisNode.getLeft(), node.getLeft()) && equalNodes(thisNode.getRight(), node.getRight());
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> aux = root;
		while(!aux.isEmpty() && !element.equals(aux.getData())){
			if(element.compareTo(aux.getData()) < 0){
				aux = (BSTNode<T>) aux.getLeft();
			} else {
				aux = (BSTNode<T>) aux.getRight();
			}
		}
		return aux;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(T element) {
		BSTNode<T> auxY = new BSTNode<>();
		BSTNode<T> auxX = root;
		while(!auxX.isEmpty()){
			auxY = auxX;
			if(element.compareTo(auxX.getData()) < 0){
				auxX = (BSTNode<T>) auxX.getLeft();
			} else {
				auxX = (BSTNode<T>) auxX.getRight();
			}
		}
		BSTNode<T> node = new BSTNode<>();
		node.setData(element);
		node.setParent(auxY);
		node.setLeft((BTNode<T>) new BSTNode<>());
		node.setRight((BTNode<T>) new BSTNode<>());
		if(auxY.isEmpty()){
			root = node;
		} else if(element.compareTo(auxY.getData()) < 0){
			auxY.setLeft(node);
		} else {
			auxY.setRight(node);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if(root.isEmpty()){
			return null;
		}
		BSTNode<T> aux = root;
		while(!aux.getRight().isEmpty()){
			aux = (BSTNode<T>) aux.getRight();
		}
		return aux;
	}

	@Override
	public BSTNode<T> minimum() {
		if(root.isEmpty()){
			return null;
		}
		BSTNode<T> aux = root;
		while(!aux.getLeft().isEmpty()){
			aux = (BSTNode<T>) aux.getLeft();
		}
		return aux;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		if(!node.getRight().isEmpty()){
			BSTNode<T> aux = (BSTNode<T>) node.getRight();
			while(!aux.getLeft().isEmpty()){
				aux = (BSTNode<T>) aux.getLeft();
			}
			return aux;
		}
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while(!parent.isEmpty() && node == parent.getRight()){
			node = parent;
			parent = (BSTNode<T>) parent.getParent();
		}
		if(parent.isEmpty()){
			return null;
		}
		return parent;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);	
		if(!node.getLeft().isEmpty()){
			BSTNode<T> aux = (BSTNode<T>) node.getLeft();
			while(!aux.getRight().isEmpty()){
				aux = (BSTNode<T>) aux.getRight();
			}
			return aux;
		}
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while(!parent.isEmpty() && node == parent.getLeft()){
			node = parent;
			parent = (BSTNode<T>) parent.getParent();
		}
		if(parent.isEmpty()){
			return null;
		}
		return parent;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		if(node.isEmpty()){
			return;
		}
		BSTNode<T> auxY;
		BSTNode<T> auxX;
		if(node.getLeft().isEmpty() || node.getRight().isEmpty()){
			auxY = node;
		} else {
			auxY = sucessor(element);
		}
		if(!auxY.getLeft().isEmpty()){
			auxX = (BSTNode<T>) auxY.getLeft();
		} else {
			auxX = (BSTNode<T>) auxY.getRight();
		}
		if(!auxX.isEmpty()){
			auxX.setParent(auxY.getParent());
		}
		if(auxY.getParent().isEmpty()){
			root = auxX;
		} else if(auxY.equals(auxY.getParent().getLeft())){
			auxY.getParent().setLeft(auxX);
		} else {
			auxY.getParent().setRight(auxX);
		}
		if(!node.equals(auxY)){
			node.setData(auxY.getData());
		}
		return;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public T[] preOrder() {
		arrayPercurso = (T[]) new Comparable[size()];
		indice = 0;
		preOrder(root);
		return arrayPercurso;
	}

	private void preOrder(BSTNode<T> node) {
		if(!node.isEmpty()){
			addToArray(node.getData());
		} else {
			return;
		}
		preOrder((BSTNode<T>) node.getLeft());
		preOrder((BSTNode<T>) node.getRight());
		return;
		
	}

	private void addToArray(T data) {
		arrayPercurso[indice] = data;
		indice++;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		arrayPercurso = (T[]) new Comparable[size()];
		indice = 0;
		order(root);
		return arrayPercurso;
	}

	private void order(BSTNode<T> node) {
		if(!node.isEmpty()){
			order((BSTNode<T>) node.getLeft());
		} else {
			return;
		}
		addToArray(node.getData());
		order((BSTNode<T>) node.getRight());
		return;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		arrayPercurso = (T[]) new Comparable[size()];
		indice = 0;
		postOrder(root);
		return arrayPercurso;
	}

	private void postOrder(BSTNode<T> node) {
		if(!node.isEmpty()){
			postOrder((BSTNode<T>) node.getLeft());
		} else {
			return;
		}
		postOrder((BSTNode<T>) node.getRight());
		addToArray(node.getData());
		return;
	}
	
	// exercise list
	@SuppressWarnings("unchecked")
	public T[] descendingOrder() {
		arrayPercurso = (T[]) new Comparable[size()];
		indice = 0;
		descendingOrder(root);
		return arrayPercurso;
	}

	private void descendingOrder(BSTNode<T> node) {
		if(!node.isEmpty()){
			descendingOrder((BSTNode<T>) node.getRight());
		} else {
			return;
		}
		addToArray(node.getData());
		descendingOrder((BSTNode<T>) node.getLeft());
		return;
	}

	@Override
	public int size() {
		return size(root);
	}
	private int size(BSTNode<T> node){
		int result = 0;
		if(!node.isEmpty()){
			result = 1 + size((BSTNode<T>)node.getLeft()) + size((BSTNode<T>)node.getRight());
		}
		return result;
	}

}
