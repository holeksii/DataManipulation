package com.github.holeksii.data;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Generic class that holds row of data after joining.
 *
 * @param <K>  type of key.
 * @param <V1> type of value.
 * @param <V2> type of value.
 */
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class JoinedDataRow<K extends Comparable<K>, V1, V2> {

  private K key;
  private V1 leftValue;
  private V2 rightValue;
}
