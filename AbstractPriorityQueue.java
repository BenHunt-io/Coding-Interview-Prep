interface AbstractPriorityQueue<K,V> {
	
	int size();
	boolean isEmtpy();
	Entry<K,V> removeMin();
	Entry<K,V> min();
	Entry<K,V> insert(K key, V value);
}


