/**
  * Filename: SortedList.java
  * Name: Brandon Nguyen
  * Login: cs8bwi20pp@ieng6.ucsd.edu
  * Date: 11 February 2020
  * Sources of Help: Stack Overflow, Geeks for Geeks, Notes
  * This file contains code for the SortedList class. This public class
  * extends the OrderedDS class, which extends the Data Structure class,
  * which implements the BasicMethods interface.
 */

 /**
 * This class contains the objects and methods that will organize
 * a list of numbers based on numerical order.
 */

public class SortedList extends OrderedDS{
  //Integer variable for maximum size of the array
  private int maxSize;
  //String variable for the spacer used when printing list out in a string
  private static final String spacer = "-";
  //String message indicating that the list has no values
  private static final String EMPTY_ERROR = "SortedList is empty";
  //String message indicating that the list cannot take in any more values
  private static final String MAX_SIZE_ERROR = "SortedList maximum limit reached";

/**
 * This constructor creates a new SortedList object
 */
  public SortedList(){
    this.maxSize = 0;
    this.array = null;
  }

/**
 * This constructor creates a new SortedList object
 * @param maxSize integer value that determines size of the list
 */
  public SortedList(int maxSize){
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
 * This constructor creates a new LifoList object
 * @param s LifoList object to be deep-copied
 */
  public SortedList(SortedList s){
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
    int temp = 0;
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
    //Inserts in element at nearest zero index
    if(element_count < this.array.length){
      for(int i = 0; i < this.array.length; i++){
        if(this.array[i] == 0){
          this.array[i] = element;
          break;
        }
      }
      //Reorganizes the list based on numerical order, using help of a temp array
      for(int i = 0; i < this.array.length - (this.array.length - element_count) + 1; i++){
        for(int j = i + 1; j < this.array.length - (this.array.length - element_count) + 1; j++){
        if(this.array[i] > this.array[j]){
          temp = this.array[i];
          this.array[i] = this.array[j];
          this.array[j] = temp;
          }
        }
      }
    }
  }
/**
 * This method deletes an integer and returns that deleted integer
 */
  @Override
  public int delete(){
    //Checks to see if array is null
    if(this.array == null){
      System.out.println(EMPTY_ERROR);
      return -1;
    }
    //Checks number of zeros in list
    int empty_check = 0;
    int temp_deleted = this.array[0];
    for(int i = 0; i < this.array.length; i++){
      if(this.array[i] == 0){
        empty_check += 1;
      }
    }
    //Checks to see if list is empty
    if(empty_check == this.array.length){
      System.out.println(EMPTY_ERROR);
      return -1;
    }
    else{
      //Deletes an integer using help of a temporary array
      SortedList temp_array = new SortedList(this);
      for(int i = 0; i < this.array.length - 1; i++){
          this.array[i] = temp_array.array[i+1];
          this.array [this.array.length-1-empty_check]= 0;
      }
    }
    return temp_deleted;
  }

/**
 * This method returns an integer, the top element of the list
 */
  @Override
  public int peek(){
    //Checks to see if array is null
    if(this.array == null){
      System.out.println(EMPTY_ERROR);
      return -1;
    }
    //Counts number of zeros in array
    int empty_check = 0;
    for(int i = 0; i < this.array.length; i++){
      if(this.array[i] == 0){
        empty_check += 1;
      }
    }
    if(empty_check == this.array.length){
      System.out.println(EMPTY_ERROR);
      return -1;
    }
    else{
      return this.array[0];
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
 * This method returns a string of the values in the array
 */
  public String toString(){
    String SortedString = "";
    //Checks to see if array is null
    if(this.array == null){
      return SortedString;
    }
    //Counts number of elements in array
    int num_elements = 0;
    for(int i = 0; i < this.array.length; i++){
      if(this.array[i] != 0){
        num_elements += 1;
      }
    }
    //Sets up the format on printing out the elements in a string
    if(num_elements != 0){
      for(int i = 0; i < num_elements - 1; i++){
        SortedString = SortedString + this.array[i] + spacer;
      }
      SortedString = SortedString + this.array[num_elements - 1];
    }
    return SortedString;
  }
}
