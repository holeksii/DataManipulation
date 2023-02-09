package com.github.holeksii;

import com.github.holeksii.data.DataRow;
import com.github.holeksii.data.JoinedDataRow;
import com.github.holeksii.operations.JoinOperation;
import java.util.ArrayList;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestHelper {

  private JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>,
      JoinedDataRow<Integer, String, String>> joinOperation;
  private Collection<DataRow<Integer, String>> leftCollection;
  private Collection<DataRow<Integer, String>> rightCollection;

  {
    leftCollection = new ArrayList<>();
    rightCollection = new ArrayList<>();
  }

  public TestHelper(JoinOperation<DataRow<Integer, String>, DataRow<Integer, String>,
      JoinedDataRow<Integer, String, String>> joinOperation) {
    this.joinOperation = joinOperation;
  }

  /**
   * Clears left and right collections.
   */
  void clearCollections() {
    leftCollection.clear();
    rightCollection.clear();
  }

  /**
   * Sets left collection to:
   * <br>[(0, "Ukraine"), (1, "Germany"), (2, "France"), (3, "Hungary"), (4, "Poland")].
   * <br>Sets right collection to:
   * <br>[(0, "Kyiv"), (1, "Berlin"), (3, "Budapest"), (5, "Warsaw")].
   */
  public void setCollections() {
    clearCollections();

    leftCollection.add(new DataRow<>(0, "Ukraine"));
    leftCollection.add(new DataRow<>(1, "Germany"));
    leftCollection.add(new DataRow<>(2, "France"));
    leftCollection.add(new DataRow<>(3, "Hungary"));
    leftCollection.add(new DataRow<>(4, "Poland"));

    rightCollection.add(new DataRow<>(0, "Kyiv"));
    rightCollection.add(new DataRow<>(1, "Berlin"));
    rightCollection.add(new DataRow<>(3, "Budapest"));
    rightCollection.add(new DataRow<>(5, "Warsaw"));
  }

  /**
   * Sets left collection to:
   * <br>[(0, "Ukraine"), (1, "Germany"), (2, "France"), (3, "Hungary")].
   * <br>Sets right collection to:
   * <br>[(0, "Kyiv"), (1, "Berlin"), (3, "Budapest")].
   */
  public void setCollectionsTheLast() {
    clearCollections();

    leftCollection.add(new DataRow<>(0, "Ukraine"));
    leftCollection.add(new DataRow<>(1, "Germany"));
    leftCollection.add(new DataRow<>(2, "France"));
    leftCollection.add(new DataRow<>(3, "Hungary"));

    rightCollection.add(new DataRow<>(0, "Kyiv"));
    rightCollection.add(new DataRow<>(1, "Berlin"));
    rightCollection.add(new DataRow<>(3, "Budapest"));
  }

  /**
   * Sets left collection to:
   * <br>[(9, "Ukraine"), (10, "Germany"), (20, "France"), (30, "Hungary"), (40, "Poland")].
   * <br>Sets right collection to:
   * <br>[(0, "Kyiv"), (1, "Berlin"), (3, "Budapest"), (4, "London")].
   */
  public void setCollectionsNoMatches() {
    clearCollections();

    leftCollection.add(new DataRow<>(9, "Ukraine"));
    leftCollection.add(new DataRow<>(10, "Germany"));
    leftCollection.add(new DataRow<>(20, "France"));
    leftCollection.add(new DataRow<>(30, "Hungary"));
    leftCollection.add(new DataRow<>(40, "Poland"));

    rightCollection.add(new DataRow<>(0, "Kyiv"));
    rightCollection.add(new DataRow<>(1, "Berlin"));
    rightCollection.add(new DataRow<>(3, "Budapest"));
    rightCollection.add(new DataRow<>(4, "London"));
  }
}
