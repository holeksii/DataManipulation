package com.github.holeksii.operations;

import com.github.holeksii.data.DataRow;
import com.github.holeksii.data.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;

/**
 * Left join operation. Implementation of the join operation interface.
 *
 * @param <K>  type of key.
 * @param <V1> type of elements in the left collection.
 * @param <V2> type of elements in the right collection.
 */
@AllArgsConstructor
public class LeftJoinOperation<K extends Comparable<K>, V1, V2> implements
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
    Collection<JoinedDataRow<K, V1, V2>> resultCollection = new ArrayList<>(leftCollection.size());

    Map<K, V2> map = new HashMap<>(rightCollection.size());
    for (DataRow<K, V2> row : rightCollection) {
      map.put(row.getKey(), row.getValue());
    }

    for (DataRow<K, V1> row : leftCollection) {
      resultCollection.add(
          new JoinedDataRow<>(row.getKey(), row.getValue(), map.get(row.getKey())));
    }

    return resultCollection;
  }
}
