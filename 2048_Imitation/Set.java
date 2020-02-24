/**
  * Filename: Set.java
  * Name: Brandon Nguyen
  * Login: cs8bwi20pp@ieng6.ucsd.edu
  * Date: 11 February 2020
  * Sources of Help: Stack Overflow, Geeks for Geeks, Notes
  * This file contains code for the Set class. This public class
  * extends the UnorderedDS class, which extends the Data Structure class,
  * which implements the BasicMethods interface.
 */

/**
 * This class contains the objects and methods that stores elements
 * in an array without any particular order.
 */

public class Set extends UnorderedDS{
  //Integer variable for maximum size of the array
  private int maxSize;
  //String message indicating that a similar element already exists
  private static final String DUPLICATE_ERROR = "Element already exists";
  //String message indicating that the list is full
  private static final String MAX_SIZE_ERROR = "Set maximum limit reached";

 /**
 * This constructor creates a new Set object
 */
  public Set(){
    this.maxSize = 0;
    this.array = null;
  }

/**
 * This constructor creates a new Set object
 * @param maxSize integer value that determines size of the list
 */
  public Set(int maxSize){
    if(maxSize > 0){
      this.maxSize = maxSize;
      this.array = new int[this.maxSize];
    }
    else{
      this.maxSize = 0;
      this.array = null;
    }
  }

/**
 * This constructor creates a new Set object
 * @param s LifoList object to be deep-copied
 */
  public Set(Set s){
    if(s == null){
      this.maxSize = 0;
      this.array = null;
    }
    else{
      this.maxSize = s.maxSize;
      this.array = new int[this.maxSize];
      for(int i = 0; i < s.array.length; i++){
        this.array[i] = s.array[i];
      }
    }
  }

/**
 * This method adds an element into the list
 * @param element integer value to be added into the list
 */
  @Override
  public void add(int element){
    //Check to see if array is null
    if(this.array == null){
      System.out.println(MAX_SIZE_ERROR);
      return;
    }
    //Counts number of non-zero values
    int element_count = 0;
    for(int i = 0; i < this.array.length; i++){
      if(this.array[i] != 0){
          element_count += 1;
      }
    }
    //Checks to see if array is full
    if(element_count == this.array.length){
      System.out.println(MAX_SIZE_ERROR);
      return;
    }
    //Checks for duplicates
    for(int i = 0; i < this.array.length; i++){
      if(this.array[i] == element){
        System.out.println(DUPLICATE_ERROR);
        return;
      }
    }
    //Inserts in element at nearest non-zero index
    for(int i = 0; i < this.array.length; i++){
      if(this.array[i] == 0){
        this.array[i] = element;
        return;
      }
    }

  }

/**
 * This method returns an integer indicating size of list
 */
  @Override
  public int size(){
    int array_size = 0;
    for(int i = 0; i < this.maxSize; i++){
      if(this.array[i] != 0){
        array_size += 1;
      }
    }
    return array_size;
  }

/**
 * This method returns a SortedList object based
 */
  @Override
  public SortedList toSortedList(){
    int num_elements = 0;
    //Create a new SortedList variable to be returned
    SortedList transform = new SortedList(this.maxSize);
    //Checks to see if the array is null
    if(this.array == null){
      //Returns a new unmodified SortedList
      SortedList failedTransform = new SortedList();
      return failedTransform;
    }
    //Counts number of elements, excluding zeros
    for(int i = 0; i < this.array.length; i++){
      if(this.array[i] != 0){
        num_elements += 1;
      }
    }
    //Uses temporary variable to help sort the array
    int temp = 0;
    for(int i = 0; i < this.array.length - (this.array.length - num_elements) + 1; i++){
      for(int j = i + 1; j < this.array.length - (this.array.length - num_elements); j++){
        if(this.array[i] > this.array[j]){
          temp = this.array[i];
          this.array[i] = this.array[j];
          this.array[j] = temp;
          }
        }
      }
    //Makes SortedList object match this list.
    for(int i = 0; i < this.array.length; i++){
        transform.array[i] = this.array[i];
    }
    return transform;
  }

}
