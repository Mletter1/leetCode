package com.leetcode.insertDeleteGetRandomNoRepeats.insertDeleteGetRandomRepeats;

import java.util.Random;

/**
 * I made this a little more complicated than I had to by implementing a
 * hashmap from scratch for fun
 */
public class Solution {
  private Wrapper[] hashMap = null;
  private int[] indexes = null;
  private int hashSize = 0;
  private Random r = null;

  /** Initialize your data structure here. */
  public Solution() {
    hashMap = new Wrapper[10000];
    indexes = new int[(hashMap.length)];
    indexes[0] = -1;
    // System.out.println(hash(1001) + " " + indexes.length);
    r = new Random();
  }

  /** Inserts a value to the collection.
   Returns true if the collection did not
   already contain the specified element. */
  public boolean insert(int val) {
    //this.printMap("inser: "+val);
    int index = this.hash(val);
    boolean status = true;
    boolean searchingForNull = true;
    while (searchingForNull){
      if (hashMap[index] == null){
        searchingForNull = false;
        indexes[this.hashSize] = index;
        hashMap[index] = new Wrapper(val, this.hashSize);
        this.hashSize++;
        indexes[this.hashSize] = -1;
      }else if(hashMap[index].getVal() == val){//linear open addressing edge case check
        return false; //only difference for no repeats
      }
      index++;
      if(index >= hashMap.length){
        index = 0;
      }
    }
    return status;
  }

  /** Removes a value from the collection.
   Returns true if the collection contained the specified element. */
  public boolean remove(int val) {
    //this.printMap("remove:"+val);
    int index = this.hash(val);
    while(true){
      if(this.hashMap[index] == null){
        return false;
      }
      if(this.hashMap[index].getVal() == val){
        this.cleanIndexes(this.hashMap[index].getHashIndex());
        this.hashMap[index] = null;
        while(true){
          index++;
          if(this.hashMap[index] == null){
            return true;
          }
          //your normal spot has something, your normal spot != to this one, and previous spot is null
          if(this.hashMap[this.hash(this.hashMap[index].val)] != null && this.hash(this.hashMap[index].val) != index && this.hashMap[index-1] == null){
            this.indexes[this.hashMap[index].getHashIndex()] = index-1;
            this.hashMap[index-1] = this.hashMap[index];
            this.hashMap[index] = null;
          }else{
            int tempIndex = this.hash(this.hashMap[index].val);
            while(true){
              if(tempIndex == index){
                break;
              }
              if(this.hashMap[tempIndex] == null){
                this.indexes[this.hashMap[index].getHashIndex()] = tempIndex;
                this.hashMap[tempIndex] = this.hashMap[index];
                this.hashMap[index] = null;
                break;
              }
              tempIndex++;
              if(tempIndex >= hashMap.length){
                tempIndex = 0;
              }
            }
          }
        }
      }
      index++;
      if(index >= hashMap.length){
        index = 0;
      }
    }
  }
  private void cleanIndexes(int removedIndex){
    for(int i = removedIndex; i < this.hashSize; i++){
      if(this.indexes[i+1] != -1) this.hashMap[this.indexes[i+1]].setHashIndex(i);
      this.indexes[i] = this.indexes[i+1];
    }
    this.hashSize--;
  }
  /** Get a random element from the collection. */
  public int getRandom() {
    int index = this.indexes[this.r.nextInt(this.hashSize)];
    //System.out.println();
    //this.printMap("badIndex: "+index);
    return this.hashMap[index].getVal();
  }
  public void printMap(String s){
    System.out.println("\n\n^Map:::::::::::::::Map^"+s);
    for(int i = 0; i <= this.hashSize + 10; i++){
      if(this.hashMap[i] != null) {
        System.out.println(i +": "+ this.indexes[i]+" "+this.hashMap[i].val);
      }else{
        System.out.println(i +": "+this.indexes[i]);
      }
    }
  }

  private int hash(int val){
    int retVal = val % hashMap.length;
    return (retVal < 0) ? -retVal : retVal;
  }
  private void reSize(){
    //TODO: to make it a truly proper hashmap
    //we need to resize it at some fullness of the map
  }
  private class Wrapper{
    private int val;
    private int hashIndex;
    Wrapper(int val, int index){
      this.val = val;
      this.hashIndex = index;
    }
    void setHashIndex(int hashIndex){
      this.hashIndex = hashIndex;
    }
    int getHashIndex(){
      return this.hashIndex;
    }
    int getVal(){
      return this.val;
    }
  }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
