public class MyHashTable<K, V> {
    class HashNode<K, V> {
       private K key;
       private V value;
       private HashNode<K, V> next;
       public HashNode (K key, V value){
           this.key = key;
           this.value = value;

       }
       public HashNode<K, V> getNext() {
            return next;
        }
       @Override
        public String toString(){
           return  "{" + key + " " + value + "}";
       }
    }

    private HashNode<K, V>[] chainArray;

    private int M = 11;

    private int size;
    public MyHashTable(){
        chainArray = new HashNode[11];
        size = 0;
    }
    public MyHashTable(int M){
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    private int hash(K key) {
        return Math.abs(key.hashCode() % M);
    }
    public void put(K key, V value){
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null){
            if (node.key.equals(key)){
                return;

            }
            node = node.next;
        }
        chainArray[index] = new HashNode<>(key, value);
        size++;
    }
    public V get(K key){
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        while(node != null){
            if(node.key.equals(key)) {
                return node.value;
            }
            node = node.next;

        }
        return null;

    }
    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> prev = null;
        HashNode<K, V> node = chainArray[index];
        while(node != null){
            if(node.equals(key)){
                return node.value;
            }
            prev = node;
            node = node.next;
            if(prev == null){
                chainArray[index] = node.next;
            }
            else{
                prev.next = node.next;

            }
            size--;
            return node.value;

        }
        return null;

    }
    public boolean contains(V value){
        for(int i = 0; i < M; i++){
            HashNode<K, V> node = chainArray[i];
            while (node != null){
                if(node.value.equals(value)){
                    return true;
                }
                node = node.next;

            }
        }
        return false;
    }
    public K getKey(V value){
        for(int i = 0; i < M; i++){
            HashNode<K, V> node = chainArray[i];
            while(node != null){
                if(node.equals(value)){
                    return node.key;
                }
                node = node.next;
            }
        }
        return null;
    }
    public HashNode<K, V> [] getChainArray(){
        return chainArray;
    }

}
