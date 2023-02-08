package com.github.holeksii.operations;

import java.util.Collection;

/**
 * An interface that describes the join operator.
 *
 * @param <D1> type of elements in the left collection.
 * @param <D2> type of elements in the right collection.
 * @param <R> type of elements in the result collection.
 */
public interface JoinOperation<D1, D2, R> {

  /**
   * Operator to join two collections.
   *
   * @param leftCollection left collection.
   * @param rightCollection right collection.
   *
   * @return result collection.
   */
  Collection<R> join(Collection<D1> leftCollection, Collection<D2> rightCollection);

}
