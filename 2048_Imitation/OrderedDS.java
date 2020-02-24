/**
  * Filename: OrderedDS.java
  * Name: Brandon Nguyen
  * Login: cs8bwi20pp@ieng6.ucsd.edu
  * Date: 11 February 2020
  * Sources of Help: Stack Overflow, Geeks for Geeks, Notes
  * This file contains code for the OrderedDS abstract class. This
  * abstract class extends the DataStructure class, which implements
  * the BasicMethods interface.
 */

/**
 * This abstract class contains the abstract methods peek and delete
 * to be extended into other classes.
 */
abstract class OrderedDS extends DataStructure{
  public abstract int peek();

  public abstract int delete();


}
