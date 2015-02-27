/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.platform.finance.fra;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableValidator;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.basics.BuySell;
import com.opengamma.basics.currency.Currency;
import com.opengamma.basics.date.DayCount;
import com.opengamma.collect.ArgChecker;
import com.opengamma.platform.finance.observation.RateObservation;

/**
 * An expanded forward rate agreement (FRA), with dates calculated ready for pricing.
 * <p>
 * A FRA is a financial instrument that represents the one off exchange of a fixed
 * rate of interest for a floating rate at a future date.
 * <p>
 * An {@code ExpandedFra} contains information based on holiday calendars.
 * If a holiday calendar changes, the adjusted dates may no longer be correct.
 * Care must be taken when placing the expanded form in a cache or persistence layer.
 */
@BeanDefinition
public final class ExpandedFra
    implements FraProduct, ImmutableBean, Serializable {

  /**
   * Whether the FRA is buy or sell.
   * <p>
   * A value of 'Buy' implies that the floating rate is received from the counterparty,
   * with the fixed rate being paid. A value of 'Sell' implies that the floating rate
   * is paid to the counterparty, with the fixed rate being received.
   */
  @PropertyDefinition(validate = "notNull")
  private final BuySell buySell;
  /**
   * The date that payment occurs.
   * <p>
   * This is an adjusted date, which should be a valid business day
   */
  @PropertyDefinition(validate = "notNull")
  private final LocalDate paymentDate;
  /**
   * The start date, which is the effective date of the FRA.
   * <p>
   * This is the first date that interest accrues.
   * <p>
   * This is an adjusted date, which should be a valid business day
   */
  @PropertyDefinition(validate = "notNull")
  private final LocalDate startDate;
  /**
   * The end date, which is the termination date of the FRA.
   * <p>
   * This is the last day that interest accrues.
   * This date must be after the start date.
   * <p>
   * This is an adjusted date, which should be a valid business day
   */
  @PropertyDefinition(validate = "notNull")
  private final LocalDate endDate;
  /**
   * The year fraction between the start and end date.
   * <p>
   * The value is usually calculated using a {@link DayCount}.
   * Typically the value will be close to 1 for one year and close to 0.5 for six months.
   * The fraction may be greater than 1, but not less than 0.
   */
  @PropertyDefinition(validate = "ArgChecker.notNegative")
  private final double yearFraction;
  /**
   * The fixed rate of interest.
   * A 5% rate will be expressed as 0.05.
   * <p>
   * See {@code buySell} to determine whether this rate is paid or received.
   */
  @PropertyDefinition
  private final double fixedRate;
  /**
   * The floating rate of interest.
   * <p>
   * The floating rate to be paid is based on this index.
   * It will be a well known market index such as 'GBP-LIBOR-3M'.
   * <p>
   * See {@code buySell} to determine whether this rate is paid or received.
   */
  @PropertyDefinition(validate = "notNull")
  private final RateObservation floatingRate;
  /**
   * The primary currency.
   * <p>
   * This is the currency of the FRA and the currency that payment is made in.
   * The data model permits this currency to differ from that of the index,
   * however the two are typically the same.
   */
  @PropertyDefinition(validate = "notNull")
  private final Currency currency;
  /**
   * The notional amount.
   * <p>
   * The notional expressed here must be positive.
   * The currency of the notional is specified by {@code currency}.
   */
  @PropertyDefinition(validate = "ArgChecker.notNegative")
  private final double notional;
  /**
   * The method to use for discounting.
   * <p>
   * There are different approaches to FRA pricing in the area of discounting.
   * This method specifies the approach for this FRA.
   */
  @PropertyDefinition(validate = "notNull")
  private final FraDiscountingMethod discounting;

  //-------------------------------------------------------------------------
  @ImmutableValidator
  private void validate() {
    ArgChecker.inOrderNotEqual(startDate, endDate, "startDate", "endDate");
  }

  //-------------------------------------------------------------------------
  /**
   * Expands this FRA, trivially returning {@code this}.
   * 
   * @return this FRA
   */
  @Override
  public ExpandedFra expand() {
    return this;
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ExpandedFra}.
   * @return the meta-bean, not null
   */
  public static ExpandedFra.Meta meta() {
    return ExpandedFra.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ExpandedFra.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static ExpandedFra.Builder builder() {
    return new ExpandedFra.Builder();
  }

  private ExpandedFra(
      BuySell buySell,
      LocalDate paymentDate,
      LocalDate startDate,
      LocalDate endDate,
      double yearFraction,
      double fixedRate,
      RateObservation floatingRate,
      Currency currency,
      double notional,
      FraDiscountingMethod discounting) {
    JodaBeanUtils.notNull(buySell, "buySell");
    JodaBeanUtils.notNull(paymentDate, "paymentDate");
    JodaBeanUtils.notNull(startDate, "startDate");
    JodaBeanUtils.notNull(endDate, "endDate");
    ArgChecker.notNegative(yearFraction, "yearFraction");
    JodaBeanUtils.notNull(floatingRate, "floatingRate");
    JodaBeanUtils.notNull(currency, "currency");
    ArgChecker.notNegative(notional, "notional");
    JodaBeanUtils.notNull(discounting, "discounting");
    this.buySell = buySell;
    this.paymentDate = paymentDate;
    this.startDate = startDate;
    this.endDate = endDate;
    this.yearFraction = yearFraction;
    this.fixedRate = fixedRate;
    this.floatingRate = floatingRate;
    this.currency = currency;
    this.notional = notional;
    this.discounting = discounting;
    validate();
  }

  @Override
  public ExpandedFra.Meta metaBean() {
    return ExpandedFra.Meta.INSTANCE;
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
   * Gets whether the FRA is buy or sell.
   * <p>
   * A value of 'Buy' implies that the floating rate is received from the counterparty,
   * with the fixed rate being paid. A value of 'Sell' implies that the floating rate
   * is paid to the counterparty, with the fixed rate being received.
   * @return the value of the property, not null
   */
  public BuySell getBuySell() {
    return buySell;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the date that payment occurs.
   * <p>
   * This is an adjusted date, which should be a valid business day
   * @return the value of the property, not null
   */
  public LocalDate getPaymentDate() {
    return paymentDate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the start date, which is the effective date of the FRA.
   * <p>
   * This is the first date that interest accrues.
   * <p>
   * This is an adjusted date, which should be a valid business day
   * @return the value of the property, not null
   */
  public LocalDate getStartDate() {
    return startDate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the end date, which is the termination date of the FRA.
   * <p>
   * This is the last day that interest accrues.
   * This date must be after the start date.
   * <p>
   * This is an adjusted date, which should be a valid business day
   * @return the value of the property, not null
   */
  public LocalDate getEndDate() {
    return endDate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the year fraction between the start and end date.
   * <p>
   * The value is usually calculated using a {@link DayCount}.
   * Typically the value will be close to 1 for one year and close to 0.5 for six months.
   * The fraction may be greater than 1, but not less than 0.
   * @return the value of the property
   */
  public double getYearFraction() {
    return yearFraction;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the fixed rate of interest.
   * A 5% rate will be expressed as 0.05.
   * <p>
   * See {@code buySell} to determine whether this rate is paid or received.
   * @return the value of the property
   */
  public double getFixedRate() {
    return fixedRate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the floating rate of interest.
   * <p>
   * The floating rate to be paid is based on this index.
   * It will be a well known market index such as 'GBP-LIBOR-3M'.
   * <p>
   * See {@code buySell} to determine whether this rate is paid or received.
   * @return the value of the property, not null
   */
  public RateObservation getFloatingRate() {
    return floatingRate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the primary currency.
   * <p>
   * This is the currency of the FRA and the currency that payment is made in.
   * The data model permits this currency to differ from that of the index,
   * however the two are typically the same.
   * @return the value of the property, not null
   */
  public Currency getCurrency() {
    return currency;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the notional amount.
   * <p>
   * The notional expressed here must be positive.
   * The currency of the notional is specified by {@code currency}.
   * @return the value of the property
   */
  public double getNotional() {
    return notional;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the method to use for discounting.
   * <p>
   * There are different approaches to FRA pricing in the area of discounting.
   * This method specifies the approach for this FRA.
   * @return the value of the property, not null
   */
  public FraDiscountingMethod getDiscounting() {
    return discounting;
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
      ExpandedFra other = (ExpandedFra) obj;
      return JodaBeanUtils.equal(getBuySell(), other.getBuySell()) &&
          JodaBeanUtils.equal(getPaymentDate(), other.getPaymentDate()) &&
          JodaBeanUtils.equal(getStartDate(), other.getStartDate()) &&
          JodaBeanUtils.equal(getEndDate(), other.getEndDate()) &&
          JodaBeanUtils.equal(getYearFraction(), other.getYearFraction()) &&
          JodaBeanUtils.equal(getFixedRate(), other.getFixedRate()) &&
          JodaBeanUtils.equal(getFloatingRate(), other.getFloatingRate()) &&
          JodaBeanUtils.equal(getCurrency(), other.getCurrency()) &&
          JodaBeanUtils.equal(getNotional(), other.getNotional()) &&
          JodaBeanUtils.equal(getDiscounting(), other.getDiscounting());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getBuySell());
    hash = hash * 31 + JodaBeanUtils.hashCode(getPaymentDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getStartDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getEndDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getYearFraction());
    hash = hash * 31 + JodaBeanUtils.hashCode(getFixedRate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getFloatingRate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getCurrency());
    hash = hash * 31 + JodaBeanUtils.hashCode(getNotional());
    hash = hash * 31 + JodaBeanUtils.hashCode(getDiscounting());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(352);
    buf.append("ExpandedFra{");
    buf.append("buySell").append('=').append(getBuySell()).append(',').append(' ');
    buf.append("paymentDate").append('=').append(getPaymentDate()).append(',').append(' ');
    buf.append("startDate").append('=').append(getStartDate()).append(',').append(' ');
    buf.append("endDate").append('=').append(getEndDate()).append(',').append(' ');
    buf.append("yearFraction").append('=').append(getYearFraction()).append(',').append(' ');
    buf.append("fixedRate").append('=').append(getFixedRate()).append(',').append(' ');
    buf.append("floatingRate").append('=').append(getFloatingRate()).append(',').append(' ');
    buf.append("currency").append('=').append(getCurrency()).append(',').append(' ');
    buf.append("notional").append('=').append(getNotional()).append(',').append(' ');
    buf.append("discounting").append('=').append(JodaBeanUtils.toString(getDiscounting()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ExpandedFra}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code buySell} property.
     */
    private final MetaProperty<BuySell> buySell = DirectMetaProperty.ofImmutable(
        this, "buySell", ExpandedFra.class, BuySell.class);
    /**
     * The meta-property for the {@code paymentDate} property.
     */
    private final MetaProperty<LocalDate> paymentDate = DirectMetaProperty.ofImmutable(
        this, "paymentDate", ExpandedFra.class, LocalDate.class);
    /**
     * The meta-property for the {@code startDate} property.
     */
    private final MetaProperty<LocalDate> startDate = DirectMetaProperty.ofImmutable(
        this, "startDate", ExpandedFra.class, LocalDate.class);
    /**
     * The meta-property for the {@code endDate} property.
     */
    private final MetaProperty<LocalDate> endDate = DirectMetaProperty.ofImmutable(
        this, "endDate", ExpandedFra.class, LocalDate.class);
    /**
     * The meta-property for the {@code yearFraction} property.
     */
    private final MetaProperty<Double> yearFraction = DirectMetaProperty.ofImmutable(
        this, "yearFraction", ExpandedFra.class, Double.TYPE);
    /**
     * The meta-property for the {@code fixedRate} property.
     */
    private final MetaProperty<Double> fixedRate = DirectMetaProperty.ofImmutable(
        this, "fixedRate", ExpandedFra.class, Double.TYPE);
    /**
     * The meta-property for the {@code floatingRate} property.
     */
    private final MetaProperty<RateObservation> floatingRate = DirectMetaProperty.ofImmutable(
        this, "floatingRate", ExpandedFra.class, RateObservation.class);
    /**
     * The meta-property for the {@code currency} property.
     */
    private final MetaProperty<Currency> currency = DirectMetaProperty.ofImmutable(
        this, "currency", ExpandedFra.class, Currency.class);
    /**
     * The meta-property for the {@code notional} property.
     */
    private final MetaProperty<Double> notional = DirectMetaProperty.ofImmutable(
        this, "notional", ExpandedFra.class, Double.TYPE);
    /**
     * The meta-property for the {@code discounting} property.
     */
    private final MetaProperty<FraDiscountingMethod> discounting = DirectMetaProperty.ofImmutable(
        this, "discounting", ExpandedFra.class, FraDiscountingMethod.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "buySell",
        "paymentDate",
        "startDate",
        "endDate",
        "yearFraction",
        "fixedRate",
        "floatingRate",
        "currency",
        "notional",
        "discounting");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 244977400:  // buySell
          return buySell;
        case -1540873516:  // paymentDate
          return paymentDate;
        case -2129778896:  // startDate
          return startDate;
        case -1607727319:  // endDate
          return endDate;
        case -1731780257:  // yearFraction
          return yearFraction;
        case 747425396:  // fixedRate
          return fixedRate;
        case -2130225658:  // floatingRate
          return floatingRate;
        case 575402001:  // currency
          return currency;
        case 1585636160:  // notional
          return notional;
        case -536441087:  // discounting
          return discounting;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public ExpandedFra.Builder builder() {
      return new ExpandedFra.Builder();
    }

    @Override
    public Class<? extends ExpandedFra> beanType() {
      return ExpandedFra.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code buySell} property.
     * @return the meta-property, not null
     */
    public MetaProperty<BuySell> buySell() {
      return buySell;
    }

    /**
     * The meta-property for the {@code paymentDate} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDate> paymentDate() {
      return paymentDate;
    }

    /**
     * The meta-property for the {@code startDate} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDate> startDate() {
      return startDate;
    }

    /**
     * The meta-property for the {@code endDate} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDate> endDate() {
      return endDate;
    }

    /**
     * The meta-property for the {@code yearFraction} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> yearFraction() {
      return yearFraction;
    }

    /**
     * The meta-property for the {@code fixedRate} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> fixedRate() {
      return fixedRate;
    }

    /**
     * The meta-property for the {@code floatingRate} property.
     * @return the meta-property, not null
     */
    public MetaProperty<RateObservation> floatingRate() {
      return floatingRate;
    }

    /**
     * The meta-property for the {@code currency} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Currency> currency() {
      return currency;
    }

    /**
     * The meta-property for the {@code notional} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> notional() {
      return notional;
    }

    /**
     * The meta-property for the {@code discounting} property.
     * @return the meta-property, not null
     */
    public MetaProperty<FraDiscountingMethod> discounting() {
      return discounting;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 244977400:  // buySell
          return ((ExpandedFra) bean).getBuySell();
        case -1540873516:  // paymentDate
          return ((ExpandedFra) bean).getPaymentDate();
        case -2129778896:  // startDate
          return ((ExpandedFra) bean).getStartDate();
        case -1607727319:  // endDate
          return ((ExpandedFra) bean).getEndDate();
        case -1731780257:  // yearFraction
          return ((ExpandedFra) bean).getYearFraction();
        case 747425396:  // fixedRate
          return ((ExpandedFra) bean).getFixedRate();
        case -2130225658:  // floatingRate
          return ((ExpandedFra) bean).getFloatingRate();
        case 575402001:  // currency
          return ((ExpandedFra) bean).getCurrency();
        case 1585636160:  // notional
          return ((ExpandedFra) bean).getNotional();
        case -536441087:  // discounting
          return ((ExpandedFra) bean).getDiscounting();
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
   * The bean-builder for {@code ExpandedFra}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<ExpandedFra> {

    private BuySell buySell;
    private LocalDate paymentDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private double yearFraction;
    private double fixedRate;
    private RateObservation floatingRate;
    private Currency currency;
    private double notional;
    private FraDiscountingMethod discounting;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(ExpandedFra beanToCopy) {
      this.buySell = beanToCopy.getBuySell();
      this.paymentDate = beanToCopy.getPaymentDate();
      this.startDate = beanToCopy.getStartDate();
      this.endDate = beanToCopy.getEndDate();
      this.yearFraction = beanToCopy.getYearFraction();
      this.fixedRate = beanToCopy.getFixedRate();
      this.floatingRate = beanToCopy.getFloatingRate();
      this.currency = beanToCopy.getCurrency();
      this.notional = beanToCopy.getNotional();
      this.discounting = beanToCopy.getDiscounting();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 244977400:  // buySell
          return buySell;
        case -1540873516:  // paymentDate
          return paymentDate;
        case -2129778896:  // startDate
          return startDate;
        case -1607727319:  // endDate
          return endDate;
        case -1731780257:  // yearFraction
          return yearFraction;
        case 747425396:  // fixedRate
          return fixedRate;
        case -2130225658:  // floatingRate
          return floatingRate;
        case 575402001:  // currency
          return currency;
        case 1585636160:  // notional
          return notional;
        case -536441087:  // discounting
          return discounting;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 244977400:  // buySell
          this.buySell = (BuySell) newValue;
          break;
        case -1540873516:  // paymentDate
          this.paymentDate = (LocalDate) newValue;
          break;
        case -2129778896:  // startDate
          this.startDate = (LocalDate) newValue;
          break;
        case -1607727319:  // endDate
          this.endDate = (LocalDate) newValue;
          break;
        case -1731780257:  // yearFraction
          this.yearFraction = (Double) newValue;
          break;
        case 747425396:  // fixedRate
          this.fixedRate = (Double) newValue;
          break;
        case -2130225658:  // floatingRate
          this.floatingRate = (RateObservation) newValue;
          break;
        case 575402001:  // currency
          this.currency = (Currency) newValue;
          break;
        case 1585636160:  // notional
          this.notional = (Double) newValue;
          break;
        case -536441087:  // discounting
          this.discounting = (FraDiscountingMethod) newValue;
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
    public ExpandedFra build() {
      return new ExpandedFra(
          buySell,
          paymentDate,
          startDate,
          endDate,
          yearFraction,
          fixedRate,
          floatingRate,
          currency,
          notional,
          discounting);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code buySell} property in the builder.
     * @param buySell  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder buySell(BuySell buySell) {
      JodaBeanUtils.notNull(buySell, "buySell");
      this.buySell = buySell;
      return this;
    }

    /**
     * Sets the {@code paymentDate} property in the builder.
     * @param paymentDate  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder paymentDate(LocalDate paymentDate) {
      JodaBeanUtils.notNull(paymentDate, "paymentDate");
      this.paymentDate = paymentDate;
      return this;
    }

    /**
     * Sets the {@code startDate} property in the builder.
     * @param startDate  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder startDate(LocalDate startDate) {
      JodaBeanUtils.notNull(startDate, "startDate");
      this.startDate = startDate;
      return this;
    }

    /**
     * Sets the {@code endDate} property in the builder.
     * @param endDate  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder endDate(LocalDate endDate) {
      JodaBeanUtils.notNull(endDate, "endDate");
      this.endDate = endDate;
      return this;
    }

    /**
     * Sets the {@code yearFraction} property in the builder.
     * @param yearFraction  the new value
     * @return this, for chaining, not null
     */
    public Builder yearFraction(double yearFraction) {
      ArgChecker.notNegative(yearFraction, "yearFraction");
      this.yearFraction = yearFraction;
      return this;
    }

    /**
     * Sets the {@code fixedRate} property in the builder.
     * @param fixedRate  the new value
     * @return this, for chaining, not null
     */
    public Builder fixedRate(double fixedRate) {
      this.fixedRate = fixedRate;
      return this;
    }

    /**
     * Sets the {@code floatingRate} property in the builder.
     * @param floatingRate  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder floatingRate(RateObservation floatingRate) {
      JodaBeanUtils.notNull(floatingRate, "floatingRate");
      this.floatingRate = floatingRate;
      return this;
    }

    /**
     * Sets the {@code currency} property in the builder.
     * @param currency  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder currency(Currency currency) {
      JodaBeanUtils.notNull(currency, "currency");
      this.currency = currency;
      return this;
    }

    /**
     * Sets the {@code notional} property in the builder.
     * @param notional  the new value
     * @return this, for chaining, not null
     */
    public Builder notional(double notional) {
      ArgChecker.notNegative(notional, "notional");
      this.notional = notional;
      return this;
    }

    /**
     * Sets the {@code discounting} property in the builder.
     * @param discounting  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder discounting(FraDiscountingMethod discounting) {
      JodaBeanUtils.notNull(discounting, "discounting");
      this.discounting = discounting;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(352);
      buf.append("ExpandedFra.Builder{");
      buf.append("buySell").append('=').append(JodaBeanUtils.toString(buySell)).append(',').append(' ');
      buf.append("paymentDate").append('=').append(JodaBeanUtils.toString(paymentDate)).append(',').append(' ');
      buf.append("startDate").append('=').append(JodaBeanUtils.toString(startDate)).append(',').append(' ');
      buf.append("endDate").append('=').append(JodaBeanUtils.toString(endDate)).append(',').append(' ');
      buf.append("yearFraction").append('=').append(JodaBeanUtils.toString(yearFraction)).append(',').append(' ');
      buf.append("fixedRate").append('=').append(JodaBeanUtils.toString(fixedRate)).append(',').append(' ');
      buf.append("floatingRate").append('=').append(JodaBeanUtils.toString(floatingRate)).append(',').append(' ');
      buf.append("currency").append('=').append(JodaBeanUtils.toString(currency)).append(',').append(' ');
      buf.append("notional").append('=').append(JodaBeanUtils.toString(notional)).append(',').append(' ');
      buf.append("discounting").append('=').append(JodaBeanUtils.toString(discounting));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}