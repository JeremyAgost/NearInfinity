// Near Infinity - An Infinity Engine Browser and Editor
// Copyright (C) 2001 - 2005 Jon Olav Hauglid
// See LICENSE.txt for license information

package infinity.resource.other;

import infinity.datatype.*;
import infinity.resource.AbstractStruct;
import infinity.resource.Resource;
import infinity.resource.key.ResourceEntry;

public final class WfxResource extends AbstractStruct implements Resource
{
  private static final String s_flag[] = {"No flags set", "", "", "Pitch variance"};

  public WfxResource(ResourceEntry entry) throws Exception
  {
    super(entry);
  }

  protected int read(byte buffer[], int offset) throws Exception
  {
    list.add(new TextString(buffer, offset, 4, "Signature"));
    list.add(new TextString(buffer, offset + 4, 4, "Version"));
    list.add(new Unknown(buffer, offset + 8, 4));
    list.add(new Flag(buffer, offset + 12, 4, "Flags", s_flag));
    list.add(new DecNumber(buffer, offset + 16, 4, "Amount"));
    list.add(new Unknown(buffer, offset + 20, 244));
    return offset + 264;
  }
}
