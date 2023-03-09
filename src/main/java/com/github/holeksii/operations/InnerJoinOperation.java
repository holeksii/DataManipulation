package com.github.holeksii.operations;

import com.github.holeksii.data.DataRow;
import com.github.holeksii.data.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    Collection<JoinedDataRow<K, V1, V2>> resultCollection = new ArrayList<>();

    Map<K, V1> leftMap = new HashMap<>();
    for (DataRow<K, V1> leftRow : leftCollection) {
      leftMap.put(leftRow.getKey(), leftRow.getValue());
    }

    for (DataRow<K, V2> rightRow : rightCollection) {
      V1 leftValue = leftMap.get(rightRow.getKey());
      if (leftValue != null) {
        resultCollection.add(
            new JoinedDataRow<>(rightRow.getKey(), leftValue, rightRow.getValue()));
      }
    }

    return resultCollection;
  }
}
