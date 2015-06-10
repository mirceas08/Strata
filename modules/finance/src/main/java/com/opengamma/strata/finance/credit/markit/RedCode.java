/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * <p>
 * Please see distribution for license.
 */
package com.opengamma.strata.finance.credit.markit;

import com.google.common.base.Preconditions;
import com.opengamma.strata.collect.id.StandardId;

/**
 * A simple string type to contain a 6 or 9 character Markit RED Code.
 * <p>
 * http://www.markit.com/product/reference-data-cds
 */
public class RedCode {

  public static final String MARKIT_REDCODE_SCHEME = "MarkitRedCode";

  public static StandardId id(String name) {
    Preconditions.checkArgument(
        name.length() == 6 || name.length() == 9,
        "RED Code must be exactly 6 or 9 characters"
    );
    return StandardId.of(MARKIT_REDCODE_SCHEME, name);
  }

}
