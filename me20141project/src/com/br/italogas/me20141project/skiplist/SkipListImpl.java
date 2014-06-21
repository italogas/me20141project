package com.br.italogas.me20141project.skiplist;

public class SkipListImpl<V> implements SkipList<V> {

	protected SkipNode<V> root;
	protected int level;
	protected int maxLevel;

	//SET THIS VALUE TO TRUE IF YOU ARE IMPLEMENTING MAX_LEVEL = LEVEL
	//SET THIS VALUE TO FALSE IF YOU ARE IMPLEMENTING MAX_LEVEL != LEVEL
	protected boolean useMaxLevelAsLevel = true;
	protected double probability = 0.5; 
	protected SkipNode<V> NIL;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SkipListImpl(int maxLevel) {
		if(useMaxLevelAsLevel){
			this.level = maxLevel;
		}else{
			this.level = 1;
		}
		this.maxLevel = maxLevel;
		root = new SkipNode(Integer.MIN_VALUE, maxLevel, new Integer(Integer.MIN_VALUE));
		NIL = new SkipNode(Integer.MAX_VALUE, maxLevel, new Integer(Integer.MAX_VALUE));
		connectRootToNil();
	}
	
	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL
	 * Caso esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com 
	 * level=1 e o metodo deve conectar apenas o forward[0].  
	 */
	private void connectRootToNil(){
		for(int i = 0; i < level; i++){
			root.forward[i] = NIL;
		}
	}
	
	/**
	 * Metodo que gera uma altura aleatoria para ser atribuida a um novo no no metodo
	 * insert(int,V) 
	 */
	private int randomLevel(){
		int randomLevel = 1;
		while(Math.random() <= probability && randomLevel < maxLevel){
			randomLevel = randomLevel + 1;
		}
		return randomLevel;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void insert(int key, V newValue) {
		SkipNode<V>[] update = new SkipNode[maxLevel];
		SkipNode<V> x = root;
		for(int i = level-1; i >= 0; i--){
			while(x.forward[i].key < key){
				x = x.forward[i];
			}
			update[i] = x;
		}
		x = x.forward[0];
		if(x.key == key){
			x.satteliteData = newValue;
		} else {
			int v = randomLevel();
			if(v > level){
				for(int i = level; i < v; i++){
					update[i] = root;
				}
				level = v;
			}
			x = new SkipNode<V>(key, v, newValue);
			for(int i = 0; i <= v-1; i++){
				x.forward[i] = update[i].forward[i];
				update[i].forward[i] = x;
			}
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(int key, V newValue, int height) {
		SkipNode<V>[] update = new SkipNode[maxLevel];
		SkipNode<V> x = root;
		for(int i = level-1; i >= 0; i--){
			while(x.forward[i].key < key){
				x = x.forward[i];
			}
			update[i] = x;
		}
		x = x.forward[0];
		if(x.key == key){
			x.satteliteData = newValue;
		} else {
			if(height > level){
				for(int i = level; i < height; i++){
					update[i] = root;
				}
				level = height;
			}
			x = new SkipNode<V>(key, height, newValue);
			for(int i = 0; i <= height-1; i++){
				x.forward[i] = update[i].forward[i];
				update[i].forward[i] = x;
			}
		}
		
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(int key) {
		SkipNode<V>[] update = new SkipNode[maxLevel];
		SkipNode<V> x = root;
		for(int i = level-1; i >= 0; i--){
			while(x.forward[i].key < key){
				x = x.forward[i];
			}
			update[i] = x;
		}
		x = x.forward[0];
		if(x.key == key){
			for(int i = 0; i < level; i++){
				if(!update[i].forward[i].equals(x)){
					break;
				}
				update[i].forward[i] = x.forward[i];
				
				while(level > 0 && root.forward[level-1].equals(NIL)){
					level = level - 1;
				}
			}
		} 
	}

	@Override
	public int height() {
		SkipNode<V> x = root;
		int height = 0;
		while(!x.forward[0].equals(NIL)){
			if(x.forward[0].forward.length > height){
				height = x.forward[0].forward.length;
			}
			x = x.forward[0];
		}
		return height;
	}

	@Override
	public SkipNode<V> search(int key) {
		SkipNode<V> x = root;
		for(int i = level-1; i >= 0; i--){
			while(x.forward[i].key < key){
				x = x.forward[i];
			}
		}
		x = x.forward[0];
		if(x.key == key){
			return x;
		}
		return null;
	}

	@Override
	public int size(){
		SkipNode<V> x = root;
		int size = 0;
		while(!x.forward[0].equals(NIL)){
			size += 1;
			x = x.forward[0];
		}
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SkipNode<V>[] toArray() {
		SkipNode<V>[] array = new SkipNode[size()+2];
		SkipNode<V> x = root;
		for(int i = 0; i < size()+2; i++){
			array[i] = x;
			x = x.forward[0];
		}
		return array;
	}

}
