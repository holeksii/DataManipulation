package com.github.holeksii.operations;

import com.github.holeksii.data.DataRow;
import com.github.holeksii.data.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Right join operation.
 *
 * @param <K>  type of key.
 * @param <V1> type of elements in the left collection.
 * @param <V2> type of elements in the right collection.
 */
public class RightJoinOperation<K extends Comparable<K>, V1, V2> implements
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
    Collection<JoinedDataRow<K, V1, V2>> resultCollection = new ArrayList<>(rightCollection.size());

    Map<K, V1> map = new HashMap<>(leftCollection.size());
    for (DataRow<K, V1> row : leftCollection) {
      map.put(row.getKey(), row.getValue());
    }

    for (DataRow<K, V2> row : rightCollection) {
      resultCollection.add(
          new JoinedDataRow<>(row.getKey(), map.get(row.getKey()), row.getValue()));
    }

    return resultCollection;
  }
}
