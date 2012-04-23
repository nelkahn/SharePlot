package jet.shareplot.persistence.pojo;

import java.io.Serializable;

import jet.framework.manager.datamodel.interfaces.DataModelRootNode;
import jet.framework.util.models.ModelHelper;
import jet.util.logger.JETLevel;
import jet.util.logger.JETLoggerManager;
import jet.util.logger.Logger;
import jet.util.logger.LoggerJUnit;
import jet.util.models.SimpleEventModelImpl;
import jet.util.models.interfaces.Model;
import jet.util.throwable.JETException;
import jet.util.throwable.JETSystemError;

/**
 * Simple pojo wrapper for the Share Data Model.
 *
 * Generated by JetTools, do not edit this file directly.
 * 
 * @author JetToolsFramework
 */
@SuppressWarnings("PMD.MethodNamingConventions")
public class ShareItem implements Cloneable, Serializable {

    private static final long serialVersionUID = 1353749886L;

    private Model dataModel;
    private Logger logger;

    /**
     * Constructor used to create a new Share Data Model
     */
    public ShareItem() {
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
        this.dataModel.setTagName("Share");
        
        SimpleEventModelImpl model = null;
        
        model = new SimpleEventModelImpl("idShare");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("name");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("description");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("code");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("datePurchase");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("purchasePrice");
        this.dataModel.appendChild(model);
        model = new SimpleEventModelImpl("entryFee");
        this.dataModel.appendChild(model);
    }
    
