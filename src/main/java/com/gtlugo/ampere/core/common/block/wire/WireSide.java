package com.gtlugo.ampere.core.common.block.wire;

import net.minecraft.util.StringRepresentable;

public enum WireSide implements StringRepresentable {
  MACHINE("up"),
  WIRE("side"),
  NONE("none");

  private final String name;

  WireSide(String pName) {
    this.name = pName;
  }

  public String toString() {
    return this.getSerializedName();
  }

  public String getSerializedName() {
    return this.name;
  }

  public boolean isConnected() {
    return this != NONE;
  }
}
