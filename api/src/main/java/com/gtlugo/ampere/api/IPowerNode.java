package com.gtlugo.ampere.api;

public interface IPowerNode {
  default boolean isRunning() { return true; }
  /// Cost to run the node. A negative cost means the node produces energy rather than consumes it.
  /// @return Integer representing the energy cost
  long energyCost();
  PowerGrid powerGrid();
}
