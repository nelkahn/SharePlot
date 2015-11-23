package jet.shareplot.persistence.pojo.portfolio;

import java.io.Serializable;

import org.eclipse.jdt.annotation.NonNull;

import jet.framework.manager.datamodel.interfaces.DataModelRootNode;
import jet.framework.util.models.ModelHelper;
import jet.framework.util.pojo2.DispatcherModel;
import jet.framework.util.pojo2.JFDataItem;
import jet.framework.util.pojo2.JFErrorHandler;
import jet.framework.util.pojo2.JFErrorHandlerProvider;
import jet.framework.util.pojo2.interceptor.StringLengthInterceptor;
import jet.util.logger.JETLevel;
import jet.util.logger.JETLoggerManager;
import jet.util.logger.Logger;
import jet.util.logger.LoggerJUnit;
import jet.util.models.SimpleEventModelImpl;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;
import jet.util.throwable.JETSystemError;

/**
 * Simple pojo wrapper for the PortfolioShare Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 *
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public class PortfolioShareItem implements Serializable, JFErrorHandlerProvider, JFDataItem {

    private static final long serialVersionUID = 1L;

    private static final String ATTRIBUTE_DISPATCHER_MODEL = "jet.shareplot.persistence.pojo.portfolio.ATTRIBUTE_DISPATCHER_MODEL";

    private static final String IS_NEW_ATTRIBUTE = "jet.shareplot.persistence.pojo.portfolio.PortfolioShare.IS_NEW_ATTRIBUTE";

    /**
     * Name of the root node in an XML DOM.
     */
    public static final String TAG_NAME = "PortfolioShare";

    private final Model dataModel;
    private transient Logger logger;

    private transient DispatcherModel<PortfolioShareItem> idPortfolioDispatcherModel;
    private transient DispatcherModel<PortfolioShareItem> idShareDispatcherModel;
    private transient DispatcherModel<PortfolioShareItem> changeQuantityDispatcherModel;
    private transient DispatcherModel<PortfolioShareItem> portfolioNameDispatcherModel;
    private transient DispatcherModel<PortfolioShareItem> shareNameDispatcherModel;
    private transient DispatcherModel<PortfolioShareItem> totalQuantityDispatcherModel;
    private transient DispatcherModel<PortfolioShareItem> valueDispatcherModel;
    private transient DispatcherModel<PortfolioShareItem> valueDateDispatcherModel;

    private transient JFErrorHandler jfErrorHandler;

    /**
     * Constructor used to create a new PortfolioShare Data Model.
     */
    public PortfolioShareItem() {
        this.dataModel = new DataModelRootNode();
        init_DataModel();
        setNew(true);
    }

    private void init_DataModel() {
        this.dataModel.setTagName(TAG_NAME);

        SimpleEventModelImpl model = null;

        model = new SimpleEventModelImpl("idPortfolio");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("idShare");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("changeQuantity");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("portfolioName");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("shareName");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("totalQuantity");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("value");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("valueDate");
        this.dataModel.appendChild(model);
    }

    /**
     * Constructor used to edit an existing PortfolioShare Data Model.
     *
     * @param model Model to use to wrap in the pojo, can not be <code>null</code>
     */
    public PortfolioShareItem(final @NonNull Model model) {
        this.dataModel = model;

        // if isNew is null, the model comes from the database therefore is not null
        final Boolean isNew = (Boolean) get_Model().getAttribute(IS_NEW_ATTRIBUTE);
        if (isNew == null) {
            setNew(false);
        }
    }

    /**
     * Copy constructor used to clone an existing PortfolioShare Data Model.
     *
     * @param portfolioShare PortfolioShareItem to use to copy in the pojo, can not be <code>null</code>
     */
    public PortfolioShareItem(final @NonNull PortfolioShareItem portfolioShare) {
        this();

        setIdPortfolio(portfolioShare.getIdPortfolio());
        setIdShare(portfolioShare.getIdShare());
        setChangeQuantity(portfolioShare.getChangeQuantity());
        setPortfolioName(portfolioShare.getPortfolioName());
        setShareName(portfolioShare.getShareName());
        setTotalQuantity(portfolioShare.getTotalQuantity());
        setValue(portfolioShare.getValue());
        setValueDate(portfolioShare.getValueDate());

        setNew(portfolioShare.isNew());
    }

    private @NonNull Logger getLogger() {
        Logger result = this.logger;
        if (result == null) {
            // initialise the logger
            try {
                final JETLoggerManager loggerManager = JETLoggerManager.getJETLoggerManager();
                result = loggerManager.getLogger("jet.shareplot.persistence.pojo.portfolio");
            } catch (final JETSystemError e) {
                // probably running in junit, use junitLogger
                result = LoggerJUnit.getInstance();
            }
            this.logger = result;
        }
        return result;
    }

    @Override
    public final boolean isDirty() {
        if (get_Model() instanceof DataModelRootNode) {
            final DataModelRootNode dmrn = (DataModelRootNode) get_Model();
            return dmrn.isDirty();
        }
        getLogger().logp(JETLevel.INFO, "PortfolioShareItem", "isDirty", "Model is not a DataModelRootNode can not define if it is dirty.");
        return false;
    }

    /**
     * Check if this portfolioShare is new.
     *
     * @return <code>true</code> if this portfolioShare is new.
     * @see JFDataItem
     */
    @Override
    public final boolean isNew() {
        final Boolean isNew = (Boolean) get_Model().getAttribute(IS_NEW_ATTRIBUTE);
        assert isNew != null : "IS_NEW_ATTRIBUTE always initialised in constructor should not be null.";
        return Boolean.TRUE.equals(isNew);
    }

    /**
     * Set the isNew state of the object.
     *
     * @param isNew <code>true</code> to indicate this object is new
     */
    protected final void setNew(final boolean isNew) {
        if (isNew) {
            get_Model().setAttribute(IS_NEW_ATTRIBUTE, Boolean.TRUE);
        } else {
            get_Model().setAttribute(IS_NEW_ATTRIBUTE, Boolean.FALSE);
        }
    }

    /* (non-Javadoc)
     * @see JFErrorHandlerProvider#setJFErrorHandler(JFErrorHandler)
     */
    @Override
    public final void setJFErrorHandler(final JFErrorHandler jfErrorHandler) {
        this.jfErrorHandler = jfErrorHandler;
    }

    /* (non-Javadoc)
     * @see JFErrorHandlerProvider#getJFErrorHandler()
     */
    @Override
    public final JFErrorHandler getJFErrorHandler() {
        return this.jfErrorHandler;
    }

    /**
     * Get the PortfolioShare Data Model that is wrapped in this pojo.
     *
     * @return PortfolioShare Data Model
     * @see JFDataItem
     */
    @Override
    public final @NonNull Model get_Model() {
        Model model = this.dataModel;
        assert model != null;
        return model;
    }

    /**
     * Get node value of Data Model node idPortfolio.
     * This field should not be <code>null</code> in the database.
     *
     * @return Long value of Data Model node idPortfolio
     */
    public final Long getIdPortfolio() {
        return (Long) get_IdPortfolio_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node idPortfolio.
     * This field should not be <code>null</code> in the database.
     *
     * @param idPortfolio Long value of Data Model node idPortfolio
     */
    public final void setIdPortfolio(final Long idPortfolio) {
        get_IdPortfolio_Model().setNodeValue(idPortfolio);
    }

    /**
     * Get Model of Data Model node idPortfolio.
     *
     * @return Model of Data Model node idPortfolio
     */
    @SuppressWarnings("unchecked")
    public final @NonNull DispatcherModel<PortfolioShareItem> get_IdPortfolio_Model() {
        if (this.idPortfolioDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "idPortfolio");
                this.idPortfolioDispatcherModel = (DispatcherModel<PortfolioShareItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.idPortfolioDispatcherModel == null) {
                    this.idPortfolioDispatcherModel = new DispatcherModel<PortfolioShareItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.idPortfolioDispatcherModel);
                    sourceModel.setAttribute(DispatcherModel.DISPATCHER_MODEL_ATTRIBUTE, this.idPortfolioDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("PortfolioShare data model does not have a child named idPortfolio. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<PortfolioShareItem> dm = this.idPortfolioDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node idShare.
     * This field should not be <code>null</code> in the database.
     *
     * @return Long value of Data Model node idShare
     */
    public final Long getIdShare() {
        return (Long) get_IdShare_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node idShare.
     * This field should not be <code>null</code> in the database.
     *
     * @param idShare Long value of Data Model node idShare
     */
    public final void setIdShare(final Long idShare) {
        get_IdShare_Model().setNodeValue(idShare);
    }

    /**
     * Get Model of Data Model node idShare.
     *
     * @return Model of Data Model node idShare
     */
    @SuppressWarnings("unchecked")
    public final @NonNull DispatcherModel<PortfolioShareItem> get_IdShare_Model() {
        if (this.idShareDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "idShare");
                this.idShareDispatcherModel = (DispatcherModel<PortfolioShareItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.idShareDispatcherModel == null) {
                    this.idShareDispatcherModel = new DispatcherModel<PortfolioShareItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.idShareDispatcherModel);
                    sourceModel.setAttribute(DispatcherModel.DISPATCHER_MODEL_ATTRIBUTE, this.idShareDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("PortfolioShare data model does not have a child named idShare. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<PortfolioShareItem> dm = this.idShareDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node changeQuantity.
     * This field should not be <code>null</code> in the database.
     *
     * @return java.math.BigDecimal value of Data Model node changeQuantity
     */
    public final java.math.BigDecimal getChangeQuantity() {
        return (java.math.BigDecimal) get_ChangeQuantity_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node changeQuantity.
     * This field should not be <code>null</code> in the database.
     *
     * @param changeQuantity java.math.BigDecimal value of Data Model node changeQuantity
     */
    public final void setChangeQuantity(final java.math.BigDecimal changeQuantity) {
        get_ChangeQuantity_Model().setNodeValue(changeQuantity);
    }

    /**
     * Get Model of Data Model node changeQuantity.
     *
     * @return Model of Data Model node changeQuantity
     */
    @SuppressWarnings("unchecked")
    public final @NonNull DispatcherModel<PortfolioShareItem> get_ChangeQuantity_Model() {
        if (this.changeQuantityDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "changeQuantity");
                this.changeQuantityDispatcherModel = (DispatcherModel<PortfolioShareItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.changeQuantityDispatcherModel == null) {
                    this.changeQuantityDispatcherModel = new DispatcherModel<PortfolioShareItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.changeQuantityDispatcherModel);
                    sourceModel.setAttribute(DispatcherModel.DISPATCHER_MODEL_ATTRIBUTE, this.changeQuantityDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("PortfolioShare data model does not have a child named changeQuantity. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<PortfolioShareItem> dm = this.changeQuantityDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node portfolioName.
     * This field should not be <code>null</code> in the database.
     *
     * @return String value of Data Model node portfolioName
     */
    public final String getPortfolioName() {
        return (String) get_PortfolioName_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node portfolioName.
     * This field should not be <code>null</code> in the database.
     *
     * @param portfolioName String value of Data Model node portfolioName
     */
    public final void setPortfolioName(final String portfolioName) {
        get_PortfolioName_Model().setNodeValue(portfolioName);
    }

    /**
     * Get Model of Data Model node portfolioName.
     *
     * @return Model of Data Model node portfolioName
     */
    @SuppressWarnings("unchecked")
    public final @NonNull DispatcherModel<PortfolioShareItem> get_PortfolioName_Model() {
        if (this.portfolioNameDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "portfolioName");
                this.portfolioNameDispatcherModel = (DispatcherModel<PortfolioShareItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.portfolioNameDispatcherModel == null) {
                    this.portfolioNameDispatcherModel = new DispatcherModel<PortfolioShareItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.portfolioNameDispatcherModel);
                    sourceModel.setAttribute(DispatcherModel.DISPATCHER_MODEL_ATTRIBUTE, this.portfolioNameDispatcherModel);
                }

                this.portfolioNameDispatcherModel.addInterceptor(StringLengthInterceptor.getStringLengthInterceptor(45));
            } catch (final JETException e) {
                throw new JETSystemError("PortfolioShare data model does not have a child named portfolioName. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<PortfolioShareItem> dm = this.portfolioNameDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node shareName.
     * This field should not be <code>null</code> in the database.
     *
     * @return String value of Data Model node shareName
     */
    public final String getShareName() {
        return (String) get_ShareName_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node shareName.
     * This field should not be <code>null</code> in the database.
     *
     * @param shareName String value of Data Model node shareName
     */
    public final void setShareName(final String shareName) {
        get_ShareName_Model().setNodeValue(shareName);
    }

    /**
     * Get Model of Data Model node shareName.
     *
     * @return Model of Data Model node shareName
     */
    @SuppressWarnings("unchecked")
    public final @NonNull DispatcherModel<PortfolioShareItem> get_ShareName_Model() {
        if (this.shareNameDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "shareName");
                this.shareNameDispatcherModel = (DispatcherModel<PortfolioShareItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.shareNameDispatcherModel == null) {
                    this.shareNameDispatcherModel = new DispatcherModel<PortfolioShareItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.shareNameDispatcherModel);
                    sourceModel.setAttribute(DispatcherModel.DISPATCHER_MODEL_ATTRIBUTE, this.shareNameDispatcherModel);
                }

                this.shareNameDispatcherModel.addInterceptor(StringLengthInterceptor.getStringLengthInterceptor(255));
            } catch (final JETException e) {
                throw new JETSystemError("PortfolioShare data model does not have a child named shareName. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<PortfolioShareItem> dm = this.shareNameDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node totalQuantity.
     * This field should not be <code>null</code> in the database.
     *
     * @return java.math.BigDecimal value of Data Model node totalQuantity
     */
    public final java.math.BigDecimal getTotalQuantity() {
        return (java.math.BigDecimal) get_TotalQuantity_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node totalQuantity.
     * This field should not be <code>null</code> in the database.
     *
     * @param totalQuantity java.math.BigDecimal value of Data Model node totalQuantity
     */
    public final void setTotalQuantity(final java.math.BigDecimal totalQuantity) {
        get_TotalQuantity_Model().setNodeValue(totalQuantity);
    }

    /**
     * Get Model of Data Model node totalQuantity.
     *
     * @return Model of Data Model node totalQuantity
     */
    @SuppressWarnings("unchecked")
    public final @NonNull DispatcherModel<PortfolioShareItem> get_TotalQuantity_Model() {
        if (this.totalQuantityDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "totalQuantity");
                this.totalQuantityDispatcherModel = (DispatcherModel<PortfolioShareItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.totalQuantityDispatcherModel == null) {
                    this.totalQuantityDispatcherModel = new DispatcherModel<PortfolioShareItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.totalQuantityDispatcherModel);
                    sourceModel.setAttribute(DispatcherModel.DISPATCHER_MODEL_ATTRIBUTE, this.totalQuantityDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("PortfolioShare data model does not have a child named totalQuantity. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<PortfolioShareItem> dm = this.totalQuantityDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node value.
     * This field should not be <code>null</code> in the database.
     *
     * @return java.math.BigDecimal value of Data Model node value
     */
    public final java.math.BigDecimal getValue() {
        return (java.math.BigDecimal) get_Value_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node value.
     * This field should not be <code>null</code> in the database.
     *
     * @param value java.math.BigDecimal value of Data Model node value
     */
    public final void setValue(final java.math.BigDecimal value) {
        get_Value_Model().setNodeValue(value);
    }

    /**
     * Get Model of Data Model node value.
     *
     * @return Model of Data Model node value
     */
    @SuppressWarnings("unchecked")
    public final @NonNull DispatcherModel<PortfolioShareItem> get_Value_Model() {
        if (this.valueDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "value");
                this.valueDispatcherModel = (DispatcherModel<PortfolioShareItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.valueDispatcherModel == null) {
                    this.valueDispatcherModel = new DispatcherModel<PortfolioShareItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.valueDispatcherModel);
                    sourceModel.setAttribute(DispatcherModel.DISPATCHER_MODEL_ATTRIBUTE, this.valueDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("PortfolioShare data model does not have a child named value. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<PortfolioShareItem> dm = this.valueDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Get node value of Data Model node valueDate.
     * This field should not be <code>null</code> in the database.
     *
     * @return java.util.Date value of Data Model node valueDate
     */
    public final java.util.Date getValueDate() {
        return (java.util.Date) get_ValueDate_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node valueDate.
     * This field should not be <code>null</code> in the database.
     *
     * @param valueDate java.util.Date value of Data Model node valueDate
     */
    public final void setValueDate(final java.util.Date valueDate) {
        get_ValueDate_Model().setNodeValue(valueDate);
    }

    /**
     * Get Model of Data Model node valueDate.
     *
     * @return Model of Data Model node valueDate
     */
    @SuppressWarnings("unchecked")
    public final @NonNull DispatcherModel<PortfolioShareItem> get_ValueDate_Model() {
        if (this.valueDateDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(get_Model(), "valueDate");
                this.valueDateDispatcherModel = (DispatcherModel<PortfolioShareItem>) sourceModel.getAttribute(ATTRIBUTE_DISPATCHER_MODEL);
                if (this.valueDateDispatcherModel == null) {
                    this.valueDateDispatcherModel = new DispatcherModel<PortfolioShareItem>(this, sourceModel);
                    sourceModel.setAttribute(ATTRIBUTE_DISPATCHER_MODEL, this.valueDateDispatcherModel);
                    sourceModel.setAttribute(DispatcherModel.DISPATCHER_MODEL_ATTRIBUTE, this.valueDateDispatcherModel);
                }
            } catch (final JETException e) {
                throw new JETSystemError("PortfolioShare data model does not have a child named valueDate. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        final DispatcherModel<PortfolioShareItem> dm = this.valueDateDispatcherModel;
        assert dm != null;
        return dm;
    }

    /**
     * Check if any node not nullable is <code>null</code>.
     * <ul>
     * <li><b>idPortfolio</b> can not be <code>null</code> in the database.</li>
     * <li><b>idShare</b> can not be <code>null</code> in the database.</li>
     * <li><b>changeQuantity</b> can not be <code>null</code> in the database.</li>
     * <li><b>portfolioName</b> can not be <code>null</code> in the database.</li>
     * <li><b>shareName</b> can not be <code>null</code> in the database.</li>
     * <li><b>totalQuantity</b> can not be <code>null</code> in the database.</li>
     * <li><b>value</b> can not be <code>null</code> in the database.</li>
     * <li><b>valueDate</b> can not be <code>null</code> in the database.</li>
     * </ul>
     *
     * @return <code>true</code> if any node not nullable is <code>null</code>
     * @see JFDataItem
     */
    @Override
    public final boolean isNotNullableNull() {
        final Long idPortfolio = getIdPortfolio();
        if (idPortfolio == null) {
            getLogger().logp(JETLevel.WARNING, "PortfolioShareItem", "isNotNullableNull",
                "idPortfolio is null but is not nullable.");
            return true;
        }
        final Long idShare = getIdShare();
        if (idShare == null) {
            getLogger().logp(JETLevel.WARNING, "PortfolioShareItem", "isNotNullableNull",
                "idShare is null but is not nullable.");
            return true;
        }
        final java.math.BigDecimal changeQuantity = getChangeQuantity();
        if (changeQuantity == null) {
            getLogger().logp(JETLevel.WARNING, "PortfolioShareItem", "isNotNullableNull",
                "changeQuantity is null but is not nullable.");
            return true;
        }
        final String portfolioName = getPortfolioName();
        if (portfolioName == null) {
            getLogger().logp(JETLevel.WARNING, "PortfolioShareItem", "isNotNullableNull",
                "portfolioName is null but is not nullable.");
            return true;
        }
        final String shareName = getShareName();
        if (shareName == null) {
            getLogger().logp(JETLevel.WARNING, "PortfolioShareItem", "isNotNullableNull",
                "shareName is null but is not nullable.");
            return true;
        }
        final java.math.BigDecimal totalQuantity = getTotalQuantity();
        if (totalQuantity == null) {
            getLogger().logp(JETLevel.WARNING, "PortfolioShareItem", "isNotNullableNull",
                "totalQuantity is null but is not nullable.");
            return true;
        }
        final java.math.BigDecimal value = getValue();
        if (value == null) {
            getLogger().logp(JETLevel.WARNING, "PortfolioShareItem", "isNotNullableNull",
                "value is null but is not nullable.");
            return true;
        }
        final java.util.Date valueDate = getValueDate();
        if (valueDate == null) {
            getLogger().logp(JETLevel.WARNING, "PortfolioShareItem", "isNotNullableNull",
                "valueDate is null but is not nullable.");
            return true;
        }
        return false;
    }

    /**
     * Check if this PK is the same as the PK from another PortfolioShareItem.
     *
     * @param other PortfolioShareItem to compare with
     * @return <code>true</code> if the pk fields from the two objects have the same values
     * @see JFDataItem
     */
    @Override
    public final boolean isPkEquals(final JFDataItem other) {
        boolean result = false;
        
        if ( getIdPortfolio() != null && getIdShare() != null) {
            if (other instanceof PortfolioShareItem) {
                final PortfolioShareItem otherPortfolioShare = (PortfolioShareItem) other;
                if ( getIdPortfolio().equals(otherPortfolioShare.getIdPortfolio()) && getIdShare().equals(otherPortfolioShare.getIdShare())) {
                    result = true;
                }
            }
        }
        
        return result;
    }
}
