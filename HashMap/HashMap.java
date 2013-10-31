package HashMap;

import java.util.LinkedList;
/*这题的几个注意点：
 * 1.need to remember the data structure we use
 * 2.Cell的几个property 是 private，要用 set get function
 * 3.If the key is same, need to replace the old one
 * (optional)4. hashcode() and equals() function 
 * 	*/
public class HashMap<K,V> {
	LinkedList<Cell<K,V>>[] items;
	
	HashMap(){
		items=((LinkedList<Cell<K, V>>[])new LinkedList[10]);//very important, must remember!!!!!
	}
	
	public void put(K key, V val){
		int index=keyhash(key)%items.length;
		
		if(items[index]==null){
			items[index]=new LinkedList<Cell<K,V>>();
			items[index].add(new Cell<K,V>(key,val));
		}else{
			LinkedList<Cell<K,V>> temp=items[index];
			for(Cell<K,V> c:temp){//删除相同key的cell
				if(c.equal(key)){
					temp.remove(c);
					break;
				}
			}
			temp.add(new Cell<K,V>(key,val));
		}
	}
	
	public V get(K k){
		int index=keyhash(k)%items.length;
		if(items[index]==null)
			return null;
		else{
			for(Cell<K,V> c:items[index]){
				if(c.equal(k))
					return c.getVlaue();
			}
			return null;
		}
	}
	
	public int keyhash(K key){
		return key.hashCode();
	}
	
}

class Cell<K,V>{
	private K key;
	private V val;
	Cell(K k, V v){
		key=k;
		val=v;
	}
	
	public boolean equal(K k){
		if(k==this.key)
			return true;
		return false;
	}
	public V getVlaue(){
		return val;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((val == null) ? 0 : val.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (val == null) {
			if (other.val != null)
				return false;
		} else if (!val.equals(other.val))
			return false;
		return true;
	}
}


