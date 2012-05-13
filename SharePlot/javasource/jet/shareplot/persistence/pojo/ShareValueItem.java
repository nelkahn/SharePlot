package jet.shareplot.persistence.pojo;

import java.io.Serializable;

import jet.framework.manager.datamodel.interfaces.DataModelRootNode;
import jet.framework.util.models.ModelHelper;
import jet.framework.util.pojo2.DispatcherModel;
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
 * Simple pojo wrapper for the ShareValue Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 * 
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public class ShareValueItem implements Serializable {

    private static final long serialVersionUID = 1461049825L;

    private Model dataModel;
    private Logger logger;

    private DispatcherModel<ShareValueItem, Long> idShareValueDispatcherModel;
    private DispatcherModel<ShareValueItem, Long> isShareDispatcherModel;
    private DispatcherModel<ShareValueItem, java.math.BigDecimal> valueDispatcherModel;
    private DispatcherModel<ShareValueItem, java.util.Date> valueDateDispatcherModel;

    /**
     * Constructor used to create a new ShareValue Data Model
     */
    public ShareValueItem() {
        // initialise the logger
        try {
            final JETLoggerManager loggerManager = JETLoggerManager.getJETLoggerManager();
            this.logger = loggerManager.getLogger("jet.shareplot.persistence.pojo");
        } catch (final JETSystemError e) {
            // probably running in junit, use junitLogger
            this.logger = LoggerJUnit.getInstance();
        }
        
        init_DataModel();
    }

    private void init_DataModel() {
        this.dataModel = new DataModelRootNode();
        this.dataModel.setTagName("ShareValue");
        
        SimpleEventModelImpl model = null;
        
        model = new SimpleEventModelImpl("idShareValue");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("isShare");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("value");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("valueDate");
        this.dataModel.appendChild(model);
    }
    
    /**
     * Constructor used to edit an existing ShareValue Data Model
     * @param model Model to use to wrap in the pojo, can not be null
     * @throws IllegalArgumentException if model is null
     */
    public ShareValueItem(final Model model) {
        if (model == null) {
            throw new IllegalArgumentException("model argument can not be null");
        }
        // initialise the logger
        try {
            final JETLoggerManager loggerManager = JETLoggerManager.getJETLoggerManager();
            this.logger = loggerManager.getLogger("jet.shareplot.persistence.pojo");
        } catch (final JETSystemError e) {
            // probably running in junit, use junitLogger
            this.logger = LoggerJUnit.getInstance();
        }
        
        this.dataModel = model;
    }
    
    /**
     * Copy constructor used to clone an existing ShareValue Data Model
     * @param shareValue ShareValueItem to use to copy in the pojo, can not be null
     * @throws IllegalArgumentException if shareValue is null
     */
    public ShareValueItem(final ShareValueItem shareValue) {
        this();
        if (shareValue == null) {
            throw new IllegalArgumentException("shareValue argument can not be null");
        }
        
        setIdShareValue(shareValue.getIdShareValue());
        setIsShare(shareValue.getIsShare());
        setValue(shareValue.getValue());
        setValueDate(shareValue.getValueDate());
    }
    
    /**
     * Get the ShareValue Data Model that is wrapped in this pojo
     * @return ShareValue Data Model
     */
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
    public final DispatcherModel<ShareValueItem, Long> get_IdShareValue_Model() {
        if (this.idShareValueDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "idShareValue");
                this.idShareValueDispatcherModel = new DispatcherModel<ShareValueItem, Long>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("ShareValue data model does not have a child named idShareValue. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.idShareValueDispatcherModel;
    }

    /**
     * Get node value of Data Model node isShare
     * @return Long value of Data Model node isShare
     */
    public final Long getIsShare() {
        return (Long) get_IsShare_Model().getNodeValue();
    }
    
    /**
     * Set node value of Data Model node isShare
     * @param isShare Long value of Data Model node isShare
     */
    public final void setIsShare(Long isShare) {
        get_IsShare_Model().setNodeValue(isShare);
    }
    
    /**
     * Get Model of Data Model node isShare
     * @return Model of Data Model node isShare
     */
    public final DispatcherModel<ShareValueItem, Long> get_IsShare_Model() {
        if (this.isShareDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "isShare");
                this.isShareDispatcherModel = new DispatcherModel<ShareValueItem, Long>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("ShareValue data model does not have a child named isShare. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.isShareDispatcherModel;
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
    public final DispatcherModel<ShareValueItem, java.math.BigDecimal> get_Value_Model() {
        if (this.valueDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "value");
                this.valueDispatcherModel = new DispatcherModel<ShareValueItem, java.math.BigDecimal>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("ShareValue data model does not have a child named value. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
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
    public final DispatcherModel<ShareValueItem, java.util.Date> get_ValueDate_Model() {
        if (this.valueDateDispatcherModel == null) {
            try {
                final Model sourceModel = ModelHelper.getChildNode(this.dataModel, "valueDate");
                this.valueDateDispatcherModel = new DispatcherModel<ShareValueItem, java.util.Date>(this, sourceModel);
            } catch (final JETException e) {
                throw new JETSystemError("ShareValue data model does not have a child named valueDate. Should be impossible, " + "if the pojo and datamodel are up to date.", e);
            }
        }
        return this.valueDateDispatcherModel;
    }

    /**
     * Check if any node not nullable is null
     * @return true if any node not nullable is null
     */
    public final boolean isNotNullableNull() {
        Long isShare = getIsShare();
        if (isShare == null) {
            this.logger.logp(JETLevel.WARNING, "ShareValueItem", "isNotNullableNull", 
                "isShare is null but is not nullable.");
            return true;
        }
        java.math.BigDecimal value = getValue();
        if (value == null) {
            this.logger.logp(JETLevel.WARNING, "ShareValueItem", "isNotNullableNull", 
                "value is null but is not nullable.");
            return true;
        }
        java.util.Date valueDate = getValueDate();
        if (valueDate == null) {
            this.logger.logp(JETLevel.WARNING, "ShareValueItem", "isNotNullableNull", 
                "valueDate is null but is not nullable.");
            return true;
        }
        return false;
    }
    
}
