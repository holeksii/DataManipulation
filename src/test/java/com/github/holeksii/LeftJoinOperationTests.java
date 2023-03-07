package com.github.holeksii;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.holeksii.data.JoinedDataRow;
import com.github.holeksii.operations.LeftJoinOperation;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LeftJoinOperationTests {

  static TestHelper testHelper;
  static Collection<JoinedDataRow<Integer, String, String>> resultCollection;

  {
    testHelper = new TestHelper(new LeftJoinOperation<>());
  }

  @BeforeAll
  static void setUp() {
    testHelper = new TestHelper(new LeftJoinOperation<>());
    resultCollection = new ArrayList<>();
  }

  @BeforeEach
  void tearDown() {
    resultCollection.clear();
  }

  @Test
  void testJoint() {
    testHelper.setCollections();

    resultCollection.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
    resultCollection.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
    resultCollection.add(new JoinedDataRow<>(2, "France", null));
    resultCollection.add(new JoinedDataRow<>(3, "Hungary", "Budapest"));
    resultCollection.add(new JoinedDataRow<>(4, "Poland", null));

    assertEquals(
        testHelper.getJoinOperation()
            .join(testHelper.getLeftCollection(), testHelper.getRightCollection()),
        resultCollection);
  }

  @Test
  void testJointTheLast() {
    testHelper.setCollectionsTheLast();

    resultCollection.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
    resultCollection.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
    resultCollection.add(new JoinedDataRow<>(2, "France", null));
    resultCollection.add(new JoinedDataRow<>(3, "Hungary", "Budapest"));

    assertEquals(
        testHelper.getJoinOperation()
            .join(testHelper.getLeftCollection(), testHelper.getRightCollection()),
        resultCollection);
  }

  @Test
  void testJointNoMatches() {
    testHelper.setCollectionsNoMatches();

    resultCollection.add(new JoinedDataRow<>(9, "Ukraine", null));
    resultCollection.add(new JoinedDataRow<>(10, "Germany", null));
    resultCollection.add(new JoinedDataRow<>(20, "France", null));
    resultCollection.add(new JoinedDataRow<>(30, "Hungary", null));
    resultCollection.add(new JoinedDataRow<>(40, "Poland", null));

    assertEquals(
        testHelper.getJoinOperation()
            .join(testHelper.getLeftCollection(), testHelper.getRightCollection()),
        resultCollection);
  }
}
