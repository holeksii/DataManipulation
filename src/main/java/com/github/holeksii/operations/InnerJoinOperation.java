package com.github.holeksii.operations;

import com.github.holeksii.data.DataRow;
import com.github.holeksii.data.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Inner join operation.
 *
 * @param <K>  type of key.
 * @param <V1> type of elements in the left collection.
 * @param <V2> type of elements in the right collection.
 */
public class InnerJoinOperation<K extends Comparable<K>, V1, V2> implements
    JoinOperation<DataRow<K, V1>, DataRow<K, V2>, JoinedDataRow<K, V1, V2>> {

  /**
   * Operator to join two collections.
   *
   * @param leftCollection  left collection.
   * @param rightCollection right collection.
   * @return result collection.
   */
  @Override
  public Collection<JoinedDataRow<K, V1, V2>> join(Collection<DataRow<K, V1>> leftCollection,
      Collection<DataRow<K, V2>> rightCollection) {
    Collection<JoinedDataRow<K, V1, V2>> result = new ArrayList<>();

    Iterator<DataRow<K, V1>> leftIterator = leftCollection.iterator();
    Iterator<DataRow<K, V2>> rightIterator = rightCollection.iterator();
    DataRow<K, V1> leftValue = leftIterator.next();
    DataRow<K, V2> rightValue = rightIterator.next();

    while (leftIterator.hasNext() || rightIterator.hasNext()) {
      if (leftValue.getKey().equals(rightValue.getKey())) {
        result.add(
            new JoinedDataRow<>(leftValue.getKey(), leftValue.getValue(), rightValue.getValue()));
        leftValue = leftIterator.next();
        rightValue = rightIterator.next();
      } else if (leftValue.getKey().compareTo(rightValue.getKey()) < 0) {
        if (!leftIterator.hasNext()) {
          break;
        }
        leftValue = leftIterator.next();
      } else {
        if (!rightIterator.hasNext()) {
          break;
        }
        rightValue = rightIterator.next();
      }
    }

    if (leftValue.getKey().equals(rightValue.getKey())) {
      result.add(
          new JoinedDataRow<>(leftValue.getKey(), leftValue.getValue(), rightValue.getValue()));
    }

    return result;
  }
}