    /**
     * Constructor used to edit an existing Share Data Model
     * @param model Model to use to wrap in the pojo, can not be null
     * @throws IllegalArgumentException if model is null
     */
    public ShareItem(final Model model) {
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
     * Get a ShareItem initialized from a Model that has the same structure but contains
     * only String node values. These will be converted to the proper DataModel node value
     * types.
     * 
     * @param untypedModel Model with String node values
     * @return ShareItem
     */
    public final static ShareItem getFromUntypedModel(final Model untypedModel) {
        final ShareItem item = new ShareItem();
        
        String sValue = null;
        
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "idShare");
            if (sValue != null) {
                item.setIdShare(Long.valueOf(sValue));
            }
        } catch (final JETException e) {
            item.logger.logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "name");
            if (sValue == null) {
                sValue = " ";
            }
            item.setName(sValue);                
        } catch (final JETException e) {
            item.logger.logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "description");
            item.setDescription(sValue);
        } catch (final JETException e) {
            item.logger.logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "code");
            item.setCode(sValue);
        } catch (final JETException e) {
            item.logger.logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "datePurchase");
            if (sValue != null) {
                Long timestamp = Long.valueOf(sValue);
                item.setDatePurchase(new java.util.Date(timestamp.longValue()));
            }
        } catch (final JETException e) {
            item.logger.logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "purchasePrice");
            if (sValue != null) {
                item.setPurchasePrice(new java.math.BigDecimal(sValue));
            }
        } catch (final JETException e) {
            item.logger.logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        try {
            sValue = ModelHelper.getChildNodeValueAsString(untypedModel, "entryFee");
            if (sValue != null) {
                item.setEntryFee(new java.math.BigDecimal(sValue));
            }
        } catch (final JETException e) {
            item.logger.logp(JETLevel.INFO, "ShareItem", "getFromUntypedModel", e.getMessage(), e);
        }
        return item;
    }

    /**
     * Get the Share Data Model that is wrapped in this pojo
     * @return Share Data Model
     */
    public Model get_Model() {
        return this.dataModel;
    }
    
    /**
     * Create a clone of the ShareItem pojo, the will clone the underlying data model
     * @return ShareItem pojo
     */
    @Override
    public ShareItem clone() throws CloneNotSupportedException {
        final ShareItem clonedItem = (ShareItem) super.clone();
        clonedItem.init_DataModel();
        clonedItem.setIdShare(getIdShare());
        clonedItem.setName(getName());
        clonedItem.setDescription(getDescription());
        clonedItem.setCode(getCode());
        clonedItem.setDatePurchase(getDatePurchase());
        clonedItem.setPurchasePrice(getPurchasePrice());
        clonedItem.setEntryFee(getEntryFee());
        return clonedItem;
    }

    /**
     * Get node value of Data Model node idShare
     * @return Long value of Data Model node idShare
     */
    public Long getIdShare() {
        try {
            final Model model = ModelHelper.getChildNode(this.dataModel, "idShare");
            return (Long) model.getNodeValue();
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named idShare. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Set node value of Data Model node idShare
     * @param idShare Long value of Data Model node idShare
     */
    private final void setIdShare(final Long idShare) {
        Long tmp = idShare;
        try {
            ModelHelper.setChildNodeValue(this.dataModel, "idShare", tmp);
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named idShare. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Get Model of Data Model node idShare
     * @return Model of Data Model node idShare
     */
    public Model get_IdShare_Model() {
        try {
            return ModelHelper.getChildNode(this.dataModel, "idShare");
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named idShare. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }

    /**
     * Get node value of Data Model node name
     * @return String value of Data Model node name
     */
    public String getName() {
        try {
            final Model model = ModelHelper.getChildNode(this.dataModel, "name");
            return (String) model.getNodeValue();
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named name. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Set node value of Data Model node name
     * @param name String value of Data Model node name
     */
    public final void setName(String name) {
        String tmp = name;
        if (tmp != null && tmp.length() > 255) {
            tmp = tmp.substring(0, 255);
            this.logger.logp(JETLevel.WARNING, "ShareItem", "setName", 
                "Data truncated [" + name + "] -> [" + tmp + "]");
        }
        try {
            ModelHelper.setChildNodeValue(this.dataModel, "name", tmp);
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named name. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Get Model of Data Model node name
     * @return Model of Data Model node name
     */
    public Model get_Name_Model() {
        try {
            return ModelHelper.getChildNode(this.dataModel, "name");
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named name. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }

    /**
     * Get node value of Data Model node description
     * @return String value of Data Model node description
     */
    public String getDescription() {
        try {
            final Model model = ModelHelper.getChildNode(this.dataModel, "description");
            return (String) model.getNodeValue();
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named description. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Set node value of Data Model node description
     * @param description String value of Data Model node description
     */
    public final void setDescription(String description) {
        String tmp = description;
        if (tmp != null && tmp.length() > 4000) {
            tmp = tmp.substring(0, 4000);
            this.logger.logp(JETLevel.WARNING, "ShareItem", "setDescription", 
                "Data truncated [" + description + "] -> [" + tmp + "]");
        }
        try {
            ModelHelper.setChildNodeValue(this.dataModel, "description", tmp);
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named description. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Get Model of Data Model node description
     * @return Model of Data Model node description
     */
    public Model get_Description_Model() {
        try {
            return ModelHelper.getChildNode(this.dataModel, "description");
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named description. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }

    /**
     * Get node value of Data Model node code
     * @return String value of Data Model node code
     */
    public String getCode() {
        try {
            final Model model = ModelHelper.getChildNode(this.dataModel, "code");
            return (String) model.getNodeValue();
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named code. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Set node value of Data Model node code
     * @param code String value of Data Model node code
     */
    public final void setCode(String code) {
        String tmp = code;
        if (tmp != null && tmp.length() > 45) {
            tmp = tmp.substring(0, 45);
            this.logger.logp(JETLevel.WARNING, "ShareItem", "setCode", 
                "Data truncated [" + code + "] -> [" + tmp + "]");
        }
        try {
            ModelHelper.setChildNodeValue(this.dataModel, "code", tmp);
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named code. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Get Model of Data Model node code
     * @return Model of Data Model node code
     */
    public Model get_Code_Model() {
        try {
            return ModelHelper.getChildNode(this.dataModel, "code");
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named code. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }

    /**
     * Get node value of Data Model node datePurchase
     * @return java.util.Date value of Data Model node datePurchase
     */
    public java.util.Date getDatePurchase() {
        try {
            final Model model = ModelHelper.getChildNode(this.dataModel, "datePurchase");
            return (java.util.Date) model.getNodeValue();
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named datePurchase. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Set node value of Data Model node datePurchase
     * @param datePurchase java.util.Date value of Data Model node datePurchase
     */
    public final void setDatePurchase(java.util.Date datePurchase) {
        java.util.Date tmp = datePurchase;
        try {
            ModelHelper.setChildNodeValue(this.dataModel, "datePurchase", tmp);
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named datePurchase. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Get Model of Data Model node datePurchase
     * @return Model of Data Model node datePurchase
     */
    public Model get_DatePurchase_Model() {
        try {
            return ModelHelper.getChildNode(this.dataModel, "datePurchase");
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named datePurchase. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }

    /**
     * Get node value of Data Model node purchasePrice
     * @return java.math.BigDecimal value of Data Model node purchasePrice
     */
    public java.math.BigDecimal getPurchasePrice() {
        try {
            final Model model = ModelHelper.getChildNode(this.dataModel, "purchasePrice");
            return (java.math.BigDecimal) model.getNodeValue();
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named purchasePrice. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Set node value of Data Model node purchasePrice
     * @param purchasePrice java.math.BigDecimal value of Data Model node purchasePrice
     */
    public final void setPurchasePrice(java.math.BigDecimal purchasePrice) {
        java.math.BigDecimal tmp = purchasePrice;
        try {
            ModelHelper.setChildNodeValue(this.dataModel, "purchasePrice", tmp);
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named purchasePrice. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Get Model of Data Model node purchasePrice
     * @return Model of Data Model node purchasePrice
     */
    public Model get_PurchasePrice_Model() {
        try {
            return ModelHelper.getChildNode(this.dataModel, "purchasePrice");
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named purchasePrice. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }

    /**
     * Get node value of Data Model node entryFee
     * @return java.math.BigDecimal value of Data Model node entryFee
     */
    public java.math.BigDecimal getEntryFee() {
        try {
            final Model model = ModelHelper.getChildNode(this.dataModel, "entryFee");
            return (java.math.BigDecimal) model.getNodeValue();
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named entryFee. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Set node value of Data Model node entryFee
     * @param entryFee java.math.BigDecimal value of Data Model node entryFee
     */
    public final void setEntryFee(java.math.BigDecimal entryFee) {
        java.math.BigDecimal tmp = entryFee;
        try {
            ModelHelper.setChildNodeValue(this.dataModel, "entryFee", tmp);
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named entryFee. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }
    
    /**
     * Get Model of Data Model node entryFee
     * @return Model of Data Model node entryFee
     */
    public Model get_EntryFee_Model() {
        try {
            return ModelHelper.getChildNode(this.dataModel, "entryFee");
        } catch (final JETException e) {
            throw new JETSystemError("Share data model does not have a child named entryFee. Should be impossible, " 
                    + "if the pojo and datamodel are up to date.", e);
        }
    }

    /**
     * Check if any node not nullable is null
     * @return true if any node not nullable is null
     */
    public boolean isNotNullableNull() {
        String name = getName();
        if (name == null) {
            this.logger.logp(JETLevel.WARNING, "ShareItem", "isNotNullableNull", 
                "name is null but is not nullable.");
            return true;
        }
        java.util.Date datePurchase = getDatePurchase();
        if (datePurchase == null) {
            this.logger.logp(JETLevel.WARNING, "ShareItem", "isNotNullableNull", 
                "datePurchase is null but is not nullable.");
            return true;
        }
        java.math.BigDecimal purchasePrice = getPurchasePrice();
        if (purchasePrice == null) {
            this.logger.logp(JETLevel.WARNING, "ShareItem", "isNotNullableNull", 
                "purchasePrice is null but is not nullable.");
            return true;
        }
        return false;
    }
    
    
}
