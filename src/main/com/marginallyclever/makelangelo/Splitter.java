package com.marginallyclever.makelangelo;

import javax.swing.JSplitPane;

@Deprecated
public class Splitter extends JSplitPane {
  static final long serialVersionUID = 1;

  public Splitter(int split_direction) {
    super(split_direction);
    setResizeWeight(0.95);
    setDividerLocation(0.95);
  }
}
