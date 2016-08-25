package com.leetcode.canConstruct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shayna on 8/23/16.
 */
public class SolutionTest {
  Solution solution = null;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @After
  public void tearDown() throws Exception {
    solution = null;
  }

  /**
   *
   * @throws Exception
   */
  @Test
  public void cantConstructShort() throws Exception {
    assertFalse(solution.canConstruct("a", "b"));
  }
  @Test
  public void cantConstructLong() throws Exception {
    assertFalse(solution.canConstruct("aa", "ab"));
  }
  @Test
  public void canConstruct() throws Exception {
    assertTrue(solution.canConstruct("aa", "aab"));
  }

}
