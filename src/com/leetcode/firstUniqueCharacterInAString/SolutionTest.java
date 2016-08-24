package com.leetcode.firstUniqueCharacterInAString;

import static org.junit.Assert.*;

/**
 * Created by Shayna on 8/23/16.
 */
public class SolutionTest {
  Solution solution = null;
  @org.junit.Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @org.junit.After
  public void tearDown() throws Exception {
    solution = null;
  }

  /**
   * test 2 unique chars should return the index of the first one
   * @throws Exception
   */
  @org.junit.Test
  public void firstUniqChar() throws Exception {
    assertEquals(0, solution.firstUniqChar("ab"));
  }

  /**
   * no unique chars should return -1
   * @throws Exception
   */
  @org.junit.Test
  public void noUniqChar() throws Exception {
    assertEquals(-1, solution.firstUniqChar("aa"));
  }

  /**
   * only 1 char in the string should return 0
   * @throws Exception
   */
  @org.junit.Test
  public void oneUniqChar() throws Exception {
    assertEquals(0, solution.firstUniqChar("z"));
  }

  /**
   * first two chars no unique last one is unique
   * @throws Exception
   */
  @org.junit.Test
  public void lastUniqChar() throws Exception {
    assertEquals(2, solution.firstUniqChar("aab"));
  }

}
