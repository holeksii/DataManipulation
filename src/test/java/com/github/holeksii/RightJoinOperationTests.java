package com.github.holeksii;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.holeksii.data.JoinedDataRow;
import com.github.holeksii.operations.RightOuterJoinOperation;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RightJoinOperationTests {

  static TestHelper testHelper;
  static Collection<JoinedDataRow<Integer, String, String>> resultCollection;

  @BeforeAll
  static void setUp() {
    testHelper = new TestHelper(new RightOuterJoinOperation<>());
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
    resultCollection.add(new JoinedDataRow<>(3, "Hungary", "Budapest"));
    resultCollection.add(new JoinedDataRow<>(5, null, "Warsaw"));

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
    resultCollection.add(new JoinedDataRow<>(3, "Hungary", "Budapest"));

    assertEquals(
        testHelper.getJoinOperation()
            .join(testHelper.getLeftCollection(), testHelper.getRightCollection()),
        resultCollection);
  }

  @Test
  void testJointNoMatches() {
    testHelper.setCollectionsNoMatches();

    resultCollection.add(new JoinedDataRow<>(0, null, "Kyiv"));
    resultCollection.add(new JoinedDataRow<>(1, null, "Berlin"));
    resultCollection.add(new JoinedDataRow<>(3, null, "Budapest"));
    resultCollection.add(new JoinedDataRow<>(4, null, "London"));

    assertEquals(
        testHelper.getJoinOperation()
            .join(testHelper.getLeftCollection(), testHelper.getRightCollection()),
        resultCollection);
  }
}
