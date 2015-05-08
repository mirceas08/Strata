/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.engine.marketdata.scenarios.curves;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.analytics.ShiftType;
import com.opengamma.analytics.financial.model.interestrate.curve.YieldCurve;
import com.opengamma.analytics.financial.model.interestrate.curve.YieldCurveUtils;
import com.opengamma.strata.engine.marketdata.scenarios.Perturbation;

/**
 * Perturbation which applies a parallel shift to a curve.
 * <p>
 * The shift can be absolute or relative. An absolute shift adds the shift amount to each point on the curve and
 * a relative shift applies a scale factor to each point on the curve.
 * <p>
 * For example, a relative shift of 0.1 (10%) multiplies each value on the curve by 1.1, and a shift of -0.2 (-20%)
 * multiplies the rate by 0.8. So for relative shifts the shifted value is {@code (value x (1 + shift))}.
 */
@BeanDefinition
public final class CurveParallelShift implements Perturbation<YieldCurve>, ImmutableBean {

  /** The type of the shift, absolute or relative. */
  @PropertyDefinition(validate = "notNull")
  private final ShiftType shiftType;

  /** The size of the shift. */
  @PropertyDefinition(validate = "notNull")
  private final double shiftAmount;

  /**
   * Creates a shift that adds a fixed amount to the value at every node in the curve.
   *
   * @param shiftAmount the amount to add to each node value in the curve
   * @return a shift that adds a fixed amount to the value at every node in the curve
   */
  public static CurveParallelShift absolute(double shiftAmount) {
    return new CurveParallelShift(ShiftType.ABSOLUTE, shiftAmount);
  }

  /**
   * Creates a shift that multiplies the values at each curve node by a fixed factor.
   *
   * @param shiftAmount the factor to multiply the value at each curve node by
   * @return a shift that multiplies the values at each curve node by a fixed factor
   */
  public static CurveParallelShift relative(double shiftAmount) {
    return new CurveParallelShift(ShiftType.RELATIVE, shiftAmount);
  }

  @Override
  public YieldCurve apply(YieldCurve curve) {
    return YieldCurveUtils.withParallelShift(curve, shiftAmount, shiftType, "");
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code CurveParallelShift}.
   * @return the meta-bean, not null
   */
  public static CurveParallelShift.Meta meta() {
    return CurveParallelShift.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(CurveParallelShift.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static CurveParallelShift.Builder builder() {
    return new CurveParallelShift.Builder();
  }

  private CurveParallelShift(
      ShiftType shiftType,
      double shiftAmount) {
    JodaBeanUtils.notNull(shiftType, "shiftType");
    JodaBeanUtils.notNull(shiftAmount, "shiftAmount");
    this.shiftType = shiftType;
    this.shiftAmount = shiftAmount;
  }

  @Override
  public CurveParallelShift.Meta metaBean() {
    return CurveParallelShift.Meta.INSTANCE;
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
   * Gets the type of the shift, absolute or relative.
   * @return the value of the property, not null
   */
  public ShiftType getShiftType() {
    return shiftType;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the size of the shift.
   * @return the value of the property, not null
   */
  public double getShiftAmount() {
    return shiftAmount;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      CurveParallelShift other = (CurveParallelShift) obj;
      return JodaBeanUtils.equal(getShiftType(), other.getShiftType()) &&
          JodaBeanUtils.equal(getShiftAmount(), other.getShiftAmount());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getShiftType());
    hash = hash * 31 + JodaBeanUtils.hashCode(getShiftAmount());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("CurveParallelShift{");
    buf.append("shiftType").append('=').append(getShiftType()).append(',').append(' ');
    buf.append("shiftAmount").append('=').append(JodaBeanUtils.toString(getShiftAmount()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CurveParallelShift}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code shiftType} property.
     */
    private final MetaProperty<ShiftType> shiftType = DirectMetaProperty.ofImmutable(
        this, "shiftType", CurveParallelShift.class, ShiftType.class);
    /**
     * The meta-property for the {@code shiftAmount} property.
     */
    private final MetaProperty<Double> shiftAmount = DirectMetaProperty.ofImmutable(
        this, "shiftAmount", CurveParallelShift.class, Double.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "shiftType",
        "shiftAmount");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 893345500:  // shiftType
          return shiftType;
        case -1043480710:  // shiftAmount
          return shiftAmount;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public CurveParallelShift.Builder builder() {
      return new CurveParallelShift.Builder();
    }

    @Override
    public Class<? extends CurveParallelShift> beanType() {
      return CurveParallelShift.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code shiftType} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ShiftType> shiftType() {
      return shiftType;
    }

    /**
     * The meta-property for the {@code shiftAmount} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> shiftAmount() {
      return shiftAmount;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 893345500:  // shiftType
          return ((CurveParallelShift) bean).getShiftType();
        case -1043480710:  // shiftAmount
          return ((CurveParallelShift) bean).getShiftAmount();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code CurveParallelShift}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<CurveParallelShift> {

    private ShiftType shiftType;
    private double shiftAmount;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(CurveParallelShift beanToCopy) {
      this.shiftType = beanToCopy.getShiftType();
      this.shiftAmount = beanToCopy.getShiftAmount();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 893345500:  // shiftType
          return shiftType;
        case -1043480710:  // shiftAmount
          return shiftAmount;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 893345500:  // shiftType
          this.shiftType = (ShiftType) newValue;
          break;
        case -1043480710:  // shiftAmount
          this.shiftAmount = (Double) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public CurveParallelShift build() {
      return new CurveParallelShift(
          shiftType,
          shiftAmount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code shiftType} property in the builder.
     * @param shiftType  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder shiftType(ShiftType shiftType) {
      JodaBeanUtils.notNull(shiftType, "shiftType");
      this.shiftType = shiftType;
      return this;
    }

    /**
     * Sets the {@code shiftAmount} property in the builder.
     * @param shiftAmount  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder shiftAmount(double shiftAmount) {
      JodaBeanUtils.notNull(shiftAmount, "shiftAmount");
      this.shiftAmount = shiftAmount;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("CurveParallelShift.Builder{");
      buf.append("shiftType").append('=').append(JodaBeanUtils.toString(shiftType)).append(',').append(' ');
      buf.append("shiftAmount").append('=').append(JodaBeanUtils.toString(shiftAmount));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
