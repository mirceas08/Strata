/*
 * *
 *  * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *  *
 *  * Please see distribution for license.
 *
 *
 */

package com.opengamma.strata.finance.credit.markit;

import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.collect.id.StandardId;
import com.opengamma.strata.finance.credit.RestructuringClause;
import com.opengamma.strata.finance.credit.SeniorityLevel;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.PropertyDefinition;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.joda.beans.Bean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

@BeanDefinition
public final class SingleNameDataKey
    implements ImmutableBean, Serializable {

  /**
   * A CDS entity identifier (e.g. 03AFCJ for Apple Inc.)
   */
  @PropertyDefinition(validate = "notNull")
  final StandardId entityId;

  @PropertyDefinition(validate = "notNull")
  final SeniorityLevel seniorityLevel;

  @PropertyDefinition(validate = "notNull")
  final Currency currency;

  @PropertyDefinition(validate = "notNull")
  final RestructuringClause restructuringClause;
  
  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code SingleNameDataKey}.
   * @return the meta-bean, not null
   */
  public static SingleNameDataKey.Meta meta() {
    return SingleNameDataKey.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(SingleNameDataKey.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static SingleNameDataKey.Builder builder() {
    return new SingleNameDataKey.Builder();
  }

  private SingleNameDataKey(
      StandardId entityId,
      SeniorityLevel seniorityLevel,
      Currency currency,
      RestructuringClause restructuringClause) {
    JodaBeanUtils.notNull(entityId, "entityId");
    JodaBeanUtils.notNull(seniorityLevel, "seniorityLevel");
    JodaBeanUtils.notNull(currency, "currency");
    JodaBeanUtils.notNull(restructuringClause, "restructuringClause");
    this.entityId = entityId;
    this.seniorityLevel = seniorityLevel;
    this.currency = currency;
    this.restructuringClause = restructuringClause;
  }

  @Override
  public SingleNameDataKey.Meta metaBean() {
    return SingleNameDataKey.Meta.INSTANCE;
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
   * Gets a CDS entity identifier (e.g. 03AFCJ for Apple Inc.)
   * @return the value of the property, not null
   */
  public StandardId getEntityId() {
    return entityId;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the seniorityLevel.
   * @return the value of the property, not null
   */
  public SeniorityLevel getSeniorityLevel() {
    return seniorityLevel;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the currency.
   * @return the value of the property, not null
   */
  public Currency getCurrency() {
    return currency;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the restructuringClause.
   * @return the value of the property, not null
   */
  public RestructuringClause getRestructuringClause() {
    return restructuringClause;
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
      SingleNameDataKey other = (SingleNameDataKey) obj;
      return JodaBeanUtils.equal(getEntityId(), other.getEntityId()) &&
          JodaBeanUtils.equal(getSeniorityLevel(), other.getSeniorityLevel()) &&
          JodaBeanUtils.equal(getCurrency(), other.getCurrency()) &&
          JodaBeanUtils.equal(getRestructuringClause(), other.getRestructuringClause());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getEntityId());
    hash = hash * 31 + JodaBeanUtils.hashCode(getSeniorityLevel());
    hash = hash * 31 + JodaBeanUtils.hashCode(getCurrency());
    hash = hash * 31 + JodaBeanUtils.hashCode(getRestructuringClause());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(160);
    buf.append("SingleNameDataKey{");
    buf.append("entityId").append('=').append(getEntityId()).append(',').append(' ');
    buf.append("seniorityLevel").append('=').append(getSeniorityLevel()).append(',').append(' ');
    buf.append("currency").append('=').append(getCurrency()).append(',').append(' ');
    buf.append("restructuringClause").append('=').append(JodaBeanUtils.toString(getRestructuringClause()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code SingleNameDataKey}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code entityId} property.
     */
    private final MetaProperty<StandardId> entityId = DirectMetaProperty.ofImmutable(
        this, "entityId", SingleNameDataKey.class, StandardId.class);
    /**
     * The meta-property for the {@code seniorityLevel} property.
     */
    private final MetaProperty<SeniorityLevel> seniorityLevel = DirectMetaProperty.ofImmutable(
        this, "seniorityLevel", SingleNameDataKey.class, SeniorityLevel.class);
    /**
     * The meta-property for the {@code currency} property.
     */
    private final MetaProperty<Currency> currency = DirectMetaProperty.ofImmutable(
        this, "currency", SingleNameDataKey.class, Currency.class);
    /**
     * The meta-property for the {@code restructuringClause} property.
     */
    private final MetaProperty<RestructuringClause> restructuringClause = DirectMetaProperty.ofImmutable(
        this, "restructuringClause", SingleNameDataKey.class, RestructuringClause.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "entityId",
        "seniorityLevel",
        "currency",
        "restructuringClause");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -2102099874:  // entityId
          return entityId;
        case 1229868454:  // seniorityLevel
          return seniorityLevel;
        case 575402001:  // currency
          return currency;
        case -1774904020:  // restructuringClause
          return restructuringClause;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public SingleNameDataKey.Builder builder() {
      return new SingleNameDataKey.Builder();
    }

    @Override
    public Class<? extends SingleNameDataKey> beanType() {
      return SingleNameDataKey.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code entityId} property.
     * @return the meta-property, not null
     */
    public MetaProperty<StandardId> entityId() {
      return entityId;
    }

    /**
     * The meta-property for the {@code seniorityLevel} property.
     * @return the meta-property, not null
     */
    public MetaProperty<SeniorityLevel> seniorityLevel() {
      return seniorityLevel;
    }

    /**
     * The meta-property for the {@code currency} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Currency> currency() {
      return currency;
    }

    /**
     * The meta-property for the {@code restructuringClause} property.
     * @return the meta-property, not null
     */
    public MetaProperty<RestructuringClause> restructuringClause() {
      return restructuringClause;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -2102099874:  // entityId
          return ((SingleNameDataKey) bean).getEntityId();
        case 1229868454:  // seniorityLevel
          return ((SingleNameDataKey) bean).getSeniorityLevel();
        case 575402001:  // currency
          return ((SingleNameDataKey) bean).getCurrency();
        case -1774904020:  // restructuringClause
          return ((SingleNameDataKey) bean).getRestructuringClause();
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
   * The bean-builder for {@code SingleNameDataKey}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<SingleNameDataKey> {

    private StandardId entityId;
    private SeniorityLevel seniorityLevel;
    private Currency currency;
    private RestructuringClause restructuringClause;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(SingleNameDataKey beanToCopy) {
      this.entityId = beanToCopy.getEntityId();
      this.seniorityLevel = beanToCopy.getSeniorityLevel();
      this.currency = beanToCopy.getCurrency();
      this.restructuringClause = beanToCopy.getRestructuringClause();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -2102099874:  // entityId
          return entityId;
        case 1229868454:  // seniorityLevel
          return seniorityLevel;
        case 575402001:  // currency
          return currency;
        case -1774904020:  // restructuringClause
          return restructuringClause;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -2102099874:  // entityId
          this.entityId = (StandardId) newValue;
          break;
        case 1229868454:  // seniorityLevel
          this.seniorityLevel = (SeniorityLevel) newValue;
          break;
        case 575402001:  // currency
          this.currency = (Currency) newValue;
          break;
        case -1774904020:  // restructuringClause
          this.restructuringClause = (RestructuringClause) newValue;
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
    public SingleNameDataKey build() {
      return new SingleNameDataKey(
          entityId,
          seniorityLevel,
          currency,
          restructuringClause);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code entityId} property in the builder.
     * @param entityId  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder entityId(StandardId entityId) {
      JodaBeanUtils.notNull(entityId, "entityId");
      this.entityId = entityId;
      return this;
    }

    /**
     * Sets the {@code seniorityLevel} property in the builder.
     * @param seniorityLevel  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder seniorityLevel(SeniorityLevel seniorityLevel) {
      JodaBeanUtils.notNull(seniorityLevel, "seniorityLevel");
      this.seniorityLevel = seniorityLevel;
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
     * Sets the {@code restructuringClause} property in the builder.
     * @param restructuringClause  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder restructuringClause(RestructuringClause restructuringClause) {
      JodaBeanUtils.notNull(restructuringClause, "restructuringClause");
      this.restructuringClause = restructuringClause;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(160);
      buf.append("SingleNameDataKey.Builder{");
      buf.append("entityId").append('=').append(JodaBeanUtils.toString(entityId)).append(',').append(' ');
      buf.append("seniorityLevel").append('=').append(JodaBeanUtils.toString(seniorityLevel)).append(',').append(' ');
      buf.append("currency").append('=').append(JodaBeanUtils.toString(currency)).append(',').append(' ');
      buf.append("restructuringClause").append('=').append(JodaBeanUtils.toString(restructuringClause));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
