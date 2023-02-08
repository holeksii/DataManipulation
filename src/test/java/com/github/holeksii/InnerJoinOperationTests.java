package com.github.holeksii;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.holeksii.data.DataRow;
import com.github.holeksii.data.JoinedDataRow;
import com.github.holeksii.operations.InnerJoinOperation;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InnerJoinOperationTests {

  static InnerJoinOperation<Integer, String, String> innerJoinOperation;
  static Collection<DataRow<Integer, String>> leftCollection;
  static Collection<DataRow<Integer, String>> rightCollection;
  static Collection<JoinedDataRow<Integer, String, String>> resultCollection;

  @BeforeAll
  static void setUp() {
    innerJoinOperation = new InnerJoinOperation<>();
    leftCollection = new ArrayList<>();
    rightCollection = new ArrayList<>();
    resultCollection = new ArrayList<>();
  }

  @BeforeEach
  void tearDown() {
    leftCollection.clear();
    rightCollection.clear();
    resultCollection.clear();
  }

  @Test
  void testJoint() {
    leftCollection.add(new DataRow<>(0, "Ukraine"));
    leftCollection.add(new DataRow<>(1, "Germany"));
    leftCollection.add(new DataRow<>(2, "France"));
    leftCollection.add(new DataRow<>(3, "Hungary"));
    leftCollection.add(new DataRow<>(4, "Poland"));

    rightCollection.add(new DataRow<>(0, "Kyiv"));
    rightCollection.add(new DataRow<>(1, "Berlin"));
    rightCollection.add(new DataRow<>(3, "Budapest"));
    rightCollection.add(new DataRow<>(5, "Warsaw"));

    resultCollection.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
    resultCollection.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
    resultCollection.add(new JoinedDataRow<>(3, "Hungary", "Budapest"));

    assertEquals(resultCollection, innerJoinOperation.join(leftCollection, rightCollection));
  }

  @Test
  void testJointTheEnd() {
    leftCollection.add(new DataRow<>(0, "Ukraine"));
    leftCollection.add(new DataRow<>(1, "Germany"));
    leftCollection.add(new DataRow<>(2, "France"));
    leftCollection.add(new DataRow<>(3, "Hungary"));

    rightCollection.add(new DataRow<>(0, "Kyiv"));
    rightCollection.add(new DataRow<>(1, "Berlin"));
    rightCollection.add(new DataRow<>(3, "Budapest"));

    resultCollection.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
    resultCollection.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
    resultCollection.add(new JoinedDataRow<>(3, "Hungary", "Budapest"));

    assertEquals(resultCollection, innerJoinOperation.join(leftCollection, rightCollection));
  }

  @Test
  void testJointEmpty() {
    leftCollection.add(new DataRow<>(9, "Ukraine"));
    leftCollection.add(new DataRow<>(10, "Germany"));
    leftCollection.add(new DataRow<>(20, "France"));
    leftCollection.add(new DataRow<>(30, "Hungary"));
    leftCollection.add(new DataRow<>(40, "Poland"));

    rightCollection.add(new DataRow<>(0, "Kyiv"));
    rightCollection.add(new DataRow<>(1, "Berlin"));
    rightCollection.add(new DataRow<>(3, "Budapest"));
    rightCollection.add(new DataRow<>(4, "London"));

    assertTrue(innerJoinOperation.join(leftCollection, rightCollection).isEmpty());
  }
}
