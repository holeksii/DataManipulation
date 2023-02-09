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

  Utils utils = new Utils(new LeftJoinOperation<>());
  static Collection<JoinedDataRow<Integer, String, String>> resultCollection;

  @BeforeAll
  static void setUp() {
    resultCollection = new ArrayList<>();
  }

  @BeforeEach
  void tearDown() {
    resultCollection.clear();
  }

  @Test
  void testJoint() {
    utils.setCollections();

    resultCollection.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
    resultCollection.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
    resultCollection.add(new JoinedDataRow<>(2, "France", null));
    resultCollection.add(new JoinedDataRow<>(3, "Hungary", "Budapest"));
    resultCollection.add(new JoinedDataRow<>(4, "Poland", null));

    assertEquals(
        utils.getJoinOperation().join(utils.getLeftCollection(), utils.getRightCollection()),
        resultCollection);
  }

  @Test
  void testJointTheLast() {
    utils.setCollectionsTheLast();

    resultCollection.add(new JoinedDataRow<>(0, "Ukraine", "Kyiv"));
    resultCollection.add(new JoinedDataRow<>(1, "Germany", "Berlin"));
    resultCollection.add(new JoinedDataRow<>(2, "France", null));
    resultCollection.add(new JoinedDataRow<>(3, "Hungary", "Budapest"));

    assertEquals(
        utils.getJoinOperation().join(utils.getLeftCollection(), utils.getRightCollection()),
        resultCollection);
  }

  @Test
  void testJointNoMatches() {
    utils.setCollectionsNoMatches();

    resultCollection.add(new JoinedDataRow<>(9, "Ukraine", null));
    resultCollection.add(new JoinedDataRow<>(10, "Germany", null));
    resultCollection.add(new JoinedDataRow<>(20, "France", null));
    resultCollection.add(new JoinedDataRow<>(30, "Hungary", null));
    resultCollection.add(new JoinedDataRow<>(40, "Poland", null));

    assertEquals(
        utils.getJoinOperation().join(utils.getLeftCollection(), utils.getRightCollection()),
        resultCollection);
  }
}
