/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.examples.report;

import java.util.List;
import java.util.Set;

import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.light.LightMetaBean;

import com.google.common.collect.ImmutableList;
import com.opengamma.strata.product.Trade;

/**
 * Represents a list of trades.
 * <p>
 * This class exists to allow the list of trades to be serialized and deserialized
 * using Joda-Beans. It is not intended to be a general purpose portfolio.
 */
@BeanDefinition(style = "light")
public final class TradeList implements ImmutableBean {

  /**
   * The trades.
   */
  @PropertyDefinition(validate = "notNull")
  private final ImmutableList<Trade> trades;

  //-------------------------------------------------------------------------
  /**
   * Obtains an instance from a list of trades.
   * 
   * @param trades  the list of trades
   * @return the portfolio
   */
  public static TradeList of(List<Trade> trades) {
    return new TradeList(trades);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code TradeList}.
   */
  private static MetaBean META_BEAN = LightMetaBean.of(TradeList.class);

  /**
   * The meta-bean for {@code TradeList}.
   * @return the meta-bean, not null
   */
  public static MetaBean meta() {
    return META_BEAN;
  }

  static {
    JodaBeanUtils.registerMetaBean(META_BEAN);
  }

  private TradeList(
      List<Trade> trades) {
    JodaBeanUtils.notNull(trades, "trades");
    this.trades = ImmutableList.copyOf(trades);
  }

  @Override
  public MetaBean metaBean() {
    return META_BEAN;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the trades.
   * @return the value of the property, not null
   */
  public ImmutableList<Trade> getTrades() {
    return trades;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      TradeList other = (TradeList) obj;
      return JodaBeanUtils.equal(trades, other.trades);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(trades);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(64);
    buf.append("TradeList{");
    buf.append("trades").append('=').append(JodaBeanUtils.toString(trades));
    buf.append('}');
    return buf.toString();
  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}