package app;

import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {

  private int size;
  private Node<T> head = null;
  private Node<T> tail = null;
  private Node<T> current = null;

  public RecursiveList() {
    this.head = null;
    this.size = 0;
  }

  public RecursiveList(Node<T> first) {
    this.head = first;
    this.size = 1;
  }


  @Override
  public int size() {
    return size;
  }

  @Override
  public void insertFirst(T elem) throws NullPointerException{
      //TODO: Implement this method.
    if(elem == null){
      throw new NullPointerException();
    }
    if(size == 0){
      head.setData(elem);
      tail.setData(elem);
      head.setNext(null);
      tail.setNext(null);
    }
    Node<T> temp = null;
    temp.setData(head.getData());
    temp.setNext(head.getNext());
    head.setData(elem);
    size++;
  }

  @Override
  public void insertLast(T elem) throws NullPointerException{
      //TODO: Implement this method.
    if(elem == null){
      throw new NullPointerException();
    }
    if(size == 0){
      head = new Node<T>(elem, null);
      tail = new Node<T>(elem, null);
      size++;
    }
    else{
      Node<T> temp = new Node<T>(tail.getData(), tail);
      tail.setData(elem);
      size++;
    }
  }

  @Override
  public void insertAt(int index, T elem) throws NullPointerException, IndexOutOfBoundsException{
      //TODO: Implement this method.
    if(elem == null){
      throw new NullPointerException();
    }
    else if(index < 0){
      throw new IndexOutOfBoundsException();
    }
    current = insertAndRemoveHelper(get(index), head);
    Node<T> newElement = null;
    newElement.setData(elem);
    newElement.setNext(current.getNext());
    current.setNext(newElement);
    size++;
  }

  private void insertAtHelper(Node<T> current, int index, Node<T> head){

  }

  @Override
  public T removeFirst() throws IllegalStateException{
    T removedItem = null;
      //TODO: Implement this method.
    if(size == 0){
      throw new IllegalStateException();
    }
    removedItem = getFirst();
    remove(getFirst());
    size--;
    return removedItem;
  }

  @Override
  public T removeLast() throws IllegalStateException{
    T removedItem = null;
      //TODO: Implement this method.
    if(size == 0){
      throw new IllegalStateException();
    }
    removedItem = getLast();
    remove(getLast());
    size--;
    return removedItem;
  }

  @Override
  public T removeAt(int i) throws IndexOutOfBoundsException{
    T removedItem = null;
      //TODO: Implement this method.
    if( i < 0 || i > size){
      throw new IndexOutOfBoundsException();
    }
    removedItem = get(i);
    remove(removedItem);
    size--;
    return removedItem;
  }

  @Override
  public T getFirst() throws IllegalStateException{
    T item = null;
      //TODO: Implement this method.
    if( size == 0){
      throw new IllegalStateException();
    }
    item = head.getData();
    return item;
  }

  @Override
  public T getLast() throws IllegalStateException{
    T item = null;
      //TODO: Implement this method.
    if( size == 0){
      throw new IllegalStateException();
    }
    item = tail.getData();
    return item;
  }

  @Override
  public T get(int i) throws IndexOutOfBoundsException{
    T item = null;
      //TODO: Implement this method.
    if( i < 0 || i > size){
      throw new IndexOutOfBoundsException();
    }
    item = getHelper(i, 0, head);

    return item;
  }

  public T getHelper(int index, int counter, Node<T> node){
    if( counter == index){
      return node.getData();
    }
    getHelper(index, counter++, node.getNext());
    return node.getData();
  }

  @Override
  public void remove(T elem) throws NullPointerException{
      //TODO: Implement this method.
    if( elem == null){
      throw new NullPointerException();
    }
    if(head.getData() == elem){
      head.setData((head.getNext()).getData());
      head.setNext((head.getNext()).getNext());
      size--;
    }
    else{
      Node<T> prev = insertAndRemoveHelper(elem, head);
      current = prev.getNext();
      prev.setNext(current.getNext());
      if( prev.getNext() == null){
        tail = prev;
      }
      size--;
    }
  }

  public Node<T> insertAndRemoveHelper(T elem, Node<T> node) throws ItemNotFoundException{
    if(node == head){
      if( node.getData() == elem){
        return head;
      }
    }
    if((node.getNext().getData()) == elem){
      return node;
    }
    insertAndRemoveHelper(elem, node.getNext());
    throw new ItemNotFoundException();
  }

  @Override
  public int indexOf(T elem) throws NullPointerException{
    int index = -1;
      //TODO: Implement this method.
    if( elem == null){
      throw new NullPointerException();
    }
    return indexOfHelper(elem, index, head);
  }

  public int indexOfHelper(T elem, int index, Node<T> node){
    if( node.getData().equals(elem) ){
      return index;
    }
    if( node.getData() == null){
      return -1;
    }
    indexOfHelper(elem, index++, node.getNext());
    return index;
    // if( node.getData() == elem ){
    //   return index;
    // }
    // if( index == -1){
    //   index = 0;
    // }
    // indexOfHelper(elem, index++, node.getNext());
    // return index;
  }


  @Override
  public boolean isEmpty() {
    boolean empty = false;
      //TODO: Implement this method.
    if(size == 0){
      empty = true;
    }
    else {
      empty = false;
    }
    return empty;
  }


  public Iterator<T> iterator() {
    Iterator<T> iter = null;
      //TODO: Implement this method.
   return iter;
}

}
