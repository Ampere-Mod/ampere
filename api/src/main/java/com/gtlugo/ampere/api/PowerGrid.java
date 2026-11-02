package com.gtlugo.ampere.api;

public class PowerGrid {
  private long capacity;

  public long capacity() {
    return capacity;
  }

  public boolean isOverwhelmed() {
    return false;
  }

  public void connect(IPowerNode node) {
    setCapacity(capacity - node.energyCost());
  }

  public void disconnect(IPowerNode node) {
    setCapacity(capacity + node.energyCost());
  }

  private void setCapacity(long newCapacity) {
    capacity = newCapacity;
  }
}
