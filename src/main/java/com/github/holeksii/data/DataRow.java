package com.github.holeksii.data;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Generic class that holds row of data.
 *
 * @param <K> type of key.
 * @param <V> type of value.
 */
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class DataRow<K extends Comparable<K>, V> {

  private K key;
  private V value;
}
