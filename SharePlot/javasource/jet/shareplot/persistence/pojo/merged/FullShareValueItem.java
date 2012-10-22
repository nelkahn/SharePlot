package jet.shareplot.persistence.pojo.merged;

import java.io.Serializable;

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
 * Simple pojo wrapper for the FullShareValue Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 *
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public class FullShareValueItem implements Serializable, JFErrorHandlerProvider, JFDataItem {

    private static final long serialVersionUID = 1L;

    private Model dataModel;
    private Logger logger;

    private DispatcherModel<FullShareValueItem, Long> idShareValueDispatcherModel;
    private DispatcherModel<FullShareValueItem, String> codeISINDispatcherModel;
    private DispatcherModel<FullShareValueItem, String> codeYahooDispatcherModel;
    private DispatcherModel<FullShareValueItem, String> descriptionDispatcherModel;
    private DispatcherModel<FullShareValueItem, Long> idPortfolioDispatcherModel;
    private DispatcherModel<FullShareValueItem, Long> idShareDispatcherModel;
    private DispatcherModel<FullShareValueItem, String> nameDispatcherModel;
    private DispatcherModel<FullShareValueItem, java.math.BigDecimal> valueDispatcherModel;
    private DispatcherModel<FullShareValueItem, java.util.Date> valueDateDispatcherModel;

    private JFErrorHandler jfErrorHandler;

    /**
     * Constructor used to create a new FullShareValue Data Model
     */
    public FullShareValueItem() {
        // initialise the logger
        try {
            final JETLoggerManager loggerManager = JETLoggerManager.getJETLoggerManager();
            this.logger = loggerManager.getLogger("jet.shareplot.persistence.pojo.merged");
        } catch (final JETSystemError e) {
            // probably running in junit, use junitLogger
            this.logger = LoggerJUnit.getInstance();
        }

        init_DataModel();
    }

    private void init_DataModel() {
        this.dataModel = new DataModelRootNode();
        this.dataModel.setTagName("FullShareValue");

        SimpleEventModelImpl model = null;

        model = new SimpleEventModelImpl("idShareValue");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("codeISIN");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("codeYahoo");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("description");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("idPortfolio");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("idShare");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("name");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("value");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("valueDate");
        this.dataModel.appendChild(model);
    }

    /**
     * Constructor used to edit an existing FullShareValue Data Model
     * @param model Model to use to wrap in the pojo, can not be null
     * @throws IllegalArgumentException if model is null
     */
    public FullShareValueItem(final Model model) {
        if (model == null) {
            throw new IllegalArgumentException("model argument can not be null");
        }
        // initialise the logger
        try {
            final JETLoggerManager loggerManager = JETLoggerManager.getJETLoggerManager();
            this.logger = loggerManager.getLogger("jet.shareplot.persistence.pojo.merged");
        } catch (final JETSystemError e) {
            // probably running in junit, use junitLogger
            this.logger = LoggerJUnit.getInstance();
        }

        this.dataModel = model;
    }

    /**
     * Copy constructor used to clone an existing FullShareValue Data Model
     * @param fullShareValue FullShareValueItem to use to copy in the pojo, can not be null
     * @throws IllegalArgumentException if fullShareValue is null
     */
    public FullShareValueItem(final FullShareValueItem fullShareValue) {
        this();
        if (fullShareValue == null) {
            throw new IllegalArgumentException("fullShareValue argument can not be null");
        }

        setIdShareValue(fullShareValue.getIdShareValue());
        setCodeISIN(fullShareValue.getCodeISIN());
        setCodeYahoo(fullShareValue.getCodeYahoo());
        setDescription(fullShareValue.getDescription());
        setIdPortfolio(fullShareValue.getIdPortfolio());
        setIdShare(fullShareValue.getIdShare());
        setName(fullShareValue.getName());
        setValue(fullShareValue.getValue());
        setValueDate(fullShareValue.getValueDate());
    }

    /* (non-Javadoc)
     * @see JFErrorHandlerProvider#setJFErrorHandler(JFErrorHandler)
     */
    @Override
    public void setJFErrorHandler(final JFErrorHandler jfErrorHandler) {
        this.jfErrorHandler = jfErrorHandler;
    }

    /* (non-Javadoc)
     * @see JFErrorHandlerProvider#getJFErrorHandler()
     */
    @Override
    public JFErrorHandler getJFErrorHandler() {
        return this.jfErrorHandler;
    }

    /**
     * Get the FullShareValue Data Model that is wrapped in this pojo
     * @return FullShareValue Data Model
     * @see JFDataItem
     */
    @Override
    public final Model get_Model() {
        return this.dataModel;
    }

    /**
     * Get node value of Data Model node idShareValue
     * @return Long value of Data Model node idShareValue
     */
    public final Long getIdShareValue() {
        return (Long) get_IdShareValue_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node idShareValue
     * @param idShareValue Long value of Data Model node idShareValue
     */
    private final void setIdShareValue(final Long idShareValue) {
        get_IdShareValue_Model().setNodeValue(idShareValue);
    }

    /**
     * Get Model of Data Model node idShareValue
     * @return Model of Data Model node idShareValue
     */
    public final DispatcherModel<FullShareValueItem, Long> get_IdShareValue_Model() {
        if (this.idShareValueDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "idShareValue");
                this.idShareValueDispatcherModel = new DispatcherModel<FullShareValueItem, Long>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("FullShareValue data model does not have a child named idShareValue. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.idShareValueDispatcherModel;
    }

    /**
     * Get node value of Data Model node codeISIN
     * @return String value of Data Model node codeISIN
     */
    public final String getCodeISIN() {
        return (String) get_CodeISIN_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node codeISIN
     * @param codeISIN String value of Data Model node codeISIN
     */
    public final void setCodeISIN(String codeISIN) {
        get_CodeISIN_Model().setNodeValue(codeISIN);
    }

    /**
     * Get Model of Data Model node codeISIN
     * @return Model of Data Model node codeISIN
     */
    public final DispatcherModel<FullShareValueItem, String> get_CodeISIN_Model() {
        if (this.codeISINDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "codeISIN");
                this.codeISINDispatcherModel = new DispatcherModel<FullShareValueItem, String>(this, sourceModel);

                this.codeISINDispatcherModel.addInterceptor(new StringLengthInterceptor<FullShareValueItem>(45));
            } catch (final JETException e) {
                throw new JETSystemError("FullShareValue data model does not have a child named codeISIN. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.codeISINDispatcherModel;
    }

    /**
     * Get node value of Data Model node codeYahoo
     * @return String value of Data Model node codeYahoo
     */
    public final String getCodeYahoo() {
        return (String) get_CodeYahoo_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node codeYahoo
     * @param codeYahoo String value of Data Model node codeYahoo
     */
    public final void setCodeYahoo(String codeYahoo) {
        get_CodeYahoo_Model().setNodeValue(codeYahoo);
    }

    /**
     * Get Model of Data Model node codeYahoo
     * @return Model of Data Model node codeYahoo
     */
    public final DispatcherModel<FullShareValueItem, String> get_CodeYahoo_Model() {
        if (this.codeYahooDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "codeYahoo");
                this.codeYahooDispatcherModel = new DispatcherModel<FullShareValueItem, String>(this, sourceModel);

                this.codeYahooDispatcherModel.addInterceptor(new StringLengthInterceptor<FullShareValueItem>(45));
            } catch (final JETException e) {
                throw new JETSystemError("FullShareValue data model does not have a child named codeYahoo. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.codeYahooDispatcherModel;
    }

    /**
     * Get node value of Data Model node description
     * @return String value of Data Model node description
     */
    public final String getDescription() {
        return (String) get_Description_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node description
     * @param description String value of Data Model node description
     */
    public final void setDescription(String description) {
        get_Description_Model().setNodeValue(description);
    }

    /**
     * Get Model of Data Model node description
     * @return Model of Data Model node description
     */
    public final DispatcherModel<FullShareValueItem, String> get_Description_Model() {
        if (this.descriptionDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "description");
                this.descriptionDispatcherModel = new DispatcherModel<FullShareValueItem, String>(this, sourceModel);

                this.descriptionDispatcherModel.addInterceptor(new StringLengthInterceptor<FullShareValueItem>(4000));
            } catch (final JETException e) {
                throw new JETSystemError("FullShareValue data model does not have a child named description. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.descriptionDispatcherModel;
    }

    /**
     * Get node value of Data Model node idPortfolio
     * @return Long value of Data Model node idPortfolio
     */
    public final Long getIdPortfolio() {
        return (Long) get_IdPortfolio_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node idPortfolio
     * @param idPortfolio Long value of Data Model node idPortfolio
     */
    public final void setIdPortfolio(Long idPortfolio) {
        get_IdPortfolio_Model().setNodeValue(idPortfolio);
    }

    /**
     * Get Model of Data Model node idPortfolio
     * @return Model of Data Model node idPortfolio
     */
    public final DispatcherModel<FullShareValueItem, Long> get_IdPortfolio_Model() {
        if (this.idPortfolioDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "idPortfolio");
                this.idPortfolioDispatcherModel = new DispatcherModel<FullShareValueItem, Long>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("FullShareValue data model does not have a child named idPortfolio. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.idPortfolioDispatcherModel;
    }

    /**
     * Get node value of Data Model node idShare
     * @return Long value of Data Model node idShare
     */
    public final Long getIdShare() {
        return (Long) get_IdShare_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node idShare
     * @param idShare Long value of Data Model node idShare
     */
    public final void setIdShare(Long idShare) {
        get_IdShare_Model().setNodeValue(idShare);
    }

    /**
     * Get Model of Data Model node idShare
     * @return Model of Data Model node idShare
     */
    public final DispatcherModel<FullShareValueItem, Long> get_IdShare_Model() {
        if (this.idShareDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "idShare");
                this.idShareDispatcherModel = new DispatcherModel<FullShareValueItem, Long>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("FullShareValue data model does not have a child named idShare. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.idShareDispatcherModel;
    }

    /**
     * Get node value of Data Model node name
     * @return String value of Data Model node name
     */
    public final String getName() {
        return (String) get_Name_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node name
     * @param name String value of Data Model node name
     */
    public final void setName(String name) {
        get_Name_Model().setNodeValue(name);
    }

    /**
     * Get Model of Data Model node name
     * @return Model of Data Model node name
     */
    public final DispatcherModel<FullShareValueItem, String> get_Name_Model() {
        if (this.nameDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "name");
                this.nameDispatcherModel = new DispatcherModel<FullShareValueItem, String>(this, sourceModel);

                this.nameDispatcherModel.addInterceptor(new StringLengthInterceptor<FullShareValueItem>(255));
            } catch (final JETException e) {
                throw new JETSystemError("FullShareValue data model does not have a child named name. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.nameDispatcherModel;
    }

    /**
     * Get node value of Data Model node value
     * @return java.math.BigDecimal value of Data Model node value
     */
    public final java.math.BigDecimal getValue() {
        return (java.math.BigDecimal) get_Value_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node value
     * @param value java.math.BigDecimal value of Data Model node value
     */
    public final void setValue(java.math.BigDecimal value) {
        get_Value_Model().setNodeValue(value);
    }

    /**
     * Get Model of Data Model node value
     * @return Model of Data Model node value
     */
    public final DispatcherModel<FullShareValueItem, java.math.BigDecimal> get_Value_Model() {
        if (this.valueDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "value");
                this.valueDispatcherModel = new DispatcherModel<FullShareValueItem, java.math.BigDecimal>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("FullShareValue data model does not have a child named value. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.valueDispatcherModel;
    }

    /**
     * Get node value of Data Model node valueDate
     * @return java.util.Date value of Data Model node valueDate
     */
    public final java.util.Date getValueDate() {
        return (java.util.Date) get_ValueDate_Model().getNodeValue();
    }

    /**
     * Set node value of Data Model node valueDate
     * @param valueDate java.util.Date value of Data Model node valueDate
     */
    public final void setValueDate(java.util.Date valueDate) {
        get_ValueDate_Model().setNodeValue(valueDate);
    }

    /**
     * Get Model of Data Model node valueDate
     * @return Model of Data Model node valueDate
     */
    public final DispatcherModel<FullShareValueItem, java.util.Date> get_ValueDate_Model() {
        if (this.valueDateDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "valueDate");
                this.valueDateDispatcherModel = new DispatcherModel<FullShareValueItem, java.util.Date>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("FullShareValue data model does not have a child named valueDate. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.valueDateDispatcherModel;
    }

    /**
     * Check if any node not nullable is null
     * @return true if any node not nullable is null
     * @see JFDataItem
     */
    @Override
    public final boolean isNotNullableNull() {
        Long idPortfolio = getIdPortfolio();
        if (idPortfolio == null) {
            this.logger.logp(JETLevel.WARNING, "FullShareValueItem", "isNotNullableNull",
                "idPortfolio is null but is not nullable.");
            return true;
        }
        Long idShare = getIdShare();
        if (idShare == null) {
            this.logger.logp(JETLevel.WARNING, "FullShareValueItem", "isNotNullableNull",
                "idShare is null but is not nullable.");
            return true;
        }
        String name = getName();
        if (name == null) {
            this.logger.logp(JETLevel.WARNING, "FullShareValueItem", "isNotNullableNull",
                "name is null but is not nullable.");
            return true;
        }
        java.math.BigDecimal value = getValue();
        if (value == null) {
            this.logger.logp(JETLevel.WARNING, "FullShareValueItem", "isNotNullableNull",
                "value is null but is not nullable.");
            return true;
        }
        java.util.Date valueDate = getValueDate();
        if (valueDate == null) {
            this.logger.logp(JETLevel.WARNING, "FullShareValueItem", "isNotNullableNull",
                "valueDate is null but is not nullable.");
            return true;
        }
        return false;
    }

    /**
     * Check if this PK is the same as the PK from another FullShareValueItem
     *
     * @param other FullShareValueItem to compare with
     * @return <code>true</code> if the pk fields from the two objects have the same values
     * @see JFDataItem
     */
    @Override
    public final boolean isPkEquals(final JFDataItem other) {
        boolean result = false;
        
        if ( getIdShareValue() != null) {
            if (other instanceof FullShareValueItem) {
                final FullShareValueItem otherFullShareValue = (FullShareValueItem) other;
                if ( getIdShareValue().equals(otherFullShareValue.getIdShareValue())) {
                    result = true;
                }
            }
        }
        
        return result;
    }

}
